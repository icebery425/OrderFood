package com.worldunion.prophesy.utils.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by liuruiyan on 2017/5/16.
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer {


    private static Map<String,String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

    //static method for accessing context properties

    /**
     * 直接通过key获取properties文件中的value
     * @param name
     * @return
     */
    public static String getProperty(String name) {
        return propertyMap.get(name);
    }







}
