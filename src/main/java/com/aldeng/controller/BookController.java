package com.aldeng.controller;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@GetMapping
	public String getBookById(){
		System.out.println("this is books.............");
		return "this is books............";
	}
}
