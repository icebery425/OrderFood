package com.worldunion.prophesy.service.security;


import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.enumeration.State;
import com.worldunion.prophesy.model.util.SessionVariable;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.utils.common.Contents;
import com.wu.cas.filter.Assertion;
import com.wu.cas.filter.ResponseData;
import com.wu.cas.filter.auth.AuthUtils;
import com.wu.cas.filter.http.HttpUtils;

/**
 * apache shiro 的身份验证类
 */
public class JdbcAuthenticationRealm extends AuthorizationRealm {


    @Autowired
    private StaffService staffService;


    /**
     * 用户登录的身份验证方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String passwd= String.valueOf(usernamePasswordToken.getPassword());
        SessionVariable model =null;
        Staff staff =this.staffService.getStaffByCode(username);
        if (staff == null) {
            throw new CredentialsException("账户不存在.");
        }
        if (staff.getState().equals(State.Delete.getValue())) {
            throw new CredentialsException("帐号不存在");
        }

        if (staff.getState().equals(State.Disable.getValue())) {
            throw new DisabledAccountException("你的账户已被禁用,请联系管理员开通.");
        }
        if("root".equals(username)||"test".equals(username)){
            if(new SimpleHash("MD5", passwd.toCharArray()).toString().equals(staff.getPassword())){
            	staff.setPassword(passwd);
            }
            model = new SessionVariable(staff);
            return new SimpleAuthenticationInfo(model, staff.getPassword(), getName());
        }else{
        	Assertion assertion = new Assertion();
        	assertion.setUserName(username);
        	assertion.setPassword(passwd);
        	assertion.setLoginType(Assertion.LOGIN_ACCOUNT);
    	    HttpUtils.CAS_URL = Contents.CAS_URL;
    	    ResponseData rsa=this.loginForApp(assertion);
    	    if(!rsa.isOK()){
    	    	throw new CredentialsException("账户或密码错误.");
    	    }
        	if(staff ==null){
            	staff = new Staff();
            	staff.setStaffcode(username);
            	staff.setState(1);
            	this.staffService.save(staff);
            }

        	staff.setPassword(passwd);
             model = new SessionVariable(staff);
             return new SimpleAuthenticationInfo(model,passwd.toCharArray(), getName());
        }
        
    }
    public static ResponseData loginForApp(Assertion assertion) {
		Map paraMap = new HashMap();
		paraMap.put("userName", assertion.getUserName());
		paraMap.put("wxAccount", assertion.getWxAccount());
		paraMap.put("mobile", assertion.getMobile());
		paraMap.put("identification", assertion.getIdentification());
		paraMap.put("password", assertion.getPassword());
		paraMap.put("loginType", assertion.getLoginType());
		paraMap.put("code", assertion.getCode());
		paraMap.put("userType", assertion.getUserType());
		String paramUrl = HttpUtils.generateUrl(paraMap);
		String result = HttpUtils.get(HttpUtils.CAS_URL
				+ "forms/auth/loginForApp?" + paramUrl);
		ResponseData rep = (ResponseData) JSON.parseObject(result,
				ResponseData.class);
		
		return rep;
	}
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
    public static void main(String[] args) {
    	Assertion assertion = new Assertion();
    	assertion.setUserName("0139931");
//    	assertion.setMobile(name);
    	assertion.setPassword("123.com");
    	assertion.setLoginType(Assertion.LOGIN_ACCOUNT);
    	// assertion.setUserType(UserCenterConstants.IS_INNER_EMP);//设置是否为内部外部员工
    	try {
    	HttpUtils.CAS_URL = "http://192.168.11.98:8686/wu-cas-web/";
    	AuthUtils.loginForApp(assertion);
    	} catch (Exception ex) {
    	throw new AccountException("用户名密码错误");
    	}
	}
}
