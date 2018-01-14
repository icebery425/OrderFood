
/**
 * echarts js 封装
 */
var CommonEcharts = function(){


    var getOption = function(echartsType){

        var echartsOption = {
            title: {
                text: ''
            },
            toolbox: {},
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                },
                textStyle:{
                    align:'left'
                }
            },
            legend: {
                /*data:['底租','租金','运营费用']*/
                data:[]
            },
            xAxis: {
                /*data: ["201701","201702","201703","201704","201705","201706"]*/
                type:'',
                data:[],
                axisLabel: {}
            },
            yAxis: {
                type:'',
                data:[],
                axisLabel: {}
            },
            series: []
        };

        if(echartsType){

            if(echartsType =='funnel' || echartsType =='gauge'){
                delete echartsOption.xAxis;
                delete echartsOption.yAxis;
                delete echartsOption.tooltip.axisPointer;
                delete echartsOption.tooltip.trigger;

                //echartsOption.tooltip.formatter = "{a} <br/>{b} : {c}%";
            }

        }


        return echartsOption;
    }




    /**
     *
     * 初始化option
     * <br>
     *     参数类型01： 没有入参，初始化一个空的option
     * <br>
     *     参数类型02：titleText,legendData,xAxis,yAxis,series
     * <br>
     *     参数类型03：titleText,legendData,xAxisType,xAxisData,yAxis,series
     * <br>
     *     参数类型04：titleText,legendData,xAxisType,xAxisData,yAxisType,yAxisData,series
     * <br>
     *     参数类型05：titleText,toolbox,tooltip,legendData,xAxisType,xAxisData,yAxisType,yAxisData,series
     * <br>
     *
     *
     * @returns {*} option
     */
    var initOption = function () {
        var option = null;
        var len  = arguments.length;
        if(len == 0){
            option = getOption();
        }else if(len == 1){
            option = getOption(arguments[0]);
        }else if(len ==5){
            option = initOption_01(arguments[0],arguments[1],arguments[2],arguments[3],arguments[4]);
        }else if(len == 6){
            option = initOption_02(arguments[0],arguments[1],arguments[2],arguments[3],arguments[4],arguments[5]);
        }else if(len == 7){
            option = initOption_03(arguments[0],arguments[1],arguments[2],arguments[3],arguments[4],arguments[5],arguments[6]);
        }else if(len == 9){
            option = initOption_04(arguments[0],arguments[1],arguments[2],arguments[3],arguments[4],arguments[5],arguments[6],arguments[7],arguments[8]);
        }
        initBarStyle(option);
        return option;
    }


    var initOption_01 = function(titleText,legendData,xAxis,yAxis,series){

        var option  = getOption();

        if(titleText) option.title.text = titleText;
        if(legendData) option.legend.data = legendData;
        if(xAxis) option.xAxis = xAxis;
        if(yAxis) option.yAxis = yAxis;
        if(series) option.series = series;

        return option;

    }

    var initOption_02 = function(titleText,legendData,xAxisType,xAxisData,yAxis,series){

        var option  = getOption();

        if(titleText) option.title.text = titleText;
        if(legendData) option.legend.data = legendData;
        if(xAxisType) option.xAxis.type = xAxisType;
        if(xAxisData) option.xAxis.data = xAxisData;
        if(yAxis) option.yAxis = yAxis;
        if(series) option.series = series;

        return option;

    }

    var initOption_03 = function(titleText,legendData,xAxisType,xAxisData,yAxisType,yAxisData,series){

        var option  = getOption();

        if(titleText) option.title.text = titleText;
        if(legendData) option.legend.data = legendData;
        if(xAxisType) option.xAxis.type = xAxisType;
        if(xAxisData) option.xAxis.data = xAxisData;
        if(yAxisType) option.yAxis.type = yAxisType;
        if(yAxisData) option.yAxis.data = yAxisData;
        if(series) option.series = series;

        return option;

    }


    var initOption_04 = function (titleText,toolbox,tooltip,legendData,xAxisType,xAxisData,yAxisType,yAxisData,series) {

        var option  = getOption();

        if(titleText) option.title.text = titleText;
        if(toolbox) option.toolbox = toolbox;
        if(tooltip) option.tooltip = tooltip;
        if(legendData) option.legend.data = legendData;
        if(xAxisType) option.xAxis.type = xAxisType;
        if(xAxisData) option.xAxis.data = xAxisData;
        if(yAxisType) option.yAxis.type = yAxisType;
        if(yAxisData) option.yAxis.data = yAxisData;
        if(series) option.series = series;

        return option;
    }



    var setOptionTitleText = function (titleText,option) {
        option.title.text = titleText;
    }

    var setOptionToolbox = function(toolbox,option){
        option.toolbox = toolbox;
    }

    var setOptionTooltip = function(tooltip,option){
        option.tooltip = tooltip;
    }

    var setOptionLegendData = function(legendData,option){
        option.legend.data = legendData;
    }

    var setOptionXAxisType = function(xAxisType,option){
        option.xAxis.type = xAxisType;
    }

    var setOptionXAxisData = function(xAxisData,option){
        option.xAxis.data = xAxisData;
    }

    var setOptionYAxisType = function(yAxisType,option){
        option.yAxis.type = yAxisType;
    }

    var setOptionYAxisData = function(yAxisData,option){
        option.yAxis.data = yAxisData;
    }

    var setOptionSeries = function(series,option){
        option.series = series;
    }

    var setOptionTooltipFormatter = function (formatter,option) {
        option.tooltip.formatter = formatter;
    }

    var setOptionXAxis = function(xAxis,option){
        option.xAxis = xAxis;
    }

    var setOptionYAxis = function (yAxis, option) {
        option.yAxis = yAxis;
    }

    var setOptionXAxisName = function (xAxisName, option) {
        option.xAxis.name = xAxisName;
    }

    var setOptionXAxisAxisLabelFormatter = function (formatter, option) {
        option.xAxis.axisLabel.formatter = formatter;
    }

    var setOptionYAxisName = function (yAxisName, option) {
        option.yAxis.name = yAxisName;
    }

    var setOptionYAxisAxisLabelFormatter = function (formatter, option) {
        option.yAxis.axisLabel.formatter = formatter;
    }

    var setOptionSeriesItemStyle_bar = function(itemStyle,option){

        $.each( option.series, function( index, val ) {
           if(this.type=="bar"){
                option.series[index].itemStyle = itemStyle;
           }
        } );
    }

    var setOptionDataZoom = function (option,start,dataZoom) {
        if(dataZoom){
            option.dataZoom = dataZoom;
        }else{
            option.dataZoom =  [{
                                    type: 'slider',
                                    start: start,
                                    end: 100
                                }];
        }

    }


    var initBarStyle = function(option){
    	var itemStyle = { normal:{barBorderRadius:[10, 10, 10, 10]} };
    	setOptionSeriesItemStyle_bar(itemStyle, option);
    }

    return {
        initOption : initOption,
        setOptionTitleText :setOptionTitleText,
        setOptionToolbox : setOptionToolbox,
        setOptionTooltip : setOptionTooltip,
        setOptionLegendData : setOptionLegendData,
        setOptionXAxisType : setOptionXAxisType,
        setOptionXAxisData : setOptionXAxisData,
        setOptionYAxisType : setOptionYAxisType,
        setOptionYAxisData : setOptionYAxisData,
        setOptionSeries : setOptionSeries,
        setOptionTooltipFormatter : setOptionTooltipFormatter,
        setOptionXAxis : setOptionXAxis,
        setOptionYAxis : setOptionYAxis,
        setOptionXAxisName : setOptionXAxisName,
        setOptionXAxisAxisLabelFormatter : setOptionXAxisAxisLabelFormatter,
        setOptionYAxisName : setOptionYAxisName,
        setOptionYAxisAxisLabelFormatter : setOptionYAxisAxisLabelFormatter,
        setOptionSeriesItemStyle_bar:setOptionSeriesItemStyle_bar,
        setOptionDataZoom:setOptionDataZoom
    }
}();