<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>对象列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css" media="all">
</head>
<body>
增加查看编辑按钮---
<table class="layui-table" lay-data="{width: 892, height:'full-200', url:'/meta/get/list', page:true, id:'idTest'}"
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
                //TODO ajax获取详细信息
                $.ajax({
                    type: "GET",
                    url: "/meta/get/" + data.name,
                    data: {},
                    dataType: "json",
                    success: function (data) {
                        //TODO 解析返回数据
                        //{"code": 0,"msg": "","count": 41, "data":[{"name":"CatalogName","display_name":"商品目录名称","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CommodityName","display_name":"商品名称","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CommodityNumber","display_name":"商品编号","type":"text","readable":true,"writable":true},{"name":"CycleSettlementDate","display_name":"周期结算日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"CycleSettlementOrderID","display_name":"周期结算单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CycleSettlementStatus","display_name":"周期结算状态","type":"text","nullable":true,"default_value":{"value":"未结算"},"readable":true,"writable":true},{"name":"DeliveryAccount","display_name":"交收量","type":"double","readable":true,"writable":true},{"name":"DeliveryDate","display_name":"交收日期","type":"date","searchable":true,"readable":true,"writable":true},{"name":"DeliveryMan","display_name":"交收专员","type":"text","nullable":true,"readable":true,"writable":true},{"name":"DeliveryMode","display_name":"交付方式","type":"picklist","options":{"list":{"all":{"options_value":["自提","送到"]}}},"readable":true,"writable":true},{"name":"FilesName","display_name":"文件名称","type":"folder","readable":true,"writable":true},{"name":"LowerEnterpriseName","display_name":"下游企业名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"NumberOfVehicles","display_name":"车数","type":"integer","nullable":true,"readable":true,"writable":true},{"name":"PlaceOfDelivery","display_name":"交付地","type":"address","readable":true,"writable":true},{"name":"PlaceOfDispatch","display_name":"发货地","type":"address","readable":true,"writable":true},{"name":"QualityListDate","display_name":"质检日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"QualityListID","display_name":"质检单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"QualityTestStatus","display_name":"质检状态","type":"text","nullable":true,"searchable":true,"default_value":{"value":"待质检"},"readable":true,"writable":true},{"name":"RelateQualityList","display_name":"关联质检单","type":"lookup","object_name":"QualityList","delete_option":"NoAction","nullable":true,"readable":true,"writable":true},{"name":"RelateTransactionNode","display_name":"关联交易节点","type":"lookup","object_name":"TransactionNode","delete_option":"NoAction","readable":true,"writable":true},{"name":"ScheduleSettlementDate","display_name":"进度结算日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"ScheduleSettlementID","display_name":"进度结算单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"ScheduleSettlementStatus","display_name":"进度结算状态","type":"text","nullable":true,"default_value":{"value":"未结算"},"readable":true,"writable":true},{"name":"SendoutDate","display_name":"发货日期","type":"date","readable":true,"writable":true},{"name":"SupplyChainID","display_name":"供应链编号","type":"text","nullable":true,"searchable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"SupplyChainName","display_name":"供应链名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"TransactionNodeID","display_name":"交易节点编号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"TransportMode","display_name":"运输方式","type":"picklist","options":{"list":{"all":{"options_value":["汽车","火车","轮船","管道","其他"]}}},"readable":true,"writable":true},{"name":"TransportationEnterprise","display_name":"负责运输企业","type":"picklist","options":{"list":{"all":{"options_value":["上游企业","下游企业","第三方企业","平台公司"]}}},"readable":true,"writable":true},{"name":"UpperEnterpriseName","display_name":"上游企业名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"created_at","display_name":"创建时间","type":"datetime","readable":true},{"name":"created_by","display_name":"创建人","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"id","display_name":"ID","type":"object_id","readable":true},{"name":"name","display_name":"交收单号","type":"autonumber","format":"RCJS{YYYY}{MM}{DD}{000000}","index":true,"unique":true,"readable":true},{"name":"owner","display_name":"所有者","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"record_type","display_name":"记录类型","type":"picklist","options":{"list":{"all":{"options_value":["main"]}}},"default_value":{"value":"main"},"readable":true,"writable":true},{"name":"system_mod_stamp","display_name":"系统修改时间","type":"datetime","readable":true},{"name":"updated_at","display_name":"修改时间","type":"datetime","readable":true},{"name":"updated_by","display_name":"修改人","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"version","display_name":"版本","type":"integer","default_value":{"value":"0"},"readable":true},{}]}
                    }
                });
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
        window.open ("/metaDetail.jsp");
        //window.location.href = ${pageContext.request.contextPath}+"/meta/get/" + data;
    }

</script>
</body>
</html>
