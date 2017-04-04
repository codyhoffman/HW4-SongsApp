
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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery() {
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String songName) {
        
        try {
            String query = "SELECT * FROM songs WHERE UPPER(songName) LIKE ? ORDER BY songID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + songName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        
        String table = "";
        table += "<table>";
        // begin table header
        
        table += "<tr>";
        
        table += "<th>";
        table += "Song ID";
        table += "</th>";
        
        table += "<th>";
        table += "Song Name";
        table += "</th>";
        
        table += "<th>";
        table += "Artist Name";
        table += "</th>"; 
                        
        table += "<th>";
        table += "Length";
        table += "</th>";
                
        table += "<th>";
        table += "Genre";
        table += "</th>";
        
        table += "</tr>";
        
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
                table += "<a href=update?songID=" + song.getSongID() + "> Update </a>" + " " + "<a href=delete?songID=" + song.getSongID() + "> Delete </a>";
                table += "</td>"; 
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
        return table;
                
    }
}
