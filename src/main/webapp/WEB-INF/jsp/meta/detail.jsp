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
<div>init meta detail jsp</div>
<button id="edit">编辑</button>
<div id="">
<textarea id="metaDetail"></textarea>
    <button style="display: none;" id="editBut">确认修改</button>
    <button style="display: none;" id="cancelBut">取消修改</button>
</div>

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