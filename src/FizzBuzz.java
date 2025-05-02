import java.util.Scanner;
public class FizzBuzz {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        n = input.nextInt();

        System.out.println(game(n));



    }

    public static int game(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        }
        if (n % 3 == 0) {
            System.out.println("Fizz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        }
            return n;

    }
}
