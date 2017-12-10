var Control = function(){
	function init(){
		pageInit();
	}
	var defaultOption = {
			type: 2,
	  		area: ['600px', '340px'],
	  		fix: false, //不固定
	  		maxmin: true,
	  		closeBtn: 2,
	  		btn: ['保存', '关闭'], //按钮
	  		shade: [0.8, '#393D49'],
	  		shadeClose:false,
	  		btn2: function(index, layero){},
		}
	$("#search").click(function(){
		gridReload();
	})
	$("#clear").click(function(){
		$("#taskname").val("");
		$("#programname").val("");
		$("#taskexecstate").selectpicker('val', '000');
		$("#endDate").val(getDate(1));
	})
	function gridReload() {
		var dataParam = {};
		dataParam.taskname = $("#taskname").val();
		dataParam.programname = $("#programname").val();
		dataParam.taskexecstate = $("#taskexecstate").selectpicker('val');
		dataParam.schedate = $("#endDate").val().replaceAll("-","");
		
	   jQuery("#grid_table").jqGrid('setGridParam', {
		   url : ctx+"/task/control/list/queryControl",
		   postData: dataParam,
		   page : 1
	   }).trigger("reloadGrid");
	}
	function pageInit(){
		$("#grid_table").jqGrid({
			url: ctx+"/task/control/list/queryControl?schedate="+$("#endDate").val().replaceAll("-",""),
		    datatype : "json",
		    height: 650,
            rownumbers:true,//显示行号
            rownumWidth:40,//设置行号列宽度
            altRows:true,
            altclass:"altRow",
            autowidth: true,
            scrollOffset: 12,
		    colNames : [ '任务号', '任务名', '任务依赖' ,'程序名' , '程序描述', '调度开始时间', '调度结束时间', '调度执行状态', '处理数量', '执行时长(秒)', '操作'],
		    colModel : [ 
		                 {name : 'taskid',index : 'taskid',width : 120}, 
		                 {name : 'taskname',index : 'taskname',width : 150}, 
		                 {name : 'taskdepend',index : 'taskdepend',width : 80}, 
		                 {name : 'programname',index : 'programname',width : 200}, 
		                 {name : 'programdesc',index : 'programdesc',width : 150}, 
		                 {name : 'taskbegintime',index : 'taskbegintime',width : 150}, 
		                 {name : 'taskendtime',index : 'taskendtime',width : 150}, 
		                 {name : 'taskexecstate',index : 'taskexecstate',width : 100,
		                	 formatter:function(cellvalue, options, rowObject){
			                	 if (cellvalue == '000') {
			                         return "未执行";
			                     } else if (cellvalue == '100') {
			                         return "执行中";
			                     }else if (cellvalue == '200') {
			                         return "执行成功";
			                     }else if (cellvalue == '300') {
			                         return "执行失败";
			                     }else if (cellvalue == '400') {
			                         return "重执行";
			                     }
			                 }}, 
		                 {name : 'totalrecnum',index : 'totalrecnum',width : 80}, 
		                 {name : 'time',index : 'time',width : 80},
		                 {name : 'oper',index : 'oper',width : 100, sortable:false,
		                	 formatter:function(cellvalue, options, rowObject){
		                		 return operateRender(rowObject);
		                	 }}
		                 
		               ],
            rowNum: 20,
            rowList: [10, 20, 30],
		    mtype : "POST",
		    pager : '#grid_pager',
		    jsonReader:{
                repeatitems : false,
                
                root:"list",  

            	page: "paginator.currentPage",  

            	total: "paginator.pages",  

            	records: "paginator.totalRows"
        	},
		    viewrecords : true,
		    sortorder : "asc"
		 });
	}
	var operateRender = function (data) {

        var html ="";
            html+="<a href='javascript:;' title='编辑' onclick=\"Control.editPage('" + data.taskid + "')\"><span class=\"handle_icon mr10\"></span></a> ";
            html+="<a href='javascript:;' title='查看' onclick=\"Control.viewPage('" + data.taskid + "')\"><span class=\"search_icon mr10\"></span></a> " ;
        return   html;
    };
    
    function editPage(taskid){
    	layer.open($.extend(defaultOption ,{
    		  title:"调度监控编辑",
    		  area: ['630px', '440px'],
    		  content: ctx + "/task/control/editTaskControl?taskid=" + taskid,
    		  yes: function(index, layero){
    			  var _form = layer.getChildFrame("#editForm");
    			  if (_form.validationEngine('validate')) {
    				  _form.attr("action", ctx + "/task/control/saveControl");
    		          _form.ajaxSubmit(function (result) {
    		        	  if (result.status == 0) {
    		                  layer.msg("操作成功");
    						  setTimeout(function(){layer.close(index);},1000);
    		              } else if (result.status == 1) {
    		                  layer.msg("操作失败");
    		              }
    		          });
    			  }
    		  }
    		}));
    }
    
    function viewPage(taskid){
    	layer.open({
    		type: 2,
  		  	title:"调度监控查看",
  		    fix: false, //不固定
	  		maxmin: true, 
	  		closeBtn: 2,
  		  	area: ['630px', '460px'],
  		  	content: ctx + "/task/control/viewTaskControl?taskid=" + taskid
  		});
    }
	
	return {
		init: init,
		editPage: editPage,
		viewPage: viewPage
	}
}();