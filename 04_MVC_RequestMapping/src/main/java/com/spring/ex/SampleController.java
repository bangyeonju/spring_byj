package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("sample")

public class SampleController {
	@RequestMapping("/input")
	public String input() {
		
		return "sample/input";
		
	}
	
	@RequestMapping("/list")
	public String list() {
		return "sample/list";
	}
}
