<#include "*/layout/template-account.ftl"/>
<#macro title>角色组管理</#macro>
<#macro head>
<link href="${ctx}/static/js/plugins/zTree/zTreeStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
<#macro body>
<div class="wrapper wrapper-content">
	<div class="box-control">
    	<div class="btn-toolbar m-b-sm">
    		<@shiro.hasPermission name="group:add">
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
</#macro>
<#macro footer>
<script src="${ctx}/static/js/account/Group.js" type="text/javascript"></script>
<script src="${ctx}/static/js/plugins/zTree/ztree.min-3.5.js" type="text/javascript"></script>
<script type="text/javascript">
    var group_edit_role = false;
    var group_delete_role = false;
    
    <@shiro.hasPermission name="group:edit">
    group_edit_role = true;
    </@shiro.hasPermission>

    <@shiro.hasPermission name="group:delete">
    group_delete_role = true;
    </@shiro.hasPermission>
    
    $(function () {
        Group.init();
    });
</script>
</#macro>

