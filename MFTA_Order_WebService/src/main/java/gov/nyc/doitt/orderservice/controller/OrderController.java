package gov.nyc.doitt.orderservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@RequestMapping(value="hello/")
	public String sayHello(){
		return "Hello World";
		
	}
}
