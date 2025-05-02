package HW2;

import java.io.*;
import java.util.*;

/**Class: GameRater
 * @author Damien Brown
 * @version 1.0
 * Course: ITEC 31250 Spring 2025
 * Written: February 15, 2025.
 * This class – Will take count the number of links on a website.
 *  It will not count the same link twice
 * The code will read from a binary file then extract unique website names
 * along with URLs storing them in appropriate data structures.
 */

public class WebLinkCounter {
    private ArrayList<Website> websites = new ArrayList<>();

    public static void main(String[] args) {
        WebLinkCounter wlc = new WebLinkCounter();
        wlc.readBinaryFile();  // Read and store data
        wlc.printWebsites();   // Print list of websites

        HashSet<String> uniqueNames = wlc.getUniqueNames();
        wlc.printUniqueNames(uniqueNames); // Print unique names

        HashMap<String, HashSet<String>> websiteMap = wlc.buildHashMap(uniqueNames);//Builds hashmap of name to urls

        HashMap<String, Integer> websiteCounts = wlc.buildCountMap(websiteMap);
        wlc.printWebsiteCounts(websiteCounts); // Print counts
    }

    // Reads the binary file and stores Website objects in an ArrayList
    private boolean readBinaryFile() {
        boolean valid = true;
        try {
           ObjectInputStream os = new ObjectInputStream(new FileInputStream("src/HW2/links.dat"));
            while (true) {
                try {
                    Website website = (Website) os.readObject();  // Cast obj
                    websites.add(website);
                    System.out.println(website);
                } catch (EOFException e) {
                    break;  // Stop when end of file is reached
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found: " + e.getMessage());
                    valid = false;
                    break;
                }
            }
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            valid = false;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
            valid = false;
        }
        return valid;
    }

    // Prints all website objects stored in the list
    private void printWebsites() {
        for (Website ws : websites) {
            System.out.println(ws);
        }
        System.out.println();
    }

    // Extracts unique website names using a HashSet
    private HashSet<String> getUniqueNames() {
        HashSet<String> uniqueNames = new HashSet<>();//stores
        for (Website ws : websites) {//for loop going through each name then adding it
            uniqueNames.add(ws.getName());
        }
        return uniqueNames;
    }

    // Prints unique website names
    private void printUniqueNames(HashSet<String> uniqueNames) {
        System.out.println("\tNames"); //  \t escape sequence represents tab and allows for more spaces w/o manually doing it
        for (String name : new TreeSet<>(uniqueNames)) { // Sorting alphabetically
            System.out.println(name);
        }
    }

    // Builds a HashMap mapping each name to a set of unique URLs
    private HashMap<String, HashSet<String>> buildHashMap(HashSet<String> names) {
        HashMap<String, HashSet<String>> websiteMap = new HashMap<>();//Stores names to URL map
        for (String name : names) {
            HashSet<String> urlSet = new HashSet<>();//Stores 'unique' URL's
            for (Website ws : websites) {
                if (ws.getName().equals(name)) {
                    urlSet.add(ws.getURL());
                }
            }
            websiteMap.put(name, urlSet);//Map website name to url set
        }
        return websiteMap;
    }

    // Builds a HashMap containing name-to-URL count mapping
    private HashMap<String, Integer> buildCountMap(HashMap<String, HashSet<String>> websiteMap) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, HashSet<String>> entry : websiteMap.entrySet()) {
            countMap.put(entry.getKey(), entry.getValue().size());//Count unique url pre site
        }
        return countMap;
    }

    // Prints website counts in table format
    private void printWebsiteCounts(HashMap<String, Integer> websiteCounts) {
        System.out.println("\n\tWebsite counts");
        System.out.println("Site\t\tCount");
        for (String name : new TreeSet<>(websiteCounts.keySet())) { // Should Sort alphabetically
            System.out.println(name + "\t\t" + websiteCounts.get(name));
        }
    }
}