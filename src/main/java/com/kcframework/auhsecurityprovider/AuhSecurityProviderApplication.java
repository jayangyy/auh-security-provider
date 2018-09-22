package com.kcframework.auhsecurityprovider;

import com.kcframework.auhsecurityprovider.config.EduAccessDecisionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuhSecurityProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuhSecurityProviderApplication.class, args);
	}
   
}
