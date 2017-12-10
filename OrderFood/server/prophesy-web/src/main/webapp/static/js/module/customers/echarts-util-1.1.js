define(function (require, exports, module) {
    //模块依赖
    require('echarts');
    
    var obj = {
    		loadNoData:function (id) {
    			var myChart = echarts.init(document.getElementById(id), macarons);
    			myChart.clear();
    		},
    		loadRevenueMap:function(datas, type, id){
    			
    			var echartstype = datas.echartstype;
    			if(echartstype == 0){ //线图
    				loadLineMap(datas, type, id);
    			} else if(echartstype == 1){ //柱图或饼图
    				if(datas.legends && datas.legends.length >0){	//柱图
    					loadBarMap(datas, type, id);
    				} else {	//饼图
    					load3DPieMap(datas, type, id);
    				}
    			} else{
    				debugger;
    				alert("load RevenueMap error!");
    			}
    		},
    		loadApartMap:function(datas, id){
    			var echartstype = datas.echartstype;
    			if(echartstype == 0){ //线图
    				loadBaseApartMap(datas, id, "line");
    			} else if(echartstype == 1){ //柱图
    				loadBaseApartMap(datas, id, "bar");
    			} else{
    				debugger;
    				alert("load RevenueMap error!");
    			}
		    },
		    loadindexdata:function(datas, type, id, isApart){
		    	var echartstype = datas.echartstype;
		    	datas.barWidth = false;
		    	if(datas.griddata && datas.griddata.length <=10){
		    		datas.barWidth = true;
		    	}
		    	if(isApart){ //公寓
		    		loadIndexApartMap(datas, type, id);
		    	} else{ //新房和放款
		    		loadBaseIndexMap(datas, type, id);
		    	}
		    },
		    loadLoanMap: function(datas, type, id){
		    	var echartstype = datas.echartstype;
    			if(echartstype == 0){ //线图
    				loadLineMap(datas, type, id);
    			} else if(echartstype == 1){ //柱图或饼图
    				loadBarMap(datas, type, id);
    			} else{
    				debugger;
    				alert("load RevenueMap error!");
    			}
		    },
		    loadNewHouseMap: function(datas, type, id){
		    	var echartstype = datas.echartstype;
    			if(echartstype == 0){ //线图
    				loadLineMap(datas, type, id);
    			} else if(echartstype == 1){ //柱图或饼图
    				loadBarMap(datas, type, id);
    			} else{
    				debugger;
    				alert("load RevenueMap error!");
    			}
		    }
    
    
    
    
    
    
    }
    
    //---------------------------------------------------------------------------------------
    
    //加载首页公寓图
    function loadIndexApartMap(datas, type, id){
    	var start = datas.start;
    	var optExtend = null;
    	if(start && start != 20){
    		optExtend = {
    				dataZoom:	{
        				show : true,
        				realtime : true,
        				start : datas.start? datas.start: 50,
        				end : 100
    				},
    				legend:{data:["收房间数","出房间数"]}
    		}
    	}
    	if(type == "recehousenum"){
			datas.echartsdata.multdata = datas.echartsdata[datas.legends[0]];
			loadBaseApartMap(datas, id, "line", optExtend);
		} else {
			loadBaseIndexMap(datas, type, id);
		}
    }
    
    //加载首页图
    function loadBaseIndexMap(datas, type,  id){
    	//type区分显示字段的图表
    	var myChart = echarts.init(document.getElementById(id), macarons);
    	myChart.clear();
    	var option={};
    	if(datas.legends.length ==1){
    		option = getSoleIndexOption(datas, type);
    	} else {
    		option = getLineIndexOption(datas, type);
    	}
    	myChart.setOption(option);
    }
    
    //加载公寓图
    function loadBaseApartMap(datas, id, type, optExtend){
    	//type区分线图和柱图
    	var myChart = echarts.init(document.getElementById(id), macarons);
    	var legItems = datas.echartsdata.multdata;
    	var series = getApartSeries(legItems, type);
//    	var title = {x:'left',text:'公寓房源'};
    	var option = {
//          		 title :title,
          		 tooltip: {
          			 trigger: 'axis'
          		 },
          		 legend: {
          			 	x: 'center',	
          			 data: datas.legends
          		 },
	             xAxis: [
	                 {
                     		type: 'category',
//                     boundaryGap: false,
                     	   data : datas.xAxis
	                 }
	             ],
	             yAxis: [
	                 {
	                	 type: 'value',
	                	 name: '公寓房源'
	                 }
	             ],
	             series: series
        };
    	if(optExtend){
    		option = $.extend(option, optExtend);
    	}
    	myChart.setOption(option);
    }
    
    
    //加载线图
    function loadLineMap(datas, type, id){
    	var myChart = echarts.init(document.getElementById(id), macarons);
    	var series = getBarLineSeries(datas, type, 'line');
    	var title = getTitle(type);
    	var option = {
    			title : title,
    			tooltip : {
    				  trigger: 'axis',
    				textStyle:{
    					align:'left'
    				},
    				formatter: function (params) {
    					return titleFormatter(params, title.subtext);
    				}
    			},
    			legend: {
    				x : 'center',
    				data: datas.legends
    			},
    			xAxis : [
    			         {
    			        	 type : 'category',
//    			        	 boundaryGap : false,		//起始和结束两端空白策略，默认为true留空，false则顶头
    			        	 data : datas.xAxis
    			         }
    			         ],
    			         yAxis : [
    			                  {
    			                	  type : 'value'
    			                  }
    			                  ],
    			                  series : series
    	};
    	myChart.setOption(option);
    }
    //加载柱状图
    function loadBarMap(datas, type, id){
    	var myChart = echarts.init(document.getElementById(id), macarons);
    	var series = null;
    	if(datas.griddata && datas.griddata.length <10){
    		series = getBarLineSeries(datas, type, 'bar', {barWidth: 60});
    	} else {
    		series = getBarLineSeries(datas, type, 'bar');
    	}
    	var title = getTitle(type);
    	var option = {
        	    title : title,
        	    tooltip : {
        	        trigger: 'axis',
        	        textStyle:{
        	        	align:'left'
        	        },
        	        formatter: function (params) {
        	            return titleFormatter(params, title.subtext);
        	        }
        	    },
        	    legend: {
        	    	x : 'center',
        	        data: datas.legends
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : datas.xAxis
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value'
        	        }
        	    ],
        	    series : series
        	};
    	
    	var len = datas.xAxis.length;
    	if(len > 11){
    		len = parseInt(1000/len) ;
    		var dataZoom = {
						show : true,
						realtime : true,
						start : 0,
						end : len
				}
    		option.dataZoom = dataZoom;
    		
    	}
    	myChart.setOption(option);
    }
    //加载饼图
    function loadPieMap(datas, type, id){
    	var myChart = echarts.init(document.getElementById(id), macarons);
    	var series = getPieSeries(datas, type);
		var title = getTitle(type);
		var option = {
				title : title,
	    	    tooltip : {
	    	        trigger: 'item',
	    	        formatter: "{b} : {c}(万) ({d}%)"
	    	    },
	    	    legend: {
	    	        orient : 'vertical',
	    	        x : 'center',
	    	        data: datas.xAxis
	    	    },
	    	    series : series
	    	};
		myChart.setOption(option);
    }
    //加载3D饼图
    function load3DPieMap(datas, type, id){
    	var title = getTitle(type);
    	var series = get3DPieSeries(datas, type, title);
    	if(series){
    		var unit = title.subtext.split("：")[1];
    		var option = {
    				chart: {
    					type: 'pie',
    					options3d: {
    						enabled: true,
    						alpha: 45,
    						beta: 0
    					}
    				},
    				credits:false,
//    				credits: {
//    					href:"###",
//    					text:"worldunion"
//    				},
    				title: {
    					text: title.text,
    					align: 'left'
    				},
    				subtitle: {
    					text: title.subtext,
    					align: 'left'
    				},
    				tooltip: {
    					pointFormat: '{series.name}: {point.y}'+unit+' <b>{point.percentage:.1f}%</b>'
    				},
    				plotOptions: {
    					pie: {
    						allowPointSelect: true,
    						cursor: 'pointer',
    						depth: 35,
    						slicedOffset: 20,	//扇区剥离距离控制
//    						innerSize:80,		//加此属性后变成环形图
    						dataLabels: {
    							enabled: true,
    							formatter: function(){
    								return this.key + ': '+ toThousands(this.y) + unit
    							}
    						},
    						point:{
    							events: {
    								mouseOver: function(e) {
    									this.select(true);
    								},
    								mouseOut: function(e){
    									this.select(false);
    								}
    						
    							}
    							
    						}
    					}
    				},
    				series: series
    		}
    		$('#'+id).highcharts(option);
    	} else {
    		$('#'+id).html("").siblings(".nodata").show();
    		$('#'+id).siblings(".tips").hide();
    	}
    }
    
    
    //---------------------------------------------------------------------------------------
    
    //首页图表只有一个城市时调用的初始化option方法
    function getSoleIndexOption(datas, type){
    	
    	var series = getIndexSeries(datas, type, true);
    	var title = getTitle(type);
    	var unit = title.subtext.split("：")[1];
    	var yAxis = getIndexyAxis(datas, title, true);
    	var city="";
    	var dataZoom = "";
    	if(datas.legends[0]!= ""){
			city = datas.legends[0]+"<br/>";
		}
    	var start = datas.start;
    	if(start && start != 20){
    		dataZoom = {
    				show : true,
    				realtime : true,
    				start : datas.start? datas.start: 50,
    				end : 100
    		}
    	}
    	var option = {
        		tooltip : {
	    	        trigger: 'axis',
	    	        formatter: function (params) {
	    	            return city+params[0].name+"<br/>"+params[0].seriesName +":" +toThousands(params[0].data)+"("+unit+")<br/>"
	    	            					+ params[1].seriesName +":" +params[1].data+"%<br/>"
	    	            					+ params[2].seriesName +":" +params[2].data+"%<br/>";
	    	        }
	    	    },
        	    legend: {
        	    	x: 'center',		
        	        data:[title.text,'环比','同比']	
        	    },
        	    grid : {
        	    	x :150,
        	    	x2 :160
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : datas.xAxis
        	        }
        	    ],
        	    yAxis : yAxis,
        	    series : series
        };
    	if(dataZoom){
    		option.dataZoom = dataZoom;
    	}
    	return option;
    }
    //首页图表有多个城市时调用的初始化option方法
    function getLineIndexOption(datas, type){
    	var series = getIndexSeries(datas, type, false);
    	var title = getTitle(type);
    	var yAxis = getIndexyAxis(datas, title, false);
    	var dataZoom = "";
    	var start = datas.start;
    	if(start && start != 20){
    		dataZoom = {
    				show : true,
    				realtime : true,
    				start : datas.start? datas.start: 50,
    				end : 100
    		}
    	}
    	var option = {
        		tooltip : {
	    	        trigger: 'axis',
	    	        formatter: function (params) {
	    	        	return titleFormatter(params, title.subtext);
	    	        }
	    	    },
        	    legend: {
        	    	x: 'center',		
        	        data:datas.legends	
        	    },
        	    grid : {
        	    	x :150,
        	    	x2 :160
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : datas.xAxis
        	        }
        	    ],
        	    yAxis : yAxis,
        	    series : series
        };
    	if(dataZoom){
    		option.dataZoom = dataZoom;
    	}
    	return option;
    }
    
    //首页初始化yAxis方法
    function getIndexyAxis(datas, title, isSole){
    	var yAxis=[];
    	var unit = title.subtext.split("：")[1];
    	if(isSole){
    		yAxis.push({
 	            type : 'value',
 	            name : title.text+"("+ unit+")",
 	            axisLabel : {
 	                formatter: '{value}'
 	            }
 	        });
    		yAxis.push({
 	            type : 'value',
 	            name : '增幅',
 	            axisLabel : {
 	                formatter: '{value}% '
 	            }
 	        })
 	        
    	} else {
    		yAxis.push({type: 'value',
		    			name : title.text+"("+ unit+")",
		 	            axisLabel : {
		 	                formatter: '{value}'
		 	            }});
    	}
    	return yAxis;
    }
    //首页初始化series方法
    function getIndexSeries(datas, type, isSole){
    	var series = [];
    	var echartsData = datas.echartsdata;
    	if(isSole){
    		var param1;
    		var param2;
    		var param3;
    		switch(type)
    		{
    		case 'saleamount':
    			param1 = {key: 'saleamount', value:'销售额'};
    			param2 = {key: 'saleamountlooprate', value:'环比'};
    			param3 = {key: 'saleamountsamerate', value:'同比'};
    			break;
    		case 'avghouseunitprice':
    			param1 = {key: 'avghouseunitprice', value:'平均单价'};
    			param2 = {key: 'avgpricelooprate', value:'环比'};
    			param3 = {key: 'avgpricesamerate', value:'同比'};
    			break;
    		case 'totsalenum':
    			param1 = {key: 'totsalenum', value:'销售套数'};
    			param2 = {key: 'salenumlooprate', value:'环比'};
    			param3 = {key: 'salenumsamerate', value:'同比'};
    			break;
    		case 'totsalearea':
    			param1 = {key: 'totsalearea', value:'销售面积'};
    			param2 = {key: 'salearealooprate', value:'环比'};
    			param3 = {key: 'saleareasamerate', value:'同比'};
    			break;
    		case 'newloanamount':
    			param1 = {key: 'newloanamount', value:'放款额'};
    			param2 = {key: 'loanamountlooprate', value:'环比'};
    			param3 = {key: 'loanamountsamerate', value:'同比'};
    			break;
    		case 'newloannum':
    			param1 = {key: 'newloannum', value:'放款笔数'};
    			param2 = {key: 'loannumlooprate', value:'环比'};
    			param3 = {key: 'loannumsamerate', value:'同比'};
    			break;
    		case 'avgloanamount':
    			param1 = {key: 'avgloanamount', value:'日均放款额'};
    			param2 = {key: 'avgloanamountlooprate', value:'环比'};
    			param3 = {key: 'avgloanamountsamerate', value:'同比'};
    			break;
    		case 'avgrenthouseamount':
    			param1 = {key: 'avgrenthouseamount', value:'出房每平米租金'};
    			param2 = {key: 'avgrentpricelooprate', value:'环比'};
    			param3 = {key: 'avgrentpricesamerate', value:'同比'};
    			break;
    		}
    		var legend = datas.legends[0];
    		var legItems = datas.echartsdata[legend];
    		if(datas.barWidth){
    			series.push(getSeriesItem(legItems, param1, "bar", {barWidth: 60}));
    		} else {
    			series.push(getSeriesItem(legItems, param1, "bar"));
    		}
    		series.push(getSeriesItem(legItems, param2, "line",{yAxisIndex: 1}));
    		series.push(getSeriesItem(legItems, param3, "line",{yAxisIndex: 1}));
    	} else {
    		series = getBarLineSeries(datas, type, 'line');
    	}
    	
    	return series;
    }
    
    //公寓初始化series方法
    function getApartSeries(legItems, type){
	    var series = [];
//	    var legItems = datas.echartsdata.multdata;
	    series.push(getSeriesItem(legItems, {key:"recehousenum", value:"收房间数"}, type));
	    series.push(getSeriesItem(legItems, {key:"renthousenum", value:"出房间数"}, type));
	    return series;
    }
    //提取seriesItem公共方法
    function getSeriesItem(legItems, param, type, extendParam){
    	var sitem = {
    			name: param.value,
				type: type,
				data:[]
    	}
    	$.each(legItems, function(index, obj){
    		var value = obj[param.key];
    		sitem.data.push(value? value : 0);
	    })
	    if(extendParam){
	    	sitem = $.extend(sitem, extendParam);
	    }
	    return sitem;
    }
    
    //柱图或线图的series提取方法，根据barLine区分
    function getBarLineSeries(datas, type, barLine, extendParam){
	    var echartsdata = datas.echartsdata;
	    var series = [];
		var legends = datas.legends;
		if(!legends){
			var sitem = {
					name: "",
					type: barLine,
					data:[]
			}
			$.each(datas.xAxis, function(i,item){
		    	var legitem = echartsdata[item];
		    	var values = legitem[0][type];
		    	sitem.data.push(values? values:0);
		    })
		    if(extendParam){
		    	sitem = $.extend(sitem, extendParam);
		    }
		    series.push(sitem);
		} else {
			$.each(legends, function(i, item){
				var sitem = {
						name: item,
						type: barLine,
						data:[]
				}
				var legItems = echartsdata[item];
				$.each(legItems, function(index, obj){
					var value = obj[type];
					sitem.data.push(value? value:0);
				})
				series.push(sitem);
			})
		}
		return series;
    }
    //公共tooltip formatter方法，可用于大部分图表的tooltip formatter
    function titleFormatter(param1, param2){
    	var res = param1[0].name;
        for (var i = 0, l = param1.length; i < l; i++) {
        	var name = param1[i].seriesName? param1[i].seriesName+":":"";
            res += '<br/>' + name + toThousands(param1[i].value);
        }
        if(param2){
        	res += '<br/>' +param2;
        }
        return res;
    }
    //饼图series获取方法
    function getPieSeries(datas, type){
	    var echartsdata = datas.echartsdata;
	    var xAxis = datas.xAxis;
	    var series = [];
	    var sitem = {
	    		name:type,
	            type:'pie',
	            radius : '50%',
	            selectedMode : 'single',
	            itemStyle : {
	                    normal : {
	                        label : {
	                            show : false
	                        },
	                        labelLine : {
	                            show : false
	                        }
	                    },
	                    emphasis : {
	                    	 shadowBlur: 10,
	                         shadowOffsetX: 0,
	                         shadowColor: 'rgba(0, 0, 0, 0.5)'
	                    }
	                },
	            data : []
	    }
	    
	    $.each(xAxis, function(i,item){
	    	var legitem = echartsdata[item];
	    	var values = legitem[0][type];
	    	sitem.data.push({value:values? values: 0, name:item})
	    })
	    series.push(sitem);
	    return series;
    
    }
    function get3DPieSeries(datas, type, title){
    	var echartsdata = datas.echartsdata;
    	var xAxis = datas.xAxis;
    	var series = [];
    	var sitem = {
    			name:title.text,
    			type:'pie',
    			data : []
    	}
    	var flag = true;
    	$.each(xAxis, function(i,item){
    		var legitem = echartsdata[item];
    		var values = legitem[0][type];
    		if(values){
    			flag = false;
    		}
    		sitem.data.push({y:values? values: 0, name:item})
    	})
    	series.push(sitem);
    	if(flag){
    		return null;
    	}else{
    		return series;
    	}
    	
    }
    //公共title获取方法
    function getTitle(type){
    	var title = {x:'left',subtext:''};
    	switch(type)
		{
		case "avgprice":
		case "avghouseunitprice":
			title.text="平均单价";
			title.subtext+="单位：元";
			break;
		case "saleamount":
			title.text="销售额";
  		  	title.subtext+="单位：万";
  		  	break;
		case "totsalearea":
			title.text="销售面积";
  		  	title.subtext+="单位：平米";
  		  	break;
		case "totsalenum":
			title.text="销售套数";
			title.subtext+="单位：套";
			break;
		case "newloanamount":
			title.text="放款额";
			title.subtext+="单位：万";
			break;
		case "newloannum":
			title.text="放款笔数";
			title.subtext+="单位：笔";
			break;
		case "singleloanamount":
			title.text="单笔放款额";
			title.subtext+="单位：万";
			break;
		case "realreveamount":
			title.text="创收";
			title.subtext+="单位：万";
			break;
		case "agentsalenum":
			title.text="代理销售套数";
			title.subtext+="单位：套";
			break;
		case "agentsaleamount":
			title.text="代理销售金额";
			title.subtext+="单位：万";
			break;
		case "loanhousenum":
			title.text="金融放款套数";
			title.subtext+="单位：套";
			break;
		case "loanhouseamount":
			title.text="金融放款金额";
			title.subtext+="单位：万";
			break;
		case "avgloanamount":
			title.text="日均放款额";
			title.subtext+="单位：万";
			break;
		case "avgrenthouseamount":
			title.text="出房每平米租金";
			title.subtext+="单位：元";
			break;
		case "failureloanamount":
			title.text="未通过放款额";
			title.subtext+="单位：万";
			break;
		case "failureloannum":
			title.text="未通过放款笔数";
			title.subtext+="单位：笔";
			break;
		default:
		}
    	return title;
    }
    //数字格式化，在千分位加','
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
    
    
    
    //接口暴露
    module.exports = {
    	loadNoData: obj.loadNoData,
    	loadRevenueMap: obj.loadRevenueMap,
    	loadApartMap: obj.loadApartMap,
    	loadindexdata: obj.loadindexdata,
    	loadLoanMap: obj.loadLoanMap,
    	loadNewHouseMap: obj.loadNewHouseMap
    }
})