<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="自动列表可编辑表格">
    <title>metaDetail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
表字段列表
<table class="layui-table" lay-data="{height: 'full-200', url:'meta/get/111', cellMinWidth: 60,}" lay-filter="demoEvent" >
    <thead>
    <tr>
        <th lay-data="{field: 'name', width:50,event: '1', style:'cursor: pointer;'}">name</th>
        <th lay-data="{field:'display_name', width:80,event: '2', style:'cursor: pointer;'}">display_name</th>
        <th lay-data="{field: 'options', width:60,event: '3', style:'cursor: pointer;'}">options</th>
        <th lay-data="{field:'experience', width:60,event: '4', style:'cursor: pointer;'}">experience</th>
        <th lay-data="{field:'object_name', width:60,event: '5', style:'cursor: pointer;'}">object_name</th>
        <th lay-data="{field:'delete_option', width:60,event: '6', style:'cursor: pointer;'}">delete_option</th>
        <th lay-data="{field:'nullable', width:60,event: '7', style:'cursor: pointer;'}">nullable</th>
        <th lay-data="{field:'index', width:60,event: '8', style:'cursor: pointer;'}">index</th>
        <th lay-data="{field:'unique', width:60,event: '9', style:'cursor: pointer;'}">unique</th>
        <th lay-data="{field:'searchable', width:60,event: '11', style:'cursor: pointer;'}">searchable</th>
        <th lay-data="{field:'related_type', width:60,event: '22', style:'cursor: pointer;'}">related_type</th>
        <th lay-data="{field:'expression', width:60,event: '33', style:'cursor: pointer;'}">expression</th>
        <th lay-data="{field:'format', width:60,event: '44', style:'cursor: pointer;'}">format</th>
        <th lay-data="{field:'start_number', width:60,event: '55', style:'cursor: pointer;'}">default_value</th>
        <th lay-data="{field:'default_value', width:60,event: '66', style:'cursor: pointer;'}">default_value</th>
        <th lay-data="{field:'group', width:60,event: '77', style:'cursor: pointer;'}">group</th>
        <th lay-data="{field:'readable', width:60,event: '88', style:'cursor: pointer;'}">readable</th>
        <th lay-data="{field:'writable', width:60,event: '99', style:'cursor: pointer;'}">writable</th>
    </tr>
    </thead>
</table>


<script src="${pageContext.request.contextPath}/resources/layui.js" charset="utf-8"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听单元格事件
        table.on('tool(demoEvent)', function(obj){
            var data = obj.data;
            if(obj.event === '1'){
                layer.prompt({
                    formType: 1
                    ,title: '修改 name 为 ['+ data.name +'] 的字段'
                    ,value: data.name
                }, function(value, index){
                    layer.close(index);

                    //这里一般是发送修改的Ajax请求

                    //同步更新表格和缓存对应的值
                    obj.update({
                        name: value
                    });
                });
            }
            if(obj.event === '2'){
                layer.prompt({
                    formType: 2
                    ,title: '修改 name 为 ['+ data.name +'] 的字段'
                    ,value: data.display_name
                }, function(value, index){
                    layer.close(index);

                    //这里一般是发送修改的Ajax请求

                    //同步更新表格和缓存对应的值
                    obj.update({
                        display_name: value
                    });
                });
            }
            if(obj.event === '3'){
                layer.prompt({
                    formType: 3
                    ,title: '修改 name 为 ['+ data.name +'] 的字段'
                    ,value: data.options
                }, function(value, index){
                    layer.close(index);

                    //这里一般是发送修改的Ajax请求

                    //同步更新表格和缓存对应的值
                    obj.update({
                        options: value
                    });
                });
            }
        });
    });
</script>
</body>
</html>
