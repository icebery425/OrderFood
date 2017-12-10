<#include "*/layout/template-account.ftl"/>
<#macro title>新增权限组</#macro>
<#macro head>
<link href="${ctx}/static/js/plugins/zTree/zTreeStyle.css" rel="stylesheet" type="text/css"/>
</#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

    <form class="form-inline" id="createForm" role="form" method="post">
    	<input type="hidden" name="type" value="03" />
    	<input type="hidden" id="ids" name="ids" value="" />
		<fieldset>
		<div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;margin-top: 15px;">
				<label style="padding-top:7px;">组名称</label><span class="red_color">*</span>
				<div class="col-sm-10" style="width: 200px; float:right;">
					<input type="text" class="validate[required] form-control"   id="name" name="name" value=""
                     placeholder="名称"/>
				</div>
	        </div>
			<div class="form-group-nb" style="width: 280px; display: inline-block;">
        		<label style="margin-left: 7px;">状态</label>
				<div class="col-sm-10 bootstrap-select" style="width: 200px; display: inline-block;">
                    <select name="state" id="state" class="selectpicker bs-select-hidden form-control">
                    	<option value="1" data-tokens="1" selected>启用</option>
                    	<option value="2" data-tokens="2">禁用</option>
                    </select>
                </div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
        	<div class="form-group-nb" style="width: 100%; display: inline-block;">
				<label style="margin:0 20px;padding-top:7px;float:left">备注</label>
				<div class="col-sm-10" style="width: 80%; float:left;">
					<input type="text" class="form-control" id="remark" name="remark" value=""/>
				</div>
	        </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div>
        	<div class="form-group-nb" style="width: 100%; display: inline-block;">
				<ul id="resourceTree" class="ztree">
        		</ul>
	        </div>
       	</div>
       	</fieldset> 
	</form>

</div>

</#macro>




