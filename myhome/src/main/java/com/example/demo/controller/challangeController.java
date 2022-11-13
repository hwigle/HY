package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class challangeController {
	@GetMapping("/")
	public String main() {
		return "challenge";
	}
}
