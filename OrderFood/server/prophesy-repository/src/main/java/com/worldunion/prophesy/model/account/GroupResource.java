package com.worldunion.prophesy.model.account;


import com.worldunion.prophesy.model.IdEntity;


public class GroupResource extends IdEntity<String> {
	private Group group;
	private Resource resource;
	
	public GroupResource(){
		
	}
	
	public GroupResource(String id){
		super.setId(id);
	}
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}