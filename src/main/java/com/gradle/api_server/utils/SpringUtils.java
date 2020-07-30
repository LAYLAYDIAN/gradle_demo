package com.gradle.api_server.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
    
    @SuppressWarnings("static-access")  
    @Override  
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
	    SpringUtils.applicationContext = applicationContext;
          
    }  
  
    public static ApplicationContext getApplicationContext(){
        return applicationContext;  
    }  
      
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);  
    }

    public static boolean isNotEmpty(String string) {
        return string != null && string.length() > 0;
    }
}
