<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a class="navbar-brand"> Customer Management App </a>
        </div>


    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${customer != null}">
            <form action="updateCustomer" method="post">
                </c:if>
                <c:if test="${customer == null}">
                <form action="insertCustomer" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${customer != null}">
                                Edit Customer
                            </c:if>
                            <c:if test="${customer == null}">
                                Add New Customer
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${customer != null}">
                        <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Customer Name</label> <input type="text"
                                                            value="<c:out value='${customer.name}' />"
                                                            class="form-control"
                                                            name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Customer Surname</label> <input type="text"
                                                               value="<c:out value='${customer.sex}' />"
                                                               class="form-control"
                                                               name="surname">
                    </fieldset>


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
