import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Forgot_pass extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int flag=0;
        String uid = request.getParameter("uid");
        
      try{


         Class.forName("com.mysql.jdbc.Driver");

         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
         PreparedStatement ps=con.prepareStatement("select uname from student");
         ResultSet t=ps.executeQuery();
         while(t.next()){
             String u=(String)t.getString("uname");
            if(u.equals(uid))
            {
                flag=1;
            }
         }
         if(flag==1){
         ps =con.prepareStatement("select pass from student where uname=?");
         ps.setString(1, uid);
         
         ResultSet rs =ps.executeQuery();
         rs.next();
         String pass = (String)rs.getString("pass");
         ps =con.prepareStatement("select email from student where uname=?");
         ps.setString(1, uid);
         
         rs =ps.executeQuery();
         rs.next();
         String email=(String)rs.getString("email");
         
         
      String from = "forgotpass.login@gmail.com";
      
      String username="forgotpass.login@gmail.com";
      String password="iamtrojan";
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "465");
      props.put("mail.smtp.user",username );
      props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");
      
            Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });
                  try {

	   Message message = new MimeMessage(session);

	   message.setFrom(new InternetAddress(from));

	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(email));
	

	   message.setSubject("<----Password for Login---->");
	

	   message.setText("Username: " +uid+
		"\nPassword: "+pass+"\nRemember Password next time!!");


	   Transport.send(message);

	   

      } 
                        catch (MessagingException e) {
         throw new RuntimeException(e);
      }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mail Status</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mail Status: </h1>");
            out.println("<b>Mail is sent to your registered Email ID</b>");
            out.println("Click <a href='index.jsp'>here</a> to go back");
            out.println("</body>");
            out.println("</html>");
                 
         }    

         else{
             out.println("Invalid Username!!Plz Try again");
           RequestDispatcher rs = request.getRequestDispatcher("Forgot_pass.jsp");
           rs.include(request, response);
         }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      } 
    }}