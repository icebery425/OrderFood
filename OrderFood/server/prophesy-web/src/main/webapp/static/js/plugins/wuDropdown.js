(function($) {

	var all_item = "<div class='com_block' style='display: inline-block;cursor: pointer;position:relative;width: 40%;margin:5px 10px 8px 25px;vertical-align: top;'>" +
		"<input type='checkbox' style='position: absolute;margin-left: -20px;' value='$0$'/>" +
		"<span title='$1$'>$1$</span></div>";
	var chart_item = "<div class='com_block' style='display: inline-block;cursor: pointer;position:relative; margin:5px 10px 5px 25px;'>" +
		"<input type='checkbox' value='$0$' checked/>" +
		"<span>$1$</span></div>";
	var loading_item='<div class="layui-anim layui-layer-dialog layui-layer-loading" type="dialog" contype="string" style="z-index: 19891023; width: 180px;margin-left: 183px;margin-top: 50px;">'
		+'<div class="layui-layer-content layui-layer-loading0"></div><span class="layui-layer-setwin"></span></div>'
	
	$.fn.wuDropdown = function(options) {
		var defaultOption = {
			id: "",
			name: "",
			url: "",
			title: "缺省标题",
			maxItem: 20,
			isCheckBox: false, //默认为单选框
			posLeft: '', //弹框默认位置
			posTop: '', //弹框默认位置,
			async: true,
			enableAll: false,//默认没有全选按钮
			enableNone: true, //默认允许为空
			defaultval: '', //默认值，可为单个值或数组
			typeaheadAjax: false, //默认搜索控件数据源为前台数据。如果设为true则通过ajax从后台请求数据，请求地址同url
			letBombBoxShowCorrectly: false, //在layer中弹出，手动设置是否让它显示正常
			relativeflag: false,		//是否有级联控件，默认没有
			childid: null,					//如果有级联控件，则需要写级联子控件的ID
			childtitle: "",
			callback: null					//回调方法
		}
		options = $.extend(defaultOption, options);
		var _target = $(this);
		var _initTargetText = _target.text();
		var targetid = _target.attr("id");
		var _isCheckBox = options.isCheckBox;
		var _dropdown = _target.next(".moreDiv");
		var _enableAll = options.enableAll;
		var _enableNone = options.enableNone;
		
		var maxItem = options.maxItem;
		if(!_isCheckBox){	//如果是单选，则选择最大值为1
			maxItem = 1;
		}
		var async = options.async;
		var activeFlag = false;
		if (_dropdown.length > 0) {
			_target.text(_initTargetText);
			_target.data("id", "");
			_target.attr("title", "");
			_target.attr("dataset", "");
			_dropdown.remove();
		}
		
		_dropdown = domInit(_target, options);
		_dropdown.tmpArr = [];
		_dropdown.lastTmpArr = [];
		_target.parent().append(_dropdown);
		
		_dropdown.find('.ensure_elected').click(function(event) {
			checkInput(_dropdown, targetid, maxItem);
			if(!_enableNone && _dropdown.find(":checked").length == 0){//如果不允许为空，则必须至少选择一项，否则给出提示
				layer.msg("请选择"+options.title);
			} else {
				activeFlag = false;
				var _chartDom = _dropdown.find("#chart_" + targetid).find('.content_box');
				_dropdown.hide();
				var nowAllSelectedId = _dropdown.lastTmpArr;
				if (_dropdown.lastTmpArr.length === _dropdown.tmpArr.length) {
					if (_dropdown.lastTmpArr.sort().toString() === _dropdown.tmpArr.sort().toString()) {
						return;
					}
				}
				resertValue(_chartDom, _target, _initTargetText);
				 //如果有级联控件，则先判断数据是否有作修改，只有数据修改了才执行回调方法
				 //否则直接执行回调方法
				if(options.relativeflag && options.childid){
					var selcityid = _target.data("id");
					selcityid = selcityid? selcityid:"";
					var _child = $("#"+options.childid);
					var histData = _child.attr("hist-data");
					if(selcityid != histData){
						_child.text("请选择"+options.childtitle);
						_child.attr({"dataset":"","title":"","hist-data":selcityid});
						_child.data("id","");
						options.callback && options.callback();
					}
						
				}else {
					options.callback && options.callback();
				}
			}
		})
		
		$.ajax({
			async: async,
			url: options.url,
			dataType: "json",
			cache: false,
			type: 'post',
			error: function(textStatus, errorThrown) {},
			beforeSend: function(){
//				index = layer.msg('努力中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000});
				_dropdown.find("#all_" + targetid).append(loading_item);
			},
			complete: function(){
//				layer.close(index);  
				_dropdown.find("#all_" + targetid).find(".layui-layer-dialog").remove();
			},
			success: function(data) {
				if (data && data.status == 0) {

					var myDatas = data.data;
					var objMap = [];
					var _allDom = _dropdown.find("#all_" + targetid);
					var _selectDom = _dropdown.find("#select_" + targetid);
					var _chartDom = _dropdown.find("#chart_" + targetid).find('.content_box');
//						if (_isCheckBox && _enableAll) { //多选提前插入多选内容块
					if (_enableAll) { 					//修改，单选也允许增加全部按钮 0142964 20170809
						var domItemSelectAll = formatStr(all_item, "**", '全选');
						_allDom.append(domItemSelectAll);
					}
					if (myDatas && myDatas.length > 0) {
						$.each(myDatas, function(i, item) {
							var domItem = formatStr(all_item, item[options.id], item[options.name]);
							_allDom.append(domItem);
							objMap.push({
								"id": item[options.id],
								"name": item[options.name]
							});
						})
					}
					//初始化搜索控件
					if (options.typeaheadAjax) { //使用ajax向后台请求数据，需要引用bootstrap-typeahead-wu.js文件
						var turl = options.url.indexOf('?') > 0 ? options.url + '&keywords=' : options.url + '?keywords=';
						_selectDom.typeaheadwu({
							source: function(query, process) {
								if (query) {
									return $.ajax({
										url: encodeURI(encodeURI(turl + query)),
										type: 'post',
										dataType: 'json',
//										contentType: "application/x-www-form-urlencoded; charset=UTF-8",
										scriptCharset: 'utf-8',
										success: function(result) {
											var resultList = [];
											$.each(result.data, function(i, item) {
												resultList.push({
													"id": item[options.id],
													"name": item[options.name]
												});
											})
											return process(resultList);
										}
									});
								}
							},
							delay: 300,
							updater: function(item) {
								var id = item;
								var _checkbox = _allDom.find(":checkbox[value='" + id + "']");
								if (_checkbox.length > 0 && !_checkbox.is(":checked")) {
									_checkbox.trigger("click");
								}
								return item;
							}
						})

					} else { //使用前台页面数据，需要引用bootstrap-typeahead.js文件
						_selectDom.typeahead({
							source: function(query, process) {
								process(objMap); //调用处理函数，格式化
							},
							updater: function(item) {
								var id = item;
								var _checkbox = _allDom.find(":checkbox[value='" + id + "']");
								if (_checkbox.length > 0 && !_checkbox.is(":checked")) {
									_checkbox.trigger("click");
								}
								return item;

							}
						})
					}
					_selectDom.parent().bind("mouseover", function(event) {
						$(this).find("i.iconcancel").show();
						event.stopPropagation();
					}).bind("mouseout", function(event) {
						$(this).find("i.iconcancel").hide();
						event.stopPropagation();
					})
					_selectDom.next("i").bind("click", function(event) {
							_selectDom.val("");
						})
						//初始化复选框
					_allDom.find(".com_block").click(function(event) {
						event.stopPropagation();
						if (!_isCheckBox) { //非多选情况
							var _obj = $(this),
								_checkbox = $(this).find(":checkbox").first();
							var id = _checkbox.val(),
								name = _obj.find("span").text(),
								status = !_checkbox.prop("checked");
							$(this).siblings().find(":checkbox").prop("checked", false);
							_checkbox.prop("checked", status); //给此复选框赋值
							setChartCom(_chartDom, id, name, status, targetid, _isCheckBox); //给页面选项赋值
							//						    	resertValue(_chartDom, _target,_initTargetText);
							saveAllSelectedId(status, _dropdown.tmpArr, id);

						} else {
							var _obj = $(this),
								_checkbox = $(this).find(":checkbox").first();

							var id = _checkbox.val(),
								name = _obj.find("span").text(),
								status = !_checkbox.prop("checked");

							if (id == "**") { //全选
								$(this).find(":checkbox").prop("checked", status);
								$(this).siblings().find(":checkbox").prop("checked", false);
								setChartCom(_chartDom, id, name, status, targetid, false); //给页面选项赋值
								//					    		resertValue(_chartDom, _target,_initTargetText);
								saveAllSelectedId(status, _dropdown.tmpArr, id);
							} else {
								//清除全选按钮
								var _allChoose = _chartDom.find(":checkbox[value='**']");
								if (_allChoose.length > 0) {
									_allChoose.trigger("click");
								}
								var itemLen = _chartDom.find(".com_block").length;
								if (status && itemLen >= maxItem) {
									layer.msg("最多只能选择" + maxItem + "条记录");
								} else {
									var _obj = $(this),
										_checkbox = $(this).find(":checkbox").first();
									var id = _checkbox.val(),
										name = _obj.find("span").text(),
										status = !_checkbox.prop("checked");
									var tmp = 0;
									var allComBlockNum = $('#all_' + targetid + ' .com_block').length;
									_checkbox.prop("checked", status); //给此复选框赋值
									if (!$(this).find(":checkbox").prop('checked')) { //有一项没选中，全选按钮不勾上
										$(this).siblings().find(":checkbox[value=0]").prop('checked', false);
									}
									setChartCom(_chartDom, id, name, status, targetid, _isCheckBox); //给页面选项赋值
									//					    			resertValue(_chartDom, _target,_initTargetText);
									saveAllSelectedId(status, _dropdown.tmpArr, id);
									$('#chart_' + targetid + ' .com_block').each(function(i, item) { //选择所有，全选按钮勾上
										if ($(item).find(":checkbox").prop('checked')) {
											tmp++;
											if (tmp === allComBlockNum - 1) {
												_obj.siblings().find(":checkbox[value=0]").prop('checked', true);
											}
										}
									})
								}
							}
						}

					})
					_allDom.find(":checkbox").click(function(event) {
						event.stopPropagation();
						var _obj = $(this);
						_obj.prop("checked", !_obj.prop("checked"));
						_obj.parent().trigger('click');
					})
					
					if(options.defaultval){
						var valList = [];
						if(options.defaultval instanceof Array){	//判断是否为数组
							valList = options.defaultval;
						} else {
							valList = options.defaultval.toString().split(',');//如果不是数组，则转化为字符数组
						}
						if(valList.length>0){
							if(_isCheckBox){
								for(var i in valList){
									_allDom.find(":checkbox[value='"+valList[i]+"']").trigger("click");
								}
							} else {
								_allDom.find(":checkbox[value='"+valList[0]+"']").trigger("click");
							}
							
							_dropdown.find('.ensure_elected').trigger("click");
						}
					}
				}
			}
		});
		_target.click(function() { //弹出弹框
			$(".moreDiv").hide();
			activeFlag = true;
			getAllSelectedId(_dropdown, targetid);
			_dropdown.show();
		})
		
		_dropdown.find('.cancel_elected').click(function() { //取消恢复原样
			var nowAllSelectedId = _dropdown.lastTmpArr;
			var _allDom = _dropdown.find("#all_" + targetid);
			$('#all_' + targetid).find('.com_block input').prop('checked', false);
			$('#chart_' + targetid).css('display', 'none').find('.content_box').empty();
			_dropdown.hide();
			_dropdown.lastTmpArr.forEach(function(item, index) {
				var nowAllSelected = null;
				if (isNaN(parseInt(item))) {
					nowAllSelected = _allDom.find(".com_block input[value='**']");
				} else {
					nowAllSelected = _allDom.find(".com_block input[value=" + item.toString() + "]");
				}
				nowAllSelected.trigger('click');
			})
		})
			
		$(window).resize(function() {
			resetLeft(_dropdown,options);
		});
		_dropdown.mouseleave(function(){
			if(activeFlag){
				$(this).find('.cancel_elected').trigger("click");
			}
//			$(this).hide();
		})
			
	}
		//点击复选框保存已选择选项，
	function saveAllSelectedId(status, tmpArr, id) {
		if (tmpArr.length == 0) {
			tmpArr.push(parseInt(id));
		} else {
			if (status) {
				tmpArr.push(parseInt(id));
			} else {
				tmpArr.forEach(function(item, index) {
					if (id == item) {
						delete tmpArr[index];
					}
				});
			}
		}
	};
	//确认后获取当前已选择全部选项
	function getAllSelectedId(_dropdown, targetid) {
		_dropdown.lastTmpArr = [];
		var _allDom = _dropdown.find("#all_" + targetid);
		var _checkbox = _allDom.find('.com_block').find(":checkbox:checked");
		_checkbox.each(function(index, item) {
			var id = $(this).val();
			_dropdown.lastTmpArr.push(parseInt(id));
		});
	};

	function setChartCom(_chartDom, id, name, status, targetid, _isCheckBox) {
		var _chartItem = _chartDom.find(":checkbox[value='" + id + "']");
		if (_chartItem.length > 0 && !status) {
			_chartItem.parent().remove();
		} else if (_chartItem.length == 0 && status) {
			var _chartitem = $(formatStr(chart_item, id, name));
			if (!_isCheckBox) { //单选多选插入
				if (status) {
					_chartDom.html(_chartitem);
				}
			} else {
				_chartDom.append(_chartitem);
			}
			/*_chartDom.append(_chartitem);*/
			_chartitem.click(function() {
				$("#all_" + targetid).find(":checkbox[value='" + id + "']").trigger('click');
			})

		}
		//判断有没有选中的内容，来展示是否显示$('#chart_'+targetid)
		if (!_chartDom.html()) {
			$('#chart_' + targetid).hide();
		} else {
			$('#chart_' + targetid).show();
		}
	}

	/*function resertValue(_chartDom, _target){
		var items = _chartDom.find(".com_block");
		_target.val(""), _target.data("id", ""),_target.attr("title",""),_target.attr("dataset","");
		if(items.length>0){
			var ids = '';
			var names = '';
			$.each(items, function(i, item){
				var _checkbox = $(item).find("input:checked");
				ids += _checkbox.val()+",";
				names += _checkbox.next("span").text()+",";
			})
			ids = ids.length>0? ids.substr(0, ids.length-1):"";
			names = names.length>0? names.substr(0, names.length-1):"";
			_target.text(names);
			_target.attr("title",names);
			_target.attr("dataset",ids);
			_target.data("id", ids);
		}
	}*/

	/**
	 * 新需求，复选框优化：筛选条件的输入框输入文字后，点击下拉框其他空白处，自动匹配消失后，如果点击“确认”，用输入框的内容匹配下拉项，匹配上时，选中，匹配不上时不处理 
	 * 20170905
	 */
	function checkInput(_chartDom, targetid, maxItem){
		var _input = _chartDom.find("#select_"+targetid);
		var inputVal = _input.val();	//查询控件输入值
		var selectflag = false;		//选择结果
		if(inputVal){	//如果输入框有值，则进一步判断
			var items = _chartDom.find("#chart_"+targetid+" .com_block");	//已选择列表
			
			if(!maxItem || items.length < maxItem						//如果已选择的项少于限制的最大值，才进入
					|| maxItem == 1 && items.length ==1){				//如果 maxItem == 1 表示为单选 ，新增需求，单选时有匹配的数据会替换掉已选择数据 20170906
				$.each(items, function(i, item) {
					var _span = $(item).find("span");
					var val = _span.text();
					if(val && inputVal == val){	//未选中输入框中的值
						selectflag = true;
						return false;	//跳出循环
					}
				})
				if(!selectflag){
					var alls = _chartDom.find("#all_"+targetid+" .com_block");	//备选择列表
					$.each(alls, function(i, item) {
						var _span = $(item).find("span");
						var val = _span.text();
						if(val && inputVal == val){	//如果输入框中的值与备选的名字相同，则将备选项选中
							$(item).trigger("click");
							return false;	//跳出循环
						}
					})
				}
				
			}
		}
		_input.val("");
	}
	
	function resertValue(_chartDom, _target, _initTargetText) { //	换成div触发
		var items = _chartDom.find(".com_block");
		_target.html(""), _target.data("id", ""), _target.attr("title", ""), _target.attr("dataset", "");
		if (items.length > 0) {
			var ids = '';
			var names = '';
			$.each(items, function(i, item) {
				var _checkbox = $(item).find("input:checked");
				ids += _checkbox.val() + ",";
				names += _checkbox.next("span").text() + ",";
				names == '' ? _initTargetText : names;
			})
			ids = ids.length > 0 ? ids.substr(0, ids.length - 1) : "";
			names = names.length > 0 ? names.substr(0, names.length - 1) : "";
			_target.text(names);
			_target.attr("title", names);
			_target.attr("dataset", ids);
			_target.data("id", ids);
		} else { //选择为空重置文本
			_target.text(_initTargetText);
		}
	}

	//设置layer弹框内容区是否可以滚动，如果内容区域表单触发checkBox弹框,去掉表单的定位
	function letBombBoxShowCorrectly(options) {
		if (options.letBombBoxShowCorrectly) {
			$('.layui-layer-content').addClass('layui-layer-content-notscroll').removeClass('layui-layer-content');
			$('.col-sm-8').css('position', '');
		}
	}

	function resetLeft(_dropdown, options){
		if(_dropdown.is(":visible")){
			var defPosLeft = options.posLeft;  //设置的position left
			var t_offset = _dropdown.parent().offset();
			var t_left = t_offset.left;
			var dropdown_left;
			var body_width = document.body.offsetWidth;
			var dropdown_width = 580;
			if(!defPosLeft){
				if(body_width - t_left < dropdown_width){
					dropdown_left = body_width - dropdown_width - 10 - t_left;
				} else {
					dropdown_left = 0;
				}
			}else{
				dropdown_left = defPosLeft;
			}
			_dropdown.css("left", dropdown_left);
		}
	}
	function domInit(_target, options) {
		letBombBoxShowCorrectly(options);
		var defPosLeft = options.posLeft; //设置的position left
		var defPosTop = options.posTop; //设置的position top
		var t_offset = _target.parent().offset();
		var t_top = t_offset.top;
		var t_left = t_offset.left;

		var dropdown_width = 580;
		var dropdown_top;
		var dropdown_left;

		var targetid = _target.attr("id");

		var body_width = document.body.offsetWidth;
		//弹出框位置设置
		if (!defPosLeft) {
			if (body_width - t_left < dropdown_width) {
				dropdown_left = body_width - dropdown_width - 10 - t_left;
			} else {
				dropdown_left = 0;
			}
		} else {
			dropdown_left = defPosLeft;
		}
		dropdown_top = defPosTop ? defPosTop : '40px';


		var _dropdown = $("<div class='search_form_suggest moreDiv' style='display:none'></div>");
		_dropdown.css({
			position: 'absolute',
			width: '580px',
			padding: '5px 0px',
			border: '1px solid #ccc',
			'border-radius': '5px',
			'box-shadow': 'rgba(0, 0, 0, 0.172549) 0px 6px 12px',
			'border-radius': '5px',
			'z-index': '19891020',
			'text-align': 'left',
			top: dropdown_top,
			background: "#fff",
			left: dropdown_left
		})
		_dropdown.append("<h3 style='border-bottom: 1px solid #ccc;padding-bottom:12px;'><label class='control-label min-w90'>全部" +
			options.title + "</label> <a class='thRight btn-primary ensure_elected'>确定</a><a class='thRight btn-white cancel_elected'>取消</a></h3>");
		_dropdown.find("a.ensure_elected").css({
				position: 'absolute',
				top: '7px',
				right: '44px',
				cursor: ' pointer',
				'font-size': ' 12px',
				'text-align': 'center',
				color: '#fff',
				padding: '0 6px',
				height: '22px',
				'line-height': '20px',
				'border-radius': '4px',
				'margin': '0 10px'
			})
			.next('a.cancel_elected').css({
				position: 'absolute',
				top: '7px',
				right: '0',
				cursor: ' pointer',
				'font-size': ' 12px',
				'text-align': 'center',
				padding: '0 6px',
				height: '22px',
				'line-height': '20px',
				'border-radius': '4px',
				'margin': '0 10px',
			});

		//已选择显示区域
		var _chart = $("<div id=chart_" + targetid + " style='padding:0 10px 0 20px;display:none;'><div style='overflow:auto;border-top:1px solid #e7eaec;border-bottom:1px solid #e7eaec;max-height:90px;'><div class='content_box'></div></div></div>");

		//查询输入框区域
		var _searchDom = $("<div class='form-group' style='margin-left: 37px;margin-top:-3px;'></div>");
		_searchDom.append("<label class='control-label' style='min-width: auto;'>查询</label>");

		var _searchInner = $("<div style='display: inline-block; position: relative;'></div>");
		_searchInner.append("<input id='select_" + targetid + "' autocomplete='off' data-provide='typeahead' type='text'" +
			"style='display: inline-block;width: 400px;vertical-align: middle; padding: 0 20px 0 10px;'" +
			"class='input-sm form-control' placeholder='查询' />");
		_searchInner.append("<i class='icon iconfont icon-iconfontguanbi2 iconcancel' style='cursor: pointer; display:none; right: 3px; top:5px; position: absolute; color: #ccc;'></i>");
		_searchDom.append(_searchInner);

		//所有数据显示区域
		var _allDom = $("<div class='wrapper wrapper-content' style='padding: 0;'>" +
			"<div class='box-control' style='position: relative;'><div>" +
			"<div style='margin-left: 10px;padding-left:30px;height:230px;overflow:auto;' id='all_" + targetid + "'>" +
			"</div></div></div></div>");

		_dropdown.append(_searchDom);
		_dropdown.append(_chart);
		_dropdown.append(_allDom);
		return _dropdown;
	}
})(jQuery);