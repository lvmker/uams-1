package com.bgi.uams.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bgi.uams.beans.UamsException;
import com.bgi.uams.beans.User;
public class UamsUserDao {
    
	private SqlSessionTemplate sqlSessionTemplate;
	public User getUamsUser(String userName) throws UamsException{
	    User uamsUser=new User();
	    uamsUser.setUserEmail(userName);
	    List<User> users= getUamsUsers(uamsUser);
	    if(null!=users&&users.size()>0){
		return users.get(0);
	    }
	    return null;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
	    return sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/**
	 * 根据ID更新用户信息
	 * @param uamsUser
	 * @throws UamsException
	 */
	public void updateUamsUserByUserId(User uamsUser) throws UamsException{
	    try {
		sqlSessionTemplate.update("UamsUserMapper.updateUamsUserByUserId", uamsUser);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "更新用户信息出现异常");
	    }
	    
	}
	/**
	 * 根据ID删除用户信息
	 * @param userId
	 * @throws UamsException
	 */
	public void deleteUamsUserByUserId(String userId) throws UamsException{
	    try {
		sqlSessionTemplate.delete("UamsUserMapper.deleteUamsUserByUserId", userId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "删除用户信息出现异常");
	    }
	}
	
	/**
	 * 获取用户信息列表
	 * @param uamsUser
	 * @return
	 * @throws UamsException
	 */
	public List<User> getUamsUsers(User uamsUser) throws UamsException{
	    try {
		return sqlSessionTemplate.selectList("UamsUserMapper.getUamsUsers", uamsUser);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取用户信息出现异常");
	    }
	    
	}
	
	/**
	 * 获取用户信息列表
	 * @param uamsUser
	 * @return
	 * @throws UamsException
	 */
	public List<User> getDetailUamsUsers(User uamsUser) throws UamsException{
	    try {
		return sqlSessionTemplate.selectList("UamsUserMapper.getDetailUamsUsers", uamsUser);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取用户详细信息出现异常");
	    }
	    
	}
	/**
	 * 统计用户信息总数出现异常
	 * @param uamsUser
	 * @return
	 * @throws UamsException
	 */
	public Integer getUamsUsersCount(User uamsUser) throws UamsException{
	    try {
		return sqlSessionTemplate.selectOne("UamsUserMapper.getUamsUsersCount", uamsUser);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "统计用户信息总数出现异常");
	    }
	}
	/**
	 * 新增用户信息出现异常
	 * @param uamsUser
	 * @throws UamsException
	 */
	public void createUamsUser(User uamsUser) throws UamsException{
	    try {
		sqlSessionTemplate.insert("UamsUserMapper.createUamsUser", uamsUser);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增用户信息出现异常");
	    }  
	}
	/**
	 * 保存用户授权角色信息
	 * @param UamsRole
	 * @return
	 * @throws UamsException
	 */
	public void saveUamsUserAndRole(@Param("userId") Long userId, @Param("roleId") Long roleId) throws UamsException{
	    try {
    	Map<Long,Long> map = new HashMap<Long,Long>();
	    map.put(userId, roleId);
		sqlSessionTemplate.insert("UamsUserMapper.saveUamsUserAndRole", map);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "保存用户和角色授权信息出现异常");
	    }
	    
	}
	/**
	 * 保存用户和数据授权信息
	 * @param uamsUser
	 * @throws UamsException
	 */
	public void saveUamsUserAndData(@Param("userId") Long userId, @Param("dataId") Long dataId) throws UamsException{
		try {
		Map<Long,Long> map = new HashMap<Long,Long>();
	    map.put(userId, dataId);
		sqlSessionTemplate.insert("UamsUserMapper.saveUamsUserAndData", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "保存用户和数据授权信息出现异常");
		}  
	}
}
