package com.worldunion.prophesy.utils.echarts;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 柱状图
 * Created by liuruiyan on 2017/6/20.
 */
@Component(value = "columnEcharts")
public class BarXToYEcharts extends DefaultEcharts {


    /**
     *  封装 y轴和X轴颠倒的Echarts的yAxis
     * @param yAxisColumnName(取数据的列名)
     * @param isSort(是否需要排序) N：不排序  Y：排序
     * @param sort(升序降序) desc: 降序  asc:升序
     * @param dataList  需要封装的数据
     * @return
     * @throws Exception
     */
    @Override
    public List<String> getYAxis(String yAxisColumnName, String isSort, String sort, List<?> dataList) throws Exception {
        return super.getXAxis(yAxisColumnName, isSort, sort, dataList);
    }

    /**
     *  封装 y轴和X轴颠倒的Echarts的 seriesData
     * @param legendColumnName (legend取数据的列名，按照legend分类)
     * @param yAxisColumnName (yAxis取数据的列名，Y坐标轴)
     * @param seriesColumnName (取数据的列名)，
     * @param legendData (已封装好的legend list)
     * @param yAxisData (已封装好的yAxisData list)
     * @param seriesType (bar/line),
     * @param stack (堆叠),
     * @param yAxisIndex (多个Y轴的情况，yAxisIndex对应yAxis配置的下标 如果有多个y轴，series列表中每个series都要设置yAxisIndex)
     *
     *               <br><br>
     * @param dataList  需要封装的数据
     * @return
     * @throws Exception
     */
    @Override
    public JSONArray getSeries(String legendColumnName, String yAxisColumnName, String seriesColumnName, List<String> legendData, List<String> yAxisData, String seriesType, String stack, Integer yAxisIndex, List<?> dataList) throws Exception {
        return super.getSeries(legendColumnName, yAxisColumnName, seriesColumnName, legendData, yAxisData, seriesType, stack, yAxisIndex, dataList);
    }




}
