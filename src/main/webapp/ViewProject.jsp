<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Project Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listProject"
                   class="nav-link">Projects</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Projects</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newProject" class="btn btn-success">Add
                New Project</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Time Of Creation</th>
                <th>Customer</th>
                <th>Company </th>

            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="project" items="${listProject}">

                <tr>
                    <td><c:out value="${project.id}" /></td>
                    <td><c:out value="${project.name}" /></td>
                    <td><c:out value="${project.time_of_creation}" /></td>
                    <td><c:out value="${project.customer}" /></td>
                    <td><c:out value="${project.company}" /></td>
                    <td><a href="editProject?id=<c:out value='${project.id}' />">Edit</a>
                        <a href="deleteProject?id=<c:out value='${project.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

<a href="<%=request.getContextPath()%>/listCustomer">View Customers</a><br>

<a href="<%=request.getContextPath()%>/list">View Developers</a><br>

</body>
</html>
