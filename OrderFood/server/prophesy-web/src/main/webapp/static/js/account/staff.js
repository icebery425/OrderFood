var Staff = function(){
	
	var ctx;
	
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
  		end: function () {
  			gridReload();
  		}
	}
	function init(parm){
		ctx = parm;
		pageInit();
	}
	function pageInit(){
		$("#table_list_1").jqGrid({
			url: ctx+"/account/staff/list/data",
		    datatype : "json",
		    height: 400,
            rownumbers:true,//显示行号
            rownumWidth:40,//设置行号列宽度
            autowidth: true,
		    colNames : [ '名称', '工号', '状态' ,'创建时间' , '操作'],
		    colModel : [ 
		                 {name : 'staffname',index : 'staffname',width : 150}, 
		                 {name : 'staffcode',index : 'staffcode',width : 150}, 
		                 {name : 'state',index : 'state',width : 100,
		                	 formatter:function(cellvalue, options, rowObject){
			                	 var val = ""
			                	 if(cellvalue==1){
			                		 val = "启用";
			                	 } else if(cellvalue==2){
			                		 val = "禁用";
			                	 } else {
			                		 val = "删除";
			                	 }
			                	 return val;
			                 }}, 
		                 {name : 'createtime',index : 'createtime',width : 100}, 
		                 {name : 'operate',index : 'operate',width : 100, sortable:false,
		                	 formatter:function(cellvalue, options, rowObject){
		                		 return operateRender(rowObject);
		                	 }} 
		               ],
            rowNum: 10,
            rowList: [10, 20, 50, 100],
		    mtype : "POST",
		    pager : '#pager_list_1',
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

        if(staff_edit_role){
            html+="<a href='javascript:;' title='编辑' onclick=\"Staff.editStaffPage(" + data.staffid + ")\"><span class=\"handle_icon mr10\"></span></a> ";
        }

        if(staff_delete_role){
            html+="<a href='javascript:;' title='删除' onclick=\"Staff.deleteStaff(" + data.staffid + ")\"><span class=\"delete_icon mr10\"></span></a> " ;
        }

        return   html +
            "<a href='javascript:;' title='权限' onclick=\"Staff.grantMenu(" + data.staffid + ")\"><span class=\"perm_icon\"></span></a> ";
    };
	
    
    
  //删除
    var deleteStaff = function (id) {
        layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
        	$.post(ctx + "/account/staff/delete", {id: id}, function (data) {
                if (data.status == 0) {
                	layer.msg("操作成功");
                	gridReload();
                } else {
                	layer.msg("操作失败");
                }
                layer.close(index);
            });
        });
        
    };
    
    $("#keywords").keypress(function(e){
    	if(e.keyCode == 13){
    		$("#search").trigger("click");
    	}
    })
	$("#search").click(function(){
		gridReload(true);
	})
	function gridReload(flag) {
	  var keywords = $("#keywords").val()||"";
	  var page = jQuery("#table_list_1").jqGrid('getGridParam','page');
	  if(flag){
		  page=1;
	  }
	  jQuery("#table_list_1").jqGrid('setGridParam', {
	    url : ctx+"/account/staff/list/data?keywords="+keywords,
	    page : page
	  }).trigger("reloadGrid");
	}
	
	var openCreate = function (type) {
    	layer.open($.extend(defaultOption ,{
  		  title:"新增账户",
  		  area: ['600px', '340px'],
  		  content: ctx + "/account/staff/add",
  		  yes: function(index, layero){
  			  loadingOpen($(".layui-layer-iframe"));
  			  var _form = layer.getChildFrame("#createForm");
  			  if (_form.validationEngine('validate')) {
  				  var params = getCreateData(_form);
  				  $.ajax({
  					  async:true,
  					  url: ctx+"/account/staff/add/save",
  					  dataType: "json",
  					  cache: false,
  					  data:params,
  					  type: 'post',
  					  error : function(textStatus, errorThrown) {
  						  alert("网络繁忙，请稍后再试。");
  						  return false;
  					  }, 
  					  complete:function(){
						  loadingClose();
			          },
  					  success : function (data){
  						  if (data.status == 0) {
  							  layer.msg("操作成功");
  							  setTimeout(function(){layer.close(index);},1500);
  						  } else {
  							  layer.msg("工号已经存在");
  						  }
  					  }       
  				  });
  			  } else {
  				  loadingClose();
  			  }
  		  }
  		}));
    };
    var updateStaffInit = function(index, layero){
    	var _form = layer.getChildFrame("#editForm");
    	loadingOpen($(".layui-layer-iframe"));
		  if (_form.validationEngine('validate')) {
			  var params = getCreateData(_form);
			  $.ajax({
				  async:true,
				  url: ctx + "/account/staff/edit/save",
				  dataType: "json",
				  cache: false,
				  data:params,
				  type: 'post',
				  error : function(textStatus, errorThrown) {
					  alert("网络繁忙，请稍后再试。");
					  return false;
				  }, 
				  complete:function(){
					  loadingClose();
		          },
				  success : function (data){
					  if (data.status == 0) {
						  layer.msg("操作成功");
						  setTimeout(function(){layer.close(index);},1500);
					  } else {
						  layer.msg("操作失败");
					  }
				  }       
			  });
		  } else {
				  loadingClose();
			  }
    }
    var editStaffPage = function (id) {
    	var updateStaff;
    	layer.open($.extend(defaultOption ,{
    		  title:"编辑账户",
    		  area: ['600px', '340px'],
    		  content: ctx + "/account/staff/edit?id=" + id,
    		  //保存按钮点击事件 
    		  yes: function(index, layero){
    			  updateStaff && updateStaff(index, layero);
    		  },
    		  success: function(layero){
    			  _state = layer.getChildFrame("#state");
    			  var stat = _state.find("option:selected").val();
    			  if(stat == '3'){
    				  layero.find(".layui-layer-btn0").remove();
    				  updateStaff = function(index){
    					  layer.close(index);
    				  }
    			  } else {
    				  updateStaff = updateStaffInit;
    			  }
//    			  layer.setTop(layero); //重点2
			  }

		}));
    };
    
    //菜单权限
    var grantMenu = function (id) {
    	layer.open($.extend(defaultOption ,{
  		  title:"菜单权限",
  		  area: ['400px', '280px'],
  		  content: ctx +"/account/staff/list/role?id="+id,
  		  //保存按钮点击事件 
  		  yes: function(index, layero){
  			  loadingOpen($(".layui-layer-iframe"));
  			  var _form = layer.getChildFrame("#roleForm");
  			  var staffid = _form.find("#staffId").val();
  			  var id = _form.find("#id").val();
  			  var fkGroupId = _form.find("#groupId").next().find("li.selected a").attr("data-tokens");
			  $.ajax({
				  async:true,
				  url: ctx + "/account/staff/list/role/save",
				  dataType: "json",
				  cache: false,
				  data:{"staffid":staffid, "id":id, "fkGroupId":fkGroupId},
				  type: 'post',
				  error : function(textStatus, errorThrown) {
					  alert("操作失败");
					  return false;
				  }, 
				  complete:function(){
					  loadingClose();
		          },
				  success : function (data){
					  if (data.status == 0) {
						  layer.msg("操作成功");
						  setTimeout(function(){layer.close(index);},1000);
					  } else {
						  layer.msg("操作失败");
					  }
				  }       
			  });
  		  }
		}));
    	
    };
    
	$("#add-btn").click(function(){
		openCreate();
	})
	
	var  doModifyPassword = function(form, ctx){
        if (jQuery('#'+form).validationEngine('validate')) {
            $("#"+form).attr("action", ctx + "/change-password");
            $("#"+form).ajaxSubmit(function (result) {
                if (result.status == 0) {
                	layer.msg("操作成功");
                	setTimeout(function(){top.location=ctx+"/logout";},2000);
                    
                } else if (result.status == 1) {
                	layer.msg("操作失败");
                }
            });


        }
    };
	function getCreateData(_form){
		var params = {};
		var staffcode = _form.find("#staffcode").val();
		var staffname = _form.find("#staffname").val();
//		var state = _form.find("#state").selectpicker('val');
		var state = _form.find("#state").next().find("li.selected a").attr("data-tokens");
		params.staffcode = staffcode;
		params.staffname = staffname;
		params.state = state;
		if(_form.find("#password").length>0){
			var password = _form.find("#password").val();
			params.password = password;
		}
		if(_form.find("#staffid").length>0){
			var staffid = _form.find("#staffid").val();
			params.staffid = staffid;
		}
		return params;
	}
	
	return {
		init: init,
		editStaffPage: editStaffPage,
		deleteStaff: deleteStaff,
		grantMenu: grantMenu,
		doModifyPassword:doModifyPassword
	}
}();