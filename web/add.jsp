<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Song</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <div id="wrapper">
    <body>
        <h1>Add New Song</h1>
        <div id="wrapper">
        <form name="addForm" action="addSong" method="get">
            <div id="wrapper">
            <label>Song Name:</label>
            </div>
            <input type="text" name="songName" value="" />
            <br><br><br>
            <div id="wrapper">
            <label>Artist Name:</label>
            </div>
            <input type="text" name="artistName" value="" />
            <br><br><br>
            <div id="wrapper">
            <label>Length:</label>
            </div>
            <input type="text" name="songLength" value="" />
            <br><br><br>
            <div id="wrapper"><label>Genre:</label></div>
            <input type="text" name="songGenre" value="" />
            <br><br><br><br>
            <input type="submit" name="submit" value="Submit" />
        </form>
        </div>
    </body>
    </div>
</html>
