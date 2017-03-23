<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Song</title>
    </head>
    <body>
        <h1>Add New Song</h1>
        
        <form name="addForm" action="addSong" method="get">
            <label>Song Name:</label>
            <input type="text" name="songName" value="" />
            <br>
            <label>Artist Name:</label>
            <input type="text" name="artistName" value="" />
            <br>
            <label>Length</label>
            <input type="text" name="songLength" value="" />
            <br>
            <label>Genre</label>
            <input type="text" name="songGenre" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
