package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.core.UserHolder;
import com.worldunion.prophesy.dao.LogDAO;
import com.worldunion.prophesy.dao.LogDetailDao;
import com.worldunion.prophesy.model.Log;
import com.worldunion.prophesy.model.LogDetail;
import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.service.base.LogService;
import com.worldunion.prophesy.utils.common.ParamsUtils;
import com.worldunion.prophesy.model.util.SystemVariableUtils;

@Service(value = "logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDAO logDao;
	
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	
	@Override
	public void add(Log log,HttpServletRequest request) {
		log.setLoginip(ParamsUtils.getRemoteHost(request)  );
		log.setUrlinfo(request.getRequestURL().toString());
		this.logDao.add(log);
		if(log.getDetail()!=null && log.getDetail().size()>0){
			batchInsertLogDetail(log);
		}
	}
	@Override
	public void add(Log log) {
		HttpServletRequest request=ParamsUtils.getRequest();
		Staff user =  SystemVariableUtils.getSessionVariable().getStaff(); 
		log.setLoginip(ParamsUtils.getRemoteHost(request)  );
		log.setUrlinfo(request.getRequestURL().toString());
		log.setStaffid( user.getStaffid());
		this.logDao.add(log);
		if(log.getDetail().size()>0){
			batchInsertLogDetail(log);
		}
		
	}
	@Override
	public void addApp(Log log) {
		HttpServletRequest request=ParamsUtils.getRequest();
		Staff user =   UserHolder.get();
		log.setLoginip(ParamsUtils.getRemoteHost(request)  );
		log.setUrlinfo(request.getRequestURL().toString());
		log.setStaffid( user.getStaffid());
		this.logDao.add(log);
		if(log.getDetail().size()>0){
			batchInsertLogDetail(log);
		}
		
	}

	/**
	 * 批量插入日志明细
	 * @param log
	 */
	private void batchInsertLogDetail(Log log){
		
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.getObject().openSession(ExecutorType.BATCH,false);
			LogDetailDao logDetailDao = sqlSession.getMapper(LogDetailDao.class);
			Long logid=Long.valueOf(log.getLogid());
			for (LogDetail logDetail2 : log.getDetail()) {
				logDetail2.setLogid(logid);
				logDetailDao.addDetail(logDetail2);
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}

	}



	@Override
	public List<Map<String, Object>> queryPVUVEchartsByDay(Map<String, Object> map) {

		String dateType = (String)map.get("dateType");
		if(dateType.equals("DAY")){
			return logDao.queryPerHourPVUVByDay(map);
		}else{
			return logDao.queryPVUVByDay(map);
		}
	}


	@Override
	public int queryPVUVTableDataCount(Map<String, Object> map) {

		String dateType = (String)map.get("dateType");
		if(dateType.equals("DAY")){
			return logDao.queryPerHourPVUVByDayFromTableCount(map);
		}else{
			return logDao.queryPVUVByDayFromTableCount(map);
		}

	}

	@Override
	public List<Map<String, Object>> queryPVUVTableData(Map<String, Object> map) {

		String dateType = (String)map.get("dateType");
		if(dateType.equals("DAY")){
			return logDao.queryPerHourPVUVByDayFromTable(map);
		}else{
			return logDao.queryPVUVByDayFromTable(map);
		}

	}


	@Override
	public int queryMenuPVByDateCount(Map<String, Object> map) {
		return logDao.queryMenuPVByDateCount(map);
	}

	@Override
	public List<Map<String, Object>> queryMenuPVByDate(Map<String, Object> map) {
		return logDao.queryMenuPVByDate(map);
	}


	@Override
	public int queryModelPVByMenuCount(Map<String, Object> map) {
		return logDao.queryModelPVByMenuCount(map);
	}

	@Override
	public List<Map<String, Object>> queryModelPVByMenuDate(Map<String, Object> map) {
		return logDao.queryModelPVByMenuDate(map);
	}


	@Override
	public List<Map<String, Object>> queryLogMenuList(Map<String, Object> map) {
		return logDao.queryLogMenuList(map);
	}

	@Override
	public int queryLogPVDetailCount(Map<String, Object> map) {
		return logDao.queryLogPVDetailCount(map);
	}

	@Override
	public List<Map<String, Object>> queryLogPVDetail(Map<String, Object> map) {
		return logDao.queryLogPVDetail(map);
	}
}
