package com.worldunion.prophesy.utils.common.error;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starhousexq on 2015/11/21.
 */
public class ErrorContext  implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<CommonError> errorStack = new ArrayList<CommonError>();

    public ErrorContext(CommonError error) {
        super();
        this.addError(error);
    }

    public void addError(CommonError error) {
        this.errorStack.add(error);
    }

    public CommonError fetchCurrentError() {
        return CollectionUtils.isEmpty(this.errorStack) ? null : this.errorStack.get(this.errorStack.size() - 1);
    }

    public CommonError fetchRootError() {
        return CollectionUtils.isEmpty(this.errorStack) ? null : this.errorStack.get(0);
    }

    public List<CommonError> getErrorStack() {
        return errorStack;
    }
}
