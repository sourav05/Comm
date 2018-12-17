package com.example.substractService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubstractionController {

	@GetMapping(value="sub/{num1}/{num2}")
	public String substract(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		return String.valueOf(number1-number2);
	}
}
