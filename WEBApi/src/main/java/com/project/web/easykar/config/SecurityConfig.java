/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.easykar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 *
 * @author manoj
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/it-return-services","/tax-knowledge","/contact-us","/user_register","/user_login","/resources/**","/", "/login", "/home", "/register","#userlogin","#useregister").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }
    
     
    //Spring Boot configured this already.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", 
                        "/assets/css/img/bg/**", "/assets/css/img/**", 
                        "/assets/css/**", "/assets/js/maps/**", 
                        "/assets/fonts/**", "/assets/js/**",
                        "/assets/images/hero/**","/assets/images/icons/**",
                        "/assets/images/news/**","/assets/images/service/**",
                        "/assets/images/team/**","/assets/js/vendor/**",
                        "/assets/map/**","/images/icons/**",
                        "/assets/images/bg/**","/assets/images/campaign/**",
                        "/assets/images/comment/**","/assets/images/gallery/**",
                        
                        "/assets/images/**","/assets/images/about/**");
    }
}
