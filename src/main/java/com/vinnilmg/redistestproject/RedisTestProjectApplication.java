package com.vinnilmg.redistestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisTestProjectApplication.class, args);
	}

}
