package com.wu.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wuhjie
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wu.common", "com.wu.web"})
@MapperScan(value = {"com.wu.web.dao"})

public class WebApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
