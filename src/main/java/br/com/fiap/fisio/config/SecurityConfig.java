package br.com.fiap.fisio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import br.com.fiap.fisio.filter.EncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);
		
		http.csrf().disable();//THIS IS NOT RECOMMENDED IN PRODUCTION
    }
}
