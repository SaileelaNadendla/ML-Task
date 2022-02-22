package com.bhavna.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.bhavna.Repository")
@ComponentScan(basePackages = "com.bhavna")


public class WebConfig {
	@Autowired
	 private Environment environment;
	 
	@Bean(name="entityManagerFactory")
	 public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		 LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
		 manager.setJpaVendorAdapter(getJpaVendorAdapter());
		 manager.setDataSource(dataSource());
		 manager.setPersistenceUnitName("myJpaPersistenceUnit");
		 manager.setPackagesToScan("com.bhavna");
		 manager.setJpaProperties(hibernateProperties());
	        return manager; 
	 }
	
	@Bean
	public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        return properties;

		
	}
	
	@Bean
	public DataSource dataSource() {
    	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\BHAVNAWKS774;databaseName=saiDB;portNumber=1433";
		String user = "sa";
		String pass = "Bhavna@123";
		
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(user);
	    dataSource.setPassword(pass);

		return dataSource;
	}
	 @Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
	    JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}
	 
	 @Bean
	 public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	 final JpaTransactionManager transactionManager = new JpaTransactionManager();
	 transactionManager.setEntityManagerFactory(emf);
	 return transactionManager;
	 }


	 

}
