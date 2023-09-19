<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LONG PC
  Date: 9/18/2023
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">Create Student</h3>
        <form action="${pageContext.request.contextPath}/student?action=create1" method="post">
            <button type="submit" class="btn btn-success">SUBMIT</button>
            <div class="mb-3">
                <label for="name" class="form-label">Input Name</label>
                <input type="text" class="form-control" placeholder="Enter your name" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="dob" class="form-label">Select Date of Birth</label>
                <input type="date" class="form-control" id="dob" name="dob">
            </div>
            <div>
                <label for="gender" class="form-label">Select your gender</label>
                <select class="form-control" name="gender" id="gender">
                    <c:forEach var="gender" items="${genders}">
                    <option value="${gender}">${gender}</option>
                    </c:forEach>
                </select>
            </div>
        </form>
    </div>
</div>

</body>
</html>
