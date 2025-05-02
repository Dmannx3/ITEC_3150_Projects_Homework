package Practice;

import java.util.Scanner;

/**
 * This code will give you the distance from Alpharreta to Athens along with how long
 * to get there bonus to add winder
 */
public class Distance {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

String from = "";
String to = "";


while (true) {
    try {
        System.out.println("Where are you from Winder, Alpharetta, Athens: ");
        from = sc.nextLine();
        if (isValidLocation(from)) {
            break;
        }
    }catch (IncorrectLocale e){
        System.out.println(e.getMessage());

    }

}
while (true) {
    try {
        System.out.println("Where are you going to: ");
        to = sc.nextLine();
        if (isValidLocation(to)) {
            break;
        }else {
            throw new IncorrectLocale();
        }
    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
}

    }

int distance = getDistance(from, to);

        System.out.println("The location "+from+ " to "+to+" is "+distance+" miles");



}
public static int getDistance(String from, String to) {
        from = from.toLowerCase();
        to = to.toLowerCase();

        if (from.equals("winder")) {
            if (to.equals("athens")) {
                return 20;
            }
            if (to.equals("alpharetta")) {
                return 40;
            }
        }
        if (from.equals("athens")) {
            if (to.equals("alpharetta")) {
                return 61;
            }
            if (to.equals("winder")) {
                return 20;
            }
        }
        if (from.equals("alpharetta")) {
            if (to.equals("winder")) {
                return 40;
            }
            if (to.equals("athens")) {
                return 61;
            }
        }
        return -1;
}
public static boolean isValidLocation(String location) {

        location = location.toLowerCase();
        return location.equals("winder") || location.equals("alpharetta") || location.equals("athens");
    }
}
