package bj.practice.humous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class testController {
	@GetMapping("/")
	@ResponseBody
	public String goHome(HttpServletRequest request) {
		System.out.println("enter");
		return "Hello Spring Boot";
	}
}