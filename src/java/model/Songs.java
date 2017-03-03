
package model;

public class Songs {
    
    private int songID;
    private String songName;
    private String artistName;
    private int songLength;
    private String songGenre;

    public Songs() {
        this.songID = 0;
        this.songName = "";
        this.artistName = "";
        this.songLength = 0;
        this.songGenre = "";
    }
    
    public Songs(int songID, String songName, String artistName, int songLength, String songGenre) {
        this.songID = songID;
        this.songName = songName;
        this.artistName = artistName;
        this.songLength = songLength;
        this.songGenre = songGenre;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    @Override
    public String toString() {
        return "Songs{" + "songID=" + songID + ", songName=" + songName + ", artistName=" + artistName + ", songLength=" + songLength + ", songGenre=" + songGenre + '}';
    }
    
}
