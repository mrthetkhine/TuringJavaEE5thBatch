package com.turingjavaee7.demo;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.model.Store;
import com.turingjavaee7.demo.service.impl.ExampleBean;
import com.turingjavaee7.demo.service.impl.HelloMessageGenerator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class AppConfig implements WebMvcConfigurer{
	@Bean
	public ExampleBean exampleBean()
	{
		log.info("Invoke via factory method");
		return new ExampleBean();
	}
	
	@Bean
	@RequestScope
	public HelloMessageGenerator requestScopedBean() {
		log.info("HelloMessageBean created ");
	    return new HelloMessageGenerator();
	}
	@Bean
	@ApplicationScope
	public HelloMessageGenerator appScopedBean() {
		log.info("HelloMessageBean app scope created ");
	    return new HelloMessageGenerator();
	}
	
	@Bean
	@SessionScope
	public ShoppingCart shoppingCart()
	{
		log.info("Shopping cart created ");
		return new ShoppingCart();
	}
	
	@Bean
	public Store<String> stringStore() {
		return new Store<String>();
	}

	@Bean
	public Store<Integer> integerStore() {
		log.info("Integer store created");
		return new Store<Integer>();
	}
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	    
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	  }
	@Bean
	public HandlerInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor(); 
		localeChangeInterceptor.setParamName("lang");
		
		return localeChangeInterceptor;
	}
}
