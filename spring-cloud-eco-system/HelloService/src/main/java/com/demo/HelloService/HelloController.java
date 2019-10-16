package com.demo.HelloService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping(value="/{firstName}/{lastName}" )
	public String get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return "Hello ="+firstName+ " "+lastName;
	}
}