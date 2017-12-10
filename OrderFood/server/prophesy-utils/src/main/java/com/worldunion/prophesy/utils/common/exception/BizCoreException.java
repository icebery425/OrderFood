package com.worldunion.prophesy.utils.common.exception;

import com.worldunion.prophesy.utils.common.error.CommonError;
import com.worldunion.prophesy.utils.common.error.ErrorContext;


/**
 * 系统级别异常
 * Created by starhousexq on 2015/11/21.
 */
public class BizCoreException  extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private ErrorContext errorContext;

    public BizCoreException(CommonError error) {
        super(error.getErrorDesc());
        this.errorContext = new ErrorContext(error);
    }

    public BizCoreException(ErrorContext errorContext) {
        super(errorContext.fetchCurrentError() == null ? null : errorContext.fetchCurrentError().getErrorDesc());
        this.errorContext = errorContext;
    }

    public ErrorContext getErrorContext() {
        return errorContext;
    }
}
