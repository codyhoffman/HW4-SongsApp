<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Songs</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <div class="wrap">
            
        <%@ include file="includes/header.jsp" %>
        <%@ include file="includes/nav.jsp" %>
        
        <div class="main">
            <h1>Search Songs</h1>
        
            <form name="searchForm" action="search" method="get">
                <table>
                    <tr>
                        <td>Search For:</td>
                        <td><input type="text" name="searchVal" value="" /></td>
                    </tr>
                </table>
                <br><br>
                <input type="submit" name="submit" value="Search" /> 
            </form>
        </div>
        
        <%@ include file="includes/footer.jsp" %>
        
        </div>
    </body>
</html>
