<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
    
    <link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/static/iconfonts/iconfont.css">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/loading-master/loading.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/bootstrap-select.css" rel="stylesheet">
    <link href="${ctx}/static/css/mystyle.css" rel="stylesheet">
    <link href="${ctx}/static/css/chosen.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
<title><@title/></title>
    <link rel="shortcut icon" href="favicon.ico">
<script type="text/javascript">
        var ctx = "${ctx}";
</script>
<style>
	<#if style?exists> <@style/> </#if>
</style>
<#if head?exists> <@head/> </#if>
</head>

<@body/>

<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js?v=3.4.0"></script>
<script src="${ctx}/static/js/plugins/layer2.2/layer.js"></script>
<script src="${ctx}/static/js/plugins/bootstrap-select-bi.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/jquery.dataTables.min.js"></script>
<script src="${ctx}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/static/plugins/loading-master/loading.js"></script>

<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/datePicker/WdatePicker.js"></script>

<#if footer?exists> <@footer/></#if>
</html>



