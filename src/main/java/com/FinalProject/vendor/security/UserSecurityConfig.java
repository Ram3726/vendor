
package com.FinalProject.vendor.security;

import com.FinalProject.vendor.service.UserAuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserAuthenticationService userAuthenticationService (){ return new UserAuthenticationService();}

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userAuthenticationService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
  @Override
    @Transactional
    public void configure (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
  }
/*  @Override
   public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring()
                .antMatchers("vendorRegistration/save");
  }*/
  @Override
    public void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/vendorRegistration/save").permitAll()
                .antMatchers(HttpMethod.GET, "/vendorRegistration/fetch").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.PUT, "/vendorRegistration/update").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE, "/vendorRegistration/delete").hasAuthority("USER")
                .antMatchers(HttpMethod.POST,"/driverController/saveDriver").permitAll()
                .antMatchers(HttpMethod.GET, "/driverController/driverDetails").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.PUT, "/driverController/update").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE, "/driverController/delete").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
  }
}




