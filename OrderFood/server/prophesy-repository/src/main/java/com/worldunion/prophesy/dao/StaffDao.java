package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.generator.page.Pagination;
import com.worldunion.prophesy.model.account.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("staffDao")
public interface StaffDao {
	public Pagination<Staff> selectByMap(Pagination<Staff> pagination, Map<String, Object> params);

    public List<Staff> selectByMap(Map<String, Object> params);

    public Pagination<Map<String,Object>> searchByMap(Pagination<Map<String, Object>> pagination, Map<String, Object> params);

    public Integer selectCountByMap(Map<String, Object> params);

    public Staff  selectById(Long id);

    /**
     * 全量更新
     * @param staff
     */
    public void update(Staff staff);

    /**
     * 选择更新
     * @param staff
     */
    public void updateBySelective(Staff staff);

    /**
     * 新增
     * @param staff
     * @return
     */
    public int insert(Staff staff);

	public int searchByMapPageCount(Map<String, Object> params);

	public List<Staff> searchByMapPage(Map<String, Object> params);
}