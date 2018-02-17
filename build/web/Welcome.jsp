
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    
    <body>
                <%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
<h1>Welcome <%=session.getAttribute("uname")%></h1>
<h1>Successfully Logged in!</h1>
<a href='logout.jsp'>Log out</a>
<%
    }
%>
        
    </body>
    

