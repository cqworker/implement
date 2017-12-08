<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>meiqia</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="name" placeholder="帐户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="pwd" placeholder="密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住我</span>
                    <button class="btn btn-default" id="login">立刻登录</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="msg">
</div>
<div>
    © meiqia.com
</div>
<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#login').click(function () {
            var name = $('#name').val();
            var pwd = $('#pwd').val();
            $.ajax({
                url: '/user/login',
                type: 'POST',
                dataType:'json',
                data: {
                    "name": name,
                    "pwd": pwd
                },
                success: function (data) {
                    var success = data.success;
                    if (success) {
                        $('#msg').html(data.message);
                    } else {
                        $('#msg').html(data.message);
                    }
                }
            });
        });
    })
    ;
</script>

</body>
</html>