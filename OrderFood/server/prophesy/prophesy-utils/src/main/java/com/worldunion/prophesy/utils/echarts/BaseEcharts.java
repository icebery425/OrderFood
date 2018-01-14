package com.worldunion.prophesy.utils.echarts;


import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 *  统计图接口类
 *
 * Created by liuruiyan on 2017/6/15.
 */
public interface BaseEcharts {


    public Map<String,Object> getLegend(EchartsDto echartsDto, List<?> dataList) throws Exception;


    public List<String> getLegend(String legendColumnName, List<?> dataList) throws Exception;


    public Map<String,Object> getXAxis(EchartsDto echartsDto,List<?> dataList) throws Exception;


    public List<String> getXAxis(String xAxisColumnName,String isSort, final String sort,List<?> dataList) throws Exception;



    public Map<String,Object> getYAxis(EchartsDto echartsDto, List<?> dataList) throws Exception;


    public List<String> getYAxis(String yAxisColumnName,String isSort, final String sort,List<?> dataList) throws Exception;


    public Map<String,Object>  getSeries(EchartsDto echartsDto, List<?> dataList) throws Exception;



    public JSONArray getSeries(String legendColumnName,String xAxisColumnName,String seriesColumnName,List<String> legendData,List<String> xAxisData,
                               String seriesType,String stack,Integer yAxisIndex,List<?> dataList) throws Exception;



    public Map<String,Object>  getEchartsOptions(EchartsDto echartsDto, List<?> dataList) throws Exception;

}
