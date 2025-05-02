package ICs.IC1;

import java.io.Serializable;

/** Class: student.ICs.IC1.Game
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3150 Spring 2025
 * Written: January 2, 2025
 * This class describes the common attributes and methods
 * of the games being collected into a library
 */
public class Game implements Serializable {
    private int id;
    private String name;
    private String type;

    public Game(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", type: " + this.type;
    }
}


