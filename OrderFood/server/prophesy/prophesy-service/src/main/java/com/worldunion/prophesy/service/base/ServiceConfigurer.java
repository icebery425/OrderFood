package com.worldunion.prophesy.service.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfigurer {

    @Value("${profile.threshold}")
    private Integer profileThreshold;


    public Integer getProfileThreshold() {
        return profileThreshold;
    }



    

}