package IC6;

public class Increment implements Runnable {

    private Score sc;

    //Constructor that initializes the Increment object with a Score.
    public Increment(Score sc) {
        this.sc = sc;
    }

    @Override
    // method will increment the score objects value by 5
    public void run() {
        for (int i = 0; i < 5; i++) {
            sc.updateScore(5); //increment



        }

    }

}
