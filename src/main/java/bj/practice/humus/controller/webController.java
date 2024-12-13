package bj.practice.humus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {
	@RequestMapping(value="/web")
	public String index() {
		return "index";
	}
}