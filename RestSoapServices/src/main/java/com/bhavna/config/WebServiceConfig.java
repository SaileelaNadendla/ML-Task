package com.bhavna.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	@Bean
	public ServletRegistrationBean messageDispacherServlet(ApplicationContext context) {
		MessageDispatcherServlet  messageDispacherServlet = new MessageDispatcherServlet();
		messageDispacherServlet.setApplicationContext(context);
		messageDispacherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDispacherServlet,"/ws/*");
		
	}
	
	@Bean(name="student")
	 public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("StudentPort");
		definition.setTargetNamespace("https://www.bhavna.com/student");
		definition.setLocationUri("/ws");
		definition.setSchema(studentSchema);
		return definition;
		
		 
	 }
	@Bean
	public XsdSchema studentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
		
	}
}
