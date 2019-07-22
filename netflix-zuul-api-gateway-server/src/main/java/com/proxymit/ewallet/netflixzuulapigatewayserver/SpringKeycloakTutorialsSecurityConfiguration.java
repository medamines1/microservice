package com.proxymit.ewallet.netflixzuulapigatewayserver;

import com.google.common.collect.ImmutableList;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringKeycloakTutorialsSecurityConfiguration {




    @Configuration
    @EnableWebSecurity
    @ConditionalOnProperty(name = "keycloak.enabled", havingValue = "true", matchIfMissing = true)
    @ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
    public static class KeycloakConfigurationAdapter extends KeycloakWebSecurityConfigurerAdapter {



        /**
         * Defines the session authentication strategy.
         */
        @Bean
        @Override
        protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
            // required for bearer-only applications.
            //pas de gestion de session puisque nous étulisant l'approche stateless
            return new NullAuthenticatedSessionStrategy();
        }

        /**
         * Registers the KeycloakAuthenticationProvider with the authentication manager.
         */
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
            // simple Authority Mapper to avoid ROLE_
            keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
            auth.authenticationProvider(keycloakAuthenticationProvider);
        }

        /**
         * Required to handle spring boot configurations
         * @return
         */
        @Bean
        public KeycloakConfigResolver KeycloakConfigResolver() {
            return new KeycloakSpringBootConfigResolver();
        }

        /**
         * Configuration spécifique à keycloak (ajouts de filtres, etc)
         * @param http
         * @throws Exception
         */

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                    // disable csrf because of API mode
                    .csrf().disable()
                    .sessionManagement()
                    // use previously declared bean
                    .sessionAuthenticationStrategy(sessionAuthenticationStrategy())
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)


                    // keycloak filters for securisation
                    //utilisation des filtres de sécurités fournit par Keycloak
                    // (qui permettent de valider les tokens à chaque appel, etc)
                    .and()
                    .addFilterBefore(keycloakPreAuthActionsFilter(), LogoutFilter.class)
                    .addFilterBefore(keycloakAuthenticationProcessingFilter(), X509AuthenticationFilter.class)
                    .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())

                    // delegate logout endpoint to spring security

                    .and()
                    .logout()
                    .addLogoutHandler(keycloakLogoutHandler())
                    .logoutUrl("/logout").logoutSuccessHandler(
                    // logout handler for API
                    (HttpServletRequest request, HttpServletResponse response, Authentication authentication) ->
                            response.setStatus(HttpServletResponse.SC_OK)
            )
                    .and()
                    // manage routes securisation here
                    .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()


                    .antMatchers("/logout",
                            "/profile/loginEmployee",
                            "/profile/registerEmployee"
                    ).permitAll()
                    .antMatchers("/profile/employee/**",
                            "/profile/allEmployeesOfCompany/**",
                            "/profile/affect/employee/**"
                            ,"/profile/allEmployees/**","/profile/employees").hasRole("USER")

                    .antMatchers("/company/company/loginCompany",
                            "/company/company/addCompany",
                            "/company/v2/api-docs",
                            "/profile/v2/api-docs",
                            "/**/v2/api-docs",
                            "/v2/api-docs",
                            "/swagger-resources/configuration/ui",
                            "/swagger-resources",
                            "/swagger-resources/configuration/security",
                            "/swagger-ui.html",
                            "/webjars/**").permitAll()
                    .antMatchers(
                            "/company/companies",
                            "/**",
                            "/company/company/**",
                            "/company/getAllCategories/**").hasRole("USER")

                    .anyRequest().denyAll();


        }

    }



}


