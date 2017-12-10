package com.worldunion.prophesy.utils.common.exception;

import com.worldunion.prophesy.utils.common.error.CommonError;
import com.worldunion.prophesy.utils.common.error.ErrorLevel;
import com.worldunion.prophesy.utils.common.error.ErrorType;


/**
 * Created by starhousexq on 2015/11/21.
 */
public abstract class BizCoreErrors {
    public static final CommonError systemError = new CommonError("ERROR001", ErrorType.SYS, ErrorLevel.ERROR, "系统异常");
    public static final CommonError illegalArgument = new CommonError("ERROR002", ErrorType.BIZ, ErrorLevel.ERROR, "非法参数");
    public static final CommonError bizError = new CommonError("ERROR005", ErrorType.BIZ, ErrorLevel.ERROR, "业务异常");
    public static final CommonError unknowError = new CommonError("ERROR004", ErrorType.BIZ, ErrorLevel.ERROR, "未知异常");
}
