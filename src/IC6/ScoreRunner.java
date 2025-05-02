package IC6;

/**
 * Class: ScoreRunner
 *  @author Damien Brown
 *  @version 1.0
 *  Course: ITEC 31250 Spring 2025
 *  Written: April 10, 2025.
 *  This class – will create 2 Score objects. These objects should be initialized to a unique ID and an initial score of 100.
 *  It will create 20 threads and assign 5 threads to the Incrementer for the first Score object,
 *  5 threads to the Decrementer for the first score object, 5 threads to the Incrementer/Decrementer for the second
 *  score object.
 *
 *
 *
 */



public class ScoreRunner {
    public static void main(String[] args) {
        // Create two Score objects with unique IDs and an initial score of 100
Score sc1 = new Score(1,100);
Score sc2 = new Score(2,100);


System.out.println("Starting Value for Score 1: "+sc1.getScore());
System.out.println("Starting Value for Score 2: "+sc2.getScore());

        Thread threads[] = new Thread[20]; // array to hold 20 threads

        //cycle from 0-5
        for (int i = 0; i < 5; i++) {

            threads[i] = new Thread(new Increment(sc1));
        }
        //cycle from 5-10
        for (int i = 5; i < 10; i++) {

            threads[i] = new Thread(new Decrement(sc1));
        }
        //cycle from 10-15
        for (int i = 10; i < 15; i++) {

            threads[i] = new Thread(new Increment(sc2));
        }
        //cycle from 15-20
        for (int i = 15; i < 20; i++) {

            threads[i] = new Thread(new Decrement(sc2));
        }
        //starts all threads
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        //wait for threads to finish
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join(); //makes sure main thread finishes first
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // final output
        System.out.println("Ending Value for Score 1: "+sc1.getScore());
        System.out.println("Ending Value for Score 2: "+sc2.getScore());


    }


}
