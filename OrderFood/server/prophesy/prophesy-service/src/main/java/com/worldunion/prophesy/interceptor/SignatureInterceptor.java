package com.worldunion.prophesy.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 0141434 on 2016-03-29.
 */
public class SignatureInterceptor implements MethodInterceptor {

    @Autowired
   /* private KeyService keyService;*/


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String className = methodInvocation.getMethod().getDeclaringClass().getSimpleName();
        //String methodName = className + "." + methodInvocation.getMethod().getName();
        Object[] parameters = methodInvocation.getArguments();
        String citycode = null;
        /*if (className.contains("Facade")) {
            Object object = parameters[0];
            AbstractRequest request = (AbstractRequest) parameters[0];

            //1）KEY 与 Pid 是否存在配置表中
            //2)是否在黑名单
            //3)数据权限
            //4)访问日志
            if (StringUtils.isNotBlank(request.getAk()) && StringUtils.isNotBlank(request.getProductId())) {
                Key key = keyService.findKey(request.getProductId(), request.getAk());
                Assert.notNull(key, "非法请求，未配置正确的密钥!");
                boolean flag = keyService.isExistBlackList(key.getKeyid());
                Assert.isTrue(!flag, "非法请求，该key在黑名单!");

                KeyUseBill keyUseBill = new KeyUseBill();
                keyUseBill.setKeyid(key.getKeyid());
                if (className.contains("Service")) {
                    String name = className.replace("Service", "").toUpperCase();
                    keyUseBill.setModulename(name);
                } else {
                	keyUseBill.setModulename(className);
                }
            	keyUseBill.setModulename(className);
                keyUseBill.setMethodname(methodInvocation.getMethod().getName());
                keyUseBill.setSdkversion(request.getVersionId());
                keyService.saveMethodInvokeLog(keyUseBill);
            } else {
                Assert.notNull(request.getAk(), "请求密钥不能为空");
                Assert.notNull(request.getProductId(), "请求产品编号不能为空");
            }

        }*/
        Object result = null;
        result = methodInvocation.proceed();

        return result;

    }


}
