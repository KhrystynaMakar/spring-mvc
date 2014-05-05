<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--<link rel="stylesheet" type="text/css" href="../resources/tableStyle.css">--%>
    <style>
        <%@include file="../../resources/tableStyle.css"%>
    </style>

</head>
<body>
    <form >
        <table class="table1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>name</th>
                    <th>price</th>
                    <th colspan="2">actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${fruitsList}" var="fruit">
                    <tr>
                        <td>${fruit.iID}</td>
                        <td>${fruit.name}</td>
                        <td>${fruit.price}</td>
                        <td ><input type="button" name="update" value="Update" class="button green" onclick="top.location.href='http://localhost:8080/update/${fruit.iID}'"/></td>
                        <td><input type="button" name="delete" value="Delete" class="button green" onclick="top.location.href='http://localhost:8080/delete/${fruit.iID}'"/></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5" align="center"><input type="button" class="button green" name="add" value="Add" onclick="top.location.href='http://localhost:8080/add'"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>