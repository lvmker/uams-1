package com.bgi.uams.services;

import java.lang.reflect.Field;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class DllLoaderListener implements ServletContextListener{
    private Logger logger=Logger.getLogger("intf");
    private void addDirToPath(String s){  
	    try {  
	        //获取系统path变量对象  
	        Field field=ClassLoader.class.getDeclaredField("sys_paths");  
	        //设置此变量对象可访问   
	        field.setAccessible(true);  
	        //获取此变量对象的值   
	        String[] path=(String[])field.get(null);  
	        //创建字符串数组，在原来的数组长度上增加一个，用于存放增加的目录  
	        String[] tem=new String[path.length+1];  
	        //将原来的path变量复制到tem中   
	        System.arraycopy(path,0,tem,0,path.length);  
	        //将增加的目录存入新的变量数组中   
	        tem[path.length]=s;  
	        //将增加目录后的数组赋给path变量对象  
	        field.set(null,tem);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
    @Override
    public void contextInitialized(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	    String path=sce.getServletContext().getRealPath("WEB-INF");  
	    logger.info("[动态链接库加载]加载路径："+path);
	    //将此目录添加到系统环境变量中   
	    addDirToPath(path);  
	    //加载相应的dll文件，注意要将'\'替换为'/' 
	    String osName=System.getProperty("os.name");
	    logger.info("[动态链接库加载]操作系统："+osName);
	    String dllPath=null;
	    if(osName.contains("Windows")){
		dllPath=path.replaceAll("\\\\","/")+"/sapjco3.dll";
	    }else {
		dllPath=path.replaceAll("\\\\","/")+"/libsapjco3.so";
	    }
	    logger.info("[动态链接库加载]加载动态链接库文件："+dllPath);
//	    System.load(dllPath); 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub
	
    }
    public static void main(String[] args) {
	System.out.println(System.getProperty("os.name"));
    }

}
