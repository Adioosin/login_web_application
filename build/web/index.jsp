    <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<html>
    <head>
        <title>Login</title>
        <script src='https://www.google.com/recaptcha/api.js'></script>
    </head>


    <body>

        <div id="particles-js">
        <form method="post" action="login">
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="uname" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" required="required" /></td>
                </tr>
                <tr><td>
                    <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Le-KCoUAAAAADx9Gku62DePtDJ_Qh2vmvTrcN1b", "6Le-KCoUAAAAADBdwH2DMW0N5IC1U34AwiKyr8p5", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>    
                    </td>    </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
                
            </table>
                    <font size="2"><a href="Forgot_pass.jsp">Forgot Password?</a></font><br>
            <font size="2">New User!! for registration <a href="register.jsp">click here</a></font>
        </fieldset>
           
        </form>
        </div>
   
    </body>
</html>