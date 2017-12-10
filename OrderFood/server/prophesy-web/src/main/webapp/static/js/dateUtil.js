var dtValue = "DAY"; // 日期类型
var maxDateLen = 60; // 最大查询日期长度

/**
 * 取比当天早 befor天的日期，befor为正表示当天往前数
 */
var getDate = function(befor) {
	var now = new Date();
	if (befor != null)
		now.setDate(now.getDate() - befor);
	return getFormatDate(now);
};

var getFormatDate = function(date){
	year = date.getFullYear();
	month = date.getMonth() + 1;
	day = date.getDate();
	month = month < 10 ? "0" + month : month;
	day = day < 10 ? "0" + day : day;
	return year + "-" + month + "-" + day;
}
/**
 * 取当月第一天
 */
var getMonthDate = function(){
	var date=new Date();
	date.setDate(1);
	return getFormatDate(date);
}
/**
 * 取上个月第一天
 */
var getLastMonthDate = function(){
	var date=new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	if(month == 0){
		month = 12;
		year=year-1;
	}
	month = month < 10 ? "0" + month : month;
	return year + "-" + month + "-01" ;
}
/**
 * 修改时间控件格式
 * @param type	时间类型
 * @param no	开始时间控件的序号
 */
function setEndDateFmt(type, no) {
	if ($("input[name=statType]").length > 0) {
		$("input[name=statDate]").val("");
		$("#timeList").html("");
	}
	var startwidth = $("#startDate").css("width");
	var endwidth = $("#endDate").css("width");
	var date, dateFmt;
	dtValue = type.value;
	var weeks = [];
	if (dtValue == "'HOUR'") {
		date = setDefHour();
		dateFmt = "'yyyy-MM-dd HH'";
	} else if (dtValue == "WEEK") {
		date = setDefDay(7);
		dateFmt = "'yyyy-MM-dd'";
		weeks[0] = getWeek(new Date(date[0]));
		weeks[1] = getWeek(new Date(date[1]));
		
	} else if (dtValue == "MONTH") {
		date = setDefMonth();
		dateFmt = "'yyyy-MM'";
	} else if (dtValue == "YEAR" || dtValue == "QUARTER"
			|| dtValue == "HALFYEAR") {
		date = setDefYear();
		dateFmt = "'yyyy'";
	} else {
		date = setDefDay(1);
		dateFmt = "'yyyy-MM-dd'";
	}
	if(dtValue != "WEEK"){
		var datePicker = "WdatePicker({dateFmt:" + dateFmt
		+ ",readOnly:true,firstDayOfWeek:1,isShowClear:false,maxDate:'%y-%M-%d'})";
		var startNo = no < 10 ? "0" + no : no, endNo = ++no < 10 ? "0" + no : no;
		var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">截止时间</label>'+
		'<input type="text" id="startDate" name="pi_'+startNo+'_startDate" style="margin-left: 4px;" class="Wdate1 form-control" onfocus="'+datePicker+'" />';
		
		var dataTd = $("#startDate").parent();
		dataTd.html(dataHtml);
		$("#startDate").val(date[0]).css("width", startwidth);
		
	} else {
		var startPicker = "WdatePicker({dateFmt:" + dateFmt +",firstDayOfWeek:1,onpicked:function() {$dp.$('weekLabelStart').innerText=$dp.cal.getP('y','yyyy')+'-'+$dp.cal.getP('W','WW');}"
		+ ", isShowWeek:true,readOnly:true,isShowClear:false,maxDate:'%y-%M-%d'})";
		var endPicker = "WdatePicker({dateFmt:" + dateFmt +",firstDayOfWeek:1,onpicked:function() {$dp.$('weekLabelEnd').innerText=$dp.cal.getP('y','yyyy')+'-'+$dp.cal.getP('W','WW');}"
		+ ", isShowWeek:true,readOnly:true,isShowClear:false,maxDate:'%y-%M-%d'})";
		var startStr = "<label id=\"weekLabelStart\" class=\"dateLabel\" style='left: 100px;'>"+weeks[0]+"</label>";
		var startNo = no < 10 ? "0" + no : no, endNo = ++no < 10 ? "0" + no : no;
		var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">截止时间</label>'+
		'<input type="text" style="margin-left: 4px;" id="startDate" name="pi_'+startNo+'_startDate" class="Wdate1 form-control" onfocus="'+startPicker+'" />';
		var dataTd = $("#startDate").parent();
		dataTd.html(dataHtml);
		$("#startDate").val(date[0]).css("width", startwidth);
		$("#startDate").after(startStr);
	}
}
function setDateFmt(type, no) {
	if ($("input[name=statType]").length > 0) {
		$("input[name=statDate]").val("");
		$("#timeList").html("");
	}
	var startwidth = $("#startDate").css("width");
	var endwidth = $("#endDate").css("width");
	var date, dateFmt;
	if(type.nodeName =='LI'){
		dtValue = $(type).attr("datatype");
	}else {
		dtValue = type.value;
	}
	var weeks = [];
	if (dtValue == "'HOUR'") {
		date = setDefHour();
		dateFmt = "'yyyy-MM-dd HH'";
	} else if (dtValue == "WEEK") {
		date = setDefDay(22);
		dateFmt = "'yyyy-MM-dd'";
		weeks[0] = getWeek(new Date(date[0]));
		weeks[1] = getWeek(new Date(date[1]));
		
	} else if (dtValue == "MONTH") {
		date = setDefMonth();
		dateFmt = "'yyyy-MM'";
	} else if (dtValue == "YEAR" || dtValue == "QUARTER"
			|| dtValue == "HALFYEAR") {
		date = setDefYear();
		dateFmt = "'yyyy'";
	} else {
		date = setDefDay(7);
		dateFmt = "'yyyy-MM-dd'";
	}
	if(dtValue != "WEEK"){
		var datePicker = "WdatePicker({dateFmt:" + dateFmt
		+ ",readOnly:true,firstDayOfWeek:1,isShowClear:false,maxDate:'%y-%M-%d'})";
		var startNo = no < 10 ? "0" + no : no, endNo = ++no < 10 ? "0" + no : no;
		var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">开始时间</label>'+
		'<input type="text" id="startDate" name="pi_'+startNo+'_startDate" style="margin-left: 4px;" class="Wdate1 form-control" onfocus="'+datePicker+'" />'+
		'<label for="inputDate2" style="margin-left: 4px;text-align: right;" class="control-label min-w90">结束时间</label>'+
		'<input type="text" style="margin-left: 4px;" id="endDate" name="pi_'+endNo+'_endDate" class="Wdate1 form-control" onfocus="'+datePicker+'" />'
		
		var dataTd = $("#startDate").parent();
		dataTd.html(dataHtml);
		$("#startDate").val(date[0]).css("width", startwidth);
		$("#endDate").val(date[1]).css("width", endwidth);
		
	} else {
		var startPicker = "WdatePicker({dateFmt:" + dateFmt +",firstDayOfWeek:1,onpicked:function() {$dp.$('weekLabelStart').innerText=$dp.cal.getP('y','yyyy')+'-'+$dp.cal.getP('W','WW');}"
		+ ", isShowWeek:true,readOnly:true,isShowClear:false,maxDate:'%y-%M-%d'})";
		var endPicker = "WdatePicker({dateFmt:" + dateFmt +",firstDayOfWeek:1,onpicked:function() {$dp.$('weekLabelEnd').innerText=$dp.cal.getP('y','yyyy')+'-'+$dp.cal.getP('W','WW');}"
		+ ", isShowWeek:true,readOnly:true,isShowClear:false,maxDate:'%y-%M-%d'})";
		var startStr = "<label id=\"weekLabelStart\" class=\"dateLabel\" style='left: 100px;'>"+weeks[0]+"</label>";
		var endStr = "<label id=\"weekLabelEnd\" class=\"dateLabel\" style='left: 383px;'>"+weeks[1]+"</label>";
		var startNo = no < 10 ? "0" + no : no, endNo = ++no < 10 ? "0" + no : no;
		var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">开始时间</label>'+
		'<input type="text" style="margin-left: 4px;" id="startDate" name="pi_'+startNo+'_startDate" class="Wdate1 form-control" onfocus="'+startPicker+'" />'+
		'<label for="inputDate2" style="margin-left: 4px;text-align: right;" class="control-label min-w90">结束时间</label>'+
		'<input type="text" style="margin-left: 4px;" id="endDate" name="pi_'+endNo+'_endDate" class="Wdate1 form-control" onfocus="'+endPicker+'" />'
		
		var dataTd = $("#startDate").parent();
		dataTd.html(dataHtml);
		$("#startDate").val(date[0]).css("width", startwidth);
		$("#endDate").val(date[1]).css("width", endwidth);
		$("#startDate").after(startStr);
		$("#endDate").after(endStr);
	}
}

