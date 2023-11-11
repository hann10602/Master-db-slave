//package com.nnh.config;
//
//import java.util.HashMap;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@PropertySource({"classpath:application.properties"})
//@EnableJpaRepositories(
//		basePackages = "com.nnh.model.product",
//		entityManagerFactoryRef = "productEntityManager",
//		transactionManagerRef = "productTransactionManager"
//)
//public class ProductDBConfiguration {
//	@Autowired
//	private Environment env;
//	
//	@Bean
//	@Primary
//	public LocalContainerEntityManagerFactoryBean productEntityManager() {
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(productDataSource());
//		em.setPackagesToScan(new String[] {"com.nnh.model.product"});
//		
//		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
//		em.setJpaVendorAdapter(va);
//		
//		HashMap<String, Object> properties = new HashMap<>();
//		properties.put("hibernate.hbm2ddl.auto", env.getProperty("create-drop"));
//		properties.put("hibernate.dialect", env.getProperty("org.hibernate.dialect.MySQL55Dialect"));
//		em.setJpaPropertyMap(properties);
//		
//		return em;
//	}
//	
//	@Bean
//	@Primary
//	public DataSource productDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3307/multiple_db");
//		dataSource.setUsername("root");
//		dataSource.setPassword("123456");
//		
//		return dataSource;
//	}
//	
//	@Bean
//	@Primary
//	public PlatformTransactionManager productTransactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(productEntityManager().getObject());
//		
//		return transactionManager;
//	}
//}
