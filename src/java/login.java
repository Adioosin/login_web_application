import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

public class login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        encrypt s=new encrypt();
        pass=s.encrypt(pass,4);
        //boolean st =false;
      try{


         Class.forName("com.mysql.jdbc.Driver");


         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
         PreparedStatement ps =con.prepareStatement("select * from student where uname=? and pass=?");
         ps.setString(1, uname);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         
         String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6Ldb70YUAAAAAGe_8gXvQusTmi3gfUEjaFzNHFrV");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

       
         boolean st = rs.next();
         if(st&& reCaptchaResponse.isValid()){
             HttpSession session = request.getSession(true);
             session.setAttribute("uname",uname);
             response.sendRedirect("Welcome.jsp");
         } 
         else if(st && !reCaptchaResponse.isValid() ){
             out.println("Invalid Captcha!!");
           RequestDispatcher r = request.getRequestDispatcher("index.jsp");
           r.include(request, response);
         }
         else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher r = request.getRequestDispatcher("index.jsp");
           r.include(request, response);
        }
         
      }catch(Exception e)
      {
          e.printStackTrace();
      } 
        
       /* if(st)
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome.jsp");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
           rs.include(request, response);
        }*/
    } 
}