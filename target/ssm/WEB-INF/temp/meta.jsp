<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/json.css"/>
</head>
<body>
${pageContext.request.contextPath}
<div>
    <c:forEach items="${dataMap.metaList}" var="m">
        <label>
            <input type="text" value="${m}"/>
            <input class="editMeta" type="button" id="${m}" value="修改">
        </label><br/>
    </c:forEach>
    <%--<c:forEach items="${dataMap.schemaList}" var="m">--%>
        <%--<label>--%>
            <%--<textarea name="" id="" cols="30" rows="10">${m}</textarea>--%>
        <%--</label><br/>--%>
    <%--</c:forEach>--%>

    <%--<c:forEach items="${dataMap.dependencyList}" var="m">--%>
        <%--<label>--%>
            <%--<input type="text" value="${m}"/>--%>
        <%--</label><br/>--%>
    <%--</c:forEach>--%>

</div>


<div style="width: 100%" >
    <c:forEach items="${list}" var="users">
        <div style="background-color: red;">${users.username } --${users.map.v} </div>
        <c:forEach items="${users.map}" var="m">
            <div style="background-color: yellow;">${m.key }--${m.value }</div>

        </c:forEach>
        <c:forEach items="${users.userList}" var="user">
            <div style="background-color: blue;">${user.username }--${user.map.v }</div>

        </c:forEach>
    </c:forEach>
</div>



<div id="fade" class="black_overlay">
</div>
<div id="MyDiv" class="white_content">
    <div style="text-align: right; cursor: default; height: 40px;" id="move">
        <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span>
    </div>
    detail
</div>


</body>


<script type="text/javascript">

    $(function () {
        $('.editMeta').bind('click',function () {


            ShowDiv('MyDiv','fade');
        })
    });

    function ShowDiv(show_div, bg_div) {

        $('#MyDiv').html();

        document.getElementById(show_div).style.display = 'block';
        document.getElementById(bg_div).style.display = 'block';
        var bgdiv = document.getElementById(bg_div);
        bgdiv.style.width = document.body.scrollWidth;
        $("#" + bg_div).height($(document).height());
    };
    //关闭弹出层
    function CloseDiv(show_div, bg_div) {
        document.getElementById(show_div).style.display = 'none';
        document.getElementById(bg_div).style.display = 'none';
    };

</script>
</html>
