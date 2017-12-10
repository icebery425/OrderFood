package com.worldunion.prophesy.service.security;


import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.service.account.ResourceService;


/**
 * 借助spring {@link FactoryBean} 对apache shiro的premission进行动态创建
 *
 *
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Section> {

	@Autowired
	private ResourceService resourceService;

	//shiro默认的链接定义
	private String filterChainDefinitions;

	/**
	 * 通过filterChainDefinitions对默认的链接过滤定义
	 *
	 * @param filterChainDefinitions 默认的接过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	@Override
	public Section getObject() throws BeansException {
		Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);

        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        
        //循环数据库资源的url
        for (Resource resource : resourceService.getResources()) {
        	if(StringUtils.isNotEmpty(resource.getValue()) && StringUtils.isNotEmpty(resource.getPermission())) {
        		section.put(resource.getValue(), resource.getPermission());
        	}
        }
        
        return section;
	}
	
	@Override
	public Class<?> getObjectType() {
		return Section.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}

	
}
