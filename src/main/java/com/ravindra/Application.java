package com.ravindra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}