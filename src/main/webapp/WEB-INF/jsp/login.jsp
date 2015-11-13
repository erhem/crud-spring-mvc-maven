<%-- 
    Document   : login
    Created on : Nov 13, 2015, 6:29:48 PM
    Author     : erhem
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form:form modelAttribute="login">
            <table>
                <tr>
                    <td>Username :  </td>
                    <td> <form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
<script>
    var a = '${message}';
    if(a != '') {
        alert(a)
    }
</script>
