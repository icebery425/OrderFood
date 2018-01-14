var ECHARTSLANGUAGE = {
	        
	        "sLengthMenu": "显示 _MENU_ 项结果",
	        "sZeroRecords": "没有匹配结果",
	        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
	        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
	        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
	        "sInfoPostFix": "",
	        "sSearch": "搜索:",
	        "sUrl": "",
	        "sEmptyTable": "表中数据为空",
	        "sLoadingRecords": "载入中...",
	        "sInfoThousands": ",",
	        "oPaginate": {
	            "sFirst": "首页",
	            "sPrevious": "上页",
	            "sNext": "下页",
	            "sLast": "末页"
	        },
	        "oAria": {
	            "sSortAscending": ": 以升序排列此列",
	            "sSortDescending": ": 以降序排列此列"
	        }
	};


function getAllParams(type){
	var returnStr="";
	if(type==null){
		return "*";
	}
	for(var i = 0; i<type.length; i++){
		returnStr += type[i]+",";
	}
	returnStr= returnStr.substr(0, returnStr.length-1);
	
	if(returnStr.length==0){
		returnStr='*';
	}
	return returnStr;
}

function getTips(opt){
	var tips = "<p class='hd'>指标说明：</p>";
	var tipTemplet = "<p class='txt'><span class='tit'>[$0]</span>$1</p>";
	for(attribute in opt){
		tips = tips + tipTemplet.replace("$0", attribute).replace("$1", opt[attribute]);
	}
	return tips;
}
 /**
 * 字符串批量替换，传入参数：arg0为待处理字符串，格式为“<div class="weui_actionsheet_cell" datacode="$0$">$1$ ($2$)</div>” 
 * arg1,arg2,arg3...等依次为被替换的字符串。
 * @returns
 */
var formatStr=function(){
	var str = arguments[0]? arguments[0]: "";
	var numargs = arguments.length; 
	if(numargs <= 1) return str;
	for(var i=1; i<numargs; i++){
		var reg=new RegExp("\\$"+(i-1)+"\\$","g");
		str = str.replace(reg, arguments[i]);
	}
	return str;
}
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
};
Number.prototype.numberFormat = function(isInt) {
    var num = this;
    if(num){
    	num = num.toFixed(2);
    	num = (num || 0).toString();
    	num = (num || 0).toString(), result = '';
    	var locate = num.indexOf(".");
    	var subNum = num;
    	var decimalPart = "";
    	if(!isInt){
    		if(locate > 0){
    			subNum = num.substr(0, locate);
    			decimalPart = num.substr(locate);
    			if(decimalPart.length == 2){
    				decimalPart = decimalPart+"0";
    			} else if(decimalPart.length > 3){
    				decimalPart = decimalPart.substr(1);
    				
    			}
    		} else{
    			decimalPart = ".00";
    		}
    	}else{
    		subNum = num.substr(0, locate);
    	}
    	while(subNum.length > 3){
    		result = ',' + subNum.slice(-3) + result;
    		subNum = subNum.slice(0, subNum.length - 3);
    	}
    	if (subNum){
    		result = subNum + result;
    	}
    	result = result + decimalPart;
    	if(result.indexOf(",")==0){
    		result = result.substr(1);
    	} else if(result.indexOf("-,")==0){
    		result = result.replace("-,","-");
    	}
    	return result;
    } else {
    	return num;
    }
        
};
String.prototype.numberFormat = function(isInt) {
	var data = this;
	var num = data.replace(/[^\d.]/g,'');
	if(num){
		var mod = data.replace(/\d+\.\d+|\d+/, "mod");
		num = parseFloat(num).numberFormat(isInt);
		return mod.replace('mod', num);
	} else {
		return data;
	}
};

function compareDate(startDate, endDate, type){
	var startlist= startDate.split("-");
	var endlist= endDate.split("-");
	var start, end;
	var flag = true;
	var msg = "";
	if(startDate>endDate){
		flag=false;
		msg="开始时间不能大于结束时间";
	}else{
		switch(type){
			case	"YEAR":
				//不限年
				break;
			case	"MONTH":
				var chargeY = parseInt(endlist[0]) - parseInt(startlist[0]);
				var chargeM = chargeY*12 + parseInt(endlist[1]) - parseInt(startlist[1]);
				if(chargeM >= 24){		//最大取24月
					flag = false;
					msg = "时间跨度最大不能超过24个月";
				}
				break;
			case	"WEEK":
				start = new Date(startlist[0], 0, 1);
				start.setDate(start.getDate()+parseInt(startlist[1])*7);
				end = new Date(endlist[0], 0, 1);
				end.setDate(end.getDate()+parseInt(endlist[1])*7);
				var charge = (end - start)/(60*60*1000*24*7);
				if(charge >= 24){		//最大取24周
					flag = false;
					msg = "时间跨度最大不能超过24周";
				}
				break;
			case	"DAY":
				start = new Date(startlist[0], startlist[1] -1, startlist[2]);
				end = new Date(endlist[0], endlist[1] - 1, endlist[2]);
				var charge = (end - start)/(60*60*1000*24);
				if(charge >= 60){		//最大取60天
					flag = false;
					msg = "时间跨度最大不能超过60天";
				}
				break;
			default:
		}
	}
	return {"flag":flag,"msg":msg};
}
//是否是数字 ，null返回true
function isNumberYesNull(value) {
    var patrn = /^(-)?\d+(\.\d{1,2})?$/;
    if (patrn.exec(value) == null || value == "") {
        return false;
    } else {
        return true;
    }
}
//改变显示的数据格式，如：12345678.22 --> 12,345,678.22
function toThousands(num) {
    var num = (num || 0).toString(), result = '';
    var locate = num.indexOf(".");
    var subNum = num;
    var decimalPart = "";
    if(locate > 0){
    	subNum = num.substr(0, locate);
    	decimalPart = num.substr(locate);
    }
    while(subNum.length > 3){
    	result = ',' + subNum.slice(-3) + result;
    	subNum = subNum.slice(0, subNum.length - 3);
    }
    if (subNum){
    	result = subNum + result;
    }
    return result + decimalPart;
}


function tooltipSingleFormatter(title){
	function formaterFun(params, ticket, callback){
		var returnStr = params[0].name+"<br/>";
		var val = params[0].value != undefined ? params[0].value: "--";
		returnStr += params[0].marker+params[0].seriesName+":"+ val +title;
		return returnStr;
	}
	return formaterFun;
}

$.fn.showNoData = function(){
	var _this = $(this);
	if(_this.next(".nodata").length == 0){
		var _nodataDiv = $('<div class="nodata" style="text-align:center;display:none;"></div>');
		_nodataDiv.append('<div style="padding-top: 80px;"></div>');
		_nodataDiv.append('<p style="margin: 10px 0 0 0;">暂无数据</p>')
		_this.after(_nodataDiv);
	}
	_this.hide();
	_this.next(".nodata").show();
}
$.fn.hideNoData = function(){
	var _this = $(this);
	_this.next(".nodata").hide();
	_this.show();
}