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
<div class="layui-tab">
    init
    <ul class="layui-tab-title">
        <li class="layui-this">实施前设置</li>
        <li>其他</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" action="${pageContext.request.contextPath}/cache/post" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">x-token</label>
                    <div class="layui-input-block">
                        <input type="text" name="token"  autocomplete="off" placeholder="" value="AWYAAHUyBFoAAEFRQUNrNUh4RkliZURnQUFHTEw1OWJwUzdoUnZDUUFBQVFBQ2s1SHhGSWJlRGdBQWNMN3I5YnBTN2hSdUNRQUH29KZb95dSWepNWi70DzznXEElFx7pU9J-pm2o23blOqNeoULhdmaoHW_KmConP4nBgnKNk4T8MQl3G2ZlrEn8" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">实施环境</label>
                    <div class="layui-input-block">
                        <input type="text" name="ip" placeholder="" value="10.102.1.64" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">租户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="tenementName" placeholder="" value="GuoXinLianCheng" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input class="layui-btn" type="submit" value="配置">
                        <input class="layui-btn" type="button" value="重置">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
</script>
</html>