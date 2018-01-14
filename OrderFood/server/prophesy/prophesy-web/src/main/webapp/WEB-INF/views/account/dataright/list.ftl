<#include "*/layout/template-account.ftl"/>
<#macro title>数据权限管理</#macro>
<#macro head>
<link href="${ctx}/static/js/plugins/zTree/zTreeStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
<#macro body>

<div class="wrapper wrapper-content">

        <fieldset>
            <div>
            	<div class="form-group" style="">
					<label class="col-sm-2 control-label pt7" style='width:60px;text-align: left;'>名称</label>
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
    	<div class="jqGrid_wrapper">
            <table id="table_list_1" style="width:100%;overflow:auto;"></table>
            <div id="pager_list_1"></div>
    	</div>
        
    </div>

</div>
</#macro>
<#macro footer>

<script src="${ctx}/static/js/account/DataRight.js" type="text/javascript"></script>
<script src="${ctx}/static/js/plugins/zTree/ztree.min-3.5.js" type="text/javascript"></script>
<script>
    var dataright_city_role =false;
    var dataright_service_role =false;
    var dataright_company_role =false;
    var dataright_revenue_role =false;
    var dataright_pdevcom_role =false; //父开发商权限
    var dataright_reportArea_role =false; //上报地区权限

    <@shiro.hasPermission name="dataright:city">
        dataright_city_role = true;
    </@shiro.hasPermission>
    <@shiro.hasPermission name="dataright:service">
        dataright_service_role = true;
    </@shiro.hasPermission>
    <@shiro.hasPermission name="dataright:company">
        dataright_company_role = true;
    </@shiro.hasPermission>
    <@shiro.hasPermission name="dataright:revenue">
        dataright_revenue_role = true;
    </@shiro.hasPermission>
    <@shiro.hasPermission name="dataright:pardevcompany">
        dataright_pdevcom_role = true;
    </@shiro.hasPermission>
    <@shiro.hasPermission name="dataright:reportArea">
        dataright_reportArea_role = true;
    </@shiro.hasPermission>

    $(function () {
    	DataRight.init();
    });

</script>

</#macro>
