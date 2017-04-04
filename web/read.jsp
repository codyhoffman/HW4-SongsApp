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
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        
        <%@ include file="includes/nav.jsp" %>
        
        <div class="main">
            <h1>My Songs</h1>
        
            <%= table %>
        
            <br><br>
        
        </div>

        <br><br>
        <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
