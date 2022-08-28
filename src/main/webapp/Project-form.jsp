<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Project Management Application</title>

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Project Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listProject"
                   class="nav-link">Projects</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${project != null}">
            <form action="updateProject" method="post">
                </c:if>
                <c:if test="${project == null}">
                <form action="insertProject" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${project != null}">
                                Edit Project
                            </c:if>
                            <c:if test="${project == null}">
                                Add New Project
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${project != null}">
                        <input type="hidden" name="id" value="<c:out value='${project.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Project Name</label> <input type="text"
                                                             value="<c:out value='${project.name}' />" class="form-control"
                                                             name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Project Time Of Creation</label> <input type="datetime-local"
                                                            value="<c:out value='${project.time_of_creation}' />" class="form-control"
                                                            name="time_of_creation">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Customer</label> <input type="text"
                                                               value="<c:out value='${project.customer}' />" class="form-control"
                                                               name="customer">
                    </fieldset>

                        <fieldset class="form-group">
                            <label>Company</label> <input type="text "
                                                                   value="<c:out value='${project.company}' />" class="form-control"
                                                                   name="company">
                        </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
