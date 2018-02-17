<%
session.setAttribute("userid", null);
session.invalidate();
out.println("Logged Out Successfully!!");
response.sendRedirect("index.jsp");
%>