package com.example.jdbctemplatebootdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("database.properties")
@ComponentScan("com.example.jdbctemplatebootdemo")
public class AppConfig {
	@Autowired
	Environment environment;
	
	//Props
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String PASS ="dbpass";
	private final String DRIVER = "driver";
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDS =  new DriverManagerDataSource();
		driverManagerDS.setUrl(environment.getProperty(URL));
		driverManagerDS.setUsername(environment.getProperty(USER));
		driverManagerDS.setPassword(environment.getProperty(PASS));
		driverManagerDS.setDriverClassName(environment.getProperty(DRIVER));
		
		return driverManagerDS;
	}
	
	@Bean
	public JdbcTemplate myJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
		
}
