package com.hospitality.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().
				url("jdbc:mysql://localhost:3306/hotelmngt?characterEncoding=utf8").
				username("root").
				password("kishore$123").
				driverClassName("com.mysql.cj.jdbc.Driver").
				build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(datasource);
		emf.setPackagesToScan("com.hospitality.core");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	
	@Bean
	public  PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}