/**
 * 财务使用，type:1 表示日， 2 表示月， 3 表示年
 * @param type
 */
function formatFinanceDate(type) {
	
	var startwidth = $("#startDate").css("width");
	var endwidth = $("#endDate").css("width");
	var date, dateFmt;
	dtValue = type.value;
	var weeks = [];
	if (type == 1) {
		date = [getLastMonthDate(), getDate(1)];
		dateFmt = "'yyyy-MM-dd'";
		
	} else if (type == 2) {
		date = setDefMonth();
		dateFmt = "'yyyy-MM'";
	} else if (type == 3) {
		var now = new Date();
		var nowYear = now.getFullYear();
		now.setMonth(-1);
		var lastYear = now.getFullYear();
		date = [lastYear, nowYear];
		dateFmt = "'yyyy'";
	}
	var datePicker = "WdatePicker({dateFmt:" + dateFmt
	+ ",readOnly:true,firstDayOfWeek:1,isShowClear:false,maxDate:'%y-%M-%d'})";
	var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">开始时间</label>'+
	'<input type="text" id="startDate" name="pi_09_startDate" style="margin-left: 4px;" class="Wdate1 form-control" onfocus="'+datePicker+'" />'+
	'<label for="inputDate2" style="margin-left: 4px;text-align: right;" class="control-label min-w90">结束时间</label>'+
	'<input type="text" style="margin-left: 4px;" id="endDate" name="pi_10_endDate" class="Wdate1 form-control" onfocus="'+datePicker+'" />'
	
	var dataTd = $("#startDate").parent();
	dataTd.html(dataHtml);
	$("#startDate").val(date[0]).css("width", startwidth);
	$("#endDate").val(date[1]).css("width", endwidth);
		
}
/**
 * 地区财务，type:1 表示日， 2 表示月， 3 表示年
 * @param type
 */
