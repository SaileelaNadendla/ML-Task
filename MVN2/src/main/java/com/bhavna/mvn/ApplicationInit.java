package com.bhavna.mvn;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bhavna.database.AppConfig;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class[] cls= {ApplicationConfig.class};
	return cls;
	}



	@Override
	protected Class<?>[] getServletConfigClasses() {
	return null;
	}



	@Override
	protected String[] getServletMappings() {
	String[] str= {"/"};
	return str;
	
	}
	}


