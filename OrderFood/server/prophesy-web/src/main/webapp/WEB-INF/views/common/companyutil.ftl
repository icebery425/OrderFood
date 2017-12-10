<style>
	.com_block{
		display: inline-block;
		cursor: pointer;
		position:relative;
		margin:5px 10px 5px 25px;
	}
	.moreCom{
		display: inline-block;
	}
	.half_block{
		display: inline-block;
	    width: 40%;
	    margin-bottom: 8px;
	    vertical-align: top;
	}
	.search_form_suggest {
	    border: 1px solid #ccc;
	    position: absolute;
	    top: 32px;
	    left: 0;
	    z-index: 978;
	    width: 576px;
	    padding: 5px 0px;
	    background: #fff;
	}
	.close{
		position: absolute;
	    top: 7px;
	    right: 0px;
	    cursor: pointer;
	    font-size: 12px;
	    text-align: center;
	    color: #fff;
	    box-sizing: border-box;
	    width: 22px;
	    height: 22px;
	    line-height: 20px;
	    border-radius: 4px;
	    background: #333;
	}
	.close:hover{
		color:#fff;
	}
</style>

<div class="form-group" style="position: relative;">
    <label class="control-label min-w90 ta-right" style="padding-top: 0px; margin-top: -9px;position: absolute; top: 50%;">地区公司</label>
    <div class="limitDiv" style="display: inline-block; width: 600px;margin-left: 90px;">
	    <span class="chartCom">
	    	<div class="com_block">
	    		<input type="checkbox" value="*" class="noCompany" checked/>
				<span>不限</span>
			</div>
	    	<#if companys??>
	    		<#assign index=0 />
	            <#list companys as cmp>
	            	<#if (cmp_index  < 5 && cmp.companyid != 630)>
	            		<#assign index= index +1 />
	            		<div class="com_block">
				    		<input type="checkbox" value="${(cmp.companyid)?c}"/>
				    		<span>${cmp.companyname}</span>
						</div>
	            	</#if>
	            </#list>
	            <#if (index < 5 && companys?size>5)>
	            	<div class="com_block">
			    		<input type="checkbox" value="${(companys[5].companyid)?c}"/>
			    		<span>${companys[5].companyname}</span>
					</div>
	            </#if>
	        </#if>
		</span>
	    <a href="###" class="moreCom blue"<#if (companys?size<5)>style="display:none"</#if> >更多地区公司&gt;&gt;</a>
    </div>
    <div class="search_form_suggest moreDiv" style="display:none;left: 90px;top: 45px; text-align: left;z-index:1000; border-radius: 5px;box-shadow: 0 6px 12px rgba(0,0,0,.175);">
    	<h3 style="border-bottom: 1px solid #ccc;padding-bottom:12px;"><label class="control-label min-w90">全部地区公司</label> <a class="thRight close">X</a></h3>
    	<div class="form-group"style="width: 370px; margin-left: 37px;">
            <label class="control-label min-w90 ta-right" style="min-width: auto;">查询</label>
            <div style=" display: inline-block; position: relative;">
	            <input id="companySelect" autocomplete="off" data-provide="typeahead" type="text"
	            			 style="display: inline-block;width: 200px;vertical-align: middle; padding: 0 20px 0 10px;"
	            			 class="input-sm form-control" placeholder="查询" />
	            <i class="icon iconfont icon-iconfontguanbi2 iconcancel" style="cursor: pointer; display:none; right: 3px; top:5px; position: absolute; color: #ccc;"></i>
		 	</div>
        </div>
		<div class="wrapper wrapper-content" style="padding: 0;">
			<div class="box-control" style="position: relative;">
			    <div>
		        	<div style="margin-left: 10px;padding-left:30px;height:230px;overflow:auto;" class="allCompany">
						<#if companys??>
		            		<#list companys as company>
		            			<div class="com_block  half_block">
	            					<input type="checkbox" style="position: absolute;margin-left: -20px;" value="${(company.companyid)?c}" <#if company.status?? && company.status == "Y"> checked</#if>/>
									<span title="${company.companyname}">${company.companyname}</span>
								</div>
		            		</#list>
		            	</#if>
			        </div>
		       	</div>
			</div>
		</div>
	</div>
</div>	
