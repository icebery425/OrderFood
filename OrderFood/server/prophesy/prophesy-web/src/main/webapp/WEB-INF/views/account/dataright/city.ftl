<#include "*/layout/template-account.ftl"/>
<#macro title>数据权限管理</#macro>
<#macro body>

<div class="wrapper wrapper-content" style="padding-bottom:20px">

    
	<style>
		#chartCity,.clr_after{
			margin-left: 34px;
    		width: 94%;
    		margin-bottom: 10px;
		}
		.tab_select dl {
		    padding: 5px 0;
		}
		.tab_select dt {
		    width: 46px;
		    background: #ccc;
		    font: bold 12px/22px Tahoma, Geneva, sans-serif;
		    color: #fff;
		    text-align: center;
		    margin-left: 5px;
		    border-radius: 3px;
		}
		.tab_select dd {
		    line-height: 22px;
		}
		dd {
		    display: block;
		    -webkit-margin-start: 40px;
		}
		.tab_select dd a {
		    color: #333;
		    margin-left: 10px;
		    display: inline-block;
		}
		a:link, a:visited {
		    text-decoration: none;
		    outline: none;
		    cursor: pointer;
		}
		.thRight {
		    float: right;
		}
		.city_block{
			display: block;
			cursor: pointer;
			margin: 0 10px 0 22px;
		}
		input[type="checkbox"] {
			position: absolute;
			margin: 5px 40px 0 -20px !important;
		}
		.clrfix{
			margin-bottom: 10px;
		}
		.checked:hover{
			color: #63F95A;
		}
		.checked{
			margin-right: 15px;
		}
	    </style>
	
	
	
	<div class="box-control" style="position: relative;">
	    <label class="control-label min-w90">已选城市</label>
	    <div id="chartCity">
	    	<#if datas??>
	            <#list datas as rightdata>
	             	<div class="city_block"><span class="checked" data-val="${(rightdata.dataid)?c}">${rightdata.dataname}</span></div>
	            </#list>
	         </#if>
		</div>
	    <label class="control-label min-w90">全部城市</label>
	    <div id="moreDiv" style=" text-align: left;">
	
	        <div class="tab_select">
	            <dl class="clrfix">
	                <dt>A-G</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                            <#list citys as ct>
	                                  <#list ["A","B","C","D","E","F","G"] as j>
	                                        <#if j= ct.firstname>
	                                        <div>
	                                        	<div class="city_block" style="display:inline;">
	                                            	<input type="checkbox" value="${(ct.cityid)?c}" <#if ct.status?? && ct.status == "Y"> checked</#if>/>
													<span>${ct.cityname}</span>
												</div>
	                                        </div>
	                                        
	                                        </#if>
	                                  </#list>
	                            </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>H-L</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["H","I","J","K","L"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}" <#if ct.status?? && ct.status == "Y"> checked</#if>/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>M-T</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["M","N","O","P","Q","R","S","T"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}" <#if ct.status?? && ct.status == "Y"> checked</#if>/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>W-Z</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["U","V","W","X","Y","Z"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}" <#if ct.status?? && ct.status == "Y"> checked</#if>/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	        </div>
	    </div>
	</div>
</div>
</#macro>

<#macro footer>
<script>
	function initBlockClick(){
		$(".city_block").unbind("click").bind("click",function(event){
			event.stopPropagation();
			var _obj = $(this);
			if(_obj.find(":checkbox").length == 0){
				var id = _obj.find("span").first().attr("data-val");
				if(id){
					resertCity(id);
				}
				_obj.remove();
			}else {
				setCity(_obj);
			}
		})
	}
	initBlockClick();
	$(":checkbox").click(function(event){
		event.stopPropagation();
		var _obj = $(this);
			_obj.prop("checked",!_obj.prop("checked"));
			_obj.parent().trigger('click');
	})
	
	function resertCity(id){
		$("#moreDiv").find(":checkbox").each(function(){
			if($(this).val() == id){
				$(this).prop("checked", false);
				return false;
			}
		})
	}
	function resertChecked(id){
		$("#chartCity").find("span").each(function(){
			if($(this).attr("data-val") && $(this).attr("data-val") == id){
				$(this).parent().remove();
				return false;
			}
		})
	}
	function setCity(_obj){
		var _checkbox = _obj.find(":checkbox").first();
		var id = _checkbox.val();
		if(_checkbox.prop("checked")){		//取消选择
			_checkbox.prop("checked", false);
			resertChecked(id);
		} else {							//选择操作
			var name = _obj.find("span").first().html();
			_checkbox.prop("checked", true);
			$("#chartCity").append('<div class="city_block"><span class="checked" data-val="'+id+'">'+name+'</span></div>');
			initBlockClick();
		}
	}

</script>
</#macro>

