package ICs.IC1;

/** Class: ICs.IC1.Puzzle
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3150 Spring 2025
 * Written: January 2, 2025
 * This class contains all of the attributes and methods for ICs.IC1.Puzzle games.
 */
public class Puzzle extends Game {
    private boolean coop;
    private int numAttempts;
    private String successMsg;
    private String failMsg;

    /** Method ICs.IC1.Puzzle
     * Constructor
     * @param id
     * @param name
     * @param type
     */
    public Puzzle(int id, String name, String type) {
        super(id, name, type);
        coop = false;
        numAttempts = 3;
        successMsg = "You have solved the " + name + " puzzle.";
        failMsg = "You did not solve the puzzle for " + name + ".\n" +
                "Please try again.";
    }

    /** Method ICs.IC1.Puzzle
     * Constructor
     * @param id
     * @param name
     * @param type
     * @param coop
     * @param numAttempts
     * @param successMsg
     * @param failMsg
     */
    public Puzzle(int id, String name, String type, boolean coop, int numAttempts, String successMsg, String failMsg) {
        super(id, name, type);
        this.coop = coop;
        this.numAttempts = numAttempts;
        this.successMsg = successMsg;
        this.failMsg = failMsg;
    }

    /** Method isCoop
     * Returns true if the game is a cooperative, false otherwise
     * @return
     */
    public boolean isCoop() {
        return coop;
    }

    /** Method setCoop
     * Setter for coop
     * @param coop
     */
    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    /** Method getNumberAttempts
     * Getter for the number of attempts
     * @return
     */
    public int getNumAttempts() {
        return numAttempts;
    }

    /** Method setNumAttempts
     * Setter for the number of attempts
     * @param numAttempts
     */
    public void setNumAttempts(int numAttempts) {
        this.numAttempts = numAttempts;
    }

    /** Method getSuccessMsg
     * Getter for the success message
     * @return
     */
    public String getSuccessMsg() {
        return successMsg;
    }

    /** Method setSuccssMsg
     * Setter for success message
     * @param successMsg
     */
    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    /** Method getFailMsg
     * Getter for the fail message
     * @return
     */
    public String getFailMsg() {
        return failMsg;
    }

    /** Method setFailMsg
     * Setter for fail message
     * @param failMsg
     */
    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    /** Method toString
     * Returns a String representation of ICs.IC1.Puzzle
     * @return
     */
    @Override
    public String toString() {
        return "ICs.IC1.Puzzle " + super.toString() +
                ",  cooperative: " + coop +
                ", number of attempts: " + numAttempts +
                ", successMsg: " + successMsg +
                ", failMsg: " + failMsg;
    }
}

