package org.rd.rws.rest.controller;

import org.rd.rws.rest.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
