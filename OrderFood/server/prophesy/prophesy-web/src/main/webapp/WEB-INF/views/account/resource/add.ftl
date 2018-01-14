<#include "*/layout/template-account.ftl"/>
<#macro title>新增资源</#macro>
<#macro head></#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">
<form name="form" id="createForm" method="post" class="form-inline">
	<fieldset>
		<div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;margin-top: 15px;">
				<label style="padding-top:7px;">资源名称</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
					<input type="text" class="validate[required] form-control" name="name" id="name" placeholder="名称"/>
				</div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 20px;padding-top:7px;">URL</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
					<input type="text" class="validate[required] form-control" name="value" id="value"
                           reg="Required" placeholder="URL" tip="请输入URL">
				</div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 7px;">资源类型</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; float:right;">
                    <select id="type" name="type" class="selectpicker bs-select-hidden form-control">
                    	<option value="01" data-tokens="01">菜单类型</option>
                        <option value="02" data-tokens="02">安全类型</option>
                    </select>
                </div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label>所属父类</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; float:right;">
                    <select name="parent.id" id="parentid" class="selectpicker bs-select-hidden form-control">
                    	<option value=""  data-tokens="">请选择...</option>
                    	<#if resourcesList??>
                             <#list resourcesList as rl>
                                  <option value="${rl.id}" data-tokens="${rl.id}">${rl.name}</option> 
                             </#list>
                        </#if>
                    </select>
                </div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 13px;padding-top:7px">顺序值</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
                    <input type="text" class="validate[required,custom[integer]] form-control" name="sort"   id="sort"
                            placeholder="排序"  >
				</div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
				<label style="margin-left: 26px;padding-top:7px;">权限</label>
				<div class="col-sm-10" style="width: 200px; float:right;">
                    <input type="text" class="form-control" name="permission"
                           id="permission" placeholder="shiro拦截权限值">
				</div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
			<div class="form-group" style="width: 280px; display: inline-block;">
				<label style="margin-left: 34px;padding-top:7px;">图标</label>
				<div class="col-sm-10" style="width: 200px; float:right;">
                    <input type="text" class="form-control" name="icon" id="icon"
                           placeholder="图标"/>
				</div>
	        </div>
        </div>
    </fieldset>    
</form>
</#macro>




