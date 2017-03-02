
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
    
}
