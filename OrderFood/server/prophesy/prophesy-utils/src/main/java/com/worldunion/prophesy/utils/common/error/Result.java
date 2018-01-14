package com.worldunion.prophesy.utils.common.error;



import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;


/**
 * 功能处理结果信息类，是一个通用的结果信息包装类。
 *
 */
public class Result {

	/**
	 * 无错误的状态值。
	 */
	public static final int STATUS_OK = 0;
	
	/**
	 * 有错误的默认状态值。
	 */
	public static final int STATUS_FAIL = 1;
	
	/**
	 * 通用的成功结果对象。
	 */
	public static final Result OK = buildOkResult();
	
	/**
	 * 通用的失败结果对象。
	 */
	public static final Result FAIL = buildErrorResult();
	
	
	/**
	 * 系统内部错误的结果对象。
	 */
	public static final Result SYSTEM_ERROR = buildSystemErrorResult();
	
	/**
	 * 处理结果状态值，0表示成功，非0表示失败，默认1表示失败。其它含义由各业务模块自行定义。
	 */
	private int status = STATUS_OK; 
	
	/**
	 * 如果处理成功，则一般会返回结果应该有相关的数据。
	 */
	private Object data = null;
	
	
	private int isInit = STATUS_FAIL;
	
	public int getIsInit() {
		return isInit;
	}

	public void setIsInit(int isInit) {
		this.isInit = isInit;
	}

	/**
	 * 如果有错误信息，错误信息列表。
	 */
	private List<CommonError> errors;


	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<CommonError> getErrors() {
		return errors;
	}

	public void setErrors(List<CommonError> errors) {
		this.errors = errors;
	}
	
	public Result() {
		super();
	}
	
	public Result(int status) {
		super();
		this.status = status;
	}

	public Result(int status, List<CommonError> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public Result(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	public Result(int status, int isInit, Object data) {
		super();
		this.status = status;
		this.isInit = isInit;
		this.data = data;
	}

	public Result(int status, Object data, List<CommonError> errors) {
		super();
		this.status = status;
		this.data = data;
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "Result [status=" + status + ",isInit=" + isInit + ", data=" + data + ", errors="
				+ errors + "]";
	}

	/**
	 * 构建一个状态为成功的结果无数据的结果对象 的工厂方法。
	 * @return 结果对象，状态为成功，无数据对象。
	 */
	public static Result buildOkResult(){
		return buildOkResult(null);
	}
	
	/**
	 * 构建一个状态为成功并且好办数据对象的结果对象的工厂方法。
	 * @param data 数据对象。
	 * @return 结果对象，状态为成功，包含数据对象。
	 */
	public static Result buildOkResult(Object data){
		return new Result(STATUS_OK, data);
	}
	public static Result buildOkResult(Object data,int isInit){
		return new Result(STATUS_OK, isInit,data);
	}
	
	/**
	 * 构建一个状态为失败的结果对象的工厂方法。
	 * @return 结果对象，状态为失败，无错误信息。
	 */
	public static Result buildErrorResult(){
		return buildErrorResult(null);
	}

	/**
	 * 构建一个状态为FAIL，包含错误的结果对象的工厂方法。
	 * @param errors 错误信息列表。
	 * @return 结果对象，状态为FAIL的值，包含错误信息。
	 */
	public static Result buildErrorResult(CommonError... errors) {
		return buildErrorResult(STATUS_FAIL, errors==null?null:Arrays.asList(errors));
	}

	/**
	 * 构建一个包含错误的结果对象的工厂方法。
	 * @param status 状态值。
	 * @param errors 错误信息列表。
	 * @return 结果对象，状态为非成功的值，包含错误信息。
	 */
	public static Result buildErrorResult(int status, List<CommonError> errors){
		return new Result(status, errors);
	}


	
	/**
	 * 构建一个包含一个具体错误的结果对象的工厂方法。
	 * @param code  错误代码。
	 * @param msg 错误详细信息。
	 * @return 结果对象，状态为非成功的值，包含一个错误。
	 */
	public static Result buildOneErrorResult(String code, String msg){
		CommonError error = new CommonError(code, ErrorType.BIZ, ErrorLevel.WARNING, msg);
		return buildErrorResult(error);
	}
	
	/**
	 * 构建一个系统内部错误的工厂方法。
	 * @return 结果对象，返回的结果信息是系统内部错误。
	 */
	public static Result buildSystemErrorResult(){
		CommonError error = new CommonError("global.system.error", ErrorType.SYS, ErrorLevel.ERROR, "system error, please nofity the administrator.");
		return buildErrorResult(error);
	}
	
	/**
	 * 构建一个用户没有登录错误的工厂方法。
	 * @return 结果对象，返回的结果信息是系统内部错误。
	 */
	public static Result buildUserNotLoginResult(){
		CommonError error = new CommonError("global.user.notLogined", ErrorType.BIZ, ErrorLevel.WARNING,"user not login, no logined user info find.");
		return buildErrorResult(error);
	}

	/**
	 * 构建一个用户没有登录错误的工厂方法。
	 * @return 结果对象，返回的结果信息是系统内部错误。
	 */
	public static Result buildPermissionResult(){
		CommonError error = new CommonError("global.illegality.permission", ErrorType.BIZ, ErrorLevel.WARNING,"user not permission, no user permission info find.");
		return buildErrorResult(error);
	}

	public CommonError CommonFirsttError(){
		return !CollectionUtils.isEmpty(errors)?errors.get(0):null;
	}

	public CommonError CommonLasError(){
		return !CollectionUtils.isEmpty(errors)?errors.get(errors.size()-1):null;
	}
}
