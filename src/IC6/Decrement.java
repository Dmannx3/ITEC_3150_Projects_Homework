package IC6;

public class Decrement implements Runnable {
    private Score sc;

    //Constructor that initializes the Decrement object with a Score.
    public Decrement(Score sc) {
        this.sc = sc;
    }

    @Override
    // method will Decrement the score objects value by 5
    public void run() {
for (int i = 0; i < 5; i++) {
    sc.updateScore(-5);//decrement
}
    }
}
