package com.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import repo.TransactionRepo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@RefreshScope
@ComponentScan({"repo", "controller","service","validation","feigns"})
@EnableJpaRepositories(basePackageClasses = TransactionRepo.class)
@EntityScan("models")
@EnableAutoConfiguration
@EnableFeignClients("feigns")
@EnableSwagger2
@EnableDiscoveryClient
public class TransactionWalletMsrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionWalletMsrvApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*") .allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Accept", "X-Requested-With", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin");

			}
		};
	}

}
