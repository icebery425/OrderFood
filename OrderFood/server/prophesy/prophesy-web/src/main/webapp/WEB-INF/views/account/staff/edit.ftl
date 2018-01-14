<#include "*/layout/template-account.ftl"/>
<#macro title>人员编辑</#macro>
<#macro head></#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

    <form class="form-inline" id="editForm" role="form">
		<fieldset <#if entity.state?? && entity.state==3>disabled</#if>>
			<input type="hidden" name="staffid"  id="staffid" value="${(entity.staffid)!''}">
			<div>
			<div class="form-group" style="width: 255px; display: inline-block;">
				<label style="padding-top:7px;">工号</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
					<input type="text" class="validate[required] form-control" name="staffcode" id="staffcode"  value="${(entity.staffcode)!''}"  placeholder="工号"/>
				</div>
	        </div>
			<div class="form-group" style="width: 280px; display: inline-block;">
				<label style="padding-top:7px;">人员名称</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
					<input type="text" class="validate[required] form-control" name="staffname" id="staffname"  value="${(entity.staffname)!''}"  placeholder="人员名称"/>
				</div>
	        </div>
        
        </div>
        <div class="hr-line-dashed"></div>
        <div>
        	<div class="form-group" style="width: 255px; display: inline-block;">
        		<label style="margin-left: 7px;margin-top:7px;">状态</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; float:right;">
                    <select id="state" class="selectpicker bs-select-hidden form-control">
                    	<option value="1" data-tokens="1"  <#if entity.state?? && entity.state==1>selected</#if>>启用</option>
                    	<option value="2" data-tokens="2"  <#if entity.state?? && entity.state==2>selected</#if>>禁用</option>
                    	<#if entity.state?? && entity.state==3><option value="3" data-tokens="3" selected>删除</option></#if>
                    </select>
                </div>
	        </div>
	        <#if Session["sv"]?? && Session["sv"].staff.staffcode=='root'>
	        <div class="form-group" style="width: 280px; display: inline-block;">
                <label style="margin-left: 33px;">密码</label>
                <div class="col-sm-10" style="width: 200px; display: inline-block;">
					<input type="text" class="form-control" name="password" id="password" />
				</div>
			</div>
            </#if>
        </div>
       </fieldset> 
</form>

</div>
</#macro>


<#macro footer>

</#macro>
