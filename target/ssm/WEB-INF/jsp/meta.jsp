<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>对象列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>

<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 'full-200'//高度最大化适应
            ,url: '/meta/get/list' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'name', title: 'name', width:200,fixed: 'left'}
                ,{field: 'dis', title: '中文描述', width:200}
            ]]
        });

    });
</script>
</body>
</html>
