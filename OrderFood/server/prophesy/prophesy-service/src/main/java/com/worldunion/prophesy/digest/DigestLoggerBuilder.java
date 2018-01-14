package com.worldunion.prophesy.digest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.rpc.RpcContext;

/**
 * Created by 0141434 on 2016-03-01.
 */
public abstract class DigestLoggerBuilder {

    public static String buildMethodInvokeDigest(String methodName, boolean success, Object[] parameters, Object result, long elapseTime) {
        StringBuilder digestBuilder = new StringBuilder();
        digestBuilder.append(DigestLoggerSymbol.LOG_PREFIX);
        digestBuilder.append(buildPerformanceDigest(methodName, success, elapseTime));
        digestBuilder.append(buildInvocationDigest());
        digestBuilder.append(buildParameterDigest(parameters));
        digestBuilder.append(buildResultDigest(result));
        digestBuilder.append(DigestLoggerSymbol.LOG_SUFFIX);
        return digestBuilder.toString();
    }

    public static String buildPerformanceDigest(String methodName, boolean success, long elapseTime) {
        StringBuilder perfDigestBuilder = new StringBuilder();
        perfDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_PREFIX);
        perfDigestBuilder.append(StringUtils.defaultIfBlank(methodName, DigestLoggerSymbol.LOG_DEFAULT));
        perfDigestBuilder.append(DigestLoggerSymbol.LOG_SEP);
        perfDigestBuilder.append(success ? DigestLoggerSymbol.YES : DigestLoggerSymbol.NO);
        perfDigestBuilder.append(DigestLoggerSymbol.LOG_SEP);
        perfDigestBuilder.append(elapseTime);
        perfDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_SUFFIX);
        return perfDigestBuilder.toString();
    }

    public static String buildInvocationDigest() {
        StringBuilder invokeDigestBuilder = new StringBuilder();
        invokeDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_PREFIX);
        String remoteHost = RpcContext.getContext().getRemoteHost();
        invokeDigestBuilder.append(StringUtils.defaultIfBlank(remoteHost, DigestLoggerSymbol.LOG_DEFAULT));
        invokeDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_SUFFIX);
        return invokeDigestBuilder.toString();
    }

    public static String buildParameterDigest(Object[] parameters) {
        StringBuilder paramsDigestBuilder = new StringBuilder();
        paramsDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_PREFIX);
        if (ArrayUtils.isEmpty(parameters)) {
            paramsDigestBuilder.append(DigestLoggerSymbol.LOG_DEFAULT);
        } else {
            for (int i = 0; i < parameters.length; i++) {
                if (i != 0) {
                    paramsDigestBuilder.append(DigestLoggerSymbol.LOG_SEP);
                }
                if (parameters[i] == null) {
                    paramsDigestBuilder.append(DigestLoggerSymbol.LOG_DEFAULT);
                } else {
                    paramsDigestBuilder.append(parameters[i].toString());
                }
            }
        }
        paramsDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_SUFFIX);
        return paramsDigestBuilder.toString();
    }

    public static String buildResultDigest(Object result) {
        StringBuilder resultDigestBuilder = new StringBuilder();
        resultDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_PREFIX);
        resultDigestBuilder.append(result == null ? DigestLoggerSymbol.LOG_DEFAULT : result.toString());
        resultDigestBuilder.append(DigestLoggerSymbol.LOG_PARAM_SUFFIX);
        return resultDigestBuilder.toString();
    }

}