package com.bgi.uams.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bgi.uams.beans.UamsException;
import com.bgi.uams.beans.UamsResponse;
@Service
public class UamsMethodFactory{
    private Logger logger = Logger.getLogger("intf");
    @Autowired
    private BeanPostProcessorImpl beanPostProcessorImpl;
    @SuppressWarnings("rawtypes")
    private Map<String, String> getParameterMap(HttpServletRequest request) {
	Map<String, String> paramsMap = new HashMap<>();
	Enumeration enumeration = request.getParameterNames();
	while (enumeration.hasMoreElements()) {
	    String paramName = (String) enumeration.nextElement();
	    String paramValue = request.getParameter(paramName);
	    // 形成键值对应的map
	    paramsMap.put(paramName, paramValue);
	}
	return paramsMap;
    }
    @SuppressWarnings("rawtypes")
    public UamsResponse executeMethod(HttpServletRequest request,
	    HttpServletResponse response) throws UamsException {
	try {
	    Map params = getParameterMap(request);
	    if (!params.containsKey("method")) {
		throw new UamsException(UamsException.ERROR_CODE.INVALID,
			"请求参数中未找到方法名");
	    }
	    String method = (String) params.get("method");
	    logger.info("[接口反射]调用方法名称为" + method);
	    if (null == beanPostProcessorImpl.getPresapMethodMap()) {
		throw new UamsException(UamsException.ERROR_CODE.INVALID,
			"统一权限管理系统方法未初始化");
	    }
	    Object[] methodInfos = beanPostProcessorImpl.getPresapMethodMap().get(method);
	    if (null == methodInfos) {
		throw new UamsException(UamsException.ERROR_CODE.INVALID,
			"未找到方法[" + method + "]");
	    }
	    Object executeObject = methodInfos[0];
	    Method executeMethod = (Method) methodInfos[1];
	    List<Object> invokeArgs = new ArrayList<Object>();
	    Class<?>[] parameterTypes = executeMethod.getParameterTypes();
	    // 遍历参数
	    for (Class<?> parameterType : parameterTypes) {
		if (HttpServletRequest.class.equals(parameterType)) {
		    invokeArgs.add(request);
		} else if (HttpServletResponse.class.equals(parameterType)) {
		    invokeArgs.add(response);
		} else if (Map.class.equals(parameterType)) {
		    invokeArgs.add(params);
		} else {
		    invokeArgs.add(null);
		}
	    }
	    return (UamsResponse) executeMethod.invoke(executeObject,
		    invokeArgs.toArray());

	} catch (Exception e) {
	    // TODO: handle exception
            Throwable cause = e.getCause();
            if(cause instanceof UamsException){
        	throw (UamsException)cause;
            }
            e.printStackTrace();
	    throw new UamsException(UamsException.ERROR_CODE.NETERROR,"系统异常");
	}
    }
}
