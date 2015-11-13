<%-- 
    Document   : member-area
    Created on : Nov 13, 2015, 8:14:15 PM
    Author     : erhem
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Member Area Page</title>
        <script>
            function hapus(id) {
                var msg = "Do you want to delete this data ?";
                if(confirm(msg)) {
                    window.location = "delete-data/"+id;
                }
            }
        </script>
    </head>
    <body>
        <h2>Member Area</h2>
        <a href="add-data">Add Data</a>
        <table border="1">
            <tr>
                <td>No</td>
                <td>Id</td>
                <td>Name</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${listData}" var="person" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>
                        <a href="edit-data/${person.id}">Edit</a>
                        <a href="#" onclick="hapus(${person.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

