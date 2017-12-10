package com.worldunion.prophesy.utils.echarts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *  统计图表插件默认实现类
 *  <br>
 * Created by liuruiyan on 2017/6/14.
 */
@Component(value = "defaultEcharts")
public class DefaultEcharts implements BaseEcharts{


    public final static String OPTION_LEGEND_DATA = "legendData";

    public final static String OPTION_XAXIS_DATA = "xAxisData";

    public final static String OPTION_SERIES_DATA = "seriesData";

    public final static String OPTION_SERIES_TYPE_LINE = "line";

    public final static String OPTION_SERIES_TYPE_BAR = "bar";

    public final static String OPTION_SERIES_TYPE_LINE_BAR = "line_bar";

    /**
     * 仪表盘
     */
    public final static String OPTION_SERIES_TYPE_GAUGE = "gauge";
    /**
     * 漏斗图
     */
    public final static String OPTION_SERIES_TYPE_FUNNEL = "funnel";

    public final static String STRING_LEGEND_NAME = "legendName";
    public final static String STRING_LEGEND_VALUE = "legendValue";



    public Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     *  封装Echarts的legend
     * @param echartsDto 解析dataList必须的参数 legendColumnName(取数据的列名)
     * @param dataList  需要封装的数据
     * @return  封装好的legend数据 key:legendData  value :List<String>
     * @throws Exception
     */
    @Override
    public Map<String,Object> getLegend(EchartsDto echartsDto, List<?> dataList) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();

        map.put(this.OPTION_LEGEND_DATA,this.getLegend(echartsDto.getLegendColumnName(),dataList));

