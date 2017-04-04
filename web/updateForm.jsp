<%-- 
    Document   : updateForm
    Created on : Apr 3, 2017, 7:28:58 PM
    Author     : codyhoffman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Songs"%>
<% Songs song = (Songs) request.getAttribute("song"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Song</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        
    </head>
    <body>
        <h1>Update A Song</h1>

        <form name="updateForm" action="updateSong" method="get">
            <table>
                <tr>
                    <td>Song ID</td>
                    <td><input type="text" name="songID" value="<%= song.getSongID() %>" readonly /></td>
                </tr>                
                <tr>
                    <td>Song Name:</td>
                    <td><input type="text" name="songName" value="<%= song.getSongName() %>" /></td>
                </tr>
                <tr>
                    <td>Artist Name:</td>
                    <td><input type="text" name="artistName" value="<%= song.getArtistName() %>" /></td>
                </tr>
                <tr>
                    <td>Length:</td>              
                    <td><input type="text" name="songLength" value="<%= song.getSongLength() %>" /></td>
                </tr>
                <tr>
                    <td><label>Genre:</label></td>
                    <td><input type="text" name="songGenre" value="<%= song.getSongGenre() %>" /></td>
                </tr>
            </table>
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Update" />       
        </form>

    </body>
</html>
