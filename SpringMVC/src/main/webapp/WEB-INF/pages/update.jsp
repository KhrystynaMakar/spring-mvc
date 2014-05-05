<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Update</title>
    <style>
        <%@include file="../../resources/tableStyle.css"%>
    </style>
</head>
<body>
    <form:form modelAttribute="fruit" method="post">
        <table class="table1">
            <tr>
                <td align="right"><form:label path="iID">ID: </form:label></td>
                <td><form:input path="iID" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name: </form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="weight">Weight: </form:label></td>
                <td><form:input path="weight"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price: </form:label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td><form:label path="citrus">Citrus: </form:label></td>
                <td><form:input path="citrus"/></td>
            </tr>
            <tr>
                <td><form:label path="orderID">OrderID: </form:label></td>
                <td><form:input path="orderID"/></td>
            </tr>
            <tr>
                <td><input class="button green" type="submit" value="Save"/></td>
                <td><input class="button green" type="button" value="List" onclick="top.location.href='http://localhost:8080/list'"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
