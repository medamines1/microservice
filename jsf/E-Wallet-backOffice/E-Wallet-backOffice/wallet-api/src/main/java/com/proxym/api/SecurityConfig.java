package com.proxym.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static String key = "10d1b5ae-3c39-4d";
    @Value("${backend.username}")
    private static String username;
    @Value("${backend.password}")
    private static String password;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${server.contextPath}")
    private String contextPath;


    @PostConstruct
    public void init() {
        BoApplicationAttributes.setContextPath(contextPath);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
               .antMatchers("/resources/**", "/javax.faces.resource/**", "/resetPassword/**").permitAll().anyRequest().permitAll()
/*                 .antMatchers("/dashboared")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/ldap")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/new")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/profile/**")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/update")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/profile/**")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/employee/**")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/roles/**")
                .hasAuthority("ROLE_SUPER_ADMIN")
                .antMatchers("/users/import").permitAll()
                .antMatchers("/uploads/**").permitAll()*/
                .anyRequest()
                .fullyAuthenticated().and().formLogin()
                .loginPage("/loginPage.xhtml")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/dash").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .exceptionHandling().accessDeniedPage("/login?error=true");

        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/uploads/**")
                .antMatchers("/passwordReset.xhtml");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

/*        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password as credentials,enabled from elm_bo_user where username =?")
                .passwordEncoder(bCryptPasswordEncoder)
                .authoritiesByUsernameQuery("select username,authority from elm_bo_authority where username=?")
                .rolePrefix("ROLE_");*/
        auth.inMemoryAuthentication().withUser("user").password("user").roles("ADMIN").and().withUser("admin")
                .password("admin").roles("SUPER_ADMIN");
    }

}