<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
invitation
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">邀请用户</li>
        <li>查看已存在用户</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/invitation/post">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="required" placeholder="张三" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">User-Phone</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone" lay-verify="required" placeholder="+86 18585835699" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">User-Email</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email" lay-verify="required" placeholder="wangyi@163.com" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <input class="layui-btn" type="submit" value = "邀请"/>
            </form>
        </div>

        <div class="layui-tab-item">Developing</div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui.js" charset="utf-8">
</script>
<script>
    layui.use('element', function(){
    })
</script>
</body>
</html>