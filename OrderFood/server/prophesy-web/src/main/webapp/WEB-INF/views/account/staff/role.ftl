<#include "*/layout/template-account.ftl"/>
<#macro title>菜单权限</#macro>
<#macro head></#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

    <form class="form-inline" id="roleForm" role="form">
		<fieldset>
			<input type="hidden" name="staffId" id="staffId" value="${(entity.staffid)?c}">
    		<input type="hidden" name="id" id="id" value="${(staffGroup.id)!''}">
			<div>
			<div class="form-group" style="width: 100%; text-align: center; display: inline-block;">
				<label >菜单权限</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; display: inline-block;">
                    <select id="groupId" class="selectpicker bs-select-hidden form-control">
                    	<#if groupList??>
                            <#list groupList as data>
                                <option value="${data.id!''}" data-tokens="${data.id!''}" <#if staffGroup??&& staffGroup.fkGroupId ==data.id>selected</#if>>${data.name}</option>
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


<#macro footer>

</#macro>

