package com.springboot.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication //(exclude = DataSourceAutoConfiguration.class)
public class SpringbootEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEcommerceApplication.class, args);
	}

}
