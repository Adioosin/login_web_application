

<html>
    <head>
        <title>Register form</title>
    </head>
    <body>
        <form method="post" action="Register">
        
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" required="required" /></td>
                </tr>
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="uname" required="required" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pass" minlength="8" required="required" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </fieldset>
        </form>
    </body>
</html>