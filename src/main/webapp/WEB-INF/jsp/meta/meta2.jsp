<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>对象列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>

<button onclick="showCreate()">新建</button>
<div id="div01" style="display: none;">
    数据库字段名<input type="text" id="display">
    <br/>
    字段中文描述<input type="text" id="des">
    <br/>
    <button id="createMeta">创建</button>
    <button id="cancel">取消</button>
</div>

<table class="layui-table" lay-data="{width: 892, height:500, url:'/meta/get/list', page:true, id:'idTest'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'name', width:80, sort: true, fixed: true}">name</th>
        <th lay-data="{field:'dis', width:80}">中文描述</th>

        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>
<div id='myDiv'
     style="display:none; POSITION:absolute; left:50%; top:50%; width:600px; height:400px; margin-left:-300px; margin-top:-200px; border:1px solid #888; background-color:#edf; text-align:center">
    显示meta详情<br><a href="javascript:closeLogin();">关闭</a></div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="${pageContext.request.contextPath}/resources/bootstrap/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/layui.js" charset="utf-8"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            //获得本行数据{,}
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('查看：' + data.name);
              window.location.href="/meta/get/"+data.name;
            } else if (obj.event === 'del') {
                layer.confirm('确认删除吗?', function (index) {
                    //??
                    layer.close(index);
                    //TODO ajax删除 返回code
                    $.ajax({
                        type: "POST",
                        url: "/meta/delete/meta",
                        data: {
                            meta: data.name
                        },
                        dataType: "json",
                        success: function (data) {
                            if (JSON.stringify(data) == '0') {
                                obj.del();
                            } else {
                                layer.msg('删除失败：错误码' + JSON.stringify(data));
                            }
                        }
                    });
                });
            } else if (obj.event === 'edit') {
                //TODO 跳转到详情页
                skip(data.name);

            }
        });

        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
<script>
    function openLogin(data) {
        document.getElementById("myDiv").style.display = "";
        document.getElementById("myDiv").innerHTML = data;
        //TODO div样式和解析出的meta信息展示
    }
    function closeLogin() {
        document.getElementById("myDiv").style.display = "none";
    }
    function skip(data) {
        //跳转到meta详情页,metaName传过去
        window.open("/metaDetail.jsp");
        //window.location.href = ${pageContext.request.contextPath}+"/meta/get/" + data;
    }
    function showCreate() {
        $('#div01').show();
    }
    $('#cancel').bind("click", function () {
        $('#div01').hide();
    })
    $('#createMeta').bind("click", function () {
        var meta = $('display').val();
        var des = $('des').val();
        $.ajax({
            type: "POST",
            url: "/post/" + meta,
            data: {
                "dispaly_name": meta,
                "descreption": des
            },
            dataType: "json",
            success: function (data) {
                alert(data);
            }
        });
    })

    $(function () {
        $.ajax({
            url: "/meta/get/list",
            data: {},
            type: 'Get',
            dataType: "json",
            success: function (data) {
                alert(data);
                //表格暂时data
            }


        })
    })
</script>
</body>
</html>
