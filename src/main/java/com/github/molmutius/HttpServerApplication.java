package com.github.molmutius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github")
@EntityScan("com.github")
public class HttpServerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(HttpServerApplication.class, args);
	}
}