function formatSaleDate(type) {
	
	var startwidth = $("#startDate").css("width");
	var endwidth = $("#endDate").css("width");
	var date, dateFmt;
	dtValue = type.value;
	var weeks = [];
	if (type == 1) {
		 var date = new Date();
		 var hours=date.getHours();
		 if(hours<=9){
			 date = [getDate(1)];
		 }else{
			 date = [getDate(0)];
		 }
		
		dateFmt = "'yyyy-MM-dd'";
		
	} else if (type == 2) {
		date = setDefMonth();
		date[0]=date[1];
		dateFmt = "'yyyy-MM'";
	} else if (type == 3) {
		var now = new Date();
		var nowYear = now.getFullYear();
		date = [nowYear];
		dateFmt = "'yyyy'";
	}
	var datePicker = "WdatePicker({dateFmt:" + dateFmt
	+ ",readOnly:true,firstDayOfWeek:1,isShowClear:false,maxDate:'%y-%M-%d'})";
	var dataHtml = '<label for="inputDate1" class="control-label min-w90" style="text-align: right;">日期</label>'+
	'<input type="text" id="startDate" name="pi_09_startDate" style="margin-left: 4px;" class="Wdate1 form-control" onfocus="'+datePicker+'" />';
	
	var dataTd = $("#startDate").parent();
	dataTd.html(dataHtml);
	$("#startDate").val(date[0]).css("width", startwidth);
		
}

function pickedFunc(element) {
	$dp.$(element).value = $dp.cal.date.y + "-" + $dp.cal.getP("W", "WW");
}

function setDefHour(befor) {
	var date = [];
	var now = new Date();
	if (befor != null)
		now.setDate(now.getDate() - befor);
	year = now.getFullYear();
	month = now.getMonth() + 1;
	day = now.getDate();
	month = month < 10 ? "0" + month : month;
	day = day < 10 ? "0" + day : day;
	date[0] = year + "-" + month + "-" + day + " 00";
	date[1] = year + "-" + month + "-" + day + " 23";
	return date;
}

