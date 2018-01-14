var Index = function () {

	var echartsObj;
	var _city ;
	seajs.config({
		base: "../../static/js/module/",
		alias: {
			'echarts': 'plugins/echarts-all.js',
		}
	})
	
	var initevent=function(){
		var num=0;
	    var num1=0;
	    var dtdis2=$("#div2").offsetTop;
		var dtdis3=$("#div3").offsetTop;
		seajs.use('customers/echarts-util-1.1', function (obj) {
			echartsObj = obj;

			$(window).bind("scroll", function (event){	
				//滚动条到网页头部的 高度，兼容ie,ff,chrome
				var top = document.documentElement.scrollTop + document.body.scrollTop;
				if((top>=num && top<2500) || dtdis2<1500){
					Index.loadDiv(2,'*');
				}
				if(top>=num1 || dtdis3<1500){
//					Index.loadDiv(3,'*');
				}
			});
		})

	}
	var loadDiv = function (i,cityid) {

		
	}
	


	var  getcitydata=function(id){
		var _city = $("#"+id+" .chartCity").find("input:checked");
		var cityid = "";
		if(_city.length>0){
			if(_city.length ==1 && _city[0].value=="**"){
				_city = $("#"+id+" .chartCity").find("input").not(":checked");
			}
			
			$(_city).each(function(){
				cityid += this.value+",";
			})
			cityid = cityid.substr(0, cityid.length-1);
		}else {
			cityid= "*";
		}
		return cityid;
	}

	$("#close").click(function(){
		$("#moreDiv").hide();
	});
	return {
		getcitydata:getcitydata,
		loadDiv:loadDiv,
//		loadApartDiv:loadApartDiv,
        init: function () {
        	initevent();
        }

    };
}();