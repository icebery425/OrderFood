package com.worldunion.prophesy.model.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.worldunion.prophesy.model.IdEntity;


public class Group extends IdEntity<String> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 名称
	private String name;
	// 成员
	private List<Staff> membersList = new ArrayList<Staff>();
	// 上级组
	private Group parent;
	// 下级组集合
	private List<Group> children = new ArrayList<Group>();
	// 类型
	private String type;// /**Organization("01","机构"),Department("02","部门"),
	// 备注
	// RoleGorup("03","角色组");
	private String remark;
	// 状态
	private Integer state;
	// 是否包含叶子节点
	private Boolean leaf = Boolean.FALSE;
	// 拥有资源
	private List<Resource> resourcesList = new ArrayList<Resource>();

	private String createTime;



	/**
	 * 构造方法
	 */
	public Group() {

	}

	public Group(String id) {
		super.setId(id);
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取组名称
	 * 
	 * @return String
	 */



	public String getName() {
		return name;
	}

	/**
	 * 设置组名称
	 * 
	 * @param name
	 *            组名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取上级组
	 * 
	 * @return {@link Group}
	 */

	public Group getParent() {
		return parent;
	}

	/**
	 * 设置上级组
	 * 
	 * @param parent
	 *            组实体
	 */
	public void setParent(Group parent) {
		this.parent = parent;
	}

	/**
	 * 获取下级组集合
	 * 
	 * @return List
	 */
	public List<Group> getChildren() {

		return children;
	}

	/**
	 * 设置下级组集合
	 * 
	 * @param children
	 *            下级组集合
	 */
	public void setChildren(List<Group> children) {
		this.children = children;
	}

	/**
	 * 获取组成员
	 * 
	 * @return List
	 */
	public List<Staff> getMembersList() {
		return membersList;
	}

	/**
	 * 设置组成员
	 * 
	 * @param membersList
	 *            用户集合
	 */
	public void setMembersList(List<Staff> membersList) {
		this.membersList = membersList;
	}

	/**
	 * 获取拥有资源
	 * 
	 * @return List
	 */
	public List<Resource> getResourcesList() {
		return resourcesList;
	}

	/**
	 * 设置该组的操作资源
	 * 
	 * @param resourcesList
	 *            资源集合
	 */
	public void setResourcesList(List<Resource> resourcesList) {
		this.resourcesList = resourcesList;
	}

	/**
	 * 获取组类型
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置组类型
	 * 
	 * @param type
	 *            类型
	 * 
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取组状态
	 * 
	 * @return
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置组状态
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 设置当前实体是否包含子节点
	 * 
	 * @param leaf
	 *            ture表示是,false表示不是
	 */
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * 获取当前实体是否包含子节点,如果是返回ture，否则返回false
	 * 
	 * @return Boolean
	 */
	public Boolean getLeaf() {
		return leaf;

	}

	/**
	 * 获取父类ID
	 * 
	 * @return String
	 */
	public String getParentId() {
		return null;
		// return this.parent == null ? "" : this.parent.getId();
	}

	/**
	 * 获取父类名称
	 * 
	 * @return String
	 */
	public String getParentName() {
		return this.parent == null ? "" : this.parent.getName();
	}
}