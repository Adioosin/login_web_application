import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	int flag=0;
        String name = request.getParameter("name");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        encrypt s=new encrypt();
        pass=s.encrypt(pass,4);
        try{
        

        Class.forName("com.mysql.jdbc.Driver");

 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/student","root","");

          PreparedStatement ps=con.prepareStatement("select uname from student");
         ResultSet t=ps.executeQuery();
         while(t.next()){
             String u=(String)t.getString("uname");
            if(u.equals(uname))
            {
                flag=1;
            }
         }
        if(flag==0){
        ps=con.prepareStatement
                  ("insert into Student values(?,?,?,?)");

        ps.setString(1, name);
        ps.setString(2, uname);
        ps.setString(3, pass);
        ps.setString(4, email);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("<script type=\"text/javascript\">");
   out.println("alert('You are Successfully Registered!!');");
   out.println("location='index.jsp';");
   out.println("</script>");
          }
        
        }
        else{
                       out.println("Username Taken!!");
           RequestDispatcher r = request.getRequestDispatcher("register.jsp");
           r.include(request, response);
        }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }