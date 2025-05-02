package IAMMusic;

public class Music {
    private String name;
    private String artist;
    private String genre;
    private int time;
    private int numTracks;

    public Music(String name, String artist, String genre, int time, int numTracks) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.time = time;
        this.numTracks = numTracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws MusicException {
        if (name.isBlank()){
            throw new MusicException("Name cannot be blank.");
        }
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) throws MusicException{
        if(artist.length() < 4){
            throw new MusicException("Artist name must be 4 characters");
        }
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) throws MusicException {
        if (time < 10){
            throw new MusicException("Time must be 10 ");

        }
        this.time = time;
    }

    public int getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(int numTracks) throws MusicException {
        if (numTracks < 2){
            throw new MusicException("Number of tracks must be 2 or more");
        }
        this.numTracks = numTracks;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", time=" + time +
                ", numTracks=" + numTracks +
                '}';
    }
}
