package ICs.IC1;

/** Class: ICs.IC1.FirstPersonShooter
 * @author Rick Price
 * @version 1.0
 * Course: ITEC 3150 Spring 2025
 * Written: January 2, 2025
 * This class contains all of the attributes and methods for first person shooters
 */
public class FirstPersonShooter extends Game {
    private int numPlayers;
    private String platform;
    private boolean teams;
    private String teamName;

    /** Method ICs.IC1.FirstPersonShooter
     * Constructor
     * @param id
     * @param name
     * @param type
     */
    public FirstPersonShooter(int id, String name, String type) {
        super(id, name, type);
        numPlayers = 1;
        platform = "PC";
        teams = false;
        teamName = "no team";
    }

    /** Method ICs.IC1.FirstPersonShooter
     * Constructor
     * @param id
     * @param name
     * @param type
     * @param numPlayers
     * @param platform
     * @param teams
     * @param teamName
     */
    public FirstPersonShooter(int id, String name, String type, int numPlayers, String platform, boolean teams, String teamName) {
        super(id, name, type);
        this.numPlayers = numPlayers;
        this.platform = platform;
        this.teams = teams;
        this.teamName = teamName;
    }

    /** Method getNumPlayers
     *  Getter for number of players
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

    /** Method getNumPlatform
     *  Getter for platform
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }

    /** Method setPlatform
     * Setter for platform
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /** Method isTeams
     *  Getter for teams, are they allowed or not
     * @return teams
     */
    public boolean isTeams() {
        return teams;
    }

    /** Method setTeams
     * Setter for whether teams are allowed or not.
     * @param teams
     */
    public void setTeams(boolean teams) {
        this.teams = teams;
    }

    /** Method getTeamName
     * Getter for team name
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /** Method setTeamName
     * Setter for team name
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /** Metod toString
     * returns a String representation of the ICs.IC1.FirstPersonShooter
     * @return
     */
    @Override
    public String toString() {
        return "First Person Shooter " + super.toString() +
                ", number of Players: " + numPlayers +
                ", platform: " + platform +
                ", teams: " + teams +
                ", teamName: " + teamName;
    }
}