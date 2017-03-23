
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

public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        
        try {
            String query = "select * from songs";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Something went wrong at line 52 of ReadQuery.java");
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        
        String table = "";
        
        table += "<table border=1>";
        
        try {
            while(this.results.next()) {
                
                Songs song = new Songs();
                song.setSongID(this.results.getInt("songID"));
                song.setSongName(this.results.getString("songName"));
                song.setArtistName(this.results.getString("artistName"));
                song.setSongLength(this.results.getInt("songLength"));
                song.setSongGenre(this.results.getString("songGenre"));
                
                table += "<tr>";
                
                table += "<td>";
                table += song.getSongID();
                table += "</td>";
                
                table += "<td>";
                table += song.getSongName();
                table += "</td>"; 
                
                table += "<td>";
                table += song.getArtistName();
                table += "</td>"; 
                
                table += "<td>";
                table += song.getSongLength();
                table += "</td>";  
                
                table += "<td>";
                table += song.getSongGenre();
                table += "</td>";  
                
                table += "<td>";
                table += "<a href=delete?songID=" + song.getSongID() + "> Delete </a>";
                table += "</td>"; 
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
        return table;
                
    }
}
