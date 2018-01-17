package com.bgi.uams.beans;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias(value="UamsRole")
public class Role extends PaginationParams{
    
	private String roleId;
	private String roleName;
	private String lastModifiedUser;//
	private String lastModifiedTime;//
	private String systemCode;//
	private String userId;//
	private List<Resource> resources;
	
	public String getUserId() {
	    return userId;
	}
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	public List<Resource> getResources() {
	    return resources;
	}
	public void setResources(List<Resource> resources) {
	    this.resources = resources;
	}
	public String getRoleId() {
	    return roleId;
	}
	public void setRoleId(String roleId) {
	    this.roleId = roleId;
	}
	public String getRoleName() {
	    return roleName;
	}
	public void setRoleName(String roleName) {
	    this.roleName = roleName;
	}
	public String getLastModifiedUser() {
	    return lastModifiedUser;
	}
	public void setLastModifiedUser(String lastModifiedUser) {
	    this.lastModifiedUser = lastModifiedUser;
	}
	public String getLastModifiedTime() {
	    return lastModifiedTime;
	}
	public void setLastModifiedTime(String lastModifiedTime) {
	    this.lastModifiedTime = lastModifiedTime;
	}
	public String getSystemCode() {
	    return systemCode;
	}
	public void setSystemCode(String systemCode) {
	    this.systemCode = systemCode;
	}
	
}
