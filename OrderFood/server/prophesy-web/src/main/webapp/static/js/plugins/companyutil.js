/*************************初始化地市控件********************************/

var CompanyUtil = function(){
	$(".moreCom").click(function(){
		var ids=[];
		var _this = $(this);
		var _chartCom = _this.siblings(".chartCom");
		var _moreDiv = _this.parent().siblings(".moreDiv");
		_chartCom.find("input:checked").each(function(){
			ids.push($(this).val());
		});
		_moreDiv.find(":checkbox").each(function(){
			if($.inArray($(this).val(), ids)>=0){
				$(this).prop("checked", true);
			} else{
				$(this).prop("checked", false);
			}
		})
		_moreDiv.show();
	});
	
	function initMultiSelect(id, callback){
		$("#"+id).find(".com_block").click(function(event){
			event.stopPropagation();
			
			var _obj = $(this), _checkbox = $(this).find(":checkbox").first();
			var _formGroup = _obj.parentsUntil(".form-group").last().parent();
			var id = _checkbox.val(), status = !_checkbox.prop("checked");

			if(_obj.parent().is(".chartCom")){	//如果是页面的元素
				if(id == "*"){
					cleanAllcheck(_formGroup);
					_checkbox.prop("checked", status);	//给此复选框赋值
				} else {
					_checkbox.prop("checked", status);	//给此复选框赋值
					resertAllcom(_formGroup);			//把不限按钮复位
					var _moreDiv = _formGroup.find(".moreDiv");
					if(_moreDiv.is(":visible")){	//如果弹框可见
						setMoreDiv(_moreDiv, id, status);
					}
				}
				callback && callback();
			} else {
				resertAllcom(_formGroup);			//把不限按钮复位
				if(status && limitis5Coms(_formGroup)){
					alert("最多只能选择五个地区公司。");
					return;
				} else {
					_checkbox.prop("checked", status);	//给此复选框赋值
					setChartCom(_formGroup, _obj, status);//给页面选项赋值
					callback && callback();
				}
			}
		})
		
		$("#"+id).find(":checkbox").click(function(event){
			event.stopPropagation();
			var _obj = $(this);
			_obj.prop("checked",!_obj.prop("checked"));
			_obj.parent().trigger('click');
		})
	}
	function initSingleSelect(id, callback){
		$("#"+id).find(".com_block").click(function(event){
			event.stopPropagation();
			
			var _obj = $(this), _checkbox = $(this).find(":checkbox").first();
			var _formGroup = _obj.parentsUntil(".form-group").last().parent();
			var id = _checkbox.val(), status = !_checkbox.prop("checked");
			
			if(_obj.parent().is(".chartCom")){	//如果是页面的元素
				cleanAllcheck(_formGroup);
				_checkbox.prop("checked", status);	//给此复选框赋值
				var _moreDiv = _formGroup.find(".moreDiv");
				if(_moreDiv.is(":visible")){	//如果弹框可见
					setMoreDiv(_moreDiv, id, status);
				}
				callback && callback();
			} else {
				cleanAllcheck(_formGroup);
				_checkbox.prop("checked", status);	//给此复选框赋值
				setChartCom(_formGroup, _obj, status);//给页面选项赋值
				callback && callback();
				
			}
		})
		
		$("#"+id).find(":checkbox").click(function(event){
			event.stopPropagation();
			var _obj = $(this);
			_obj.prop("checked",!_obj.prop("checked"));
			_obj.parent().trigger('click');
		})
	}
	var objMap = [];
	var parseLocalObjectData = function(){
//		var names = [];
		$(".allCompany").first().find(".com_block").each(function(){
			var _obj = $(this);
			var id = _obj.find(":checkbox").first().val();
			var name = _obj.find("span").first().text();
			objMap.push({"id":id,"name":name});
//            names.push(name);
		})
	    //typeahead只能处理简单的列表，所以要构造一个array string。名称对应的id放到objMap里面；
	    $("#companySelect").typeahead({
	        source: function (query, process) {
	            process(objMap);//调用处理函数，格式化
	        },
	        updater: function (item) {
	        	var id = item;
    			var _allComs = $("#companySelect").parentsUntil(".moreDiv").siblings("div").find(".allCompany");
    			var _checkbox = _allComs.find(":checkbox[value='"+id+"']");
    			if(_checkbox.length>0 && !_checkbox.is(":checked")){
    				_checkbox.trigger("click");
    			}
	        	return item; //这里一定要return，否则选中不显示，外加调用display的时候null reference错误。

        	}
	    })
	    $("#companySelect").parent().bind("mouseover", function(event){
	    	$(this).find("i.iconcancel").show();
	    	event.stopPropagation();
	    }).bind("mouseout", function(event){
	    	$(this).find("i.iconcancel").hide();
	    	event.stopPropagation();
	    })
	}();
	$("#companySelect + i").bind("click", function(event){
//    	event.stopPropagation();
    	var _input = $(this).siblings("input#companySelect");
    	_input.val("");
    })
	//清除所有已选项
	function cleanAllcheck(_obj){
		_obj.find(":checkbox").each(function(){
			$(this).prop("checked", false);
		})
	}
	//取消不限按钮的选择
	function resertAllcom(_obj){
		_obj.find(":checkbox[value='*']").prop("checked", false);
	}
	//设置弹框中的值
	function setMoreDiv(_obj, id, status){
		_obj.find(":checkbox[value='"+id+"']").prop("checked", status);
	}
	//是否已经选了5个选项
	function limitis5Coms(_obj){
		var len = _obj.find(".chartCom :checked").length;
		if(len >=5){
			return true;
		} else {
			return false;
		}
	}
	//给页面元素赋值
	function setChartCom(_obj, _comBlock, status){
		var id = _comBlock.find(":checkbox").first().val();
		var _chartCom = _obj.find(".chartCom").first();
		var _selectbox = _chartCom.find(":checkbox[value='"+id+"']");
		if(_selectbox.length>0){
			_selectbox.first().prop("checked", status);
		} else {
			_chartCom.find(":checkbox").not(":checked").last().parent().remove();
			_comBlock.clone(true).insertAfter(_chartCom.find(".noCompany").parent()).removeClass("half_block");
		}
	}
	
	$(".close").click(function(){
		$(".moreDiv").hide();
	});
	$(".moreDiv").mouseleave(function(){
		$(this).hide();
	})
	function getCompanyId(parentid){
		
		var pids = '';
		var _comdiv  = $("#"+parentid).find(".chartCom");
		if(_comdiv.length >0){
			var _com = _comdiv.find("input:checked");
			if(_com.length>0){
				var cid = "";
				$(_com).each(function(){
					cid += this.value+",";
				})
				pids = cid.substr(0, cid.length-1);
				
			}else {
				pids = "*";
			}
			return pids;
		} else {
			return "*";
		}
	}
	
	return {
		getCompanyId : getCompanyId,
		initMultiSelect :initMultiSelect,
		initSingleSelect : initSingleSelect
	}	
}();