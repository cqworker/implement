<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="meta列表">
    <title>metaDetail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
表字段列表不可编辑
<table id="demo" lay-filter="test"></table>

<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 315
            ,url: 'meta/get/111' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'name', title: 'name', width:70,fixed: 'left'}
                ,{field: 'display_name', title: '中文描述', width:90}
                ,{field: 'type', title: '类型', width:60}
                ,{field: 'options', title: '类型可选', width:90}
                ,{field: 'object_name', title: '关联对象', width: 90}
                ,{field: 'delete_option', title: '关联行为', width: 90}
                ,{field: 'nullable', title: '可为空', width: 75}
                ,{field: 'index', title: '设置索引', width: 90}
                ,{field: 'unique', title: '唯一', width: 60}
                ,{field: 'searchable', title: '可检索', width: 80}
                ,{field: 'related_type', title: '关联类型', width: 90}
                ,{field: 'expression', title: '表达式', width: 75}
                ,{field: 'format', title: '格式化', width: 75}
                ,{field: 'start_number', title: '序号', width: 75,}
                ,{field: 'default_value', title: '默认值', width: 75}
                ,{field: 'group', title: '组', width: 40}
                ,{field: 'readable', title: '可读', width: 60}
                ,{field: 'writable', title: '可写', width: 60}
            ]]
        });

    });
</script>
</body>
</html>
