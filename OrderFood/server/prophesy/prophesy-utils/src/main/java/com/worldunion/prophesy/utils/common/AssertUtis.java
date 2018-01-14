package com.worldunion.prophesy.utils.common;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AssertUtis extends Assert {
    private final static Map<String, Object> classNameCacheMap = new ConcurrentHashMap<String, Object>();
    private final static Object classNameCacheMapItemValue = new Object();

    public static void hasOneValue(Collection<? extends Object> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
        if (collection.size() != 1) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 系统中是不是存在这个类
     *
     * @param className 类的全路径
     */
    public static void hasClassName(String className, String msg) {
        if (classNameCacheMap.containsKey(className)) {
            return;
        }
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(msg, e);
        }
        classNameCacheMap.put(className, classNameCacheMapItemValue);
    }

    public static void asBoolean(Object obj, String msg) {
        AssertUtis.notNull(obj, msg);
        try {
            Boolean.parseBoolean(obj.toString());
        } catch (Exception e) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void asString(Object obj, String msg) {
        AssertUtis.notNull(obj, msg);
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void eqArrLength(Object[] objs, int length, String msg) {
        AssertUtis.notEmpty(objs, msg);
        if (objs.length != length) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void asCollection(Object v, String msg) {
        if (v instanceof Collection) {
            return;
        }
        throw new IllegalArgumentException(msg);
    }

    public static void asClass(Object obj, Class<?> cls, String msg) {
        AssertUtis.notNull(obj, msg);
        AssertUtis.notNull(cls, msg);
        final boolean b = cls.isAssignableFrom(obj.getClass());
        if (b) {
            return;
        }
        throw new IllegalArgumentException(msg);
    }

}