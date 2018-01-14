package com.worldunion.prophesy.interceptor;

import com.worldunion.prophesy.digest.DigestLoggerBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by 0141434 on 2016-03-01.
 */
public class ServiceInvokeLoggerInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ServiceInvokeLoggerInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        boolean success = false;
        String className = methodInvocation.getMethod().getDeclaringClass().getSimpleName();
        String methodName = className + "." + methodInvocation.getMethod().getName();
        Object[] parameters = methodInvocation.getArguments();
        Object result = null;
        try {
            result = methodInvocation.proceed();
            success = true;
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            if(className.contains("Facade"))
            logger.info(DigestLoggerBuilder.buildMethodInvokeDigest(methodName, success, parameters, result, endTime - startTime));
        }
    }
}
