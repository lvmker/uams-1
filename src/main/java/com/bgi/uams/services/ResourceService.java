package com.bgi.uams.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgi.uams.beans.Resource;
import com.bgi.uams.beans.UamsException;
import com.bgi.uams.dao.UamsResourceDao;

@Service
public class ResourceService {

    @Autowired
    private UamsResourceDao uamsResourceDao;
	/**
	 * 根据ID更新菜单资源信息
	 * @param UamsResource
	 * @throws UamsException
	 */
	public void updateUamsResourceByResourceId(Resource uamsResource) throws UamsException{
	    try {
		uamsResourceDao.updateUamsResourceByResourceId(uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "更新角色信息出现异常");
	    }
	    
	}
	/**
	 * 根据ID删除菜单资源信息
	 * @param ResourceId
	 * @throws UamsException
	 */
	public void deleteUamsResourceByResourceId(String resourceId) throws UamsException{
	    try {
		uamsResourceDao.deleteUamsResourceByResourceId(resourceId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "删除角色信息出现异常");
	    }
	}
	/**
	 * 获取菜单资源列表
	 * @param UamsResource
	 * @return
	 * @throws UamsException
	 */
	public List<Resource> getUamsResources(Resource uamsResource) throws UamsException{
	    try {
		return uamsResourceDao.getUamsResources(uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取角色信息出现异常");
	    }
	    
	}
	/**
	 * 统计菜单资源信息总数
	 * @param UamsResource
	 * @return
	 * @throws UamsException
	 */
	public Integer getUamsResourcesCount(Resource uamsResource) throws UamsException{
	    try {
		return getUamsResourcesCount(uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "统计角色信息总数出现异常");
	    }
	}
	/**
	 * 新增菜单资源信息
	 * @param UamsResource
	 * @throws UamsException
	 */
	public void createUamsResource(Resource uamsResource) throws UamsException{
	    try {
		uamsResourceDao.createUamsResource(uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增角色信息出现异常");
	    }  
	}
}
