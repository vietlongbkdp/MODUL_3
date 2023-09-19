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
        <h3 class="text-center">List Student Removed</h3>
        <div style="display: flex">
            <form  method="post">
                <button type="submit" formaction="/student?action=no1" class="btn btn-secondary mb-2">BACK</button>
            </form>
        </div>
        <table class="table table-striped">
            <thead>
            <td>ID</td>
            <td>NAME</td>
            <td>DATE OF BIRTH</td>
            <td>GENDER</td>
            <td>ACTION</td>
            </thead>
            <c:forEach var="student" items="${studentRestore}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.dob}</td>
                <td>${student.gender}</td>
                <td>
                    <form  action="/student?action=restore${student.getId()}" method="post">
                        <button type="submit" class="btn btn-info mb-2">RESTORE</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
