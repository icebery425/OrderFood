package com.worldunion.prophesy.utils.common.error;

public class CommonError {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private ErrorType errorType;
    private ErrorLevel errorLevel;
    private String errorDesc;

    public CommonError(String errorCode, ErrorType errorType, ErrorLevel errorLevel, String errorDesc) {
        super();
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorLevel = errorLevel;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public ErrorLevel getErrorLevel() {
        return errorLevel;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public CommonError message(String message) {
        return new CommonError(errorCode, errorType, errorLevel, errorDesc + "[" + message + "]");
    }
}