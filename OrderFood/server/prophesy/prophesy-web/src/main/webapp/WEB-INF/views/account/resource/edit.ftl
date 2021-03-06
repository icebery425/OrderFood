<#include "*/layout/template-account.ftl"/>
<#macro title>编辑资源</#macro>
<#macro head></#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">
<form name="form" id="updateForm" method="post" class="form-inline">
	<fieldset>
		<input type="hidden" name="id" value="${(entity.id)!''}">
		<div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;margin-top: 15px;">
				<label>资源名称</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; display: inline-block;">
					<input type="text" class="validate[required] form-control" value="${(entity.name)!''}"
								 name="name" id="name" placeholder="名称"/>
				</div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 25px;">URL</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; display: inline-block;">
					<input type="text" class="validate[required] form-control" name="value" id="value"
                           value="${(entity.value)!''}" reg="Required" placeholder="URL" tip="请输入URL">
				</div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label>资源类型</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; display: inline-block;">
                    <select id="type" name="type" class="selectpicker bs-select-hidden form-control">
                        <option value="01" <#if entity.type??&&entity.type=='01'> selected</#if>>菜单类型</option>
                        <option value="02" <#if entity.type??&&entity.type=='02'> selected</#if>>安全类型</option>
                    </select>
                </div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label>所属父类</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; display: inline-block;">
                    <select name="parent.id" id="parentid" class="selectpicker bs-select-hidden form-control">
                    	<option value=""  data-tokens="">请选择...</option>
                    	<#if resourcesList??>
                             <#list resourcesList as rl>
                                  <option value="${rl.id}"<#if entity.parentId==rl.id> selected="selected" </#if> >${rl.name}</option>
                             </#list>
                        </#if>
                    </select>
                </div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 13px;">顺序值</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; display: inline-block;">
                    <input type="text" class="validate[required,custom[integer]] form-control" name="sort"   id="sort"
                           value="${(entity.sort)!''}"  placeholder="排序"  >
				</div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 25px;">权限</label>
				<div class="col-sm-10" style="width: 200px; display: inline-block;">
                    <input type="text" class="form-control" name="permission" value="${(entity.permission)!''}"
                           id="permission" placeholder="用于shiro对拦截的值promission">
				</div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group" style="width: 280px; display: inline-block;">
				<label style="margin-left: 25px;">图标</label>
				<div class="col-sm-10" style="width: 200px; display: inline-block;">
                    <input type="text" class="form-control" name="icon" id="icon" value="${(entity.icon)!''}"
                           placeholder="图标"/>
				</div>
	        </div>
        </div>
    </fieldset>    
</form>
</#macro>
