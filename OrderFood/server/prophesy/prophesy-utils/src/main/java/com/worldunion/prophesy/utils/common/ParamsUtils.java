package com.worldunion.prophesy.utils.common;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ParamsUtils {
	public static Map<String, Object> getParams(Map<String, Object> map,
			HttpServletRequest request,String staffId) {
		
		map.put("addTime", new Date());
		map.put("enterTime", new Date());
		map.put("checkTime", new Date());
		map.put("alterTime", new Date());
		map.put("enterId", staffId);
		map.put("checkId", staffId);
		map.put("alterId", staffId);
		map.put("status", "Y");
		return map;
	}

	public static Map<String, Object> getUpdateParams(Map<String, Object> map,
			HttpServletRequest request,String staffId) {
		map.put("checkTime", new Date());
		map.put("alterTime", new Date());
		map.put("alterId", staffId);
		map.put("status", "Y");
		return map;
	}
/**
 * 
 * @param map
 * @param suffix  后缀，没有可以不填
 * @return
 */
	public static List<String> getNameBySeqNo(Map<String, String> map,String suffix,String type) {
		// 起始号
		Integer startNum = Integer.parseInt(map.get("startNum"));
		// 连续数量
		Integer addNum = Integer.parseInt(map.get("addNum"));
		// 生成规则
		/**
		 * 1:阿拉伯数字
		 * 2：中文数字
		 * 3：英文小写
		 * 4：英文大写
		 * 5：中文大写
		 */
		String rule = map.get("rule");
		List<String> arrayList=new ArrayList<String>();
		Integer maxNum=startNum+addNum-1;
		for(int num=startNum;num<=maxNum;num++){
			if("1".equals(rule)){
				if("1".equals(type)){
					arrayList.add(suffix+String.valueOf(num));
				}else{
					arrayList.add(String.valueOf(num)+suffix);
				}
			}else if("2".equals(rule)){
				arrayList.add(numToChina(num,1,suffix,type));
			}else if("3".equals(rule)){
				arrayList.add(numToChar(num,1,suffix,type));
			}else if("4".equals(rule)){
				arrayList.add(numToChar(num,2,suffix,type));
			}else if("5".equals(rule)){
				arrayList.add(numToChina(num,2,suffix,type));
			}
		}
		return arrayList;
	}
	/**
	 * 
	 * @param map
	 * @param suffix  后缀，没有可以不填
	 * @return
	 */
	public static List<String> getNameBySeqNoEnd(Map<String, String> map,String suffix) {
		// 起始号
		Integer startNum = Integer.parseInt(map.get("startNum"));
		// 结束
		Integer endNum = Integer.parseInt(map.get("endNum"));
		// 生成规则
		/**
		 * 1:阿拉伯数字
		 * 2：中文数字
		 * 3：英文小写
		 * 4：英文大写
		 * 5：中文大写
		 */
		String rule = map.get("rule");
		List<String> arrayList=new ArrayList<String>();
		for(int num=startNum;num<=endNum;num++){
			if("1".equals(rule)){
				arrayList.add(String.valueOf(num)+suffix);
			}else if("2".equals(rule)){
				arrayList.add(numToChina(num,1,suffix,"2"));
			}else if("3".equals(rule)){
				arrayList.add(numToChar(num,1,suffix,"2"));
			}else if("4".equals(rule)){
				arrayList.add(numToChar(num,2,suffix,"2"));
			}else if("5".equals(rule)){
				arrayList.add(numToChina(num,2,suffix,"2"));
			}
		}
		return arrayList;
	}
	/**
	 * 阿拉伯数字转中文数字 -支持亿
	 * @param d(数字)
	 * @param type(大小写,2是大写)
	 */
	  public static String numToChina(int d,int type,String suffix,String suffixType) {
        String str[] = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String ss[] = new String[] { "", "十", "百", "千", "万", "十", "百", "千", "亿" };
        if(type==2){
        	str = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
            ss = new String[] {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿" };
        }
        String s = String.valueOf(d);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            String index = String.valueOf(s.charAt(i));
            sb = sb.append(str[Integer.parseInt(index)]);
        }
        String sss = String.valueOf(sb);
        int i = 0;
        for (int j = sss.length(); j > 0; j--) {
            sb = sb.insert(j, ss[i++]);
        }
        if("2".equals(suffixType)){
        	return sb.toString()+suffix;
        }else{
        	return suffix+sb.toString();
        }
    }
	  public static void main(String args[]){
		  String num=numToChina(22,2,"栋","1");
	  }
	  /**
		 * 阿拉伯数字转字母 
		 * @param d(数字)
		 * @param type(大小写,2是大写)
		 */
	  public static  String numToChar(int d,int type,String suffix,String suffixType) {
		  char c1=(char) (d+96);
		  if(2==type){
			  c1=(char) (d+64);
		  }
		  if("2".equals(suffixType)){
			  return String.valueOf(c1)+suffix;
		  }else{
			  return suffix+String.valueOf(c1);
		  }
	  }
	  /**
	   * 规则为空的默认为数值
	   * @param map
	   * @param suffix
	   * @return
	   */
	  public static List<String> getNameBySeqNoOther(Map<String, String> map,String suffix) {
		  String rule = map.get("rule");
		  if(StringUtils.isEmpty(rule)){
			  rule = "1";
		  }
		  map.put("rule", rule);
		  return getNameBySeqNoEnd(map, suffix);
	  }
	  public static String getBuildTypeId(int maxFloor){
		  if(maxFloor<=3){
			  return "01";
		  }else if(maxFloor<=7 && maxFloor>=4){
			  return "02";
		  }else if(maxFloor<=12 && maxFloor>=8){
			  return "03";
		  }else if(maxFloor<=40 && maxFloor>=13){
			  return "04";
		  }else if( maxFloor>=41){
			  return "05";
		  }
		  return null;
	  }



		public static String getBuildTypeCode(int maxFloor){
			if(maxFloor<=3){
				return "1";//低层
			}else if(maxFloor<=7 && maxFloor>=4){
				return "2";//多层
			}else if(maxFloor<=12 && maxFloor>=8){
				return "3";//小高层
			}else if(maxFloor<=40 && maxFloor>=13){
				return "4";//高层
			}else if( maxFloor>=41){
				return "5";//超高层
			}
			return null;
	}




	public static String listToString(List<String> strList){
		  StringBuffer loginsb = new StringBuffer();
	        for(int i =0;i<strList.size();i++){
	        	loginsb.append("'");
	        	loginsb.append(strList.get(i));
	        	loginsb.append("'");
	        	loginsb.append(",");
	        }

	        String channelName = loginsb.substring(0, loginsb.length() - 1);
	        return channelName;
	  }
	  public static boolean compareTime(Date update,int i){
		  boolean flag=false;
		  Date d2=new Date();
		  Calendar calendar = Calendar.getInstance(); //得到日历
		  calendar.setTime(d2);//把当前时间赋给日历
		  calendar.add(Calendar.DAY_OF_MONTH, i);  //设置为前一天
		  d2 = calendar.getTime();   //得到前一天的时间
		  if(update.getTime()>d2.getTime()){
			  flag= true;
		  }
		  return flag;
	  }
	  public static  String getFileLast(File f){ 
			  String fileName=f.getName();
			  String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
			  return prefix;
	  }
	  public static boolean isNum(String macAddress){
	        String reg = "^\\d+$";
	        return Pattern.compile(reg).matcher(macAddress).find();
	   }
	  public static Date formatDate(String dateStr,String format){
		  	DateFormat format1 = new SimpleDateFormat(format);  
		  	Date d=null;
	        try {
				d= format1.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
	        return d;
	  }
	  public static HttpServletRequest getRequest() {
	        return ((ServletRequestAttributes) RequestContextHolder
	                .getRequestAttributes()).getRequest();
	    }
	  //获取客户端IP
	  public static String getRemoteHost(HttpServletRequest request){
		    String ip = request.getHeader("x-forwarded-for");
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getHeader("Proxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getHeader("WL-Proxy-Client-IP");
		    }
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
		        ip = request.getRemoteAddr();
		    }
		    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		}
}
