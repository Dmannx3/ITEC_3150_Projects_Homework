package Practice;

public class IncorrectLocale extends IllegalArgumentException {
    public IncorrectLocale(String message) {
        super(message);
    }
    public  IncorrectLocale(){
        System.out.println("Invalid Input, location must be Winder, Alpharetta, Athens");
    }
}
