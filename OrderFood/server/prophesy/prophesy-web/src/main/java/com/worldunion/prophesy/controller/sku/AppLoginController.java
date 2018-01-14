package com.worldunion.prophesy.controller.sku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.model.sku.User;
import com.worldunion.prophesy.service.base.LoginService;
import com.worldunion.prophesy.utils.common.error.Result;
import com.worldunion.prophesy.utils.httputils.httpclient.HttpRequest;
@Controller
@RequestMapping("/api/login")
public class AppLoginController extends BaseController{
	
	@Autowired
	LoginService loginService;
    
//    /**
//     * 注册接口
//     *
//     * @return
//     */
//    @RequestMapping("/register")
////    @SystemControllerLog(description = "用户注册",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
//    @ResponseBody
//    public Result register( ) {
//    	Map<String,String> params=new HashMap<String,String>();
//    	User u=null;
//
//    	Map<String,Object> resultparams=new HashMap<String,Object>();
//    	String[] strarr ={"mobile","code","wxAppCode","nickName","avatarUrl","gender","wxFormId"};
//    	
//    	params=getHeaderMap(strarr);
//    	List<User> stList=null;
//		try {
//			stList =loginService.selectUserByParams(params);
//			if(stList!=null && stList.size()>0){
//				u=stList.get(0);
//				u.setStatus("1");
//				return Result.buildOkResult(u);
//			}else{
//				loginService.insertUserByParams(params);
//				resultparams.put("token", "token");//值取调用微信接口后返回的数据
//				resultparams.put("userid", "userid");//值取调用微信接口后返回的数据
//				resultparams.put("wechatnickname", "wechatnickname");//值取调用微信接口后返回的数据
//				resultparams.put("avatarUrl", "avatarUrl");//值取调用微信接口后返回的数据
//				resultparams.put("gender", params.get("gender"));//值取调用微信接口后返回的数据
//				resultparams.put("status", "2");
//				resultparams.put("openId", "openId");//值取调用微信接口后返回的数据
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return Result.buildOkResult(resultparams);
//    }
    /**
     * 登录接口
     *
     * @return
     */
    @RequestMapping("/login")
//    @SystemControllerLog(description = "用户登录",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="t_billing")
    @ResponseBody
    public Result userLogin( ) {

    	
    	Map<String,Object> map = this.getQueryParams();
    	String code =String.valueOf(map.get("code"));
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return Result.buildOkResult(map);
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wx1ae64c4c9fac2659";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "56cbf507e5b7e7bd842e3516acf9753b";
        //授权（必填）
        String grant_type = "authorization_code";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
       
        System.out.println("sr"+sr);
        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
//            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
//            if (null != result && result.length() > 0) {

//                JSONObject userInfoJSON = JSONObject.parseObject(session_key);
        	 //解析相应内容（转换成json对象）
            JSONObject json = JSONObject.parseObject(sr);
            //获取会话密钥（session_key）
            String session_key = json.get("session_key").toString();
            //用户的唯一标识（openid）
            String openid = (String) json.get("openid");
        		JSONObject userInfoJSON=json;
                Map<String,Object>  userInfo = new HashMap<String,Object> ();
               
                userInfo.put("openId", userInfoJSON.get("openid"));
                userInfo.put("nickName", map.get("nickName"));
                userInfo.put("gender", map.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", map.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                userInfo.put("session_key", userInfoJSON.get("session_key"));
                List<User> stList =loginService.selectUserByParams(userInfo);
                map.put("status", "0");
                map.put("msg", "登录成功");
    			if(stList!=null && stList.size()>0){
    				userInfo.put("status", 1);
    				return Result.buildOkResult(userInfo);
    			}else{
    				loginService.insertUserByParams(userInfo);
    				userInfo.put("status", 2);
    				return Result.buildOkResult(userInfo);
    			}
//            }
        } catch (Exception e) {
        	 map.put("status", "1");
             map.put("msg", "登录失败");
            e.printStackTrace();
            return Result.buildOkResult(map);
        }
       
    	
    }
}
