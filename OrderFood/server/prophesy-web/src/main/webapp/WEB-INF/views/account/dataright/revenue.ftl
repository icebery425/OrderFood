<#include "*/layout/template-account.ftl"/>
<#macro title>数据权限管理</#macro>
<#macro head>
</#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

    <form class="form-inline" id="dataForm" role="form" style="height:157px">
		<fieldset style="height:100%">
			<div>
			<div class="form-group" style="width: 100%; text-align: center; display: inline-block;">
				<label >创收权限</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; display: inline-block;">
                    <select id="revenueRight" class="selectpicker bs-select-hidden form-control">
                    	<option value="" data-tokens="">请选择</option>
                    	<#if revenueList??>
                            <#list revenueList as data>
                                <option value="${data.ID!''}" data-tokens="${data.ID!''}" <#if revenuedata??&& revenuedata ==data.ID>selected</#if>>${data.NAME!''}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
	        </div>
        </div>
       </fieldset> 
</form>

</div>

</#macro>
