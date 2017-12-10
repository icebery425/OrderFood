package com.worldunion.prophesy.service.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldunion.prophesy.model.Log;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.model.util.SystemVariableUtils;
import com.worldunion.prophesy.service.account.StaffService;
import com.worldunion.prophesy.service.base.LogService;

/**
 * 验证码登录认证Filter
 * 
 *
 */
@Component
public class CaptchaAuthenticationFilter extends FormAuthenticationFilter {
	
	/**
	 * 默认验证码参数名称
	 */
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	@Autowired
	private LogService logService; 
	@Autowired
	private StaffService staffService;

	/**
	 * 默认在session中存储的登录错误次数的名称
	 */
	
	//验证码参数名称
    private String captchaParam = DEFAULT_CAPTCHA_PARAM;
    //在session中的存储验证码的key名称
    private String sessionCaptchaKeyAttribute = DEFAULT_CAPTCHA_PARAM;
    
    /**
     * 重写父类方法，在shiro执行登录时先对比验证码，正确后在登录，否则直接登录失败
     */
	@Override
	protected boolean executeLogin(ServletRequest request,ServletResponse response) throws Exception {
		Session session = SystemVariableUtils.createSessionIfNull();
		Staff staff = staffService.getStaffByCode(request.getParameter("username"));
		String passwd=request.getParameter("password");
		Log log =new Log();
		log.setLogtypeCode(Constant.LOG_TYPECODE_SYS);
		log.setLogactionCode(Constant.LOG_ACTION_LOGIN);
		log.setFuncCode(Constant.LOG_FUNC_BASE);
		if(staff!=null){
			log.setStaffid(staff.getStaffid());
			log.setRemark("系统登录");
//			logService.add(log,(HttpServletRequest)request);
		}
		return super.executeLogin(request, response);
	}


	/**
	 * 重写父类方法，当登录失败将异常信息设置到request的attribute中
	 */
	@Override
	protected void setFailureAttribute(ServletRequest request,AuthenticationException ae) {
		if (ae instanceof IncorrectCredentialsException) {
			request.setAttribute(getFailureKeyAttribute(), "登录密码不正确");
		} else {
			request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
		}
		
		
	}
	
	/**
	 * 重写父类方法，当登录失败后，将allowIncorrectNumber（允许登错误录次） + 1
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,AuthenticationException e, ServletRequest request,ServletResponse response) {
		return super.onLoginFailure(token, e, request, response);
	}
	
	/**
	 * 重写父类方法，当登录成功后，将allowIncorrectNumber（允许登错误录次）设置为0，重置下一次登录的状态
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		
		Session session = SystemVariableUtils.getSession();
		session.setAttribute("sv", subject.getPrincipal());
		return super.onLoginSuccess(token, subject, request, response);
	}

	/**
	 * 设置验证码提交的参数名称
	 * 
	 * @param captchaParam 验证码提交的参数名称
	 */
	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	/**
	 * 获取验证码提交的参数名称
	 * 
	 * @return String
	 */
	public String getCaptchaParam() {
		return captchaParam;
	}

	/**
	 * 设置在session中的存储验证码的key名称
	 * 
	 * @param sessionCaptchaKeyAttribute 存储验证码的key名称
	 */
	public void setSessionCaptchaKeyAttribute(String sessionCaptchaKeyAttribute) {
		this.sessionCaptchaKeyAttribute = sessionCaptchaKeyAttribute;
	}
	
	/**
	 * 获取设置在session中的存储验证码的key名称
	 * 
	 * @return Sting
	 */
	public String getSessionCaptchaKeyAttribute() {
		return sessionCaptchaKeyAttribute;
	}

	
	/**
	 * 获取用户输入的验证码
	 * 
	 * @param request ServletRequest
	 * 
	 * @return String
	 */
	public String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	

}