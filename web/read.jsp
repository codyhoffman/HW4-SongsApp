<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Songs Database</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>My Songs</h1>
        
        <%= table %>
        
        <br><br>
        
        <a href="add"> Add New Song</a>
        
        <br><br>
        
    </body>
</html>
