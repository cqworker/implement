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


可编辑表字段列表
<table class="layui-table" lay-data="{height: 'full-200', url:'meta/get/111', cellMinWidth: 60,}" lay-filter="demoEvent" >
    <thead>
    <tr>
        <th lay-data="{field: 'name', width:50,event: 'name', style:'cursor: pointer;'}">name</th>
        <th lay-data="{field:'display_name', width:80,event: 'display_name', style:'cursor: pointer;'}">display_name</th>
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
    document.getElementsByClassName("layui-table")[0].attributes["lay-data"].url = 'meta/get/111';
</script>
<script>

    //接收事件标志,返回function
    function zhuz(eventSign,data){
        layer.prompt({
            formType: 2
            ,title: '修改 name 为 ['+ data.name +'] 的字段'
            ,value: data.options
        }, function(value, index){
            layer.close(index);
            $.ajax({
                type: "POST",
                url: "put/" + data.name,
                data: {
                    "name": data.name,
                    "display_name": data.display_name,
                    "type": data.type,
                    "nullable": false,
                    "index": false,
                    "unique": false,
                    "default_value": {
                        "value": "4",
                        "dynamic": false
                    }
                },
                dataType: "json",
                success: function (data) {
                    //TODO 解析返回数据
                    //{"code": 0,"msg": "","count": 41, "data":[{"name":"CatalogName","display_name":"商品目录名称","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CommodityName","display_name":"商品名称","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CommodityNumber","display_name":"商品编号","type":"text","readable":true,"writable":true},{"name":"CycleSettlementDate","display_name":"周期结算日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"CycleSettlementOrderID","display_name":"周期结算单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"CycleSettlementStatus","display_name":"周期结算状态","type":"text","nullable":true,"default_value":{"value":"未结算"},"readable":true,"writable":true},{"name":"DeliveryAccount","display_name":"交收量","type":"double","readable":true,"writable":true},{"name":"DeliveryDate","display_name":"交收日期","type":"date","searchable":true,"readable":true,"writable":true},{"name":"DeliveryMan","display_name":"交收专员","type":"text","nullable":true,"readable":true,"writable":true},{"name":"DeliveryMode","display_name":"交付方式","type":"picklist","options":{"list":{"all":{"options_value":["自提","送到"]}}},"readable":true,"writable":true},{"name":"FilesName","display_name":"文件名称","type":"folder","readable":true,"writable":true},{"name":"LowerEnterpriseName","display_name":"下游企业名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"NumberOfVehicles","display_name":"车数","type":"integer","nullable":true,"readable":true,"writable":true},{"name":"PlaceOfDelivery","display_name":"交付地","type":"address","readable":true,"writable":true},{"name":"PlaceOfDispatch","display_name":"发货地","type":"address","readable":true,"writable":true},{"name":"QualityListDate","display_name":"质检日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"QualityListID","display_name":"质检单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"QualityTestStatus","display_name":"质检状态","type":"text","nullable":true,"searchable":true,"default_value":{"value":"待质检"},"readable":true,"writable":true},{"name":"RelateQualityList","display_name":"关联质检单","type":"lookup","object_name":"QualityList","delete_option":"NoAction","nullable":true,"readable":true,"writable":true},{"name":"RelateTransactionNode","display_name":"关联交易节点","type":"lookup","object_name":"TransactionNode","delete_option":"NoAction","readable":true,"writable":true},{"name":"ScheduleSettlementDate","display_name":"进度结算日期","type":"date","nullable":true,"readable":true,"writable":true},{"name":"ScheduleSettlementID","display_name":"进度结算单号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"ScheduleSettlementStatus","display_name":"进度结算状态","type":"text","nullable":true,"default_value":{"value":"未结算"},"readable":true,"writable":true},{"name":"SendoutDate","display_name":"发货日期","type":"date","readable":true,"writable":true},{"name":"SupplyChainID","display_name":"供应链编号","type":"text","nullable":true,"searchable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"SupplyChainName","display_name":"供应链名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"TransactionNodeID","display_name":"交易节点编号","type":"text","nullable":true,"readable":true,"writable":true},{"name":"TransportMode","display_name":"运输方式","type":"picklist","options":{"list":{"all":{"options_value":["汽车","火车","轮船","管道","其他"]}}},"readable":true,"writable":true},{"name":"TransportationEnterprise","display_name":"负责运输企业","type":"picklist","options":{"list":{"all":{"options_value":["上游企业","下游企业","第三方企业","平台公司"]}}},"readable":true,"writable":true},{"name":"UpperEnterpriseName","display_name":"上游企业名称","type":"text","nullable":true,"default_value":{"value":"保存时自动添加"},"readable":true,"writable":true},{"name":"created_at","display_name":"创建时间","type":"datetime","readable":true},{"name":"created_by","display_name":"创建人","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"id","display_name":"ID","type":"object_id","readable":true},{"name":"name","display_name":"交收单号","type":"autonumber","format":"RCJS{YYYY}{MM}{DD}{000000}","index":true,"unique":true,"readable":true},{"name":"owner","display_name":"所有者","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"record_type","display_name":"记录类型","type":"picklist","options":{"list":{"all":{"options_value":["main"]}}},"default_value":{"value":"main"},"readable":true,"writable":true},{"name":"system_mod_stamp","display_name":"系统修改时间","type":"datetime","readable":true},{"name":"updated_at","display_name":"修改时间","type":"datetime","readable":true},{"name":"updated_by","display_name":"修改人","type":"lookup","object_name":"User","delete_option":"Restrict","readable":true},{"name":"version","display_name":"版本","type":"integer","default_value":{"value":"0"},"readable":true},{}]}
                }
            });
            obj.update({
                options: value
            });
        });


    }
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听单元格事件
        table.on('tool(demoEvent)', function(obj){
            var data = obj.data;
            //TODO 组装请求
            zhuz(obj.event,data);
            if(obj.event === 'name'){
                layer.prompt({
                    formType: 2
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
            if(obj.event === 'display_name'){
                layer.prompt({
                    formType: 2
                    ,title: '修改 names 为 ['+ data.name +'] 的字段'
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
            if(obj.event === 'options'){
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
