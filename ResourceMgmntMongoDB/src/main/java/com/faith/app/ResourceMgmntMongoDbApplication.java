package com.faith.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceMgmntMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceMgmntMongoDbApplication.class, args);
		
		System.out.println("App Running...");
	}

}
