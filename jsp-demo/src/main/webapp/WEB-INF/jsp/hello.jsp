<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>View Books</title>
       
    </head>
    <body>
        Hello World form JSP
        <%
        double num = Math.random();
        if (num > 0.95) {
        %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
        <%
        } else 
        {
        %>
            <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
        <%
        }
        %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
    </body>
</html>