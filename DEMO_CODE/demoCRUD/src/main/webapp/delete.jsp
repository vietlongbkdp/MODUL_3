<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LONG PC
  Date: 9/18/2023
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card container px-6">
        <h3 class="text-center">Are you sure to Delete ${obj.getName()} ?</h3>
        <div style="display: flex">
            <form  method="post">
                <button type="submit" formaction="/student?action=delete${obj.getId()}" class="btn btn-danger mb-2">DELETE</button>
                <button type="submit" formaction="/student?action=no1" class="btn btn-secondary mb-2">CLOSE</button>
            </form>
        </div>
        <table class="table table-striped">
            <thead>
            <td>ID</td>
            <td>NAME</td>
            <td>DATE OF BIRTH</td>
            <td>GENDER</td>
            </thead>
                <tr>
                    <td>${obj.id}</td>
                    <td>${obj.name}</td>
                    <td>${obj.dob}</td>
                    <td>${obj.gender}</td>
                </tr>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>