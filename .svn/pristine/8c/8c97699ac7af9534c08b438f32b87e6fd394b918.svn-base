package com.bgi.uams.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bgi.uams.beans.Resource;
import com.bgi.uams.beans.UamsException;
@Repository
public class UamsResourceDao {
        @Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
	    return sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/**
	 * 根据ID更新角色信息
	 * @param UamsResource
	 * @throws UamsException
	 */
	public void updateUamsResourceByResourceId(Resource uamsResource) throws UamsException{
	    try {
		sqlSessionTemplate.update("UamsUserMapper.updateUamsResourceByResourceId", uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "更新角色信息出现异常");
	    }
	    
	}
	/**
	 * 根据ID删除角色信息
	 * @param ResourceId
	 * @throws UamsException
	 */
	public void deleteUamsResourceByResourceId(String resourceId) throws UamsException{
	    try {
		sqlSessionTemplate.delete("UamsUserMapper.deleteUamsResourceByResourceId", resourceId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "删除角色信息出现异常");
	    }
	}
	/**
	 * 获取角色信息列表
	 * @param UamsResource
	 * @return
	 * @throws UamsException
	 */
	public List<Resource> getUamsResources(Resource uamsResource) throws UamsException{
	    try {
		return sqlSessionTemplate.selectList("UamsUserMapper.getUamsResources", uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取角色信息出现异常");
	    }
	    
	}
	/**
	 * 统计角色信息总数出现异常
	 * @param UamsResource
	 * @return
	 * @throws UamsException
	 */
	public Integer getUamsResourcesCount(Resource uamsResource) throws UamsException{
	    try {
		return sqlSessionTemplate.selectOne("UamsUserMapper.getUamsResourcesCount", uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "统计角色信息总数出现异常");
	    }
	}
	/**
	 * 新增角色信息出现异常
	 * @param UamsResource
	 * @throws UamsException
	 */
	public void createUamsResource(Resource uamsResource) throws UamsException{
	    try {
		sqlSessionTemplate.insert("UamsUserMapper.createUamsResource", uamsResource);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增角色信息出现异常");
	    }  
	}
	
}
