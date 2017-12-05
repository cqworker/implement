<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>meiqia</title>
    <link rel="stylesheet" href="resources/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">meiqia 实施</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a onclick="changeIframe('tenement')">租户管理</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('invitation')">邀请用户</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('meta')">标准对象管理</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('validation')">Validation管理</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('trigger')">Trigger管理</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('trigger')">Trigger管理</a></li>
            <li class="layui-nav-item"><a onclick="changeIframe('trigger')">Trigger管理</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它</a>
                <dl class="layui-nav-child">
                    <dd><a href="">审批管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">权限管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="resources/images/face/0.gif" class="layui-nav-img">
                    meiqia
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">更换实施环境</a></dd>
                    <dd><a href="">更换租户</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出实施</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">

                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="https://wiki.meiqia.com/pages/viewpage.action?pageId=16058753">租户创建</a></dd>
                        <dd><a href="https://wiki.meiqia.com/pages/viewpage.action?pageId=13861836">Trigger</a></dd>
                        <dd><a href="https://wiki.meiqia.com/pages/viewpage.action?pageId=16058759">用户邀请</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">其他</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe src="${pageContext.request.contextPath}/init.jsp" frameborder="0" id="1" style="width: 100%; height: 100%;"></iframe>
        </div>


    </div>
</div>

<div class="layui-footer">
    © meiqia.com
</div>
</div>
<script src="resources/layui.js"></script>
<script>
    layui.use('element', function () {
        var element = layui.element;

    });
    function changeIframe(iframeName) {
        document.getElementById('1').setAttribute('src',"${pageContext.request.contextPath}"+"/"+iframeName+"/"+"init");
    }
</script>

</body>
</html>