package com.bgi.uams.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bgi.uams.beans.Resource;
import com.bgi.uams.beans.UamsResponse;
import com.bgi.uams.services.ResourceService;

@Controller
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    
    
    /**
     * 更新
     */
    @RequestMapping("/updateUamsResourceByResourceId")
    @ResponseBody
    public UamsResponse updateUamsResourceByResourceId(Resource uamsResource){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	resourceService.updateUamsResourceByResourceId(uamsResource);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;

    }
    
    /**
     * 删除
     */
    @RequestMapping("/deleteUamsResourceByResourceId")
    public String deleteUamsResourceByResourceId(String resourceId){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
			resourceService.deleteUamsResourceByResourceId(resourceId);
		} catch (Exception e) {
			e.printStackTrace();
			uamsResponse.setMsg(e.getMessage());
		}
        return "/manager/menu/menu";
    }
    
    /**
     * 资源信息列表
     */
    @RequestMapping("/findUamsResources")
    @ResponseBody
    public UamsResponse findUamsResources(Resource uamsResource){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	List<Resource> resource = resourceService.getUamsResources(uamsResource);
        	uamsResponse.setRows(resource);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;
    }

    /**
     * 保存
     */
    @RequestMapping("/createUamsResource")
    public String createUamsResource(Resource uamsResource){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	resourceService.createUamsResource(uamsResource);
        	uamsResponse.setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg("保存失败");
        }
        return "/manager/menu/menu";
    }
    
}
