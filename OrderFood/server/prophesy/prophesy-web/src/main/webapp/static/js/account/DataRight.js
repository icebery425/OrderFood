var DataRight = function(){
	
	var defaultOption = {
		type: 2,
  		area: ['630px', '540px'],
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
	function init(){
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
            shrinkToFit:false,
            autoScroll: true,
		    colNames : [ '名称', '工号', '状态' ,'创建时间' , '操作'],
		    colModel : [ 
		                 {name : 'staffname',index : 'staffname',width : 100}, 
		                 {name : 'staffcode',index : 'staffcode',width : 100}, 
		                 {name : 'state',index : 'state',width : 200,
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
		                 {name : 'createtime',index : 'createtime',width : 200}, 
		                 {name : 'operate',index : 'operate',width : 600, sortable:false,
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

        if(dataright_city_role){
            html+="<span></span><a href='javascript:;' title='城市权限' onclick=\"DataRight.editCityPage(" + data.staffid + ")\">城市权限</a> ";
        }
        if(dataright_service_role){
        	html+="<span></span><a href='javascript:;' title='业务线权限' onclick=\"DataRight.editServicePage(" + data.staffid + ")\">业务线权限</a> ";
        }
        if(dataright_company_role){
        	html+="<span></span><a href='javascript:;' title='地区公司权限' onclick=\"DataRight.editCompanyPage(" + data.staffid + ")\">地区公司权限</a> ";
        }
        if(dataright_revenue_role){
        	html+="<span></span><a href='javascript:;' title='创收权限' onclick=\"DataRight.editRevenuePage(" + data.staffid + ")\">创收权限</a> ";
        }
        if(dataright_pdevcom_role){
        	html+="<span></span><a href='javascript:;' title='父开发商权限' onclick=\"DataRight.editPardevcompany(" + data.staffid + ")\">父开发商权限</a> ";
        }
        if(dataright_reportArea_role){
        	html+="<span></span><a href='javascript:;' title='上报区域权限' onclick=\"DataRight.editReportArea(" + data.staffid + ")\">上报区域权限</a> ";
        }

        return   html;
    };
    
    //open 上报区域权限数据编辑页面
    function editReportArea(staffid){
    	layer.open($.extend(defaultOption ,{
  		  title:"上报区域权限",
  		  content: ctx + "/account/dataright/reportArea?id="+staffid,
  		  yes: function(index, layero){
	      loadingOpen($(".layui-layer-iframe"));
  			  var _table = layer.getChildFrame("#chartCity");
  			  var ids = getCityIds(_table);
  			  $.ajax({
					  async:true,
					  url: ctx + "/account/dataright/reportArea/save",
					  dataType: "json",
					  cache: false,
					  data:{'ids':ids, 'staffid':staffid},
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
  		  	}
  		}));
    	
    }
    //open 父开发商权限数据编辑页面
    function editPardevcompany(staffid){
    	layer.open($.extend(defaultOption ,{
    		title:"父开发商权限",
    		content: ctx + "/account/dataright/pardevcompany?id="+staffid,
    		yes: function(index, layero){
    			loadingOpen($(".layui-layer-iframe"));
    			var _table = layer.getChildFrame("#chartCity");
    			var ids = getCityIds(_table);
    			$.ajax({
    				async:true,
    				url: ctx + "/account/dataright/pardevcompany/save",
    				dataType: "json",
    				cache: false,
    				data:{'ids':ids, 'staffid':staffid},
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
    		}
    	}));
    	
    }
    
    //open 地区公司权限数据编辑页面
    function editCompanyPage(staffid){
    	layer.open($.extend(defaultOption ,{
    		title:"地区公司权限",
    		content: ctx + "/account/dataright/company?id="+staffid,
    		yes: function(index, layero){
    		loadingOpen($(".layui-layer-iframe"));
    		var _table = layer.getChildFrame("#chartCity");
    		var ids = getCityIds(_table);
    		$.ajax({
    			async:true,
    			url: ctx + "/account/dataright/company/save",
    			dataType: "json",
    			cache: false,
    			data:{'ids':ids, 'staffid':staffid},
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
    		}
    	}));
    	
    }
    
    //open 业务线权限数据编辑页面
    function editServicePage(staffid){
    	layer.open($.extend(defaultOption ,{
    		  title:"业务线权限",
    		  content: ctx + "/account/dataright/service?id="+staffid,
    		  yes: function(index, layero){
    			  loadingOpen($(".layui-layer-iframe"));
    			  var _table = layer.getChildFrame("#databody");
    			  var ids = getServiceIds(_table);
    			  $.ajax({
					  async:true,
					  url: ctx + "/account/dataright/service/save",
					  dataType: "json",
					  cache: false,
					  data:{'ids':ids, 'staffid':staffid},
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
    		  }
    		}));
    }
    
  //open 创收权限数据编辑页面
    function editRevenuePage(staffid){
    	layer.open($.extend(defaultOption ,{
    		  title:"创收权限",
    		  content: ctx + "/account/dataright/revenue?id="+staffid,
    		  area: ['400px', '300px'],
    		  yes: function(index, layero){
    			  loadingOpen($(".layui-layer-iframe"));
    			  var _table = layer.getChildFrame("#dataForm");
    			  var revenueId = _table.find("#revenueRight").next().find("li.selected a").attr("data-tokens");
    			  $.ajax({
					  async:true,
					  url: ctx + "/account/dataright/revenue/save",
					  dataType: "json",
					  cache: false,
					  data:{'ids':revenueId, 'staffid':staffid},
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
    		  }
    		}));
    }
    
    function getServiceIds(_table){
    	var ids = "";
    	if(_table.length >0){
    		_table.find("input:checked").each(function(){
    			var id = $(this).val();
    			if(id){
    				ids = ids + id + ","
    			}
    		})
    		if(ids.length>0){
    			ids = ids.substr(0, ids.length -1);
    		}
    	}
    	return ids;
    }
    
	//open 城市数据权限编辑页面
    function editCityPage(staffid){
    	layer.open($.extend(defaultOption ,{
    		  title:"城市权限",
    		  content: ctx + "/account/dataright/city?id="+staffid,
    		  yes: function(index, layero){
    			  loadingOpen($(".layui-layer-iframe"));
    			  var _cityForm = layer.getChildFrame("#chartCity");
    			  var ids = getCityIds(_cityForm);
    			  $.ajax({
					  async:true,
					  url: ctx + "/account/dataright/city/save",
					  dataType: "json",
					  cache: false,
					  data:{'ids':ids, 'staffid':staffid},
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
    		  }
    		}));
    }
    
    function getCityIds(_cityForm){
    	var ids = "";
    	if(_cityForm.length >0){
    		_cityForm.find("span").each(function(){
    			var id = $(this).attr("data-val");
    			if(id){
    				ids = ids + id + ","
    			}
    		})
    		if(ids.length>0){
    			ids = ids.substr(0, ids.length -1);
    		}
    	}
    	return ids;
    }
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
	
    var editStaffPage = function (id) {
    	
    	layer.open($.extend(defaultOption ,{
    		  title:"编辑账户",
    		  area: ['600px', '340px'],
    		  content: ctx + "/account/staff/edit?id=" + id,
    		  //保存按钮点击事件 
    		  yes: function(index, layero){
    			  loadingOpen($(".layui-layer-iframe"));
    			  var _form = layer.getChildFrame("#editForm");
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
    							  layer.msg("工号已经存在");
    						  }
    					  }       
    				  });
    			  }
    		  }
		}));
    };
    
	return {
		init: init,
		editCityPage: editCityPage,
		editServicePage: editServicePage,
		editCompanyPage: editCompanyPage,
		editRevenuePage: editRevenuePage,
		editPardevcompany: editPardevcompany,
		editReportArea:editReportArea
	}
}();