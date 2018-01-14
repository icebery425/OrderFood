/*************************初始化地市控件********************************/

var CityUtil = function(){
	$(".moreCity").click(function(){
		var ids=[];
		var _this = $(this);
		var _chartCity = _this.siblings(".chartCity");
		var _moreDiv = _this.siblings(".moreDiv");
		_chartCity.find("input:checked").each(function(){
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
		$("#"+id).find(".city_block").click(function(event){
			event.stopPropagation();
			var _obj = $(this).find(":checkbox").first();
			if(_obj.prop("checked")){
				_obj.prop("checked", false);
				resertCity($(this));
				callback && callback();
			} else {
				resertAllCity(_obj);
				
				if($(this).parent().is(".chartCity") || checkCity(_obj)){
					_obj.prop("checked", true);
					resertCity($(this));
					callback && callback();
				} else {
					alert("最多只能选择五个城市。");
				}
			}
		})
		$("#"+id).find(":checkbox").click(function(event){
			event.stopPropagation();
			var _obj = $(this);
			resertAllCity(_obj);
			
			if(_obj.parent().parent().is(".chartCity") || checkCity(_obj)){
				resertCity($(this).parent());
				callback && callback();
			} else {
				if(_obj.prop("checked")){
					_obj.prop("checked", false);
					alert("最多只能选择五个城市。");
				} else {
					resertCity($(this).parent());
					callback && callback();
				}
			}
		})
	}
	function initSingleSelect(id, callback){
		$("#"+id).find(".city_block").click(function(event){
			event.stopPropagation();
			var _obj = $(this).find(":checkbox").first();
			if(_obj.prop("checked")){
				_obj.prop("checked", false);
				resertCity($(this));		//取消选择
			} else {	//选择
//				resertAllCity(_obj);	//重置不限按钮
				
				cleanAllCity(_obj);
				_obj.prop("checked", true);
				if($(this).parent().is(".chartCity")){
					resertCity($(this));
				} else {
					selectChartCity(_obj);
				}
			}
			callback && callback();
		});
		$("#"+id).find(":checkbox").click(function(event){
			event.stopPropagation();
			var _obj = $(this);
//			resertAllCity(_obj);
			_obj.prop("checked", !_obj.prop("checked"));
			_obj.parent().trigger('click');
		});
	}
	
	//清除所有已选项
	function cleanAllCity(_obj){
		_obj.parentsUntil(".form-group").find(":checkbox").each(function(){
			$(this).prop("checked", false);
		})
		_obj.parentsUntil(".form-group").siblings().find(":checkbox").each(function(){
			$(this).prop("checked", false);
		})
		
	}
	
	function checkCity(_obj){
		var _chartCity = _obj.parentsUntil(".form-group").siblings(".chartCity");
		if(_chartCity.length > 0){
			var selectedLen = _chartCity.find("input:checked").length;
			if(selectedLen>=5){
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
	
	//在chartcity中选中参数中的这一项
	function selectChartCity(_obj){
		var id = _obj.val();
		var _chartCity = _obj.parentsUntil(".form-group").siblings(".chartCity");
		var _noChecked = _chartCity.find(":checkbox");
		var flag = true;
		$.each(_noChecked, function(i, item){
			if(id == $(item).val()){
				flag = false;
				$(item).prop("checked", true);
				return false;
			}
		})
		if(flag){
			if(_noChecked.not(":checked").length>0){
				_noChecked.not(":checked").last().parent().remove();
				$(_obj).parent().clone(true).insertAfter(_noChecked.filter(".allCity").parent());
			}
		}
	}
	
	function resertCity(_obj){
		var parent = _obj.parent();
		var id = _obj.find(":checkbox").first().val();
		var status = _obj.find(":checkbox").first().prop("checked");
		if(parent.is(".chartCity")){
			var _moredivs = parent.siblings(".moreDiv").find(":checkbox");
			$.each(_moredivs, function(i, item){
				if(id == $(item).val()){
					$(item).prop("checked", status);
					return false;
				}
			})
		} else if(parent.is(".clr_after")){
			//if(checkCity()){
			var _chartCity = _obj.parentsUntil(".form-group").siblings(".chartCity");
			var _noChecked = _chartCity.find(":checkbox");
			var flag = true;
			$.each(_noChecked, function(i, item){
				if(id == $(item).val()){
					flag = false;
					$(item).prop("checked", status);
					return false;
				}
			})
			if(flag){
				if(_noChecked.not(":checked").length>0){
					_noChecked.not(":checked").last().parent().remove();
					$(_obj).clone(true).insertAfter(_noChecked.filter(".allCity").parent());
				}
			}
			//} else {
			//	alert("最多只能选择五个城市。")
			//}
		}
	}
	
	function resertAllCity(_obj){
		var _checkboxs = _obj.parentsUntil(".form-group").siblings().find(":checkbox");
		if(_obj.val() == "*"){
			_checkboxs.not(_obj).prop("checked", false);
		} else {
			_checkboxs.filter(".allCity").prop("checked", false);
		}
	}
	$(".close").click(function(){
		$(".moreDiv").hide();
	});
	$(".moreDiv").mouseleave(function(){
		$(this).hide();
	})
	function getCityId(parentid){
		
		var cityids = '';
		var _citydiv  = $("#"+parentid).find(".chartCity");
		if(_citydiv.length >0){
			var _city = _citydiv.find("input:checked");
			if(_city.length>0){
//				if(_city.length ==1 && _city[0].value=="*"){
//					_city = _citydiv.find("input").not(":checked");
//				}
				var cityid = "";
				$(_city).each(function(){
					cityid += this.value+",";
				})
				cityids = cityid.substr(0, cityid.length-1);
				
			}else {
				cityids = "*";
			}
			return cityids;
		} else {
			return "*";
		}
	}
	return {
		getCityId : getCityId,
		initMultiSelect :initMultiSelect,
		initSingleSelect : initSingleSelect
	}	
}();