package com.bgi.uams.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bgi.uams.beans.Data;
import com.bgi.uams.beans.UamsException;
@Repository 
public class UamsDataDao {
    
        @Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
	    return sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	    this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/**
	 * 根据ID更新数据信息
	 * @param UamsData
	 * @throws UamsException
	 */
	public void updateUamsDataByDataId(Data uamsData) throws UamsException{
	    try {
		sqlSessionTemplate.update("UamsUserMapper.updateUamsDataByDataId", uamsData);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "更新数据信息出现异常");
	    }
	    
	}
	/**
	 * 根据ID删除数据信息
	 * @param DataId
	 * @throws UamsException
	 */
	public void deleteUamsDataByDataId(String dataId) throws UamsException{
	    try {
		sqlSessionTemplate.delete("UamsUserMapper.deleteUamsDataByDataId", dataId);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "删除数据信息出现异常");
	    }
	}
	/**
	 * 获取数据信息列表
	 * @param UamsData
	 * @return
	 * @throws UamsException
	 */
	public List<Data> getUamsDatas(Data uamsData) throws UamsException{
	    try {
		return sqlSessionTemplate.selectList("UamsUserMapper.getUamsDatas", uamsData);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "获取数据信息出现异常");
	    }
	    
	}
	/**
	 * 统计数据信息总数出现异常
	 * @param UamsData
	 * @return
	 * @throws UamsException
	 */
	public Integer getUamsDatasCount(Data uamsData) throws UamsException{
	    try {
		return sqlSessionTemplate.selectOne("UamsUserMapper.getUamsDatasCount", uamsData);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "统计数据信息总数出现异常");
	    }
	}
	/**
	 * 新增数据信息出现异常
	 * @param UamsData
	 * @throws UamsException
	 */
	public void createUamsData(Data uamsData) throws UamsException{
	    try {
		sqlSessionTemplate.insert("UamsUserMapper.createUamsData", uamsData);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增数据信息出现异常");
	    }  
	}
}
