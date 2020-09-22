package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("member/view")
	public String view() {
		System.out.println("view()");
		return "member/memberView";
	}
	@RequestMapping("a")
	public String a() {
		System.out.println("a()");
		return "b";
	}
	@RequestMapping("member/input")
	public String input(Model model) {
		model.addAttribute("id","abc");//id=abc; 모델 속성설정..?request.setAttribute랑 똑같당!
		//request.setAttribute("id","abc");
		System.out.println("input");
		return "member/result";
	}
	
	@RequestMapping("member/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","연주");//name=연주
		mav.addObject("pw","1204");//pw=1204
		
		System.out.println("list");
		//return "member/list";
		mav.setViewName("member/list");
		return mav;
	}
	
}
