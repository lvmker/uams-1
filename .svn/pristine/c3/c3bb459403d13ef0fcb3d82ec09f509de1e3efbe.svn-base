package com.bgi.uams.services;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import com.bgi.uams.beans.UamsMethod;
@Service
public class BeanPostProcessorImpl implements BeanPostProcessor {
    private Logger logger=Logger.getLogger(BeanPostProcessorImpl.class);
    private Map<String, Object[]> presapMethodMap = null;
    public Object postProcessBeforeInitialization(Object bean, String beanName)
           throws BeansException {
       return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)throws BeansException {
	Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
	for (Method method : methods) {
		UamsMethod uamsMethod = method.getAnnotation(UamsMethod.class);
		if (uamsMethod != null) {
		    Object[] methodInfos = new Object[2];
		    methodInfos[0] = bean;
		    methodInfos[1] = method;
		    logger.info(beanName+"添加UAMS方法-"+uamsMethod.value());
		    if(null==presapMethodMap){
			presapMethodMap=new HashMap<>();
		    }
		    presapMethodMap.put(uamsMethod.value(), methodInfos);
		}
	    }
       return bean;
    }
    public Map<String, Object[]> getPresapMethodMap() {
        return presapMethodMap;
    }
    public void setPresapMethodMap(Map<String, Object[]> presapMethodMap) {
        this.presapMethodMap = presapMethodMap;
    }
    
    
}