package br.com.fiap.fisio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, 
						scanBasePackages = {"br.com.fiap.fisio"})
public class FisioDomicilioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FisioDomicilioApplication.class);
	}
}
