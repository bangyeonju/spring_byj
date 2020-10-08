package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import order.model.Order;
import product.model.CompositeDao;

@Controller
public class OrderMallController {
	final String command ="/order.mall";
	final String getPage ="ShopList";
	
	@Autowired
	CompositeDao compositeDao;
	
	@RequestMapping(command)
	public String toAction(HttpSession session,Model model) {
		Member  loginInfo =(Member)session.getAttribute("loginInfo");
		if(loginInfo==null) {
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/loginForm.me";
			
		} else {
			List<Order> lists =	compositeDao.orderMall(loginInfo.getId());
//			for(int i=0;i>lists.size();i++) {
//				System.out.println();
//			}
			model.addAttribute("lists",lists);//다음페이지까지만 정보가 넘어갈라고 굳이 session 쓸 필요가 없어옹
			 
			
			
		}
		return getPage;
	}
}
