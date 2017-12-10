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
    <link rel="stylesheet" href="${ctx}/static/iconfonts/iconfont.css">
    <link href="${ctx}/static/css/common.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/mystyle.css" rel="stylesheet">
    <link href="${ctx}/static/css/chosen.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/bootstrap-select.css" rel="stylesheet">
    <link href="/wubi-web/static/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jQueryUI/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/jqgrid/ui.jqgrid.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/loading-master/loading.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/plugins/ValidationEngine/css/validationEngine.jquery.css">
<title><@title/></title>
    <link rel="shortcut icon" href="favicon.ico">
<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
        var ctx = "${ctx}";
</script>
<style>
	body{
		    background-color: #f3f3f4;
	}
	<#if style?exists> <@style/> </#if>
</style>
<#if head?exists> <@head/> </#if>
</head>
<@body/>
<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/static/js/jquery.form.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${ctx}/static/js/datePicker/WdatePicker.js"></script>
<script src="${ctx}/static/js/plugins/bootstrap-select-bi.js"></script>
<script src="${ctx}/static/js/plugins/chosen/chosen.jquery.js"></script>
<script src="${ctx}/static/js/plugins/jqGrid/i18n/grid.locale-cn.js"></script>
<script src="${ctx}/static/js/plugins/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx}/static/js/module/plugins/blue.js"></script>
<script src="${ctx}/static/js/layer2.2/layer.js"></script>
<script src="${ctx}/static/js/layer2.2/extend/layer.ext.js"></script>
<script src="${ctx}/static/js/content.min.js"></script>
<script src="${ctx}/static/js/seajs/sea.js"></script>
<script src="${ctx}/static/plugins/loading-master/loading.js"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/jquery.validationEngine.js?t=${.now?string("yyyyMMddHHmmss")}"></script>
<script type="text/javascript" src="${ctx}/static/js/plugins/ValidationEngine/languages/jquery.validationEngine-zh_CN.js?t=${.now?string("yyyyMMddHHmmss")}"></script>
<script src="${ctx}/static/js/dateUtil.js"></script>
<#if footer?exists> <@footer/></#if>
</html>



