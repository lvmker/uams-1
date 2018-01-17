package com.bgi.uams.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bgi.uams.beans.Role;
import com.bgi.uams.beans.UamsResponse;
import com.bgi.uams.services.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
   
    /**
     * 更新
     */
    @RequestMapping("/updateUamsUserByUserId")
    @ResponseBody
    public UamsResponse updateUamsUserByUserId(Role uamsRole){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	roleService.updateUamsRoleByRoleId(uamsRole);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;

    }
    
    /**
     * 删除
     */
    @RequestMapping("/deleteUamsRoleByRoleId")
    @ResponseBody
    public String deleteUamsRoleByRoleId(String roleId){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
			roleService.deleteUamsRoleByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			uamsResponse.setMsg(e.getMessage());
		}
        return "/manager/role/role";
    }
    
    /**
     * 角色信息列表
     */
    @RequestMapping("/findUamsRoles")
    @ResponseBody
    public UamsResponse findUamsRoles(Role uamsRole){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	List<Role> role = roleService.getUamsRoles(uamsRole);
        	uamsResponse.setTotal(100);
        	uamsResponse.setPages(1);
        	uamsResponse.setPageRows(5);
        	uamsResponse.setRows(role);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;
    }

    /**
     * 保存
     */
    @RequestMapping("/createUamsRole")
    @ResponseBody
    public UamsResponse createUamsRole(Role uamsRole){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	roleService.createUamsRole(uamsRole);
        	uamsResponse.setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg("保存失败");
        }
        return uamsResponse;
    }
    
}
