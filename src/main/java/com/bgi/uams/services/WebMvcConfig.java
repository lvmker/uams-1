package com.bgi.uams.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override  
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {  
        ReturnHandler returnHandler=new ReturnHandler();  
        returnValueHandlers.add(returnHandler);  
        super.addReturnValueHandlers(returnValueHandlers);  
    } 
}
