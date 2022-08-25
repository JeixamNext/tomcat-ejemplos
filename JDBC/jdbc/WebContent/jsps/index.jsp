<%@page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
   <title>Ejemplo de JDBC</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div class="content">
      
        <%
            String url = response.encodeURL("/secure/showAccount.jsp");
        %>
        <a href="<%=url%>">Ver los usuarios</a>
        <form action="<%=url%>" method="POST">
            <input type="submit" name="submit post request" value="submit post request" />
        </form>

    </div>
  </body>
</html>
