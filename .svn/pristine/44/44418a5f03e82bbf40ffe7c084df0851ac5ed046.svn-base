/**
 * ������
 */
package com.bgi.uams.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author MaJunjie
 *
 */
public class WealthInterceptor implements HandlerInterceptor  {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView view) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return true;
	}

	
}
