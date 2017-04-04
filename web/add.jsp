<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Song</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <div class="wrap">
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/nav.jsp" %>
        
        <div class="main">
            <h1>Add New Song</h1>
        
            <form name="addForm" action="addSong" method="get">
                <table>               
                    <tr>
                        <td>Song Name:</td>
                        <td><input type="text" name="songName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Artist Name:</td>
                        <td><input type="text" name="artistName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Length:</td>              
                        <td><input type="text" name="songLength" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Genre:</label></td>
                        <td><input type="text" name="songGenre" value="" /></td>
                    </tr>
                </table>
                <br>
                <input type="submit" name="submit" value="Submit" />       
            </form>
        </div>
        
        <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
