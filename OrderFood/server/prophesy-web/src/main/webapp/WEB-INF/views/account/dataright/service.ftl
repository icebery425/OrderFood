<#include "*/layout/template-account.ftl"/>
<#macro title>数据权限管理</#macro>
<#macro head>
</#macro>
<#macro body>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

    <form class="form-inline" id="updateForm" role="form" method="post">
		<fieldset>
		<div>
			<div class="jqGrid_wrapper" id="dataarea">
            	<table id="table_list_1" class="table table-bordered text-center" style="width:90%" align="center">
                        <thead id="datatitle">
                             <tr>
                                <td  class="text-center bdr_1dd" style="background:#eeeeee;text-align: center;">序号</td>
                                <td class="text-center bdr_1dd" style="background:#eeeeee;" >业务线</td>
                                <td class="text-center" style="background:#eeeeee;position:relative;">选择状态</td>
                            </tr>
                        </thead>
                        <tbody id="databody">
                            <#if datas??>
					            <#list datas as rightdata>
					             	<tr>
					             		<td>${rightdata_index +1}</td>
					             		<td>${(rightdata.dataname)!''}</td>
					             		<td><input type="checkbox" style="position:static;margin:0;" value="${(rightdata.dataid)?c}" <#if rightdata.status?? && rightdata.status == "Y"> checked</#if>/></td>
					             	</tr>
					            </#list>
					         </#if>
                        </tbody>
                        <tfoot>
                        </tfoot>
            </table>
    	</div>
        </div>
	</form>

</div>

</#macro>
