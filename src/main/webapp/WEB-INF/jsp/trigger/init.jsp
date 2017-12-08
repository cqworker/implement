<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>init list jsp</div>

<div style="">
    <button id="create">创建</button>
    <button id="delete">删除</button>
</div>

<div id="createDiv" style="display: none">
    对象名: <input type="text" id="metaName"/>
    触发器内容: <input type="text" id="triggerContext"/>
    <button id="createBut">创建</button>
    <button id="cancel">取消</button>
</div>

<div id="deleteDiv" style="display: none">
    <input type="text" id="msg" value="请确认关联已删除">
    <button id="deleteBut">确认删除</button>
    <button id="canceldel">取消</button>
</div>

<table id="myTable">
    <thead>
    <tr>
        <th></th>
        <th>对象</th>
        <th>触发器描述</th>
        <th>触发器内容</th>
    </tr>
    </thead>
    <tbody id="myTBody">
    <c:forEach var="data" items="${list}">
        <tr>
            <td><input type="checkbox" id="${data.meta}"></td>
            <td>${data.meta}</td>
            <td>${data.display}</td>
            <td>${data.context}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

</script>

<script type="text/javascript">
    $(function () {
        //创建
        $("#create").bind("click", function () {
            $('#createDiv').show();
        });
        $("#cancel").bind("click", function () {
            $('#createDiv').hide();
        });
        $("#createBut").bind("click", function () {
            var metaName = $('metaName').val();
            var triggerContext = $("triggerContext").val();
            //非空验证
            $.ajax({
                url: "/trigger/post/" + metaName,
                type: "Post",
                data: {
                    "trigger": triggerContext
                },
                dataType: "json",
                success: function (data) {
                    alert(data);
                    if (data.success) {
                        $('#createDiv').hide();
                    }
                }
            });
        })
        //删除
        $('#delete').bind("click",function () {
            $('#deleteDiv').show();
        })
        $('#canceldel').bind("click",function () {
            $('#deleteDiv').hide();
        })

    })
</script>
</body>
</html>