package com.worldunion.prophesy.model.echarts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

public class EchartsMuti {
	private	String[] legend;
	private String[] xAxis;
	private String[] yAxis;
	private List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
	public String[] getLegend() {
		return legend;
	}
	public void setLegend(String[] legend) {
		this.legend = legend;
	}
	public String[] getxAxis() {
		return xAxis;
	}
	public void setxAxis(String[] xAxis) {
		this.xAxis = xAxis;
	}
	public String[] getyAxis() {
		return yAxis;
	}
	public void setyAxis(String[] yAxis) {
		this.yAxis = yAxis;
	}
	public List<Map<String, Object>> getDataList() {
		return dataList;
	}
	public void setDataList(List<Map<String, Object>> dataList) {
		this.dataList = dataList;
	}
	public JSONArray getJsonData() {
		
		return null;
		
//		tooltip : {
//        trigger: 'axis'
//    },
//    toolbox: {
//        show : true,
//        feature : {
//            mark : {show: true},
//            dataView : {show: true, readOnly: false},
//            magicType: {show: true, type: ['line', 'bar']},
//            restore : {show: true},
//            saveAsImage : {show: true}
//        }
//    },
//    calculable : true,
//    legend: {
//        data:['蒸发量','降水量','平均温度']
//    },
//    dataZoom : {
//        show : true,
//        realtime : true,
//        start : 20,
//        end : 80
//    },
//   
//    xAxis : [
//        {
//            type : 'category',
//            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
//        }
//    ],
//    yAxis : [
//        {
//            type : 'value',
//            name : '水量',
//            axisLabel : {
//                formatter: '{value} ml'
//            }
//        },
//        {
//            type : 'value',
//            name : '温度',
//            axisLabel : {
//                formatter: '{value} °C'
//            }
//        }
//    ],
//    series : [
//
//        {
//            name:'蒸发量',
//            type:'bar',
//            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
//        },
//        {
//            name:'降水量',
//            type:'bar',
//            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
//        },
//        {
//            name:'平均温度',
//            type:'line',
//            yAxisIndex: 1,
//            data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
//        }
//    ]
//		StringBuffer sb = new StringBuffer();
//		sb.append("title : {text: '").append("").append("'},tooltip : {trigger: 'axis'},calculable : true,");
//		sb.append(" formatNumberScale='0'");
//		sb.append(" toolTipBgColor='#eaf3f6'");
//		sb.append(" toolTipSepChar='：'");
//		sb.append(" palette='4'");
//		sb.append(" decimals='2'");
//		sb.append(" baseFontSize='12'");
//		sb.append(" enableSmartLabels='1'");
//		sb.append(" >");
//		for (DataSetPie d : this.dataList) {
//			sb.append("<set");
//			sb.append(d.getXmlStrfromLabel());
//			sb.append(d.getXmlStrfromValue());
//			sb.append(d.getXmlStrfromSliced());
//			sb.append(" />");
//		}
//		sb.append("</chart>");
//		return sb.toString();
	}
	
}
