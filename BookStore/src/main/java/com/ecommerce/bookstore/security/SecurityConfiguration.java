package com.ecommerce.bookstore.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	DataSource dataSource;

	 	
	@Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	    {
	    	
	    	auth.jdbcAuthentication().dataSource(dataSource)
	    	.usersByUsernameQuery("select username , password, Active from Users where username=?")
	    	.authoritiesByUsernameQuery("select u1.username , u2.role from Users u1 , Roles u2 where u1.role_id=u2.user_role_id and u1.username=?");
	    }
	    
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
	      	.antMatchers("/","/home").permitAll()
	        //.antMatchers("/", "/home").access("hasRole('USER')")
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/db/**").access("hasRole('ADMIN') or hasRole('DBA')")
	        .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	        .usernameParameter("username").passwordParameter("password")
	        .and().csrf().disable();
	        //.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	    }

}
