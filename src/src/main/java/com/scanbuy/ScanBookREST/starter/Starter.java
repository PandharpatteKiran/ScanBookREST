package com.scanbuy.ScanBookREST.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Kiran Pandharpatte
 */

@EnableAutoConfiguration
@ComponentScan("com.scanbuy.ScanBookREST.resource")
@EnableSwagger
public class Starter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Starter.class,args);
	}
	
}
