package com.infosys.capstone.config;

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
@ComponentScan("com.infosys.capstone")
@PropertySource("database.properties")
public class JDBCConfig {

	@Autowired
	private Environment env;

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String PASS = "dbpass";
	private final String DRIVER = "driver";

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl(env.getProperty(URL));
		datasource.setUsername(env.getProperty(USER));
		datasource.setPassword(env.getProperty(PASS));
		datasource.setDriverClassName(env.getProperty(DRIVER));
		return datasource;

	}

	@Bean
	public JdbcTemplate myJdbc(DataSource ds) {
		return new JdbcTemplate(ds);
	}

}
