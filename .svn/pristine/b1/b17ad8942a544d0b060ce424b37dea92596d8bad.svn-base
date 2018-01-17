package com.bgi.uams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgi.uams.beans.Data;
import com.bgi.uams.beans.UamsException;
import com.bgi.uams.dao.UamsDataDao;

@Service
public class DataService {
    @Autowired
    private UamsDataDao uamsDataDao;
	/**
	 * 根据ID更新数据信息
	 * @param UamsData
	 * @throws UamsException
	 */
	public void updateUamsDataByDataId(Data uamsData) throws UamsException{
	    try {
		uamsDataDao.updateUamsDataByDataId(uamsData);
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
		uamsDataDao.deleteUamsDataByDataId(dataId);
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
		return uamsDataDao.getUamsDatas(uamsData);
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
		return uamsDataDao.getUamsDatasCount(uamsData);
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
		uamsDataDao.createUamsData(uamsData);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new UamsException(UamsException.ERROR_CODE.ILLEGAL, "新增数据信息出现异常");
	    }  
	}
}
