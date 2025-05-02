package IC2;
import java.util.*;
/**Class: GameRater
 * @author Damien Brown
 * @version 1.0
 * Course: ITEC 31250 Spring 2025
 * Written: February 9, 2025
 *
 * This class – Will take user listed games put them in a Tree set then store those games in a HashMap to be in sorted order
 * The program then will request user's rating on each game till 'blank' is entered
 * lastly the program will display the game the rating and the average.
 */
public class GameRater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String>Games = new TreeSet<>();

        // Steps 1 / 2: Collect unique game names without using contains method or traversing
        while (true) {
            System.out.println("Please enter the Game name, blank to exit");
            String game = sc.nextLine().trim(); // Trim to remove trailing spaces
            if (game.isEmpty()) break; // Check before adding to the set breaks when blank
            Games.add(game.toLowerCase());// Makes sure no duplicates are stored regardless of upper/lower case
        }

        Map<String, ArrayList<Integer>> gr = new HashMap<>(); //Map arraylist for sorted order
        // Step 3 & 4: Collect ratings for each game

        //for loop stores user listed 'Games' into 'games'
        for (String game : Games) {
            ArrayList<Integer> ratings = new ArrayList<>();

            while (true) {
                System.out.println("Please enter your rating for " + game + " (1-10). Enter 0 to stop entering ratings.");

                try {
                    int rating = Integer.parseInt(sc.nextLine().trim()); //Turns user String number into and int value
                   // If else statement for breaking if 0 is pressed
                    if (rating == 0 && ratings.isEmpty()) {
                        System.out.println("At least one rating is required.");
                    } else if (rating == 0) {
                        break;
                    } else if (rating >= 1 && rating <= 10) {
                        ratings.add(rating);
                    } else {
                        System.out.println("You must enter an integer between 1 and 10, or 0 to exit.");
                    }
                    //Catch block for anything other than 1-10 or 0
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer between 1 and 10, or 0 to exit.");
                }
            }
            gr.put(game, ratings); //Since Map is being used .put will update the entry
        }

        // Step 5 & 6: Print game name, number of ratings, and average rating
        System.out.println("\nGame Ratings Summary:");
        for (Map.Entry<String, ArrayList<Integer>> entry : gr.entrySet()) {
            String game = entry.getKey();
            ArrayList<Integer> ratings = entry.getValue();
            int numRatings = ratings.size();

            double average;
            if (!ratings.isEmpty()) {
                int sum = 0;
                for (int rating : ratings) {
                    sum += rating;
                }
                average = (double) sum / ratings.size();  // Convert to double for decimal precision
            } else {
                average = 0.0;
            }
            System.out.printf("%s %d %.1f\n", game, numRatings, average);
        }

        sc.close();
    }
}
