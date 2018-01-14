package com.worldunion.prophesy.utils.common;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.worldunion.prophesy.utils.common.error.CommonError;
import com.worldunion.prophesy.utils.common.exception.BizCoreException;


public abstract class AssertUtil {

    public static void isTrue(boolean expression, CommonError error) {
        if (!expression) {
            throw new BizCoreException(error);
        }
    }
    

    public static void isNull(Object object, CommonError error) {
        if (object != null) {
            throw new BizCoreException(error);
        }
    }

    public static void notNull(Object object, CommonError error) {
        if (object == null) {
            throw new BizCoreException(error);
        }
    }

    public static void hasLength(String text, CommonError error) {
        if (!StringUtils.hasLength(text)) {
            throw new BizCoreException(error);
        }
    }

    public static void hasText(String text, CommonError error) {
        if (!StringUtils.hasText(text)) {
            throw new BizCoreException(error);
        }
    }

    public static void notEmpty(Object[] array, CommonError error) {
        if (ObjectUtils.isEmpty(array)) {
            throw new BizCoreException(error);
        }
    }

    public static void noNullElements(Object[] array, CommonError error) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    throw new BizCoreException(error);
                }
            }
        }
    }

    public static void notEmpty(Collection<?> collection, CommonError error) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BizCoreException(error);
        }
    }

    public static void notEmpty(Map<?, ?> map, CommonError error) {
        if (CollectionUtils.isEmpty(map)) {
            throw new BizCoreException(error);
        }
    }
}