<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Javascript</title>
    <link href="resources/navjs/iconfont.css" rel="stylesheet">
    <link href="resources/navjs/nav.css" rel="stylesheet">
    <script type="text/javascript" src="resources/bootstrap/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resources/navjs/nav.js"></script>
</head>
<body>

<div class="nav">
    <div class="nav-top">
        <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><a>meiqia</a></div>
    </div>
    <ul>
        <li class="nav-item">
            <a href="javascript:;"><i class="my-icon nav-icon icon_1"></i><span>租户配置</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="" id="tenement"><span>创建租户</span></a></li>
                <li><a href="javascript:;"><span></span></a></li>
                <li><a href="javascript:;"><span>帮助文档</span></a></li>
                <li><a href="javascript:;"><span></span></a></li>
                <li><a href="javascript:;"><span></span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><i class="my-icon nav-icon icon_2"></i><span>标准对象管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="" id="list"><span>标准对象</span></a></li>
                <li><a href="javascript:;"><span>详情页</span></a></li>
                <li><a href="javascript:;"><span>编辑页</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><i class="my-icon nav-icon icon_3"></i><span>触发器管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>订单列表</span></a></li>
                <li><a href="javascript:;"><span>打个酱油</span></a></li>
                <li><a href="javascript:;"><span>也打酱油</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><i class="my-icon nav-icon icon_3"></i><span>验证器管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>订单列表</span></a></li>
                <li><a href="javascript:;"><span>打个酱油</span></a></li>
                <li><a href="javascript:;"><span>也打酱油</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;"><i class="my-icon nav-icon icon_3"></i><span>审批管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="javascript:;"><span>订单列表</span></a></li>
                <li><a href="javascript:;"><span>打个酱油</span></a></li>
                <li><a href="javascript:;"><span>也打酱油</span></a></li>
            </ul>
        </li>
    </ul>
</div>

<div style="position:absolute;right:0px;top: 10px;left: 220px;height: 100%" >
    <!-- 内容主体区域 -->
        <iframe src="${pageContext.request.contextPath}/home.jsp" frameborder="0" id="myiframe" style="height: 100%;width: 100%"></iframe>
</div>
<script type="text/javascript">
    $(function () {
        $('#list').bind("click",function () {
            $('#myiframe').attr("src","${pageContext.request.contextPath}/meta/get/list");
        });
        $('#tenement').bind("click",function () {
            $('#myiframe').attr("src","${pageContext.request.contextPath}/tenement/init");
        });
    })
</script>
</body>
</html>