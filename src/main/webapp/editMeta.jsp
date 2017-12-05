<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="resources/css/layui.css" media="all">
</head>
<body>
<form class="layui-form layui-form-pane" action="">
<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">Schema</label>
    <div class="layui-input-block">
        <textarea placeholder="请修改" class="layui-textarea"></textarea>
    </div>
</div><br/>
    <span>&nbsp;&nbsp;&nbsp;</span>  <button class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>  <button class="layui-btn" lay-submit="" lay-filter="demo1">取消修改</button>
</form>
<script src="resources/layui.js" charset="utf-8"></script>

</body>
</html>