function setDefDay(differ) {
	var date = [];
	date[1] = getDate(1);
	date[0] = getDate(differ);
	return date;

}

function setDefWeek() {
	var date = [];
	var now = new Date();// 当前日期
	date[0] = getWeek(now);
	date[1] = date[0];
	return date;
}

function setDefMonth() {
	var date = [];
	var now = new Date();
	year = now.getFullYear();
	month = now.getMonth() + 1;
	day = now.getDate();
	month = month < 10 ? "0" + month : month;
	date[1] = year + "-" + month;
	var iday = now.getDate();
	var upMonth = iday - iday;
	now.setDate(upMonth);
	year = now.getFullYear();
	month = now.getMonth() + 1;
	month = month < 10 ? "0" + month : month;
	date[0] = year + "-" + month;
	return date;
}


function setDefYear() {
	var date = [];
	var now = new Date();
	year = now.getFullYear();
	day = now.getDate();
	date[0] = year + "";
	now.setDate(day - 1);
	year = now.getFullYear();
	date[1] = year + "";
	return date;
}

// 返回指定日期的周 。格式：YYYY-WW
function getWeek(date) {
	var week = getWeekOfYear(date.getFullYear(), date.getMonth() + 1, date.getDate());
	week = week < 10 ? "0" + week : week;
	return "" + date.getFullYear() + "-" + week;
}

// 得到当前是本年第几周
function getWeekOfYear(y, m, d) {
	var date1 = new Date(y, parseInt(m) - 1, d), date2 = new Date(y, 0, 1);
	dt = Math.round((date1.valueOf() - date2.valueOf()) / 604800000);
	return Math.ceil((dt));
}

function setStatType(el) {
	if (el.checked) {
		$("#statType").val("TOTAL");
	} else {
		$("#statType").val("");
	}
}

function subStatTime(el) {
	var statDate = $("input[name=statDate]").val();
	var dateList = statDate.split("@");
	var delDate = $(el).parent().text().replace(/</g, "").replace(/>/g, "").replace(/X/g, "").split("至");
	var newDate = "";
	for ( var i = 0; i < dateList.length; i++) {
		var statime = dateList[i].split(",");
		if ((statime[0] == delDate[0]) && (statime[1] == delDate[1]))
			continue;
		if (newDate == "")
			newDate = dateList[i];
		else
			newDate += "@" + dateList[i];
	}
	$("input[name=statDate]").val(newDate);
	$(el).parent().remove();
}

function doAddTime() {
	var statType = $("input[name=statType]")[0];
	if (!statType.checked) {
		alert("请勾选小统计选项！");
		return false;
	}
	var statDate = $("input[name=statDate]").val();
	var stDate = $("#startDate").val();
	var edDate = $("#endDate").val();
	if (stDate != null && edDate != null) {
		var dateList = statDate.split("@");
		if (dateList.length >= 3) {
			alert("一次查询最多包含3个时间段！");
			return false;
		}
		for ( var i = 0; i < dateList.length; i++) {
			var statime = dateList[i].split(",");
			if ((statime[0] == stDate) && (statime[1] == edDate)) {
				alert("不能重复添加相同的时间段！");
				return false;
			}
		}
	}
	if (statDate == null || statDate == "")
		$("input[name=statDate]").val(stDate + "," + edDate);
	else
		$("input[name=statDate]").val(statDate + "@" + stDate + "," + edDate);
	var html = $("#timeList").html() + " <font color='green'><";
	$("#timeList").html(html + stDate + ">至<" + edDate + "><a title='删除' style='color:red;font-weight:bold;cursor:pointer;' onclick='subStatTime(this)'>X</a></font>");
}

function getStartDate(type){
	var startdate = '';
	if($("#startDate").length>0){
		if(type && type=="WEEK"){
			startdate = $("#weekLabelStart").text();
		}else {
			startdate = $("#startDate").val();
		} 
	}
	return startdate;
}

function getEndDate(type){
	var enddate = '';
	if($("#endDate").length>0){
		if(type && type=="WEEK"){
			enddate = $("#weekLabelEnd").text();
		}else {
			enddate = $("#endDate").val();
		} 
	}
	return enddate;
}