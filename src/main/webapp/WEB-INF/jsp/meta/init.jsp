<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div>init meta list jsp</div>
<button id="create">创建</button>

<div id="createDiv" style="display: none">
    数据库存储对象名:<input type="text" id="meta"><br/>
    页面显示对象名:<input type="text" id="display_name"><br/>
    对象描述<input type="text" id="description">
    <button id="createBut">创建</button>
    <button id="cancel">取消</button>
</div>
<table>
    <thead>
    <tr>
        <th></th>
        <th>对象</th>
        <th>对象描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="metaList">
    <tr>
        <td><input type="checkbox"></td>
        <td></td>
        <td></td>
        <td><button id="delete">删除</button>
            <button id="edit">编辑</button></td>
    </tr>
    </tbody>
</table>


<div>
    © meiqia.com
</div>


<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url:'/meta/get/list',
            data:{},
            type:'Get',
            dataType:'json',
            success:function (data) {
                //组装表格
                alert('ok'+ data);
            }
        });

        $('#createBut').click(function () {
            var meta = $('#meta').val();
            var display_name = $('#display_name').val();
            var description = $('#description').val();
            $.ajax({
                url: '/meta/post/'+meta,
                type: 'POST',
                dataType:'json',
                data: {
                    "display_name": display_name,
                    "description": description
                },
                success: function (data) {
                   alert(data);
                }
            });
        });

        $('#cancel').bind("click",function () {
            $('#meta').html("");
            $('#display_name').html("");
            $('#description').html("");
            $('#createDiv').hide();
        })
    });


</script>

</body>
</html>