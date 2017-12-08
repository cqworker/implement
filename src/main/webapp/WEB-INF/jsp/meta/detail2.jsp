<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>meiqia</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div>init meta detail jsp</div>
<button id="add">添加</button>
<div id='addDiv' style="display: none;">
    <form>
    name:<input type="text" id="name"><br/>
    display_name:<input type="text" id="display_name"><br/>
    type:<select id="type">
    <option id="integer">integer</option>
    <option id="lookup">lookup</option>
    <option id="text">text</option>
    <option id="double">double</option>
</select><br/>
    option:<input type="text" name="option"><input type="text" name="option"><input type="text" name="option">
    <input type="text" name="option"><input type="text" name="option">
    nullable:<input type="checkbox" id="nullable"><br/>
    default_value<input type="submit" value="创建字段" >
        <input type="button" value="取消" id="cancel">
    </form>
</div>
<button id="delete">删除</button>
<div id="">
    <input type="button" value="" id="count">
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th>name</th>
            <th>display_name</th>
            <th>type</th>
            <th>option</th>
            <th>object_name</th>
            <th>delete_option</th>
            <th>nullable</th>
            <th>index</th>
            <th>unique</th>
            <th>searchable</th>
            <th>related_type</th>
            <th>expression</th>
            <th>format</th>
            <th>start_num</th>
            <th>default_value</th>
            <th>group</th>
            <th>writable</th>
            <th>readable</th>
        </tr>
        </thead>
        <tbody id="mytbody" style="">

        <c:forEach items="${list}" var="field">
            <tr>
                <td><input class="box" type="checkbox" id="${field.name}"></td>
                <td>${field.name}</td>
                <td>${field.display_name}</td>
                <td>${field.type}</td>
                    <%--<td>${field.option}</td>--%>
                <td>${field.object_name}</td>
                <td>${field.delete_option}</td>
                <td>${field.nullable}</td>
                <td>${field.index}</td>
                <td>${field.unique}</td>
                <td>${field.searchable}</td>
                <td>${field.related_type}</td>
                    <%--<td>${field.expression}</td>${}--%>
                <td>${field.format}</td>
                    <%--<td>${field.start_num}</td>--%>
                <td>${field.default_value}</td>
                <td>${field.group}</td>
                <td>${field.writable}</td>
                <td>${field.readable}</td>

            </tr>

        </c:forEach>

        </tbody>


    </table>


</div>

<div>
    © meiqia.com
</div>


<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#count").attr("value", $(".box").length);

        $('#createBut').click(function () {
            var meta = $('#meta').val();
            var display_name = $('#display_name').val();
            var description = $('#description').val();
            $.ajax({
                url: '/meta/post/' + meta,
                type: 'POST',
                dataType: 'json',
                data: {
                    "display_name": display_name,
                    "description": description
                },
                success: function (data) {
                    alert(data);
                }
            });
        });

        $('#cancel').bind("click", function () {
            $('#meta').html("");
            $('#display_name').html("");
            $('#description').html("");
            $('#addDiv').hide();
        })

        $('#delete').bind('click', function () {
            alert("o");
            var ids = $(".box:checked");
            var str = "[";
            for (var i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    str += ids.id;
                }
                str += ids.id + ",";
            }
            str += "]"

            $.ajax({
                url: '',
                data: {
                    "ids": str
                },
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    alert(data);
                }
            })


        });
        $('#add').bind("click", function () {
            $('#addDiv').show();
        })

    });


</script>

</body>
</html>