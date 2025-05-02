package ICs.IC1;

/** Class: ICs.IC1.Card
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3150 Spring 2025
 * Written: January 2, 2025
 * This class describes the common attributes and methods
 * of the ICs.IC1.Card games
 *
 */
public class Card extends Game {
    private String deckType;
    private int handSize;
    private int numPlayers;

    /** Method ICs.IC1.Card
     * Constructor
     * @param id
     * @param name
     * @param type
     */
    public Card(int id, String name, String type) {
        super(id, name, type);
        deckType = "standard";
        handSize = 8;
        numPlayers = 4;
    }

    /** Method ICs.IC1.Card
     * Constructor
     * @param id
     * @param name
     * @param type
     * @param deckType
     * @param handSize
     * @param numPlayers
     */
    public Card(int id, String name, String type, String deckType, int handSize, int numPlayers) {
        super(id, name, type);
        this.deckType = deckType;
        this.handSize = handSize;
        this.numPlayers = numPlayers;
    }

    /** Method getDeckType
     * Getter for deck typ
     * @return deckType
     */
    public String getDeckType() {
        return deckType;
    }

    /** Method setDeckType
     * Setter for deck type
     * @param deckType
     */
    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    /** Method getHandSize
     * Getter for deck typ
     * @return deckType
     */
    public int getHandSize() {
        return handSize;
    }

    /** Method setHandSize
     * Setter for hand size
     * @param handSize
     */
    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    /** Method getNumPlayers
     * Getter for number of players
     * @return numPlayers
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /** Method setNumPlayers
     * Setter for number of players
     * @param numPlayers
     */
    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    /** Method toString
     * return a String representation of ICs.IC1.Card
     */
    @Override
    public String toString() {
        return "ICs.IC1.Card: " + super.toString() +
                "deck type: " + deckType +
                ", handSize: " + handSize +
                ", numPlayers: " + numPlayers;
    }
}