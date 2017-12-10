/**
 * Created by starhousexq on 2015/11/23.
 */
var Resource = function () {
	
	var defaultOption = {
			type: 2,
			area: ['630px', '440px'],
			fix: false, //不固定
			maxmin: true,
			closeBtn: 2,
			btn: ['保存', '关闭'], //按钮
			shade: [0.8, '#393D49'],
			shadeClose:false,
			btn2: function(index, layero){},
			end: function () {
			}
	}
	
    var initEvent = function () {
        $("#del-btn").bind("click", function () {
            deleteResource();
        });

        $("#add-btn").bind("click", function () {
            addResourcePage();
        });


    };


    /**
     * 更新数据
     */
    var addResourcePage = function () {

    	layer.open($.extend(defaultOption ,{
    		  title:"新增菜单资源",
    		  content: ctx + "/account/resource/add",
    		  yes: function(index, layero){
    			  var _form = layer.getChildFrame("#createForm");
    			  addResource(index, _form);
    		  }
    		}));

    };




    /**
     * 更新
     */
    var addResource = function (index, _form) {
        if (_form.validationEngine('validate')) {
        	
        	
        	var val = _form.find("#value").val();
        	var parent = _form.find("#parentid :selected").val();
        	if(parent){
        		if(val.length<4){
        			layer.msg("URL长度必须大于4");
        			return false;
        		}
        	}
        	
        	_form.attr("action", ctx + "/account/resource/add/save");
        	_form.ajaxSubmit(function (result) {

                if (result.status == 0) {
                	layer.msg("操作成功");
					setTimeout(function(){layer.close(index);location.reload();},1000);
                } else if (result.status == 1) {
                	layer.msg("操作失败");
                }
            });


        }
    };



    /**
     * 更新数据
     */
    var updateResourcePage = function (id) {
    	layer.open($.extend(defaultOption ,{
  		  title:"修改菜单资源",
  		  content: ctx + "/account/resource/edit?id=" + id,
  		  yes: function(index, layero){
  			  var _form = layer.getChildFrame("#updateForm");
  			  updateResource(index, _form);
  		  }
  		}));
    };


    /*
     删除
     */
    var deleteResource = function () {
        var treeObj = $.fn.zTree.getZTreeObj("dataTable");
        var nodes = treeObj.getCheckedNodes(true);
        if (nodes.length <= 0) {
        	layer.msg("请选择要删除的选项");
        } else {

        	layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
        		var ids = "";
                for (var i = 0; i < nodes.length; i++) {
                    var node = nodes[i];
                    if (!node.getCheckStatus().half) {
                        ids += (node.id + ",")
                    }
                }
                $.post(ctx + "/account/resource/delete", {ids: ids}, function (data) {
                    if (data.status == 0) {
                    	layer.msg("操作成功");
                    	window.location.reload();
                    } else {
                    	layer.msg("操作失败");
                    }
                });
            });
        	
        }
    };


    var addDiyDom =function(treeId, treeNode){
        var aObj = $("#" + treeNode.tId + "_a");

        if(resource_edit_role){
            if(treeNode.type=='01'){
                aObj.append('<span class="tree_menu_icon"><span></span></span>');
            }else {
                aObj.append('<span class="tree_handle_icon"></span>');
            }
            aObj.append("  <a href='javascript:;' title ='编辑' onclick=\"Resource.updateResourcePage('"+treeNode.id+"')\" ><span class=\"tree_edit_icon\"></span></a>");
        }




    };

    var initResourceTree = function () {
        var zNodes = null;
        $.ajax({
            url: ctx +"/account/resource/list/data",
            async: false,
            success: function (data) {
                zNodes = data.data;
            }

        });

        var setting = {
            view: {
                selectedMulti: false,
                dblClickExpand: false,
                //addHoverDom : addHoverDom,
                addDiyDom : addDiyDom//,
                //removeHoverDom :removeHoverDom
            },

            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };


        var treeObj = $.fn.zTree.init($("#dataTable"), setting, zNodes);
        treeObj.expandAll(true);


    };





    /**
     * 更新
     */
    var updateResource = function (index, _form) {
        if (_form.validationEngine('validate')) {
        	

        	var val = _form.find("#value").val();
        	var parent = _form.find("#parentid :selected").val();
        	if(parent){
        		if(val.length<4){
        			layer.msg("URL长度必须大于4");
        			return false;
        		}
        	}
        	_form.attr("action", ctx + "/account/resource/edit/save");
        	_form.ajaxSubmit(function (result) {
        		
        		if (result.status == 0) {
                	layer.msg("操作成功");
					setTimeout(function(){layer.close(index);location.reload();},1000);
                } else if (result.status == 1) {
                	layer.msg("操作失败");
                }
            });


        }
    };


    return {
        updateResource:updateResource,
        addResource:addResource,
        updateResourcePage:updateResourcePage,
        init: function () {
            initEvent();
            initResourceTree()
        }

    };

}();


