package com.worldunion.prophesy.utils.echarts;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 仪表盘和漏斗图表
 * Created by liuruiyan on 2017/8/2.
 */
@Component(value = "funnelGaugeEcharts")
public class FunnelGaugeEcharts extends DefaultEcharts{


    /**
     *  封装Echarts的options 适用于仪表盘和漏斗图 ，封装了legendData和seriesData
     * @param seriesType    统计图类型 ：适用于仪表盘和漏斗图 OPTION_SERIES_TYPE_GAUGE，OPTION_SERIES_TYPE_FUNNEL
     * @param seriesDataNameKey 从list中取维度名的key
     * @param seriesDataValueKey 从list中取维度值的key
     * @param dataList  数据
     * @return
     * @throws Exception
     */
    public Map<String, Object> getEchartsOptions(String seriesName,String seriesType,String seriesDataNameKey,String seriesDataValueKey,List<?> dataList) throws Exception {

        Map<String,Object> resultMap = new HashMap<String ,Object>();

        List<JSONObject> jsonList =  ObjectFormatJsonObject(dataList);

        List<String> legendData = this.getLegend(seriesDataNameKey,dataList);

        JSONObject seriesMap = new JSONObject();

        seriesMap.put("name",seriesName);
        seriesMap.put("type",seriesType);
        JSONArray data = new JSONArray();

        for (JSONObject jsonObject: jsonList) {
            JSONObject tempObj = new JSONObject();
            tempObj.put("name",jsonObject.get(seriesDataNameKey));
            tempObj.put("value",jsonObject.get(seriesDataValueKey));
            data.add(tempObj);
        }
        seriesMap.put("data",data);

        if(super.OPTION_SERIES_TYPE_GAUGE.equals(seriesType)){
            JSONObject detailMap = new JSONObject();
            detailMap.put("formatter","{value}%");
            seriesMap.put("detail",detailMap);
        }


        JSONArray seriesData = new JSONArray();
        seriesData.add(seriesMap);

        resultMap.put(this.OPTION_LEGEND_DATA,legendData);
        resultMap.put(this.OPTION_XAXIS_DATA,null);
        resultMap.put(this.OPTION_SERIES_DATA,seriesData);

        return resultMap;
    }
}
