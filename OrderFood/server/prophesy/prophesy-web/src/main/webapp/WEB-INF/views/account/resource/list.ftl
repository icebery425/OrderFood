<#include "*/layout/template-account.ftl"/>
<#macro title>资源管理</#macro>
<#macro head>
<link href="${ctx}/static/js/plugins/zTree/zTreeStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
<#macro body>

<form class="form-inline" role="form">
<div class="wrapper wrapper-content">
	<fieldset>	

        <div class="btn-toolbar m-b-sm">


            <@shiro.hasPermission name="resource:add">
                <button type="button" id="add-btn" class="btn-sm btn btn-primary" style="margin:5px 10px;">新增</button>
            </@shiro.hasPermission>



            <@shiro.hasPermission name="resource:delete">
                <button type="button" id="del-btn" class="btn-sm btn btn-default">删除</button>
            </@shiro.hasPermission>

        </div>

        <ul id="dataTable" class="ztree">
        </ul>
	</fieldset>
</div>
</form>



</#macro>
<#macro footer>
<script src="${ctx}/static/js/plugins/zTree/ztree.min-3.5.js" type="text/javascript"></script>
<script src="${ctx}/static/js/account/Resource.js" type="text/javascript"></script>
<script type="text/javascript">

    var resource_edit_role =false;

        <@shiro.hasPermission name="resource:edit">
        resource_edit_role = true;
        </@shiro.hasPermission>

    $(function(){
        Resource.init();
    });
</script>
</#macro>






