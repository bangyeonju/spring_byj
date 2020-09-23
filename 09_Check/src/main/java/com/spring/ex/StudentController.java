package com.spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class StudentController {
//	get,post��� �����ؼ� 
	@RequestMapping(value="form",method=RequestMethod.GET) //url�Է��� get��û.
	public String form() {
		return "form";
	}
	
	@RequestMapping(value= "form",method=RequestMethod.POST) //type="submit"�� post��û.
													//command ��ü @ModelAttribute("stu") ��Ī����
	public String form(HttpServletRequest request,
						@ModelAttribute("stu") @Valid Student stu,
						BindingResult result) {
		
		System.out.println(stu.getName());
		System.out.println(stu.getId());
		String page = "result";
		System.out.println("result.hasErrors():"+result.hasErrors());
		if(result.hasErrors()) {
			page = "form";
		}
		//������ ������ true 
		//������ ������ false 
		return page;
	}
	
}
