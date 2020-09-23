package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("a1")
	public String a1(HttpServletRequest request, Model model) {
		System.out.println("a1요청");
		
		model.addAttribute("model_attr","model_attr");
		request.setAttribute("req_attr","req_attr");
		return "redirect:/a2";
		
		
	}
	@RequestMapping("a2")
	public String a2() {
		System.out.println("a2요청");
		return "a3";
	}
	//요청에 따라 또다른 페이지로 갈때는 model이나  map (RedirectAttributes)를 이용해서 가져간당~
	@RequestMapping("b1")
	public String b1(RedirectAttributes redirectAttributes) {
		System.out.println("b1요청");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("model_attr", "model_attr");
		map.put("req_attr", "req_attr");
		redirectAttributes.addFlashAttribute("map1",map);
		System.out.println(map);
		return "redirect:/b2";
//		return "b2";
	}
	
	@RequestMapping("b2")
	public String b2() {
		System.out.println("b2요청");
		return "b3";
	}
	
	
}
