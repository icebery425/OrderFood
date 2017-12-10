package com.worldunion.prophesy.controller.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.worldunion.prophesy.model.Log;
import com.worldunion.prophesy.model.LogDetail;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.util.SystemVariableUtils;
import com.worldunion.prophesy.service.base.LogService;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.service.base.SystemServiceLog;
import com.worldunion.prophesy.utils.common.ParamsUtils;

/**  
 * 切点类  
 * @author 0139931  
 * @since 2016-02-22 Pm 20:35  
 * @version 1.0  
 */    
@Aspect    
@Component    
public  class SystemLogAspect {    
	//本地异常日志记录对象    
//    private  static  final Logger logger = Logger.getLogger(SystemLogAspect.class);  
    private static Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    //注入Service用于把日志保存数据库    
    @Resource    
     private LogService logService;    
    
    
    //Service层切点    
    @Pointcut("@annotation(com.worldunion.prophesy.service.base.SystemServiceLog)")
     public  void serviceAspect() {    
    }    
    
    //Controller层切点    
    @Pointcut("@annotation(com.worldunion.prophesy.service.base.SystemControllerLog)")
     public  void controllerAspect() {    
    }    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     */    
    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) {    
    
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //读取session中的用户    
        if(SystemVariableUtils.getSessionVariable()==null){
        	return;
        }
        Staff user =  SystemVariableUtils.getSessionVariable().getStaff();    
        //请求的IP    
        String ip =ParamsUtils.getRemoteHost(request);   
         try {    
        	 String params = "";    
             if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
                 for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                    params += joinPoint.getArgs()[i] + ";";    
                }    
            }        
           
            //*========数据库日志=========*//    
            Log log =getControllerMethodDescription(joinPoint);
             //如果注解的funcode为空，则不记录日志
             if(log==null || "".equals(log.getFuncCode())){
                 return ;
             }
            log.setLoginip(ip); 
            log.setUrlinfo(request.getRequestURL().toString());
            log.setStaffid(user.getStaffid());
            List<LogDetail> logDetail=log.getDetail();
            LogDetail ld=null;
            for(int num=0;num<logDetail.size();num++){
            	ld=logDetail.get(num);
            	ld.setNowvalue(getQueryParamsStr(request));
            }
            //保存数据库    
            logService.add(log); 
            
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error( e.getMessage());    
        }    
    }   
    /**  
     * 
     *  
     * @param joinPoint 切点  
     */    
    @Around("serviceAspect()")    
     public  void doAfter(JoinPoint joinPoint) {    
    
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //读取session中的用户    
        Staff user =  SystemVariableUtils.getSessionVariable().getStaff();    
        //请求的IP    
        String ip =ParamsUtils.getRemoteHost(request);      
         try {    
        	 String params = "";    
             if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
                 for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                    params += joinPoint.getArgs()[i] + ";";    
                }    
            }        
           
            //*========数据库日志=========*//    
            Log log =getControllerMethodDescription(joinPoint);    
            log.setLoginip(ip); 
            log.setUrlinfo(request.getRequestURL().toString());
            log.setStaffid(user.getStaffid());
            List<LogDetail> logDetail=log.getDetail();
            LogDetail ld=null;
            for(int num=0;num<logDetail.size();num++){
            	ld=logDetail.get(num);
            	ld.setNowvalue(getQueryParamsStr(request));
            }
            //保存数据库    
            logService.add(log); 
            
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error( e.getMessage());    
        }    
    }    
    
//    /**  
//     * 异常通知 用于拦截service层记录异常日志  
//     *  目前暂未用到
//     * @param joinPoint  
//     * @param e  
//     */    
//    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
//     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {    
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        String errorStr="";
//        //读取session中的用户    
//        Staff user =  SystemVariableUtils.getSessionVariable().getStaff();     
//        //获取请求ip    
//        String ip = request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")?"127.0.0.1":request.getRemoteAddr();   
//        //获取用户请求方法的参数并序列化为JSON格式字符串    
//        String params = "";    
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
//                params += joinPoint.getArgs()[i] + ";";    
//            }    
//        }    
//         try {    
//               /*==========数据库日志=========*/    
//            Log log = new Log();    
//            errorStr=e.getMessage();
//            if(errorStr.length()>300){
//            	errorStr=errorStr.substring(0, 280);
//            }
//            log.setRemark(errorStr);    
//            log.setActiontype((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
//            log.setLoginip(ip); 
//            log.setUrlinfo(request.getRequestURL().toString());
//            log.setParams(  getQueryParamsStr(request));    
//            log.setStaffid(user.getStaffid());    
//            log.setLogintime(new Date());    
//            //保存数据库    
//            logService.add(log); 
//            System.out.println(log.getLogid());
//        }  catch (Exception ex) {    
//            //记录本地异常日志    
//            logger.error("==异常通知异常==");    
//            logger.error( ex.getMessage());    
//        }    
//         /*==========记录本地异常日志==========*/    
//    
//    }    
    public String getQueryParamsStr(HttpServletRequest request ) {
        String parameters = " ";
        Map map = request.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {

            if (StringUtils.isNotEmpty(request.getParameter(key.toString()))) {
            	parameters+=key.toString()+"="+
            			request.getParameter(key.toString())+",";
            }
        }
        
        parameters=parameters.substring(0, parameters.length()-1);
        if(parameters.length()>200){
        	parameters=parameters.substring(0, 195);//数据库长度为200，这里限制195
        }
        return parameters;
    }
    
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        Log log=new Log();
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) { 
                    description = method.getAnnotation(SystemServiceLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static Log getControllerMethodDescription(JoinPoint joinPoint)  throws Exception { 
    	Log log=new Log();
    	List<LogDetail> lDetail=new ArrayList<LogDetail>();
    	LogDetail logd=null;
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {  
                	 lDetail=new ArrayList<LogDetail>();
                	 logd=new LogDetail();
                	 log.setRemark( method.getAnnotation(SystemControllerLog. class).description());    
                	 log.setLogtypeCode(method.getAnnotation(SystemControllerLog. class).logTypeCode());
                    log.setLogactionCode( method.getAnnotation(SystemControllerLog. class).logActionCode());
                    log.setFuncCode(method.getAnnotation(SystemControllerLog. class).funcCode());
                    logd.setTablename(method.getAnnotation(SystemControllerLog. class).tableName());
                    lDetail.add(logd);
                    log.setDetail(lDetail);
                    break;    
                }    
            }    
        }    
         return log;    
    }    
}    
