package com.worldunion.prophesy.utils.echarts;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 柱状折线混合统计图
 * Created by liuruiyan on 2017/8/8.
 */
@Component
public class LineBarEcharts extends DefaultEcharts{


    /**
     *  柱状图加折线图混合数据封装
     * @param dataList      数据集合
     * @param columnConvertRowNameMap   列转行字段map
     * @param barLegendDataNameList     bar:柱状图legendData名list
     * @param lineLegendDataNameList    line:折线图legendData名list
     * @param xAxisColumnName           x轴字段名
     * @return
     * @throws Exception
     */
    public Map<String, Object> getEchartsOptions(List<?> dataList,Map<String,String> columnConvertRowNameMap,List<String> barLegendDataNameList,List<String> lineLegendDataNameList,String xAxisColumnName,String barStack) throws Exception {


        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<String> legendData = null;
        List<String> xAxisData = null;
        JSONArray series = null;
        EchartsDto echartsDto = new EchartsDto();

        //数据转换
        List<Map<String,Object>>  list =  DefaultEcharts.rowsConvertColumn(dataList,columnConvertRowNameMap,STRING_LEGEND_NAME,STRING_LEGEND_VALUE);

        try {
            echartsDto.setLegendColumnName(STRING_LEGEND_NAME);
            echartsDto.setxAxisColumnName(xAxisColumnName);
            echartsDto.setSeriesColumnName(STRING_LEGEND_VALUE);


            legendData = getLegend(echartsDto.getLegendColumnName(),list);
            xAxisData = getXAxis(echartsDto.getxAxisColumnName(),echartsDto.getIsSort(),echartsDto.getSort(), list);


            //封装seriesType为bar的series
            List<String> barList = new ArrayList<String>();
            barList.addAll(legendData);
            barList.removeAll(lineLegendDataNameList);

            echartsDto.setLegendData(barList);
            echartsDto.setxAxisData(xAxisData);
            echartsDto.setSeriesType(DefaultEcharts.OPTION_SERIES_TYPE_BAR);
            echartsDto.setyAxisIndex(0);
            if(StringUtils.isNotBlank(barStack)){echartsDto.setStack(barStack);} //多条柱状合成一条柱状

            Map<String,Object> seriesMap = getSeries(echartsDto,list);
            series = (JSONArray) seriesMap.get(DefaultEcharts.OPTION_SERIES_DATA);


            //封装seriesType为line的series
            List<String> lineList = new ArrayList<String>();
            lineList.addAll(legendData);
            lineList.removeAll(barLegendDataNameList);

            echartsDto.setLegendData(lineList);
            echartsDto.setSeriesType(DefaultEcharts.OPTION_SERIES_TYPE_LINE);
            echartsDto.setyAxisIndex(1);
            echartsDto.setStack(null);

            seriesMap = getSeries(echartsDto,list);


            series.addAll((JSONArray)seriesMap.get(DefaultEcharts.OPTION_SERIES_DATA));

        } catch (Exception e) {
            e.printStackTrace();
        }


        resultMap.put(OPTION_LEGEND_DATA,legendData);
        resultMap.put(OPTION_XAXIS_DATA,xAxisData);
        resultMap.put(OPTION_SERIES_DATA,series);

        return resultMap;

    }



    /**
     *  根据Echarts类型封装数据 类型：折线图，柱状图，折线+柱状图
     * @param echartsDto    xAxisColumnName，SeriesType不能为空   echart类型：   line：折线图, bar:柱状图，  line_bar：柱状图+折线图
     * @param dataList      数据集合
     * @param columnConvertRowNameMap   列转行字段map    如果不需要列转行则传null
     * @param barLegendDataNameList     bar:柱状图legendData名list  bar+line不能为空
     * @param lineLegendDataNameList    line:折线图legendData名list bar+line不能为空
     * @return
     * @throws Exception
     */
    public Map<String, Object> getEchartsOptionsByEchartsType(EchartsDto echartsDto,List<Map<String,Object>> dataList,Map<String,String> columnConvertRowNameMap,List<String> barLegendDataNameList,List<String> lineLegendDataNameList) throws Exception {


        Map<String,Object> resultMap = new HashMap<String, Object>();

        if(OPTION_SERIES_TYPE_LINE_BAR.equals(echartsDto.getSeriesType())){

            resultMap = getEchartsOptions(dataList,columnConvertRowNameMap,barLegendDataNameList,lineLegendDataNameList,echartsDto.getxAxisColumnName(),echartsDto.getStack());

        }else if(OPTION_SERIES_TYPE_BAR.equals(echartsDto.getSeriesType()) || OPTION_SERIES_TYPE_LINE.equals(echartsDto.getSeriesType())){

            //数据转换
            List<Map<String,Object>>  list =  dataList;

            if(columnConvertRowNameMap!=null){
                list =  rowsConvertColumn(dataList,columnConvertRowNameMap,STRING_LEGEND_NAME,STRING_LEGEND_VALUE);
            }

            Map<String,Object> echartsOptionsMap = getEchartsOptions(echartsDto,list);

            resultMap.put("legendData",echartsOptionsMap.get(DefaultEcharts.OPTION_LEGEND_DATA));
            resultMap.put("xAxisData",echartsOptionsMap.get(DefaultEcharts.OPTION_XAXIS_DATA));
            resultMap.put("seriesData",echartsOptionsMap.get(DefaultEcharts.OPTION_SERIES_DATA));

        }else{
            logger.error("根据Echarts类型封装数据，异常，EchartsType="+echartsDto.getSeriesType());


        }

        return resultMap;

    }
}
