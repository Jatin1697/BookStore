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
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
	        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
	        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
	    }
	 /*
	 @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	    {
	    	
	    	auth.jdbcAuthentication().dataSource(dataSource)
	    	.usersByUsernameQuery("select username , password, isActive from Users where username=?")
	    	.authoritiesByUsernameQuery("select u1.username , u2.role from Users u1 , Roles u2 where u1.user_id=u2.user_id and u1.username=?");
	    }
	    */
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
	        .antMatchers("/", "/home").access("hasRole('USER')")
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/db/**").access("hasRole('ADMIN') or hasRole('DBA')")
	        .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	        .usernameParameter("username").passwordParameter("password")
	        .and().csrf()
	        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	    }

}