        return map;
    }


    /**
     *  封装Echarts的legend
     * @param legendColumnName (取数据的列名)
     * @param dataList  需要封装的数据
     * @return  封装好的legend数据
     * @throws Exception
     */
    @Override
    public List<String> getLegend(String legendColumnName, List<?> dataList) throws Exception{

        List<JSONObject> jsonList =  ObjectFormatJsonObject(dataList);
        List<String> resultList = new ArrayList<String>();

        for (JSONObject json: jsonList) {
            if(json!=null){
                String value = (String)json.get(legendColumnName);
                if(resultList.indexOf(value)<0){
                    resultList.add(value);
                }
            }
        }

        return  resultList;
    }


    /**
     *  封装Echarts的xAxis
     * @param echartsDto 解析dataList必须的参数:xAxisColumnName(取数据的列名)，isSort(是否需要排序) N：不排序  Y：排序
     * @param dataList  需要封装的数据
     * @return  封装好的XAxis数据  key:xAxisData  value :List<String>
     * @throws Exception
     */
    @Override
    public Map<String,Object> getXAxis(EchartsDto echartsDto, List<?> dataList) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();

        map.put(this.OPTION_XAXIS_DATA,this.getXAxis(echartsDto.getxAxisColumnName(),echartsDto.getIsSort(),echartsDto.getSort(),dataList));
        return map;
    }

    /**
     *  封装Echarts的xAxis
     * @param xAxisColumnName(取数据的列名)
     * @param isSort(是否需要排序) N：不排序  Y：排序
     * @param sort(升序降序) desc: 降序  asc:升序
     * @param dataList  需要封装的数据
     * @return  封装好的XAxis数据
     * @throws Exception
     */
    @Override
    public List<String> getXAxis(String xAxisColumnName, String isSort, final String sort, List<?> dataList) throws Exception{


        List<JSONObject> jsonList =  ObjectFormatJsonObject(dataList);
        List<String> resultList = new ArrayList<String>();

        for (JSONObject json: jsonList) {
            if(json!=null){
                //String value = (String)json.get(xAxisColumnName);
                Object obj = json.get(xAxisColumnName);
                String value = null;
                if(obj!=null){
                    value = obj.toString();
                }
                if(resultList.indexOf(value)<0){
                    resultList.add(value);
                }
            }
        }

        if(StringUtils.isNotBlank(isSort) && isSort.equals("Y")){
            //Arrays.sort(data);
            Collections.sort(resultList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if("desc".equals(sort) || "DESC".equals(sort)){
                        return o2.compareTo(o1);
                    }else{
                        //默认正序
                        return o1.compareTo(o2);
                    }
                }
            });
        }

        return resultList;
    }




    /**
     *  封装Echarts的yAxis
     * @param echartsDto 解析dataList的参数
     * @param dataList  需要封装的数据
     * @return  封装好的YAxis数据
     * @throws Exception
     */
    @Override
    public Map<String,Object> getYAxis(EchartsDto echartsDto, List<?> dataList) throws Exception{

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("type","value");

        return map;
    }

    /**
     *  封装Echarts的yAxis
     * @param yAxisColumnName(取数据的列名)
     * @param isSort(是否需要排序) N：不排序  Y：排序
     * @param sort(升序降序) desc: 降序  asc:升序
     * @param dataList  需要封装的数据
     * @return  封装好的XAxis数据
     * @throws Exception
     */
    @Override
    public List<String> getYAxis(String yAxisColumnName,String isSort, final String sort,List<?> dataList) throws Exception{

        return null;
    }



    /**
     *  封装Echarts的Series,不同统计图表自行实现,返回值Map请参照方法说明的map；异常请抛出，调用的方法自行try catch
     * @param echartsDto 解析dataList的参数,key:
     *               <br>seriesColumnName(取数据的列名)，
     *               <br>legendColumnName(legend取数据的列名，按照legend分类)
     *               <br>legendData(已封装好的legend list)
     *               <br>xAxisColumnName(xAxis取数据的列名，x坐标轴)
     *               <br>xAxisData(已封装好的xAxisData list)
     *               <br>type(bar/line),
     *               <br>stack(堆叠),
     *               <br>yAxisIndex(多个Y轴的情况，yAxisIndex对应yAxis配置的下标)
     *
     *
     *               <br><br>
     * @param dataList  需要封装的数据
     * @return  Map<String,Object>  key: seriesData,value:JSONArray
     * @throws Exception
     */
    @Override
    public Map<String,Object>  getSeries(EchartsDto echartsDto, List<?> dataList) throws Exception{

        Map<String,Object> resultMap = new HashMap<String, Object>();

        resultMap.put(this.OPTION_SERIES_DATA,this.getSeries(echartsDto.getLegendColumnName(),echartsDto.getxAxisColumnName(),echartsDto.getSeriesColumnName(),
                echartsDto.getLegendData(),echartsDto.getxAxisData(),echartsDto.getSeriesType(),
                echartsDto.getStack(),echartsDto.getyAxisIndex(),dataList));

        return resultMap;
    }

    /**
     *  封装Echarts的Series,不同统计图表自行实现,返回值Map请参照方法说明的map；异常请抛出，调用的方法自行try catch
     * @param legendColumnName (legend取数据的列名，按照legend分类)
     * @param xAxisColumnName (xAxis取数据的列名，x坐标轴)
     * @param seriesColumnName (取数据的列名)，
     * @param legendData (已封装好的legend list)
     * @param xAxisData (已封装好的xAxisData list)
     * @param seriesType (bar/line),
     * @param stack (堆叠),
     * @param yAxisIndex (多个Y轴的情况，yAxisIndex对应yAxis配置的下标 如果有多个y轴，series列表中每个series都要设置yAxisIndex)
     *
     *               <br><br>
     * @param dataList  需要封装的数据
     * @return  封装好的series
     * @throws Exception
     */
    public JSONArray getSeries(String legendColumnName,String xAxisColumnName,String seriesColumnName,List<String> legendData,List<String> xAxisData,
                               String seriesType,String stack,Integer yAxisIndex,List<?> dataList) throws Exception{

        JSONArray series = new JSONArray();
        List<JSONObject> jsonList =  ObjectFormatJsonObject(dataList);

        Map<String,Object> seriesOption = new HashMap<String, Object>();
        seriesOption.put("type",seriesType);
        if(StringUtils.isNotBlank(stack))seriesOption.put("stack",stack);
        if(null != yAxisIndex)seriesOption.put("yAxisIndex",yAxisIndex);

        for (int i = 0; i < legendData.size(); i++) {

            JSONObject seriesMap = new JSONObject();
            // Map<String,Object> seriesMap = new HashMap<String, Object>();
            Object data[] = new Object[xAxisData.size()];//series选项中的data
            seriesMap.put("name",legendData.get(i));
            seriesMap.putAll(seriesOption);

            for (int j = 0; j < jsonList.size(); j++) {
                JSONObject json = jsonList.get(j);
                String tempLegendColumnName = (String) json.get(legendColumnName);
                if(legendData.get(i).equals(tempLegendColumnName)){

                    //String tempxAxisColumnName = (String) json.get(xAxisColumnName);
                    Object obj = json.get(xAxisColumnName);
                    String tempxAxisColumnName = null;
                    if(obj!=null){
                        tempxAxisColumnName = obj.toString();
                    }
                    for (int k = 0; k < xAxisData.size(); k++) {
                        if(tempxAxisColumnName.equals(xAxisData.get(k))){
                            data[k] = json.get(seriesColumnName); //将数据设置到series的data数组中，与x轴的数组顺序对应
                        }
                    }

                    jsonList.remove(j--);
                }

            }


            seriesMap.put("data",data);

            //series 数组
            series.add(seriesMap);

        }

        return series;
    }


    /**
     *  封装Echarts的options,普通统计图表用，特殊化请调用getLegend,getXAxis,getSeries方法单个封装,返回值Map请参照方法说明的map；异常请抛出，调用的方法自行try catch
     * @param echartsDto 解析dataList的参数,key:
     *               <br>*必须* legendColumnName(legend取数据的列名，按照legend分类)
     *               <br>*必须* xAxisColumnName(xAxis取数据的列名，x坐标轴)
     *               <br>*必须* seriesColumnName(取数据的列名)，
     *               <br>isSort(是否需要排序) N：不排序  Y：排序
     *               <br>sort(升序降序) desc: 降序  asc:升序
     *               <br>*必须* type(bar/line),
     *               <br>stack(堆叠),
     *               <br>yAxisIndex(多个Y轴的情况，yAxisIndex对应yAxis配置的下标 ，此方法不适用多个y轴情况)
     *
     *               <br><br>
     * @param dataList  需要封装的数据
     * @return  Map<String,Object>  key: legendData,value:List<String>; key:xAxisData,value:List<String> key:seriesData,value:JSONArray
     * @throws Exception
     */
    @Override
    public Map<String, Object> getEchartsOptions(EchartsDto echartsDto, List<?> dataList) throws Exception {

        Map<String,Object> resultMap = new HashMap<String ,Object>();

        List<String> legendData = this.getLegend(echartsDto.getLegendColumnName(),dataList);

        List<String> xAxisData = this.getXAxis(echartsDto.getxAxisColumnName(),echartsDto.getIsSort(),echartsDto.getSort(), dataList);

        echartsDto.setLegendData(legendData);
        echartsDto.setxAxisData(xAxisData);

        Map<String,Object> series = this.getSeries(echartsDto,dataList);

        JSONArray seriesData = (JSONArray) series.get(DefaultEcharts.OPTION_SERIES_DATA);

        resultMap.put(this.OPTION_LEGEND_DATA,legendData);
        resultMap.put(this.OPTION_XAXIS_DATA,xAxisData);
        resultMap.put(this.OPTION_SERIES_DATA,seriesData);

        return resultMap;
    }


    public static void main(String[] args) {

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> map01 = new HashMap<String, Object>();
        map01.put("legendName","公寓");
        map01.put("xAxis","201702");
        map01.put("amount",1000);
        Map<String,Object> map02 = new HashMap<String, Object>();
        map02.put("legendName","大数据");
        map02.put("xAxis","201702");
        map02.put("amount",3000);
        Map<String,Object> map03 = new HashMap<String, Object>();
        map03.put("legendName","装修");
        map03.put("xAxis","201701");
        map03.put("amount",5000);
        Map<String,Object> map04 = new HashMap<String, Object>();
        map04.put("legendName","装修");
        map04.put("xAxis","201702");
        map04.put("amount",6000);
        Map<String,Object> map05 = new HashMap<String, Object>();
        map05.put("legendName","大数据");
        map05.put("xAxis","201701");
        map05.put("amount",4000);
        Map<String,Object> map06 = new HashMap<String, Object>();
        map06.put("legendName","公寓");
        map06.put("xAxis","201701");
        map06.put("amount",2000);
        /*Map<String,Object> map07 = new HashMap<String, Object>();
        map07.put("legendName","公寓");
        map07.put("xAxis","201704");*/

        list.add(map01);
        list.add(map02);
        list.add(map03);
        list.add(map04);
        list.add(map05);
        list.add(map06);
        //list.add(map07);

        DefaultEcharts echarts = new DefaultEcharts();
        EchartsDto echartsDto = new EchartsDto();
        try {

            echartsDto.setLegendColumnName("legendName");
            echartsDto.setxAxisColumnName("xAxis");
            echartsDto.setSeriesColumnName("amount");
            echartsDto.setIsSort("Y");


            Map<String,Object> legendMap = echarts.getLegend(echartsDto,list);

            Map<String,Object> xAxisMap = echarts.getXAxis(echartsDto,list);

            echartsDto.setLegendData((List<String>) legendMap.get(DefaultEcharts.OPTION_LEGEND_DATA));
            echartsDto.setxAxisData((List<String>)xAxisMap.get(DefaultEcharts.OPTION_XAXIS_DATA));
            echartsDto.setSeriesType("line");

            Map<String,Object> seriesMap =echarts.getSeries(echartsDto,list);


            JSONArray jsonArray = (JSONArray) seriesMap.get(DefaultEcharts.OPTION_SERIES_DATA);

            for (Object object:jsonArray) {
                JSONObject json = (JSONObject)object;
                System.out.println(json.toJSONString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    /**
     * 将List<Object>格式转换为List<JSONObject>
     * @param objects
     * @return
     */
    public static List<JSONObject> ObjectFormatJsonObject(List<?> objects){

        List<JSONObject> jsonList = null;

        if(objects!=null && objects.size()>0){
            jsonList = new ArrayList<JSONObject>();
            for (Object obj:objects) {
                String json = JSON.toJSONString(obj);

                jsonList.add(JSON.parseObject(json));
            }
        }
        return  jsonList;
    }


    /**
     *
     * @param listData  原数据
     * @param rowNameMap    将要转换的列名，对应的含义       如：rent:租金；income：收入；other：其他费用
     * @param convertColumnName 转换后的列名，这一列存放要转换列对应的含义  如： 列名 costType  ，存放：租金，收入，其他费用
     * @param convertValueColumnName    转换后的列名，这一列存放要转换列对应的值  如：money ，存放：costType对应的金额
     * @return
     */
    public static List<Map<String,Object>> rowsConvertColumn(List<?> listData,Map<String,String> rowNameMap,String convertColumnName,String convertValueColumnName){

        /*
            *          转换前                          转换后
            *
            *  项目 租金  底租  运营费用         项目   费用类型    金额
            *   A   100   50    200            A       租金     100
            *   B   100   50    200            A       底租     50
            *   C   100   50    200            A      运营费    200
            *                                  B       租金     100
            *                                  B       底租     50
            *                                  B      运营费    200
            *                                  C       租金     100
            *                                  C       底租     50
            *                                  C      运营费    200
            * */

        List<JSONObject> list = ObjectFormatJsonObject(listData);
        if(list==null){
            return null;
        }


        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

        for (JSONObject json: list) {
            //1.将当前json转换成map，并且把将要转换的列删除
            Map<String,Object> map = new HashMap<String, Object>();
            for (String key:json.keySet()) {
                if(!rowNameMap.containsKey(key)){
                    map.put(key,json.get(key));
                }
            }



            //2.遍历将要转换的列名，将其含义set到map中，key为convertColumnName,同时将对应的值set到map中，key为convertValueColumnName
            for (String key:rowNameMap.keySet()) {
                Map<String,Object> newMap = new HashMap<String, Object>();
                newMap.putAll(map);
                newMap.put(convertColumnName,rowNameMap.get(key));//列转行 含义
                newMap.put(convertValueColumnName,json.get(key));//列转行 对应的值

                resultList.add(newMap);
            }


        }

        return  resultList;
    }


}
