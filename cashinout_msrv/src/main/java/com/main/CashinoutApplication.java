package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RefreshScope
@ComponentScan({"interfaces", "controller","service","validation","feign"})
@EnableJpaRepositories("interfaces")
@EntityScan("models")
@EnableAutoConfiguration
@EnableFeignClients("feign")
@EnableSwagger2
@EnableDiscoveryClient
public class CashinoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashinoutApplication.class, args);
	}

}
