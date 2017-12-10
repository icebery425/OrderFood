/**
 * Created by starhousexq on 2015/11/23.
 */

var Group = function () {
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
				resetList();
			}
	}
	
	
    var initEvent = function () {
        $("#add-btn").bind("click", function () {
            addGroupPage();
        });

    };

    //菜单权限
    var addGroupPage = function () {
    	layer.open($.extend(defaultOption ,{
  		  title:"新增权限组",
  		  content: ctx + "/account/group/add",
  		  yes: function(index, layero){
  			  var _form = layer.getChildFrame("#createForm");
  			  var url = ctx + "/account/group/add/save";
  			  updateGroup(index, _form, url);
  		  },
  		  success: function(layero, index){
  			  var _resourceTree = layer.getChildFrame("#createForm").find("#resourceTree");
  			  initAddResourceTree(_resourceTree);
  		  }
  		}));

    };


    var selectList = function () {
        var manager = $("#dataTable").ligerGetGridManager();
        manager.loadData();
        manager.changePage('first');
    };

    /**
     * 新增 与更新代码相同，舍弃
     */
    /*var addGroup = function (index, _form) {
        if (_form.validationEngine('validate')) {
            var treeObj = $.fn.zTree.getZTreeObj("resourceTree");
            var nodes = treeObj.getCheckedNodes(true);
            var ids = "";
            if (nodes.length > 0) {
                for (var i = 0; i < nodes.length; i++) {
                    var node = nodes[i];
                    ids += (node.id + ",")
                }
            }
            _form.attr("action", ctx + "/account/group/add/save");
            _form.find("#ids").val(ids);
        	_form.ajaxSubmit(function (result) {
                if (result.status == 0) {
                	layer.msg("操作成功");
					setTimeout(function(){layer.close(index);},1000);
                } else {
                	layer.msg("操作失败");
                }
            });

        }
    };*/

    var initGrid = function () {//默认不加载
    	$("#table_list_1").jqGrid({
			url: ctx + "/account/group/list/data",
		    datatype : "json",
		    height: 500,
            rownumbers:true,//显示行号
            rownumWidth:40,//设置行号列宽度
            autowidth: true,
		    colNames : [ '权限组名称', '状态', '创建时间' , '操作'],
		    colModel : [ 
		                 {name : 'name',index : 'name', sortable:false, width : 150}, 
		                 {name : 'state',index : 'state',width : 100, sortable:false,
		                	 formatter:function(cellvalue, options, rowObject){
			                	 var val = ""
			                	 if(cellvalue==1){
			                		 val = "启用";
			                	 } else if(cellvalue==2){
			                		 val = "禁用";
			                	 } 
			                	 return val;
			                 }}, 
		                 {name : 'createTime',index : 'creatTime', sortable:false,width : 100}, 
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

    };


    var operateRender = function (data) {
        var html ="";
        if(group_edit_role){
            html += "<a href='javascript:;' title='编辑' onclick=\"Group.editGroup('" + data.id + "')\"><span class=\"handle_icon mr10\"></span></a> ";
        }
        if(group_delete_role){
            html +=  "<a href='javascript:;' title='删除' onclick=\"Group.deleteGroup('" + data.id + "')\"><span class=\"delete_icon\"></span></a>";
        }
        return  html;
    };

    var initResourceTree = function (_form) {
        var zNodes = null;
        var groupId = _form.find("#id").val();
        $.ajax({
            url: ctx + "/account/group/edit/resourceTree?groupId=" + groupId,
            async: false,
            success: function (data) {
                zNodes = data.data;
            }
        });

        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var treeObj = $.fn.zTree.init(_form.find("#resourceTree"), setting, zNodes);
        treeObj.expandAll(true);
    };


    var initAddResourceTree = function (_resourceTree) {
        var zNodes = null;
        $.ajax({
            url: ctx + "/account/group/add/resourceTree",
            async: false,
            success: function (data) {
                zNodes = data.data;
            }

        });

        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };


        var treeObj = $.fn.zTree.init(_resourceTree, setting, zNodes);
        treeObj.expandAll(true);

    };


    //删除
    var deleteGroup = function (id) {
    	layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
        	$.post(ctx + "/account/group/delete", {groupId: id}, function (data) {
                if (data.status == 0) {
                	layer.msg("操作成功");
                	resetList();
                } else {
                	if(data.errors.length>0 && data.errors[0].errorCode=='ERROR002'){
                		layer.msg("已关联账户不可删除");
                	}else {
                		layer.msg("操作失败");
                	}
                }
                layer.close(index);
            });
        });
    	
    };


    var resetList = function () {
        jQuery("#table_list_1").jqGrid('setGridParam', {page : 1}).trigger("reloadGrid");
    };
    
    //菜单权限
    var editGroup = function (id) {
    	
    	layer.open($.extend(defaultOption ,{
			title:"菜单权限授权",
			content: ctx + "/account/group/edit?groupId=" + id,
			yes: function(index, layero){
				  var _form = layer.getChildFrame("#updateForm");
				  var url = ctx + "/account/group/edit/save";
				  updateGroup(index, _form, url);
			},
			success: function(layero, index){
				  var _form = layer.getChildFrame("#updateForm");
				  initResourceTree(_form);
			}
		}));
    };



    /**
     * 更新
     */
    var updateGroup = function (index, _form, url) {

    	if (_form.validationEngine('validate')) {
            var treeObj = $.fn.zTree.getZTreeObj("resourceTree");
            var nodes = treeObj.getCheckedNodes(true);
            var ids = "";
            if (nodes.length > 0) {
                for (var i = 0; i < nodes.length; i++) {
                    var node = nodes[i];
                    ids += (node.id + ",")
                }
            }
            _form.attr("action", url);
            _form.find("#ids").val(ids);
        	_form.ajaxSubmit(function (result) {
                if (result.status == 0) {
                	layer.msg("操作成功");
					setTimeout(function(){layer.close(index);},2000);
                } else {
                	if(result.errors.length>0 && result.errors[0].errorCode=='ERROR002'){
                		layer.msg("权限组名称已存在");
                	}else {
                		layer.msg("操作失败");
                	}
                }
            });

        }
    	
    	
    };


    return {
        editGroup: editGroup,
        deleteGroup: deleteGroup,
        initResourceTree: initResourceTree,
        initAddResourceTree: initAddResourceTree,
        init: function () {
            initEvent();
            initGrid();
        }

    };

}();


