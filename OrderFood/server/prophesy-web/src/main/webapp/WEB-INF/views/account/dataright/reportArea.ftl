<#include "*/layout/template-account.ftl"/>
<#macro title>上报区域管理</#macro>
<#macro body>
<style>
	.city_block{
		cursor: pointer;
	}
	.half_block{
		display: inline-block;
	    width: 45%;
	    margin-bottom: 8px;
	}
</style>
<div class="wrapper wrapper-content" style="padding-bottom:20px">

	<div class="box-control" style="position: relative;">
	    <label class="control-label min-w90" style="margin: 20px 0 10px auto;position:relative;top:2px;">已选上报区域</label>
	    <input class="btn btn-white" type="button" style="padding:0 20px; background-color: #f1f1f1; height:30px;" id="clear" value="取消选择"/>
	    <div id="chartCity" style="border-bottom: 1px solid #e5e5e5;margin-bottom: 20px;padding: 5px 10px 10px 15px;">
	    	<#if datas??>
	            <#list datas as rightdata>
	            	<#if rightdata.status?? && rightdata.status == "Y" >
	             		<div class="city_block half_block"><span class="checked" data-val="${(rightdata.dataid)?c}">${rightdata.dataname}</span></div>
	             	</#if>
	            </#list>
	        </#if>
		</div>
		<div class="form-group"style="width: 375px;">
            <label class="control-label min-w90 ta-right">查询</label>
            <div style=" display: inline-block; position: relative;top:-2px;">
	            <input id="companySelect" autocomplete="off" data-provide="typeahead" type="text"
	            			 style="display: inline-block;width: 180px;vertical-align: middle; padding-right: 20px;"
	            			 class="form-control" placeholder="查询" />
	            <i class="fa fa-times-circle" style="position: absolute; z-index: 100;right: 6px; top: 50%;
	            			 margin-top: -7px; color: rgb(204, 204, 204); cursor: pointer; display:none;"></i>
		 	</div>
            
        </div>
	    <label class="control-label min-w90" style="margin: 20px 0 10px auto;">全部上报区域</label>
	    <div>
        	<div style="margin-left: 40px;" id="allCompany">
				<#if datas??>
            		<#list datas as company>
            			<div>
	            			<div class="city_block" style="display:inline-block;">
		            			<input type="checkbox" value="${(company.dataid)?c}" <#if company.status?? && company.status == "Y"> checked</#if>/>
								<span>${company.dataname}</span>
							</div>
						</div>
            		</#list>
            	</#if>
	        </div>
       	</div>
	</div>
</div>
</#macro>

<#macro footer>

<script src="${ctx}/static/js/plugins/bootstrap-typeahead.js"></script>
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
		$("#allCompany").find(":checkbox").each(function(){
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
			$("#chartCity").append('<div class="city_block half_block"><span class="checked" data-val="'+id+'">'+name+'</span></div>');
			initBlockClick();
		}
	}
	var objMap = [];
	var parseLocalObjectData = function(){
		$("#allCompany").find(".city_block").each(function(){
			var _obj = $(this);
			var id = _obj.find(":checkbox").first().val();
			var name = _obj.find("span").first().text();
			objMap.push({"id":id,"name":name});
		})
	    //typeahead只能处理简单的列表，所以要构造一个array string。名称对应的id放到objMap里面；
	    $("#companySelect").typeahead({
	        source: function (query, process) {
	            process(objMap);//调用处理函数，格式化
	        },
	        updater: function (item) {
	        	var id = item;
    			var _checkbox = $("#allCompany").find(":checkbox[value='"+id+"']");
    			if(_checkbox.length>0 && !_checkbox.is(":checked")){
    				_checkbox.trigger("click");
    			}
	        	return item; 

        	}
	    })
	    $("#companySelect").parent().bind("mouseover", function(){
	    	$(this).find("i.fa-times-circle").show();
	    	event.stopPropagation();
	    }).bind("mouseout", function(){
	    	$(this).find("i.fa-times-circle").hide();
	    	event.stopPropagation();
	    })
	}();
	$("#companySelect + i").bind("click", function(event){
    	var _input = $(this).siblings("input#companySelect");
    	_input.val("");
    })
	
	$("#clear").click(function(){
		$("#allCompany").find(":checkbox").prop("checked", false);
		$("#chartCity").empty();
	})

</script>
</#macro>

