package ICs.IC1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Class: ICs.IC1.CreateBinaryFile
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3150 Spring 2025
 * Written: January 2, 2025
 * Purpose: Generates the binary file. Your reader must use the corresponding methods to read the file
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateBinaryFile {
    public CreateBinaryFile() {
    }

    public static void main(String[] args) {
        ObjectOutputStream output = null;

        try {
            output = new ObjectOutputStream(new FileOutputStream("BinaryGames.dat"));
        } catch (Exception var8) {
            System.out.println("Unable to open file for writing- try again");
            System.exit(0);
        }

        try {
            output.writeUTF("card");
            output.writeInt(1);
            output.writeUTF("Solitaire");
            output.writeUTF("standard");
            output.writeInt(52);
            output.writeInt(1);
            output.writeUTF("firstPersonShooter");
            output.writeInt(2);
            output.writeUTF("Halo");
            output.writeInt(4);
            output.writeUTF("XBox");
            output.writeBoolean(true);
            output.writeUTF("Chiefs");
            Puzzle puz = new Puzzle(3, "Portal", "ICs.IC1.Puzzle", false, 3, "Congratulations, you have completed the challenges of Portal", "Better luck next time. Perhaps you will be able to teleport next time.");
            output.writeObject(puz);
            output.writeUTF("ICs.IC1.Card");
            output.writeInt(4);
            output.writeUTF("Free Cell");
            output.writeUTF("standard");
            output.writeInt(52);
            output.writeInt(1);
            Card crd = new Card(5, "ICs.IC1.Card", "Spider", "standard", 52, 1);
            output.writeObject(crd);
            FirstPersonShooter fps = new FirstPersonShooter(6, "Borderland", "firstPersonShooter", 4, "XBox", false, "none");
            output.writeObject(fps);
            output.writeUTF("firstPersonShooter");
            output.writeInt(7);
            output.writeUTF("Diablo 4");
            output.writeInt(20);
            output.writeUTF("PC, XBox, PS");
            output.writeBoolean(true);
            output.writeUTF("Wizards");
            Puzzle puz2 = new Puzzle(8, "Maze Master", "ICs.IC1.Puzzle", false, 10, "You successfully navigated the mazes.", "You got lost in the mazes. Hope you can find your way out sometime.");
            output.writeObject(puz2);
            output.writeUTF("ICs.IC1.Puzzle");
            output.writeInt(9);
            output.writeUTF("Match Maker");
            output.writeBoolean(false);
            output.writeInt(3);
            output.writeUTF("You matched all of the tiles");
            output.writeUTF("Need to learn your shapes. These don't match.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Problem writing to file");
        }

        try {
            output.close();
            System.out.println("File successfully written.");
        } catch (Exception var6) {
            System.out.println("unable to properly close file");
        }

    }
}