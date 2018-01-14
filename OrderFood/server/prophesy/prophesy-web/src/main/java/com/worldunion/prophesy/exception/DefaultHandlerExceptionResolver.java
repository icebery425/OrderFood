
package com.worldunion.prophesy.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.worldunion.prophesy.utils.ConvertUtil;
import com.worldunion.prophesy.utils.ObjectMappingCustomer;
import com.worldunion.prophesy.utils.common.error.CommonError;
import com.worldunion.prophesy.utils.common.error.ErrorType;
import com.worldunion.prophesy.utils.common.error.Result;
import com.worldunion.prophesy.utils.common.exception.BizCoreErrors;
import com.worldunion.prophesy.utils.common.exception.BizCoreException;


public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver {



    static MappingJackson2JsonView view = new MappingJackson2JsonView();
    static ModelAndView modelAndView = new ModelAndView();

    static {
        view.setObjectMapper(new ObjectMappingCustomer());
        modelAndView.setView(view);
    }


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CommonError error = null;
        if (ex instanceof BizCoreException) {
            error = ((BizCoreException) ex).getErrorContext().fetchCurrentError();
            error = ErrorType.BIZ.equals(error.getErrorType()) ? error : BizCoreErrors.illegalArgument;
        } else {
            error = BizCoreErrors.unknowError;
        }
        ex.printStackTrace();

        view.setAttributesMap(ConvertUtil.convertToMap(Result.buildErrorResult(error)));
        return modelAndView;
    }
}