define(function (require, exports, module) {
    //模块依赖
    require('echarts');
    var myChart;
    var mydatas;
    var obj = {
        init: function (datas, type) {
            obj.a(datas, type);
            obj.b(datas, type);
        },
        //x轴可拖动,demo1
        a:function () {
            // 基于准备好的dom，初始化echarts图表
        	if(null != document.getElementById('echarts-bar-chart')){
	            myChart = echarts.init(document.getElementById('echarts-bar-chart'), 'macarons');
	            /*macarons为可选主题*/
	
	            // 过渡---------------------
	           /* myChart.showLoading({
	                text: '正在努力的读取数据中...',    //loading
	            });*/
	
	            //                    参数配置
	            option = {
	            	    tooltip : {
	            	        trigger: 'axis'
	            	    },
	            	    toolbox: {
	            	        show : true,
	            	        feature : {
	            	            mark : {show: true},
	            	            dataView : {show: true, readOnly: false},
	            	            magicType: {show: true, type: ['line', 'bar']},
	            	            restore : {show: true},
	            	            saveAsImage : {show: true}
	            	        }
	            	    },
	            	    calculable : false,
	            	    legend: {
	            	        data:['蒸发量','降水量','平均温度']
	            	    },
	            	    dataZoom : {
	            	        show : true,
	            	        realtime : true,
	            	        start : 20,
	            	        end : 80
	            	    },
	            	   
	            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	            	        }
	            	    ],
	            	    yAxis : [
	            	        {
	            	            type : 'value',
	            	            name : '水量',
	            	            axisLabel : {
	            	                formatter: '{value} ml'
	            	            }
	            	        },
	            	        {
	            	            type : 'value',
	            	            name : '温度',
	            	            axisLabel : {
	            	                formatter: '{value} °C'
	            	            }
	            	        }
	            	    ],
	            	    series : [

	            	        {
	            	            name:'蒸发量',
	            	            type:'bar',
	            	            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
	            	        },
	            	        {
	            	            name:'降水量',
	            	            type:'bar',
	            	            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
	            	        },
	            	        {
	            	            name:'平均温度',
	            	            type:'line',
	            	            yAxisIndex: 1,
	            	            data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
	            	        }
	            	    ]
	            	};
	            	                    
//	            option = {
//	            	    tooltip : {
//	            	        trigger: 'axis'
//	            	    },
//	            	    legend: {
//	            	        data:['最高','最低']
//	            	    },
//	//            	    calculable : false
//	            	    dataZoom : {
//	            	        show : true,
//	            	        realtime : true,
//	            	        start : 20,
//	            	        end : 80
//	            	    },
//	            	    xAxis : [
//	            	        {
//	            	            type : 'category',
//	            	            boundaryGap : false,
//	            	            data : function (){
//	            	                var list = [];
//	            	                for (var i = 1; i <= 30; i++) {
//	            	                    list.push('2013-03-' + i);
//	            	                }
//	            	                return list;
//	            	            }()
//	            	        }
//	            	    ],
//	            	    yAxis : [
//	            	        {
//	            	            type : 'value'
//	            	        }
//	            	    ],
//	            	    series : [
//	            	        {
//	            	            name:'最高',
//	            	            type:'line',
//	            	            data:function (){
//	            	                var list = [];
//	            	                for (var i = 1; i <= 30; i++) {
//	            	                    list.push(Math.round(Math.random()* 30));
//	            	                }
//	            	                return list;
//	            	            }()
//	            	        },
//	            	        {
//	            	            name:'最低',
//	            	            type:'line',
//	            	            data:function (){
//	            	                var list = [];
//	            	                for (var i = 1; i <= 30; i++) {
//	            	                    list.push(Math.round(Math.random()* 10));
//	            	                }
//	            	                return list;
//	            	            }()
//	            	        }
//	            	    ]
//	            	};
	            	                    
	            myChart.setOption(option);
	        }
        },
        //显示折线图
        b:function (type, id, datas) {
            // 基于准备好的dom，初始化echarts图表
        	if(datas){
        		mydatas = datas;
        	}
        	initEcharts(id);
            var parammap = lineParamsGenerate(mydatas, type);

            //                    参数配置
            var option = {
            		title : parammap.title,
            	    tooltip : {
            	        trigger: 'axis',
            	        formatter: function (params) {
            	            return titleFormatter(params, parammap);
            	        }
            	    },
            	    noDataLoadingOption: {
                        text: '暂无数据',
                        effect: 'bubble',
                        effectOption: {
                            effect: {
                                n: 0
                            }
                        }
            	    },	
            	    legend: {
            	        x: 'center',	
            	        data: parammap.legend
            	    },
            	    calculable : false,
            	    /*dataZoom : {
            	        show : true,
            	        realtime : true,
            	        start : 20,
            	        end : 80
            	    },*/
            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            boundaryGap : false,
	            	            data : parammap.xAxis
	            	        }
	            	    ],
            	    yAxis : [
            	        {
            	            type : 'value'
            	        }
            	    ],
            	    series : parammap.series
            	};
            /*if(parammap.xAxis.length<10){
            	delete option.dataZoom;
            } else {
            	option.dataZoom = {
            	        show : true,
            	        realtime : true,
            	        start : 20,
            	        end : 80
            	    }
            }*/         
            if(option.series.length>0){
            	myChart.setOption(option);
            }
            
        },
        //显示环图
        c:function (type, id, datas) {
            // 基于准备好的dom，初始化echarts图表
        	if(datas){
        		mydatas = datas;
        	}
//        	initEcharts(id);
        	 myChart = echarts.init(document.getElementById(id), macarons);
            var parammap = pieParamsGenerate(mydatas, type);
            /*macarons为可选主题*/
            //                    参数配置
            var option = {
            		title : parammap.title,
            	    tooltip : {
            	        trigger: 'item',
            	        formatter: "{b} : {c}(万) ({d}%)"
            	    },
            	    legend: {
            	        orient : 'vertical',
            	        x : 'center',
            	        data: parammap.legend
            	    },
            	    calculable : false,
            	    series : parammap.series
            	};
            	                    
            myChart.setOption(option);
        },
        //显示柱状图
        d:function (type, id, datas) {
        	if(datas){
        		mydatas = datas;
        	}
        	initEcharts(id);
            var parammap = barParamsGenerate(mydatas, type);
            //                    参数配置
            var option = {
            	    title : parammap.title,
            	    tooltip : {
            	        trigger: 'axis',
            	        formatter: function (params) {
            	            return titleFormatter(params, parammap);
            	        }
            	    },
            	    legend: {
            	    	x : 'center',
            	        data:parammap.legend
            	    },
            	    calculable : false,
            	    xAxis : [
            	        {
            	            type : 'category',
            	            data : parammap.xAxis
            	        }
            	    ],
            	    yAxis : [
            	        {
            	            type : 'value'
            	        }
            	    ],
            	    series : parammap.series
            	};
            if(option.series.length>0){
            	myChart.setOption(option);
            }	                    
        },

        //显示多维（柱状图和折线图）
        e:function (type, id, prop1, prop2, prop3, datas) {
            // 基于准备好的dom，初始化echarts图表
        	if(null != document.getElementById(id) ){
        		if(datas){
            		mydatas = datas;
            	}
            	initEcharts(id);
                var parammap = multiParamsGenerate(mydatas, type, prop1, prop2, prop3);
	            option = {
	            		title : parammap.title,
	            	    tooltip : {
	            	        trigger: 'axis'
	            	    },
	            	  
	            	    calculable : false,
	            	    legend: {
	            	        data:parammap.legend
	            	    },
	            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            data : parammap.xAxis
	            	        }
	            	    ],
	            	    yAxis : [
	            	        {
	            	            type : 'value',
	            	            name : params.title.text,
	            	            axisLabel : {
	            	                formatter: '{value}'
	            	            }
	            	        },
	            	        {
	            	            type : 'value',
	            	            name : '温度',
	            	            axisLabel : {
	            	                formatter: '{value} %'
	            	            }
	            	        }
	            	    ],
	            	    series : parammap.series
	            	};
	            myChart.setOption(option);
	        }
        },
      //显示柱状图
        bardemo:function (id, paramsmap) {
        	if(null != document.getElementById(id) ){
        		if(paramsmap.data.length !=0){
        	initEcharts(id);
            //                    参数配置
            var  option = {
            	    tooltip : {
            	        trigger: 'axis',
            	        formatter: function (params) {
            	            return titleFormatter(params, paramsmap);
            	        }
            	    },
            	    legend: {
            	    	x : 'center',
            	        data:paramsmap.legend
            	    },
            	    calculable : false,
            	    xAxis : [
            	        {
            	            type : 'category',
            	            data : paramsmap.xAxis
            	        }
            	    ],
            	    yAxis : [
            	        {
            	            type : 'value'
            	        }
            	    ],
            	    series : paramsmap.series
            	};
            	                    
            	myChart.setOption(option);
        		}else{
        			$("#"+id).text("系统暂无相关数据");
        		}
        		}
        },
        dataline:function (type, id, datas) {
            // 基于准备好的dom，初始化echarts图表
        	if(datas){
        		mydatas = datas;
        	}
        	 myChart = echarts.init(document.getElementById(id), macarons);
            var parammap = lineParamsGenerate(mydatas, type);

            //                    参数配置
            var option = {
            		title : parammap.title,
            	    tooltip : {
            	        trigger: 'axis',
            	        formatter: function (params) {
            	            return titleFormatter(params, parammap);
            	        }
            	    },
            	    noDataLoadingOption: {
                        text: '暂无数据',
                        effect: 'bubble',
                        effectOption: {
                            effect: {
                                n: 0
                            }
                        }
            	    },	
            	    legend: {
            	        x: 'center',	
            	        data: parammap.legend
            	    },
            	    calculable : false,
            	    /*dataZoom : {
            	        show : true,
            	        realtime : true,
            	        start : 20,
            	        end : 80
            	    },*/
            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            boundaryGap : false,
	            	            data : parammap.xAxis
	            	        }
	            	    ],
            	    yAxis : [
            	        {
            	            type : 'value'
            	        }
            	    ],
            	    series : parammap.series
            	};
            /*if(parammap.xAxis.length<10){
            	delete option.dataZoom;
            } else {
            	option.dataZoom = {
            	        show : true,
            	        realtime : true,
            	        start : 20,
            	        end : 80
            	    }
            }*/                   
            myChart.setOption(option);
            
        },
      //显示柱状图
        databar:function (type, id, datas) {
        	if(datas){
        		mydatas = datas;
        	}
        	 myChart = echarts.init(document.getElementById(id), macarons);
            var parammap = barParamsGenerate(mydatas, type);
            //                    参数配置
            var option = {
            	    title :parammap.title,
            	    tooltip : {
            	        trigger: 'axis',
            	        formatter: function (params) {
    	    	            return titleFormatter(params, parammap);
    	    	        }
            	    },
            	    legend: {
            	    	x : 'center',
            	    	y : 70,
            	        data:parammap.legend
            	    },
            	    calculable : false,
            	    grid:{
            	    	y : 150,
            	    
            	    },
            	    xAxis : [
            	        {
            	            type : 'category',
            	            data : parammap.xAxis
            	        }
            	    ],
            	    yAxis : [
            	        {
            	            type : 'value'
            	        }
            	    ],
            	    series : parammap.series
            	};
            	                    
            myChart.setOption(option);
        },
        loadindexdata:function (id,datetype,parammap) {
        	var city="";
        	if(parammap.citys.length==1 && parammap.citys[0]!=""){
        		city=parammap.citys[0]+"<br/>";
        	}
            // 基于准备好的dom，初始化echarts图表
        	if(null != document.getElementById(id) ){
        		 myChart = echarts.init(document.getElementById(id), macarons);
 	            myChart.clear();
        		if(parammap.data.length !=0){
	           
	            window.CollectGarbage && CollectGarbage();
	            /*macarons为可选主题*/
//	            myChart.showLoading({
//	                text: '正在努力的读取数据中...',    //loading
//	            });
	            // 过渡---------------------
	           /* myChart.showLoading({
	                text: '正在努力的读取数据中...',    //loading
	            });*/
	            //                    参数配置
	            if(datetype!='year'){
	            option = {
	            		tooltip : {
	    	    	        trigger: 'axis',
	    	    	        formatter: function (params) {
	    	    	            return city+params[0].name+"<br/>"+params[0].seriesName +":" +toThousands(params[0].data)+"("+parammap.unit+")<br/>"
	    	    	            					+ params[1].seriesName +":" +params[1].data+"%<br/>"
	    	    	            					+ params[2].seriesName +":" +params[2].data+"%<br/>";
	    	    	        }
	    	    	    },
	            	    calculable : false,
	            	    legend: {
	            	    	x: 'center',		
	            	        data:[parammap.title,'环比','同比']	
	            	    },
	            	    dataZoom : {
	            	        show : true,
	            	        realtime : true,
	            	        start : parammap.start,
	            	        end : 100,
//	            	        backgroundColor : '#d9e7f4',
//	            	        dataBackgroundColor : '#e4eff8',
//	            	        fillerColor : 'rgba(0,0,0,0)'
	            	    },
	            	    grid : {
	            	    	x :150,
	            	    	x2 :160
	            	    },
	            	    xAxis : [
	            	        {
	            	            type : 'category',
	            	            data : parammap.xAxis
	            	        }
	            	    ],
	            	    yAxis : [
	            	        {
	            	            type : 'value',
	            	            name : parammap.title+"("+parammap.unit+")",
	            	            axisLabel : {
	            	                formatter: '{value}'
	            	            }
	            	        },
	            	        {
	            	            type : 'value',
	            	            name : parammap.yAxisother,
	            	            axisLabel : {
	            	                formatter: '{value}% '
	            	            }
	            	        }
	            	    ],
	            	    series : parammap.series
	            	};
	            }else{
	            	 option = {
	 	            	    tooltip : {
	 	            	        trigger: 'axis',
		    	    	        formatter: function (params) {
		    	    	            return city+params[0].name+"<br/>"+params[0].seriesName +":" +toThousands(params[0].data)+"("+parammap.unit+")<br/>"
		    	    	            					+ params[1].seriesName +":" +params[1].data+"%<br/>"
		    	    	            					+ params[2].seriesName +":" +params[2].data+"%<br/>";
		    	    	        }
	 	            	    },
	 	            	   grid : {
		            	    	x :150,
		            	    	x2 :160
		            	    },
	 	            	    calculable : false,
	 	            	    legend: {
	 	            	    	x: 'center',	
	 	            	        data:[parammap.title,'环比','同比']
	 	            	    },
	 	            	    
	 	            	   
	 	            	    xAxis : [
	 	            	        {
	 	            	            type : 'category',
	 	            	            data : parammap.xAxis
	 	            	        }
	 	            	    ],
	 	            	    yAxis : [
	 	            	        {
	 	            	            type : 'value',
	 	            	            name : parammap.title+"("+parammap.unit+")",
	 	            	            axisLabel : {
	 	            	                formatter: '{value}'
	 	            	            }
	 	            	        },
	 	            	        {
	 	            	            type : 'value',
	 	            	            name : parammap.yAxisother,
	 	            	            axisLabel : {
	 	            	                formatter: '{value}% '
	 	            	            }
	 	            	        }
	 	            	    ],
	 	            	    series : parammap.series
	 	            	};
	            	}
	            myChart.setOption(option);
        	}
	        }
        },
        
        loadindexLinedata:function (id,datetype,parammap) {
            // 基于准备好的dom，初始化echarts图表
        	if(null != document.getElementById(id) ){
        		myChart = echarts.init(document.getElementById(id), macarons);
        		myChart.clear();
        		if(parammap.data.length !=0){
	            
	            
	            window.CollectGarbage && CollectGarbage();
	            /*macarons为可选主题*/
//	            myChart.showLoading({
//	                text: '正在努力的读取数据中...',    //loading
//	            });
	            // 过渡---------------------
	           /* myChart.showLoading({
	                text: '正在努力的读取数据中...',    //loading
	            });*/
	            
	            //                    参数配置
	            if(datetype!='year'){
	            	var option = {
	            		title : parammap.title,
//	                                   鼠标悬浮交互时的信息提示
	                   tooltip: {
	                       trigger: 'axis',
	            	        formatter: function (params) {
	            	            return titleFormatter(params, parammap);
	            	        }
	                       
	                   },
//	                                   图例,最多一个
	                   legend: {
	                	   x: 'center',	
	                       data: parammap.legend
	                   },
//	                                   工具箱,最多一个
	                 
	                   calculable: true,
	                   dataZoom: {
	                       show: true,
	                       realtime: true,
	                       start: parammap.start,
	                       end: 100,
//	                       backgroundColor: 'rgba(144,197,237,0.7)',
//	                       dataBackgroundColor: '#eee',
//	                       fillerColor: 'rgba(0,0,0,0)'
	                       
	                   },
	                   grid: {
	                	   x : 150,
	                	   x2 : 160
	                   },
//	                                   x轴区间
	                   xAxis: [
	                       {
	                           type: 'category',
	                           boundaryGap: false,
	                           data: parammap.xAxis
	                       }
	                   ],
//	                                   y轴
	                   yAxis: [
	                       {
	                           type: 'value'
	                       }
	                   ],
//	                                   y轴随机数模拟
	                   series: parammap.series
	               };
	            }else{
	            	var option = {
	               		 title :parammap.title,
//	                                   鼠标悬浮交互时的信息提示
	                   tooltip: {
	                       trigger: 'axis',
	            	        formatter: function (params) {
	            	            return titleFormatter(params, parammap);
	            	        }
	                   },
	                   legend: {
	                	   x: 'center',	
	                       data: parammap.legend
	                   },
	                   grid : {
	            	    	x :150,
	            	    	x2 :160
	            	    },
	                   calculable: true,
	                 
	                   xAxis: [
	                       {
	                           type: 'category',
	                           boundaryGap: false,
	                           data: parammap.xAxis
	                       }
	                   ],
//	                                   y轴
	                   yAxis: [
	                       {
	                           type: 'value'
	                       }
	                   ],
//	                                   y轴随机数模拟
	                   series: parammap.series
	               };
	            	}
	            myChart.setOption(option);
        	}
	        }
        },
        
        loadmutilLinedata:function (id,parammap) {
            // 基于准备好的dom，初始化echarts图表
        	if(null != document.getElementById(id) ){
        		myChart = echarts.init(document.getElementById(id), macarons);
        		if(parammap.data.length >1){
	            
	            myChart.clear();
	            window.CollectGarbage && CollectGarbage();
	            /*macarons为可选主题*/
//	            myChart.showLoading({
//	                text: '正在努力的读取数据中...',    //loading
//	            });
	            // 过渡---------------------
	           /* myChart.showLoading({
	                text: '正在努力的读取数据中...',    //loading
	            });*/
	            
	            //                    参数配置
	            
	            	var option = {
	               		 title :parammap.title,
//	                                   鼠标悬浮交互时的信息提示
	                   tooltip: {
	                       trigger: 'axis'
	                   },
	                   legend: {
	                	   x: 'center',	
	                       data: parammap.legend
	                   },
	                   
	                   calculable: true,
	                 
	                   xAxis: [
	                       {
	                           type: 'category',
	                           boundaryGap: false,
	                           data: parammap.xAxis
	                       }
	                   ],
//	                                   y轴
	                   yAxis: [
	                       {
	                           type: 'value'
	                       }
	                   ],
//	                                   y轴随机数模拟
	                   series: parammap.series
	               };
	            	
	            myChart.setOption(option);
        	}else{
        		myChart.clear();
//        		$("#"+id).parent().hide();
        	}
	        }
        },
        
        loadMap:function(datas, type, id){
        	mydatas = datas;
        	var _parent = $("#"+id).parent();
        	_parent.show();
        	if(datas && datas.timeAxis){
        		if(datas.timeAxis.length==1){
        			if(datas.type == 'loan' && (!datas.xAxis || datas.xAxis.length ==1) ||
        					datas.type == 'analysis' && datas.services.length == 1 && datas.companys.length == 1){
        				_parent.hide();
        			}else {
        				obj.d(type, id);
        			}
        		} else {
        			if(datas.type !='loan' && datas.services.length >1 && datas.companys.length > 1){
        				_parent.hide();
        			}else {
        				obj.b(type, id);
        			}
        		}
        		
        	}
        	
        },
        loadLoanMap:function(datas, type, id){
        	mydatas = datas;
        	
        	$("#"+id).parent().show();
        	if(datas && datas.timeAxis){
        		if(datas.timeAxis.length==1){
        			if(datas.companys.length == 1 ){
        				$("#"+id).parent().hide();
        			}else {
        				obj.databar(type, id);
        			}
        		} else {
        			if(datas.companys.length > 1 && datas.services.length >1){
        				$("#"+id).parent().hide();
        			}else {
        				obj.b(type, id);
        			}
        		}
        		
        	}
        	
        },
        loadRevenueMap:function(datas, type, id){
        	mydatas = datas;
        	$("#"+id).parent().show();
        	
        	if(datas && datas.timeAxis){
        		if(datas.timeAxis.length==1){
        			if(datas.companys.length == 1 && datas.services.length == 1){
        				$("#"+id).parent().hide();
        			}else if((datas.companys.length == 1 && datas.services.length > 1) ||(datas.companys.length > 1 && datas.services.length == 1)){
        				obj.c(type, id);
        			}else {
        				obj.databar(type, id);
        			}
        		} else {
        			if(datas.companys.length > 1 && datas.services.length >1){
        				$("#"+id).parent().hide();
        			}else {
        				obj.dataline(type, id);
        			}
        		}
        		
        	}
        	
        },
        loadApartMap:function(datas, type, id){
        	mydatas = datas;
        	$("#"+id).parent().show();
        	if(datas && datas.timeAxis){
        		if(datas.timeAxis.length==1){
        			if(datas.citys.length == 1 && datas.companys.length == 1){
        				$("#"+id).parent().hide();
        			}else {
        				obj.d(type, id);
        			}
        		} else {
        			if(datas.citys.length > 1 && datas.services.length >1){
        				$("#"+id).parent().hide();
        			}else {
        				obj.b(type, id);
        			}
        		}
        		
        	}
        	
        },
        /**
         * datas	数据
         * type		图表切换
         * id		图表ID
         * prop1	显示柱状图的数据id
         * prop2	显示折线图的数据1id
         * prop3	显示折线图的数据2id
         */
        loadMultiMap:function(datas, type, id, prop1, prop2, prop3){
        	mydatas = datas;
        	$("#"+id).parent().parent().parent().show();
        	if(datas && datas.timeAxis){
        		if(datas.timeAxis.length==1){
        			if(datas.citys.length == 1 && datas.services.length == 1){
        				$("#"+id).parent().parent().parent().hide();
        			}else {
        				obj.d(type, id);
        			}
        		} else {
        			if(datas.citys.length > 1 && datas.services.length >1){
        				$("#"+id).parent().parent().parent().hide();
        			}else {
        				obj.e(type, id, prop1, prop2, prop3, datas);
        			}
        		}
        		
        	}
        	
        }
    }
    
    $("#optionsss").on('change',function(event){
    	/*var e = window.event || event;
    	if ( e.stopPropagation ){ //如果提供了事件对象，则这是一个非IE浏览器
    	e.stopPropagation();
    	}else{
    	//兼容IE的方式来取消事件冒泡
    	window.event.cancelBubble = true;
    	}*/
    	if(document.title == "金融销售排名分析"){
    		return ;
    	}
    	if(this.id =='optionsss'){
	    	var type = $(this).selectpicker('val');
	    	var mapType = $("#optionsss").data("type");
	    	var param;
	    	if(mapType == "line"){
	    		param = lineParamsGenerate(mydatas, type);
	    	} else if(mapType == "bar"){
	    		param = barParamsGenerate(mydatas, type);
	    	} else if(mapType == "pie"){
	    		param = pieParamsGenerate(mydatas, type);
	    	}
	    	myChart.setOption({
	    		title: param.title, 
	    		series : param.series, 
	    		tooltip : {
	    	        trigger: 'axis',
	    	        formatter: function (params) {
	    	            return titleFormatter(params, param);
	    	        }
	    	    }});
    	} else {
    		return;
    	}
    	
    })
    
    function initEcharts(id){
		myChart = echarts.init(document.getElementById(id), macarons);
		myChart.clear();
    }
    function titleFormatter(param1, param2){
    	var res = param1[0].name;
        for (var i = 0, l = param1.length; i < l; i++) {
        	var name = param1[i].seriesName? param1[i].seriesName+":":"";
            res += '<br/>' + name + toThousands(param1[i].value);
        }
        if(param2.title && param2.title.subtext){
        	res += '<br/>' +param2.title.subtext;
        }
        return res;
    }
    
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
    
    
    function showLoading(msg, id){
    	if(!myChart){
    		initEcharts(id);
    	}
		myChart.clear();
    	myChart.showLoading({
            text: msg    //loading
        });
    }
    function hideLoading(){
    	if(myChart){
    		myChart.hideLoading();
    	}
    }
    //------------------------------------------------------------------------------------------------------
    function lineParamsGenerate(datas, type){
    	$("#optionsss").data("type","line");
    	var params = paramsGenerate(datas, type);
		var housesobj = datas.datas;
		for(attribute in housesobj){ 
			var itemseries={};
			itemseries.data = [];
			$.each(housesobj[attribute], function(j,memb){
				var val = memb[type]?memb[type]:"0";
				itemseries.data.push(val);
			})
			itemseries.name = attribute;
			itemseries.type = "line";
			itemseries.smooth = true,
			params.series.push(itemseries);
		}
		return params;
    }
    
    function barParamsGenerate(datas, type){
    	$("#optionsss").data("type","bar");
    	var params = paramsGenerate(datas, type);
    	params.legend =[];
		var housesobj = datas.datas;
		var index=0;
		for(attribute in housesobj){ 
			index++;
			var itemseries={};
			itemseries.data = [];
			$.each(housesobj[attribute], function(j,memb){
				var val = memb[type]?memb[type]:"0";
				itemseries.data.push(val);
			})
			params.legend.push(attribute);
			itemseries.name = attribute;
			itemseries.type = "bar";
			if(housesobj[attribute].length<=10){
			itemseries.barWidth = 60;
			}
			params.series.push(itemseries);
			
		} 
		return params;
    }
    function pieParamsGenerate(datas, type){
    	$("#optionsss").data("type","pie");
    	var params = paramsGenerate(datas, type);
    	var itemseries={};
		itemseries.name = datas.subtitle;
		itemseries.type = 'pie';
		itemseries.radius = '50%';
		itemseries.selectedMode= 'single';
		itemseries.itemStyle = {
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
        };
		itemseries.data = [];
		$.each(datas.datas, function(i,item){
			itemseries.data.push({value:item[0][type], name:i})
		})
		params.series.push(itemseries);
		return params;
    }
    function multiParamsGenerate(datas, type, prop1, prop2, prop3){
    	$("#optionsss").data("type","bar");
    	var params = paramsGenerate(datas, type);
    	params.legend = [];
		var housesobj = datas.datas;
		for(attribute in housesobj){ 
			var itemseries1={};
			var itemseries2={};
			var itemseries3={};
			itemseries1.data = [];
			itemseries2.data = [];
			itemseries3.data = [];
			$.each(housesobj[attribute], function(j,memb){
				var val = memb[prop1]?memb[prop1]:"0";
				var samerate = memb[prop2]?memb[prop2]:"0";
				var looprate = memb[prop3]?memb[prop3]:"0";
				itemseries1.data.push(val);
				itemseries2.data.push(samerate);
				itemseries3.data.push(looprate);
			})
			itemseries1.name = attribute ;
			itemseries2.name = attribute + "同比";
			itemseries3.name = attribute + "环比";
			itemseries1.type = "bar";
			itemseries2.type = "line";
			itemseries3.type = "line";
			itemseries2.yAxisIndex= 1,
			itemseries3.yAxisIndex= 1,
			params.series.push(itemseries1);
			params.series.push(itemseries2);
			params.series.push(itemseries3);
			params.legend.push(itemseries1.name);
			params.legend.push(itemseries2.name);
			params.legend.push(itemseries3.name);
		} 
		return params;
    }
    function paramsGenerate(datas, type){
    	var params={};
    	if(datas && type){
    		params.xAxis = datas.xAxis;
    		params.legend = datas.legends;
    		params.series = [];
    		params.title = {};
    		params.title.x = 'left';
    		params.title.subtext =datas.subtitle? datas.subtitle +"  ":"";
    		switch(type)
    		{
    		case "avgprice":
    			params.title.text="平均单价";
    			params.title.subtext+="单位：元";
    			break;
    		case "saleamount":
    			params.title.text="销售额";
      		  	params.title.subtext+="单位：万";
      		  	break;
    		case "totsalearea":
    			params.title.text="销售面积";
      		  	params.title.subtext+="单位：平米";
      		  	break;
    		case "totsalenum":
    			params.title.text="销售套数";
    			params.title.subtext+="单位：套";
    			break;
    		case "newloanamount":
    			params.title.text="放款额";
    			params.title.subtext+="单位：万";
    			break;
    		case "newloannum":
    			params.title.text="放款笔数";
    			params.title.subtext+="单位：笔";
    			break;
    		case "singleloanamount":
    			params.title.text="单笔放款额";
    			params.title.subtext+="单位：万";
    			break;
    		case "realreveamount":
    			params.title.text="创收";
    			params.title.subtext+="单位：万";
    			break;
    		case "agentsalenum":
    			params.title.text="代理销售套数";
    			params.title.subtext+="单位：套";
    			break;
    		default:
    		case "agentsaleamount":
    			params.title.text="代理销售金额";
    			params.title.subtext+="单位：万";
    			break;
    		case "loanhousenum":
    			params.title.text="金融放款套数";
    			params.title.subtext+="单位：套";
    			break;
    		case "loanhouseamount":
    			params.title.text="金融放款金额";
    			params.title.subtext+="单位：万";
    			break;
    		}
    		
    			//环形图参数配置
    			/*
    			 * var itemseries={};
    			itemseries.name = datas.subtitle;
    			itemseries.type = 'pie';
    			itemseries.radius = ['50%', '60%'];
    			itemseries.itemStyle = {
	                normal : {
	                    label : {
	                        show : false
	                    },
	                    labelLine : {
	                        show : false
	                    }
	                },
	                emphasis : {
	                    label : {
	                        show : true,
	                        position : 'center',
	                        textStyle : {
	                            fontSize : '30',
	                            fontWeight : 'bold'
	                        }
	                    }
	                }
	            };
    			itemseries.data = [];
    			$.each(datas.datas, function(i,item){
    				params.legend.push(i);
    				itemseries.data.push({value:item[0][type], name:i})
    			})
    			params.series.push(itemseries);*/
    			
    	}
    	return params;
    }
    
    
    //接口暴露
    module.exports = {
        a:obj.a,
        loadindexdata:obj.loadindexdata,
        loadindexLinedata:obj.loadindexLinedata,
        lineMap:obj.b,
        pieMap:obj.c,
        barMap:obj.d,
        loadRevenueMap:obj.loadRevenueMap,
        loadMap:obj.loadMap,
        loadLoanMap:obj.loadLoanMap,
        loadMultiMap:obj.loadMultiMap,
        showLoading:showLoading,
        hideLoading: hideLoading,
        bardemo:obj.bardemo,
        databar:obj.databar,
        dataline:obj.dataline,
        loadmutilLinedata:obj.loadmutilLinedata
    }
});