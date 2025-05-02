package IC4;



public class Gamer {
    private String gamerTag;
    private double avgScore;
    private String fname;
    private String lname;
    private String email;
    private String favGame;

    public Gamer(String gamerTag, double avgScore, String fname, String lname, String email, String favGame) {

        this.gamerTag = gamerTag;
        this.avgScore = avgScore;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.favGame = favGame;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag)throws GamerEntry {
        if (gamerTag.length() < 4) {
            throw new GamerEntry("Gamertag must contain at least 4 characters");
        }
        this.gamerTag = gamerTag;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) throws GamerEntry {
        if (avgScore < 0 || avgScore > 1000) {
            throw new GamerEntry("Avg score must be between 0 and 1000");
        }
        this.avgScore = avgScore;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname)throws GamerEntry {
        if (fname.isBlank()) {
            throw new GamerEntry("First name must not be blank");
        }
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname)throws GamerEntry {
        if (lname.isBlank()) {
            throw new GamerEntry("Last name must not be blank");
        }
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)throws GamerEntry {
        if (!(email.contains("@") && email.contains("."))) {
            throw new GamerEntry("Email must contain an '@' and a '.'");
        }
        this.email = email;
    }

    public String getFavGame() {
        return favGame;
    }

    public void setFavGame(String favGame)throws GamerEntry {
        if (favGame.length() < 3) {
            throw new GamerEntry("FavGame must contain at least 3 characters");
        }
        this.favGame = favGame;
    }

    @Override
    public String toString() {
        return "Gamer" +
                "gamerTag='" + gamerTag + '\'' +
                ", avgScore=" + avgScore +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", favGame='" + favGame + '\'' ;
    }
}
