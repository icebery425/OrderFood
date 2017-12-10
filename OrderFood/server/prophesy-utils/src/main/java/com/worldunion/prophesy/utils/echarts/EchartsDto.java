package com.worldunion.prophesy.utils.echarts;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * Echarts基础bean
 *
 * Created by liuruiyan on 2017/6/22.
 */
public class EchartsDto {

    /**
     *  取legend数据的列名
     */
    private String legendColumnName;

    /**
     * 取xAxis数据的列名
     */
    private String xAxisColumnName;

    /**
     * 取series数据的列名
     */
    private String seriesColumnName;

    /**
     *  xAxis，即x轴是否需要排序， N:不排序    Y_：排序
     */
    private String isSort;

    /**
     * desc: 降序  asc:升序  默认为升序
     */
    private String sort = "asc";

    /**
     *  图标类型 如：bar ，line
     */
    private String seriesType;

    /**
     *  x轴数据是否堆叠
     */
    private String stack;

    /**
     *  多个Y轴的情况，yAxisIndex对应yAxis配置的下标  如果有多个y轴，series列表中每个series都要设置yAxisIndex
     */
    private Integer yAxisIndex;

    /**
     * 封装好的legend的数据
     */
    private List<String> legendData;

    /**
     * 封装好的xAxis的数据
     */
    private List<String> xAxisData;

    /**
     * 封装好的yAxis的数据 ，因不涉及数据转换，格式比较简单，一般在页面用js封装
     */
    private List<String> yAxisData;

    /**
     *  封装好的series数据
     */
    private JSONArray seriesData;


    public String getLegendColumnName() {
        return legendColumnName;
    }

    public void setLegendColumnName(String legendColumnName) {
        this.legendColumnName = legendColumnName;
    }

    public String getxAxisColumnName() {
        return xAxisColumnName;
    }

    public void setxAxisColumnName(String xAxisColumnName) {
        this.xAxisColumnName = xAxisColumnName;
    }

    public String getSeriesColumnName() {
        return seriesColumnName;
    }

    public void setSeriesColumnName(String seriesColumnName) {
        this.seriesColumnName = seriesColumnName;
    }

    public String getIsSort() {
        return isSort;
    }

    public void setIsSort(String isSort) {
        this.isSort = isSort;
    }

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Integer getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(Integer yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public List<String> getLegendData() {
        return legendData;
    }

    public void setLegendData(List<String> legendData) {
        this.legendData = legendData;
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<String> getyAxisData() {
        return yAxisData;
    }

    public void setyAxisData(List<String> yAxisData) {
        this.yAxisData = yAxisData;
    }

    public JSONArray getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(JSONArray seriesData) {
        this.seriesData = seriesData;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "EchartsDto{" +
                "legendColumnName='" + legendColumnName + '\'' +
                ", xAxisColumnName='" + xAxisColumnName + '\'' +
                ", seriesColumnName='" + seriesColumnName + '\'' +
                ", isSort='" + isSort + '\'' +
                ", sort='" + sort + '\'' +
                ", seriesType='" + seriesType + '\'' +
                ", stack='" + stack + '\'' +
                ", yAxisIndex=" + yAxisIndex +
                ", legendData=" + legendData +
                ", xAxisData=" + xAxisData +
                ", yAxisData=" + yAxisData +
                ", seriesData=" + seriesData +
                '}';
    }
}
