package com.bgi.uams.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bgi.uams.beans.UamsResponse;
import com.bgi.uams.beans.User;
import com.bgi.uams.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/createUser")
    @ResponseBody
    public UamsResponse execute(HttpServletRequest request,HttpServletResponse response) {

	return null;
    }
    
    /**
     * 更新
     */
    @RequestMapping("/updateUamsUserByUserId")
    @ResponseBody
    public UamsResponse updateUamsUserByUserId(User user){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	userService.updateUamsUserByUserId(user);
        	uamsResponse.setRows(user);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;

    }
    
    /**
     * 删除
     */
    @RequestMapping("/deleteUamsUserByUserId")
    @ResponseBody
    public String deleteUamsUserByUserId(String userId){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
			userService.deleteUamsUserByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			uamsResponse.setMsg(e.getMessage());
		}
        return "/manager/user/user";
    }
    
    /**
     * 用户信息列表
     */
    @RequestMapping("/findUamsUsers")
    @ResponseBody
    public UamsResponse findUamsUsers(User uamsUser){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	List<User> user = userService.getUamsUsers(uamsUser);
        	uamsResponse.setTotal(100);
        	uamsResponse.setPages(1);
        	uamsResponse.setPageRows(5);
        	uamsResponse.setRows(user);
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg(e.getMessage());
        }
        return uamsResponse;
    }
    
    /**
     * 保存
     */
    @RequestMapping("/createUamsUser")
    @ResponseBody
    public UamsResponse createUamsUser(User user){
    	UamsResponse uamsResponse =new UamsResponse();
        try {
        	userService.createUamsUser(user);
        	uamsResponse.setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            uamsResponse.setMsg("保存失败");
        }
        return uamsResponse;
    }
    
    @RequestMapping("/getUser")
    @ResponseBody
    public UamsResponse getUamsUser(HttpServletRequest request,HttpServletResponse response) {
	UamsResponse uamsResponse=new UamsResponse();
	try {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
		    
		}
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return uamsResponse;
    }
    
}
