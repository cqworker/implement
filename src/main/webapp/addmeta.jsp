<%--
  Created by IntelliJ IDEA.
  User: cq
  Date: 12/6 0006
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>meiqia</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    数据库存储对象名:<input type="text" id="meta"><br/>
    页面显示对象名:<input type="text" id="display_name"><br/>
    对象描述<input type="text" id="description">
    <Input type="button" id="addmeta" value="创建meta">
</div>
<div id="msg"></div>
<div id="succ_msg"></div>
<a href="put/schema" style="display: none" id="editMeta">点此完善</a>

<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#addmeta').bind('click', function () {
            var mate = $('#meta').val();
            var name = $('#display_name').val();
            var des = $('#description').val();
            $.ajax({
                url: '/meta/post/' + mate,
                type: 'POST',
                dataType: 'json',
                data: {
                    "display_name": name,
                    "description": des
                },
                success: function (data) {

                    if (data.success) {
                        $('#succ_msg').html(data.message);
                        $('#editMeta').attr("href", data.meta);
                        $('#succ_msg').show();
                    } else {
                        $('#msg').html(data.message);
                    }
                }
            });
        })

    })


</script>
</body>
</html>
