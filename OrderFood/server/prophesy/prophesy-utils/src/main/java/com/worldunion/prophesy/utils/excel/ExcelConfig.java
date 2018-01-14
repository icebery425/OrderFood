package com.worldunion.prophesy.utils.excel;

/**
 * Created by liuruiyan on 2017/4/19.
 */
public class ExcelConfig {
    /**
     * 工程名
     */
    private static String projectName;

    public static void setProjectName(String projectName) {
        ExcelConfig.projectName = projectName;
    }

    public static String getProjectName() {
        return projectName;
    }
}
