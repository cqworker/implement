<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>对象列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
<script>
    var html = "";
    <c:forEach items="list" var="meta">
        html +="
            <th>${meta.name}</th>
            <th>${meta.name}</th>
            <th>${meta.name}</th>
            <th>${meta.name}</th>
            "
    $("#body").innerHTML=html;
    </c:forEach>


</script>
<table>
<thead id="head">
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
</thead>
    <tbody id="body">

    <th>${meta.name}</th>
    <th>${meta.name}</th>
    <th>${meta.name}</th>
    <th>${meta.name}</th>


    </tbody>



</table>

<script>
</script>
</body>
</html>
