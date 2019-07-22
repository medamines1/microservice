package com.proxymit.ewallet.ewalletmanagementcompanyapi;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableFeignClients("com.proxymit.ewallet.ewalletmanagementcompanyapi.feign")
@EnableDiscoveryClient
public class EwalletManagementcompanyApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwalletManagementcompanyApiApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder getBCPE()  {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //trace All the request
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }


    @Bean
    public FilterRegistrationBean corsFilter() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        logger.info("****************************** init cors ");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Integer.MIN_VALUE);
        return bean;
    }

}
