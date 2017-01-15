package com.ecommerce.bookstore.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ecommerce.bookstore")
public class AppContextConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/Views/");
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
		
	}
	
	@Bean
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        //Using gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("jatin.sabherwal16497@gmail.com");
        mailSender.setPassword("dtuenvironmental");
         
        Properties javaMailProperties = new Properties();
    
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
         
        mailSender.
        setJavaMailProperties(javaMailProperties);
		return mailSender;
		
	}
	
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	

}
