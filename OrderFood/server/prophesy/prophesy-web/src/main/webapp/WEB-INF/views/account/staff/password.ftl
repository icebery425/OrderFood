<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="经营分析系统">
<meta name="description" content="经营分析系统">

    <link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/mystyle.css" rel="stylesheet">
    <link href="${ctx}/static/css/chosen.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/bootstrap-select.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jQueryUI/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jqgrid/ui.jqgrid.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jqgrid/jqGrid.style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/plugins/ValidationEngine/css/validationEngine.jquery.css">
<title>人员编辑</title>
<link rel="shortcut icon" href="favicon.ico">
<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
<style>
body{
	    background-color: #f3f3f4;
}
</style>
</head>
<body>
	<div class="wrapper wrapper-content" style="padding-bottom:20px">

		<form class="form-inline" id="modify_password_page_form" role="form">
		<fieldset style="width:50%; min-width:800px;">
			<input type="hidden" name="id" value="${(Session["sv"].staff.staffid)?c}">
			
			<div class="form-block" style="margin-top:15px;"><label class="control-label-div" style="text-align:left">账号名</label>
                <div style="display: inline; padding-left: 15px;">${Session["sv"].staff.staffcode}</div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-block"><label class="control-label-div" style="text-align:left">姓名</label>
                <div style="display: inline; padding-left: 15px;">${Session["sv"].staff.staffname}</div>
            </div>
            <div class="hr-line-dashed"></div>
            
            <div class="form-block">
            	<span class="red_color" style="position: absolute; padding-top: 8px;">*</span>
            	<label class="col-sm-2 control-label" style="padding-top:8px;">旧密码</label>
                <div style="display: inline; padding-left: 15px;"><input type="password" id="oldPassword" name="oldPassword"
                			 class="validate[required] form-control" placeholder="请输入旧密码" /></div>
            </div>
            <div class="hr-line-dashed"></div>
            
            <div class="form-block">
            	<span class="red_color" style="position: absolute; padding-top: 8px;">*</span>
            	<label class="col-sm-2 control-label" style="padding-top:8px;">新密码</label>
                <div style="display: inline; padding-left: 15px;"><input type="password" id="password" name="password"
                			 class="validate[required] form-control" placeholder="请输入新密码" /></div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-block">
            	<span class="red_color" style="position: absolute; padding-top: 8px;">*</span>
            	<label class="col-sm-2 control-label" style="padding-top:8px;">重复新密码</label>
                <div style="display: inline; padding-left: 15px;"><input type="password" class="validate[required,equals[password]] form-control"
                			 placeholder="请重复新密码" /></div>
            </div>
            
            
		</form>
		<div class="form-block" style="margin-top: 20px; text-align: right; padding-right: 20px;">
	        <input type="button" class="btn btn-success mr20" id="save-btn" value="保存"/>
	        <input type="button" class="btn btn-default" id="resert" value="重置"/>
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
<script src="${ctx}/static/js/jquery.form.js"></script>

<script src="${ctx}/static/js/seajs/sea.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/jquery.validationEngine.js?t=${.now?string("yyyyMMddHHmmss")}"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/languages/jquery.validationEngine-zh_CN.js?t=${.now?string("yyyyMMddHHmmss")}"></script>

<!-- 欢迎信息 -->
<script src="${ctx}/static/js/dateUtil.js"></script>
<script src="${ctx}/static/js/account/staff.js" type="text/javascript"></script>
<script>
$(function () {
		var ctx = "${ctx}";
		$("#save-btn").click(function(){Staff.doModifyPassword("modify_password_page_form", ctx);});
		$("#resert").click(function(){
			$("input[type='password']").val("");
		});
    });
</script>

</html>



