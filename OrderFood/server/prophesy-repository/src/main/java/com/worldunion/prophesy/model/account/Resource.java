package com.worldunion.prophesy.model.account;

import java.util.ArrayList;
import java.util.List;

import com.worldunion.prophesy.model.IdEntity;


public class Resource extends IdEntity<String> {
	/**
	 * 通过用户id和资源类型获取该用户下的所有资源
	 */
	
	//名称
	private String name;
	//action url
	private String value;
	//父类
	private Resource parent;
	//顺序值
	private Integer sort;
	//是否包含叶子节点
	private Boolean leaf = Boolean.FALSE;
	//子类
	private List<Resource> children = new ArrayList<Resource>();
	//备注
	private String remark;
	//资源类型
	private String type;//Menu("01","菜单类型"),Security("02","安全类型");
	//资源所对应的组集合
	private List<Group> groupsList = new ArrayList<Group>();
	//shiro permission 字符串
	private String permission;
	//图标
	private String icon;
	
	/**
	 * 构造方法
	 */
	public Resource() {
		
	}

	public Resource(String id) {
		super.setId(id);
	}
	/**
	 * 获取资源名称
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置资源名称
	 * 
	 * @param name 资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取资源操作URL
	 * 
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置资源操作URL
	 * 
	 * @param value 资源操作URL
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取父类资源
	 * 
	 * @return {@link Resource}
	 */
	public Resource getParent() {
		return parent;
	}

	/**
	 * 设置父类资源
	 * 
	 * @param parent 父类资源
	 */
	public void setParent(Resource parent) {
		this.parent = parent;
	}

	/**
	 * 获取顺序值
	 * 
	 * @return Integer
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置顺序值
	 * 
	 * @param sort 顺序值
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	
	/**
	 * 获取当前资源是否包含叶子节点,如果是返回ture，否则返回false
	 * 
	 * @return Boolean
	 */
	public Boolean getLeaf() {
		return this.leaf;
	}
	
	/**
	 * 设置当前资源是否包含叶子节点,
	 * 
	 * @return Boolean ture表示是，否则返回false
	 */
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * 获取子类资源
	 * 
	 * @return List
	 */
	public List<Resource> getChildren() {
		return children;
	}

	/**
	 * 设置子类资源
	 * 
	 * @param children 子类资源
	 */
	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	/**
	 * 获取备注
	 * 
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取资源类型
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置资源类型
	 * @param type 类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取该资源对应的组集合
	 * 
	 * @return List
	 */
	public List<Group> getGroupsList() {
		return groupsList;
	}

	/**
	 * 设置该资源对应的组集合
	 * 
	 * @param groupsList 组集合
	 */
	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}

	/**
	 * 获取父类名称
	 * 
	 * @return String 
	 */
	public String getParentName() {
		
		return this.parent == null ? "" : parent.getName();
	}
	
	/**
	 * 获取父类ID
	 * 
	 * @return String
	 */
	public String getParentId() {
		return this.parent == null ? "" : parent.getId();
	}

	/**
	 * 获取permission字符串
	 * 
	 * @return String 
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * 设置permission字符串
	 * @param permission 字符串
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * 获取资源图标
	 * 
	 * @return String
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置资源图标
	 * @param icon 图标css class
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
}