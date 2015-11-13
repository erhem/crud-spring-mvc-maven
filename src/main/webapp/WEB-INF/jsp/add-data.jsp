<%-- 
    Document   : add-data
    Created on : Nov 13, 2015, 10:05:21 PM
    Author     : erhem
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Add Data Page</title>
    </head>
    <body>
        <h2>Add Data</h2>
        <form:form modelAttribute="person">
            <table>
                <tr>
                    <td>Id : </td>
                    <td><form:input path="id" /></td>
                </tr>
                <tr>
                    <td>Name : </td>
                    <td><form:input path="name" /></td>
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
        alert(a);
    }
</script>
