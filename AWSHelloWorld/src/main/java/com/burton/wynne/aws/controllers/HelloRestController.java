package com.burton.wynne.aws.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@RequestMapping(value="hello/{name}")
	public String sayHello(@PathVariable(name="name") String name){
		return (name == null) ? "Hello World!"
				: String.format("Hello %s!", name);
		
	}
	
	@RequestMapping(value="hello/")
	public String sayHello(){
		return "Hello World";
		
	}
	

}
