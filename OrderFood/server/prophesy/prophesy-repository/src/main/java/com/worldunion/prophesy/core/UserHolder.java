package com.worldunion.prophesy.core;

import com.worldunion.prophesy.model.account.Staff;

public class UserHolder {

    private static final ThreadLocal<Staff> userHolder = new ThreadLocal<Staff>();

    public static Staff get() {
        return userHolder.get();
    }

    public static void setUserInfo(Staff userInfo) {
    	userHolder.set(userInfo);
    }

    public static void clear() {
    	userHolder.remove();
    }
}
