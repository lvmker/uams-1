package com.bgi.uams.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgi.uams.beans.Role;
import com.bgi.uams.beans.UamsException;
import com.bgi.uams.beans.User;
import com.bgi.uams.dao.UamsRoleDao;

@Service
public class RoleService {
    @Autowired
    private UamsRoleDao uamsRoleDao;
    
	/**
	 * 根据ID更新角色信息
	 * @param UamsRole
	 * @throws UamsException
	 */
	public void updateUamsRoleByRoleId(Role uamsRole) throws UamsException{
	    try {
		uamsRoleDao.updateUamsRoleByRoleId(uamsRole);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "更新角色信息出现异常");
	    }
	    
	}
	/**
	 * 根据ID删除角色信息
	 * @param RoleId
	 * @throws UamsException
	 */
	public void deleteUamsRoleByRoleId(String roleId) throws UamsException{
	    try {
		uamsRoleDao.deleteUamsRoleByRoleId(roleId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "删除角色信息出现异常");
	    }
	}
	/**
	 * 获取角色信息列表
	 * @param UamsRole
	 * @return
	 * @throws UamsException
	 */
	public List<Role> getUamsRoles(Role uamsRole) throws UamsException{
	    try {
		return uamsRoleDao.getUamsRoles(uamsRole);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取角色信息出现异常");
	    }
	    
	}
	/**
	 * 统计角色信息总数出现异常
	 * @param UamsRole
	 * @return
	 * @throws UamsException
	 */
	public Integer getUamsRolesCount(Role uamsRole) throws UamsException{
	    try {
		return uamsRoleDao.getUamsRolesCount(uamsRole);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "统计角色信息总数出现异常");
	    }
	}
	/**
	 * 新增角色信息出现异常
	 * @param UamsRole
	 * @throws UamsException
	 */
	public void createUamsRole(Role uamsRole) throws UamsException{
	    try {
		uamsRoleDao.createUamsRole(uamsRole);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增角色信息出现异常");
	    }  
	}
	/**
	 * 保存角色和菜单资源授权信息
	 * @param UamsResource
	 * @throws UamsException
	 */
	public void saveUamsRoleAndResource(@Param("roleId") Long roleId, @Param("resourceId") Long resourceId) throws UamsException{
	    try {
	    uamsRoleDao.saveUamsRoleAndResource(roleId,resourceId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "保存角色和菜单资源授权信息出现异常");
	    }  
	}
}
