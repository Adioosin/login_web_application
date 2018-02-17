<%-- 
    Document   : Forgot_pass
    Created on : 24 Jul, 2017, 10:50:48 PM
    Author     : guest11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <form method="post" action="Forgot_pass">
           <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>

                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="uid" required="required" /></td>
                </tr>
               
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </fieldset>
        </form>
    </body>
</html>
