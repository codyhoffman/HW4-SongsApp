
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Songs;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Songs song = new Songs();
    private int songID;
    
    public ReadRecord(int songID) {
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.songID = songID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        
        try {
            String query = "select * from songs where songID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, songID);
            
            this.results = ps.executeQuery();
            this.results.next();
            
            song.setSongID(this.results.getInt("songID"));
            song.setSongName(this.results.getString("songName"));
            song.setArtistName(this.results.getString("artistName"));
            song.setSongLength(this.results.getInt("songLength"));
            song.setSongGenre(this.results.getString("songGenre"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Songs getSong() {
        return this.song;
    }
   
}
