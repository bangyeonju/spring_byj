package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
		PCommand command = null;
		@RequestMapping("write_view")
		public String write_view() {
			return "write_view";
		}
		
		@RequestMapping("write")
		public String write(HttpServletRequest request) {
//			String id = request.getParameter("id");
			command =new PWriteCommand();
			command.execute(request);
			return "redirect:/list";
		}
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		command=new PListCommand();
		command.execute(request);
		return "list";
	}
}
