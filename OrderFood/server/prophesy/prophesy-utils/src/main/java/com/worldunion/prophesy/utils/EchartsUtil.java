package com.worldunion.prophesy.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.worldunion.prophesy.utils.common.StringUtil;

public class EchartsUtil {
	public static JSONArray prepareStatLine(Map<String,Object> params){
		JSONArray echartsJsons = new JSONArray();
		return echartsJsons;
	}
	public static JSONArray prepareStatMuti(Map<String,Object> params){
		JSONArray echartsJsons = new JSONArray();
		return echartsJsons;
	}
	
	public static String[] getXLinePoints(String lineColName, List<Map<String, Object>> resultMapList) {
		HashSet<String> ret = new HashSet<String>();
		String s = null;
		for (Map<String, Object> m : resultMapList) {
			s = String.valueOf(m.get(lineColName));
			ret.add(s);
		}
		String[] rs = new String[ret.size()];
		ret.toArray(rs);
		Arrays.sort(rs);
		return rs;
	}
	public static Integer getGroupByCols(Map<String, Object> inParam, List<String> inKeys) {
		Integer ret = Integer.valueOf(0);
		for (String inkey : inKeys){
			if (String.valueOf(inParam.get(inkey)).startsWith("**")
					|| String.valueOf(inParam.get(inkey)).indexOf(",") > 0){
				
				ret++;
			}
		}
		return ret;
	}
	public static List<String> sortMapKey(Map<String, Object> inParam) {
		List<String> inKeys = new ArrayList<String>();
		inKeys.addAll(inParam.keySet());
		Collections.sort(inKeys);
		return inKeys;
	}
	public static boolean  isFlag(String[] param) {
		boolean flag=false;
		if((param.length > 1)||(param.length > 0
						&& StringUtils.isNotBlank(param[0]))){
			flag=true;
		}
		return flag;
	}
	
	
	/**
	 * 
	 * @param list	数组
	 * @param timeparam 时间字段,为排名时此字段为空
	 * @param paramList 字段数组 长度为2或4，为4时是公寓房源分析
	 * @return
	 */
	public static Map<String, Object> generateEchartMap(List<Map<String, Object>> list, String timeparam,
			List<String> paramList){
		Map<String, Object> datas = new HashMap<String, Object>();
		String legend = null;
		String xAxis = null;
		//showType:0 图表和表格; 1 列表; 2 无
		//echartstype:0 显示为时间连续的折线图； 1 显示为固定时间点的饼图或柱图
		//griddata: 列表显示的数据
		//xAxis: x轴下标
		//echartsdata: 图表数据
		//legends: 分组字段
		
		if(null == list || list.isEmpty() || list.size()==1 && list.get(0) == null){
			datas.put("showtype", 2);
		} else {
			datas.put("griddata", list);
			
			if(StringUtils.isBlank(timeparam)){//新房或金融或创收排名
				int index=0;
				String[] xAxislist = new String[list.size()];
				String param = paramList.get(0)+"";
				for(Map<String, Object> house : list){
					xAxislist[index++] = StringUtils.isNotBlank(house.get(param)+"") ?house.get(param)+"":"";
					house.put("rank",index);
				}
				datas.put("showType", 0);
				datas.put("echartstype", 1);
				datas.put("xAxis", xAxislist);
				datas.put("echartsdata", getCommonEDatas(param, xAxislist, list));
				
			}else{
			
				Map<String, Set> setMap = new HashMap<String, Set>();
				Map<String, String[]> paramsMap = new HashMap<String, String[]>();
				Set<String> timeset = new HashSet<String>();
				
				//获取字段set
				for(String param : paramList){	
					int index=1;
					Set<String> paraset = new HashSet<String>();
					for(Map<String, Object> obj : list){
						obj.put("rank",index++);
						generateSet(param, paraset, obj);
						generateSet(timeparam, timeset, obj);
					}
					setMap.put(param, paraset);
				} 
				
				
				int count = 0;		//维度统计
				
				//获取字段List
				Iterator iter = setMap.entrySet().iterator();
				while(iter.hasNext()){	
					Map.Entry e=(Map.Entry)iter.next();
					String pk = e.getKey()+"";
					Set<String> set = (Set<String>) e.getValue();
					String[] paras = generateStr(set);
					if(paras.length>1){
						count++;
						if(count == 2){
							xAxis = legend;
						}
						legend = pk;
					} else if(paras.length==1 && StringUtils.isNotBlank(paras[0]) && StringUtils.isBlank(legend)
							&& !StringUtils.equalsIgnoreCase("null", paras[0]) && !StringUtils.equals("未知", paras[0])){
						legend = pk;
					}
					paramsMap.put(pk, paras);
				}
				
				String[] times = generateStr(timeset);
				paramsMap.put(timeparam, times);
				if(paramList.size()==4){
					//有4个字段，为公寓房源分析
					//区分时间点和时间段
					String[] legList = {"收房间数","出房间数"};
					datas.put("legends", legList);
					if(times.length > 1){ //时间段
						datas.put("xAxis", times);
						datas.put("echartstype", 0);	//显示线图
						if(count>0){//如果有一个维度超过1个选项，只显示列表，不显示图表
							datas.put("showtype", 1);
						} else {
							datas.put("showtype", 0);
							Map<String,List> echartsdata = getApartmentEDatas(list, times, timeparam);
//							Map<String,List> echartsdata = getApartmentEDatas(list);
							
							datas.put("echartsdata", echartsdata);
						}
					} else { // 时间点
						datas.put("echartstype", 1);	//显示柱图或饼图
						if(count>1){//如果有两个及以上维度超过1个选项，只显示列表，不显示图表
							datas.put("showtype", 1);
						} else if(count == 1) {
							String[] xAxisList = paramsMap.get(legend);
							datas.put("showtype", 0);
							datas.put("xAxis", xAxisList);
							Map<String,List> echartsdata = getApartmentEDatas(list, xAxisList, legend);
//							Map<String,List> echartsdata = getApartmentEDatas(list);
							datas.put("echartsdata", echartsdata);
						} else {//如果只有1条记录，只显示列表，不显示图表
							datas.put("showtype", 1);
						}
					}
				} else {
					//非公寓房源分析页面
					//区分时间点和时间段
					if(times.length > 1){ //时间段
						datas.put("echartstype", 0);	//显示线图
						datas.put("xAxis", times);
						if(count>1){//如果有两个及以上维度超过1个选项，只显示列表，不显示图表
							datas.put("showtype", 1);
						} else {
							datas.put("showtype", 0);
							Map<String,List> echartsdata = null;
							if(StringUtils.isNotBlank(legend)){
								String[] legList = paramsMap.get(legend);
								datas.put("legends", legList);
								echartsdata = getTwoDimenEDatas(legend,timeparam, paramsMap, list);
							} else { //没有筛选条件时直接把list放入echarts.
								datas.put("legends", new String[]{""});
								echartsdata = getSoleEDatas(list);
							}
							
							
							datas.put("echartsdata", echartsdata);
						}
					} else { // 时间点
						datas.put("echartstype", 1);	//显示柱图或饼图
						Map<String,List> echartsdata = null;
						System.out.println("");
						if(count>1){
							datas.put("showtype", 0);
							String[] legList = paramsMap.get(legend);
							String[] xAxisList = paramsMap.get(xAxis);
							datas.put("legends", legList);
							datas.put("xAxis", xAxisList);
							echartsdata = getTwoDimenEDatas(legend,xAxis, paramsMap, list);
						}else if(count== 1) {
							String[] legList = paramsMap.get(legend);
							datas.put("showtype", 0);
							datas.put("xAxis", legList);
							echartsdata = getCommonEDatas(legend, legList, list);
						} else {//如果只有1条记录，只显示列表，不显示图表
							datas.put("showtype", 1);
							String[] legList = paramsMap.get(legend);
							datas.put("xAxis", legList);
							echartsdata = getCommonEDatas(legend, legList, list);
						}
						datas.put("echartsdata", echartsdata);
					}
				}
			}
		}
		return datas;
	}
	private static Map<String,List> getTwoDimenEDatas(String legend, String xAxis,
			Map<String, String[]> paramsMap, List<Map<String, Object>> list) {
		String[] legList = paramsMap.get(legend);
		String[] xAxisList = paramsMap.get(xAxis);
		Map<String, List> legMap = new HashMap<String, List>();
		for(String leg : legList){
			List<Object> tmpList = new ArrayList<Object>();
			for(String xaxis : xAxisList){
				boolean flag = true;	//判断标志，判断相应的legend,xAxis下有没有相应的数据，没有则补充一个空数据
				for(Map<String, Object> obj : list){
					String legValue = obj.get(legend)+"";
					String xValue = obj.get(xAxis)+"";
					if(StringUtils.equals(leg, legValue) && StringUtils.equals(xaxis, xValue)){
						tmpList.add(obj);
						flag = false;
						break;
					}
				}
				if(flag){
					Map<String, Object> obj = new HashMap<String, Object>();
					obj.put(legend, leg);
					obj.put(xAxis, xaxis);
					tmpList.add(obj);
				}
			}
			legMap.put(leg, tmpList);
		}
		return legMap;
	}
	private static Map<String,List> getSoleEDatas(List<Map<String, Object>> list) {
		Map<String, List> legMap = new HashMap<String, List>();
		legMap.put("", list);
		return legMap;
	}
	private static Map<String, List> getCommonEDatas(String legend, String[] legList, List<Map<String, Object>> list) {
		Map<String, List> legMap = new HashMap<String, List>();
		if(null != legList && legList.length>0){
			for(String leg : legList){
				List<Object> tmpList = new ArrayList<Object>();
				for(Map<String, Object> obj : list){
					String obValue = obj.get(legend)+"";
					if(StringUtils.equals(leg, obValue)){
						tmpList.add(obj);
						break;
					}
				}
				legMap.put(leg, tmpList);
			}
		}
		
		return legMap;
	}
	private static Map<String, List> getApartmentEDatas(List<Map<String, Object>> list,String[] xAxis, String leg) {
		Map<String, List> dataMap = new HashMap<String, List>();
		List<Object> tmpList = new ArrayList<Object>();
		for(String axis : xAxis){
			for(Map<String, Object> tmpObj: list){
				if(StringUtils.equals(axis, tmpObj.get(leg)+"")){
					tmpList.add(tmpObj);
					break;
				}
			}
		}
		dataMap.put("multdata", list);
		return dataMap;
	}
	private static String[] generateStr(Set<String> paraset) {
		String[] paras=null;
		if(!paraset.isEmpty()){
			paras = StringUtil.convertSet2SortedList(paraset);
		}
		return paras;
	}
	private static void generateSet(String para1, Set<String> paraset,
			Map<String, Object> object) {
		if(StringUtils.isNotBlank(para1)){
			if(StringUtils.isBlank(object.get(para1)+"") || StringUtils.equalsIgnoreCase("null", object.get(para1)+"")){
				object.put(para1, "");
			}
			paraset.add(object.get(para1)+"");
		}
	}
	
	
}
