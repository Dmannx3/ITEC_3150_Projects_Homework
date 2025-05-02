package ICs.IC1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameTracker {
    private ArrayList<Game> games = new ArrayList();
    private Scanner keyboard;

    public GameTracker() {
        this.keyboard = new Scanner(System.in);
    }

    private void printGames() {
        for (Game game : this.games) {
            System.out.println(game);
        }

        System.out.println();
    }

    private Game searchById(int id) {
        Game item = null;

        for (Game game : this.games) {
            if (game.getId() == id) {
                item = game;
            }
        }

        return item;
    }

    private void addGame(Game game) {
        this.games.add(game);
    }

    private int displayMenu() {
        System.out.println("Would you like to :");
        System.out.println("  1. View contents of library");
        System.out.println("  2. Search for an item");
        System.out.println("  3. Exit");
        int userInput = this.keyboard.nextInt();
        return userInput;
    }

    private boolean actions(int userInput) {
        boolean done = false;
        if (userInput == 1) {
            this.printGames();
        } else if (userInput == 2) {
            System.out.println("Please enter item number");
            int id = this.keyboard.nextInt();
            Game item = this.searchById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Sorry- item not found");
            }
        } else {
            done = true;
        }

        return done;
    }

    private boolean readFile() {
        boolean valid = true;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BinaryGames.dat"))) {
            while (true) {
                try {
                    //card type game
                    System.out.println(input.readUTF());
                    //ID 1
                    System.out.println(input.readInt());
                    //Name solatarie
                    System.out.println(input.readUTF());
                    //standard type
                    System.out.println(input.readUTF());
                    //52
                    System.out.println(input.readInt());
                    //1
                    System.out.println(input.readInt());

                    //Game 2 fps 2 halo 4 xbox
                    System.out.println(input.readUTF());//fps
                    System.out.println(input.readInt());//2
                    System.out.println(input.readUTF());//halo
                    System.out.println(input.readInt());//4
                    System.out.println(input.readUTF());//xbox
                    System.out.println(input.readBoolean());//true
                    System.out.println(input.readUTF());//Chiefs

                    //Puzzle obj
                    Puzzle puz = (Puzzle) input.readObject();
                    System.out.println("// Puzzle game: " + puz);

                    System.out.println(input.readUTF());//ICS.IC1.Card
                    System.out.println(input.readInt());//4
                    System.out.println(input.readUTF());//Free cell
                    System.out.println(input.readUTF());//standard
                    System.out.println(input.readInt());//52
                    System.out.println(input.readInt());//1

                    //Card obj
                    Card crd = (Card) input.readObject();
                    System.out.println("// Card game: " + crd);

                    //FPS obj
                    FirstPersonShooter fps = (FirstPersonShooter) input.readObject();
                    System.out.println("// First person shooter: " + fps);

                    System.out.println(input.readUTF());//fps
                    System.out.println(input.readInt());//7
                    System.out.println(input.readUTF());//diablo 4
                    System.out.println(input.readInt());//20
                    System.out.println(input.readUTF());//pc xbox ps
                    System.out.println(input.readBoolean());//true
                    System.out.println(input.readUTF());//wizards

                    //Puzzle obj2
                    Puzzle puzz = (Puzzle) input.readObject();
                    System.out.println("// Puzzle game: " + puzz);

                    System.out.println(input.readUTF());//ICS.IC1.Puzzle
                    System.out.println(input.readInt());//9
                    System.out.println(input.readUTF());//Match maker
                    System.out.println(input.readBoolean());//false
                    System.out.println(input.readInt());//3
                    System.out.println(input.readUTF());//you match...
                    System.out.println(input.readUTF());//need to learn....


                }catch (FileNotFoundException e) {
                    valid = false;
                }
                catch (EOFException e) {
                    System.out.println("// End of file");
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error having trouble reading binary file" +e.getMessage());
            valid = false;
        }

        return valid;
    }

    public static void main(String[] args) {
        GameTracker gt = new GameTracker();
        boolean done = false;
        done = !gt.readFile();
        if (!done) {
            System.out.println("Welcome to the ICs.IC1.Game Tracker");
        }

        while (!done) {
            int userInput = gt.displayMenu();
            done = gt.actions(userInput);
        }

        gt.keyboard.close();
    }
}