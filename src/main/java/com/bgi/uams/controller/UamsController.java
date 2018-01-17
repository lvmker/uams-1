package com.bgi.uams.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bgi.base.sapcon.RfcMethodExcuteService;
import com.bgi.uams.beans.UamsException;
import com.bgi.uams.beans.UamsResponse;
import com.bgi.uams.services.UamsMethodFactory;
import com.bgi.uams.utils.MD5;
import com.bgi.uams.utils.UtilTools;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Controller
@RequestMapping("/")
public class UamsController {
    private Logger logger=Logger.getLogger(UamsController.class);
        @Autowired
        private DefaultWebSecurityManager securityManager;
        @Autowired
        private RfcMethodExcuteService rfcMethodExcuteService;
        @Autowired
        private UamsMethodFactory uamsMethodFactory;
        private Gson gson=new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {  
            @Override  
            public boolean shouldSkipField(FieldAttributes f) {  
                return f.getName().contains("Pwd");  
            }  
            @Override  
            public boolean shouldSkipClass(Class<?> clazz) {  
                return false;  
            }  
        }).create();
	@RequestMapping("/test")
	@ResponseBody
	public String execute(HttpServletRequest request,HttpServletResponse response) {
	    logger.info("invoke test method");
		return "test";
	}
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) { 
		Subject subject = SecurityUtils.getSubject();  
		String msg=request.getParameter("errormsg");
		if (subject.isAuthenticated()) { 
		    String userName=(String) subject.getPrincipal();
		    ModelAndView modelAndView=new ModelAndView("main");
		    modelAndView.addObject("userName", userName);
		    return modelAndView;
		}else {
		    ModelAndView modelAndView=new ModelAndView("login");
		    if(StringUtils.isNotEmpty(msg)){
		    modelAndView.addObject("errorInfo", msg);
		    }
		    return modelAndView;
		} 
	}
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
	    Subject subject = SecurityUtils.getSubject(); 
		if (subject.isAuthenticated()) { 
		    subject.getSession().stop();
		}
		return "redirect:/index.do";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
	    logger.info("invoke test method");
	    String msg="";
	    try {
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String md5pwd=MD5.getMD5(passWord);
		if(null==SecurityUtils.getSecurityManager()){
		    SecurityUtils.setSecurityManager(securityManager);
		}
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,md5pwd);
		Subject subject=SecurityUtils.getSubject();
		subject.login(usernamePasswordToken);
//		Object object=subject.getPrincipal();
		System.out.println(111);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		msg="user name or password error";
	    }
	    return "redirect:/index.do?errormsg="+msg;
	}
	/**
	 * UAMS对外公共接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/intf")
	public void uamsCommonInterface(HttpServletRequest request,HttpServletResponse response){
		UamsResponse uamsResponse= new UamsResponse();
		try {
		    uamsResponse=uamsMethodFactory.executeMethod(request, response);
		} catch (UamsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uamsResponse.setCode(e.getCode());
			uamsResponse.setMsg(e.getMessage());
		} catch (Exception e) {
		    uamsResponse.setCode(UamsException.ERROR_CODE.ILLEGAL);
		    uamsResponse.setMsg("系统异常");
		}
		String responseJson=gson.toJson(uamsResponse);
		logger.info("invoke webintf return:"+responseJson);
		UtilTools.writeAjaxResult(request, response, responseJson);
	}
	@RequestMapping("/role")
	public String redirectRolePage(HttpServletRequest request,HttpServletResponse response){
		return "/manager/role/role";
	}
	@RequestMapping("/menu")
	public String redirectMenuPage(HttpServletRequest request,HttpServletResponse response){
		return "/manager/menu/menu";
	}
	@RequestMapping("/data")
	public String redirectDataPage(HttpServletRequest request,HttpServletResponse response){
		return "/manager/data/data";
	}
	@RequestMapping("/user")
	public String redirectUserPage(HttpServletRequest request,HttpServletResponse response){
		return "/manager/user/user";
	}
}