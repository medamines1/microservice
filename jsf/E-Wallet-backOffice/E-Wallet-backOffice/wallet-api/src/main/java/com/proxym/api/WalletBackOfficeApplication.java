package com.proxym.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WalletBackOfficeApplication extends SpringBootServletInitializer{
	    public static void main(String[] args) throws Exception {
			SpringApplication.run(WalletBackOfficeApplication.class, args);
	    }	
}