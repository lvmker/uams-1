package com.bgi.uams.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bgi.uams.beans.Data;
import com.bgi.uams.beans.UamsResponse;
import com.bgi.uams.services.DataService;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;
   
    
    /**
     * 更新
     */
    @RequestMapping("/updateUamsDataByDataId")
    @ResponseBody
    public UamsResponse updateUamsDataByDataId(Data uamsData){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	dataService.updateUamsDataByDataId(uamsData);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;

    }
    
    /**
     * 删除
     */
    @RequestMapping("/deleteUamsDataByDataId")
    @ResponseBody
    public String deleteUamsDataByDataId(String dataId){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
			dataService.deleteUamsDataByDataId(dataId);
		} catch (Exception e) {
			e.printStackTrace();
			uamsResponse.setMsg(e.getMessage());
		}
        return "/manager/data/data";
    }
    
    /**
     * 数据信息列表
     */
    @RequestMapping("/findUamsDatas")
    @ResponseBody
    public UamsResponse findUamsDatas(Data uamsData){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	List<Data> datas = dataService.getUamsDatas(uamsData);
        	uamsResponse.setTotal(100);
        	uamsResponse.setPages(1);
        	uamsResponse.setPageRows(5);
        	uamsResponse.setRows(datas);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;
    }

    /**
     * 保存
     */
    @RequestMapping("/createUamsData")
    @ResponseBody
    public String createUamsData(Data uamsData){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	dataService.createUamsData(uamsData);
        	uamsResponse.setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg("保存失败");
        }
        return "/manager/data/data";
    }
    
}
