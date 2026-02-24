package com.ereniridere.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ereniridere.configruation.GlobalProperties;

@SpringBootApplication
@EntityScan(basePackages = "com.ereniridere")
@EnableJpaRepositories(basePackages = "com.ereniridere")
@ComponentScan(basePackages = "com.ereniridere")
//@PropertySource(value = "classpath:app.properties")

@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
