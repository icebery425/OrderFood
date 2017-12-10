package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.LogDetail;
import com.worldunion.prophesy.model.LogDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("logDetailMapper")
public interface LogDetailMapper {
    int countByExample(LogDetailExample example);

    int deleteByExample(LogDetailExample example);

    int deleteByPrimaryKey(Long logdetailid);

    int insert(LogDetail record);

    int insertSelective(LogDetail record);

    List<LogDetail> selectByExample(LogDetailExample example);

    LogDetail selectByPrimaryKey(Long logdetailid);

    int updateByExampleSelective(@Param("record") LogDetail record, @Param("example") LogDetailExample example);

    int updateByExample(@Param("record") LogDetail record, @Param("example") LogDetailExample example);

    int updateByPrimaryKeySelective(LogDetail record);

    int updateByPrimaryKey(LogDetail record);
}