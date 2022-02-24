package com.bhavna.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {
	 
	@Autowired
	public Environment environment;
	
	@Bean
	public DataSource datasource() {
//	 DriverManagerDataSource datasource =  new DriverManagerDataSource();
//	 datasource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//	 datasource.setUrl(environment.getRequiredProperty("jdbc.url"));
//	 datasource.setUsername(environment.getRequiredProperty("jdbc.username"));
//	 datasource.setPassword(environment.getRequiredProperty("jdbc.password"));
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbUrl ="jdbc:sqlserver://localhost\\\\BHAVNAWKS774;databaseName=saiDB;portNumber=1433";
		String UserName = "sa";
		String Password = "Bhavna@123";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(UserName);
		dataSource.setPassword(Password);
		return dataSource;

		
		
	}
	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
//		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//		properties.put("hibernate.formate_sql", environment.getRequiredProperty("hibernate.formate_sql"));
	
		properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "none");
	
		return properties;
		
	}
//	@Bean
//	 public HibernateTransactionManager getTransationManager() {
//		 HibernateTransactionManager transactionMnager = new HibernateTransactionManager();
//		 transactionMnager.setSessionFactory(sessionFactory().getObject());
//		return transactionMnager;
//		 
//	 }
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource());
		sessionFactory.setPackagesToScan(new String[] {
				"com.bhavna.entity"
		});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
}
	
