<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>用户管理</title>

    <meta name="keywords" content="经营分析系统">
    <meta name="description" content="经营分析系统">

    <link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/common.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/mystyle.css" rel="stylesheet">
    <link href="${ctx}/static/css/chosen.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/bootstrap-select.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jQueryUI/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jqgrid/ui.jqgrid.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jqgrid/jqGrid.style.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/loading-master/loading.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/plugins/ValidationEngine/css/validationEngine.jquery.css">
    
    <style>
    .w100{
    	width:100px !important;
    }
    
    </style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
<div class="wrapper wrapper-content">

        <fieldset>
            <div>
            	<div class="form-group" style=''>
					<label class="col-sm-2 control-label pt7" style='width: 60px;text-align: left;'>名称</label>
					<div class="col-sm-10">
         				<div class="input-group m-b"  style='width: 325px;'>
         					<input type="text" class="form-control"id="keywords" name="keywords" class="" placeholder="名称/工号" /> 
                   			<span class="input-group-btn"> 
                   				<input type="button" class="btn btn-primary" id="search" value="查询" />
                         	</span>
                        </div>
        			</div>
				</div>
            	
            </div>
            
        </fieldset>
    
    <div class="box-control">
    	<div class="btn-toolbar m-b-sm">
            <@shiro.hasPermission name="staff:add">
            	<div class="btn-group">
                <input type="button" id="add-btn" class="btn-sm btn btn-primary" value="新增"/>
                </div>
            </@shiro.hasPermission>

        </div>
    	<div class="jqGrid_wrapper">
            <table id="table_list_1"></table>
            <div id="pager_list_1"></div>
    	</div>
        
    </div>

</div>
</body>

<!-- 全局js -->
<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.4.0"></script>

<script src="${ctx}/static/js/datePicker/WdatePicker.js"></script>

<script src="${ctx}/static/js/plugins/bootstrap-select-bi.js"></script>
<script src="${ctx}/static/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctx}/static/js/plugins/jqGrid/i18n/grid.locale-cn.js"></script>
<script src="${ctx}/static/js/plugins/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx}/static/js/plugins/cityutil.js"></script>
<script src="${ctx}/static/js/module/plugins/blue.js"></script>
<script src="${ctx}/static/js/layer2.2/layer.js"></script>
<script src="${ctx}/static/js/layer2.2/extend/layer.ext.js"></script>
<!-- 自定义js -->
<script src="${ctx}/static/js/content.min.js"></script>

<script src="${ctx}/static/js/seajs/sea.js"></script>
<script src="${ctx}/static/plugins/loading-master/loading.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/languages/jquery.validationEngine-zh_CN.js"></script>

<!-- 欢迎信息 -->
<script src="${ctx}/static/js/dateUtil.js"></script>
<script src="${ctx}/static/js/account/staff.js" type="text/javascript"></script>
<script>
    var staff_edit_role =false;
    var staff_delete_role =false;

    <@shiro.hasPermission name="staff:edit">
        staff_edit_role = true;
    </@shiro.hasPermission>

    <@shiro.hasPermission name="staff:delete">
        staff_delete_role = true;
    </@shiro.hasPermission>
	var ctx = '${ctx}';
    $(function () {
        Staff.init(ctx);
    });

</script>

</html>




