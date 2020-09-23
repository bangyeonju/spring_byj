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
//	get,post방식 구분해서 
	@RequestMapping(value="form",method=RequestMethod.GET) //url입력은 get요청.
	public String form() {
		return "form";
	}
	
	@RequestMapping(value= "form",method=RequestMethod.POST) //type="submit"은 post요청.
													//command 객체 @ModelAttribute("stu") 별칭지정
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
		//문제가 있을떄 true 
		//문제가 없을때 false 
		return page;
	}
	
}
