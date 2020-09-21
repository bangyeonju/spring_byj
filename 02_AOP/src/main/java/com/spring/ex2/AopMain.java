package com.spring.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
//		Login li = new Login();
//		li.login();
//		
//		OrderImpl oi = new OrderImpl();
//		oi.order();
		
//		Dao dao = new Dao();
//		dao.dao();
		
//		Logout lo = new Logout();
//		lo.logout();
		AbstractApplicationContext context =new GenericXmlApplicationContext("aopExam.xml");
		System.out.println("----상품주문하기-----");
		// OrderImpl myorder = (OrderImpl)context.getBean("myorder"); 다른 설정 필요. error
		Order myorder = (Order)context.getBean("myorder");
		myorder.order();
		
		System.out.println("----게시물등록하기-----");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board();
//		BoardImpl 핵심기능 .
		
	}		
}
