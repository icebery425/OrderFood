package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.LogDetail;
import org.springframework.stereotype.Repository;

@Repository("logDetailDao")
public interface LogDetailDao {
	
	void addDetail(LogDetail logDetail);
	
	void addDetailSelective(LogDetail logDetail);
	
}