package com.spring.ex1;

public class Order {	
	public  void order() {
		String msg ="상품주문";
		Login.login(msg);//공통기능 
		System.out.println(msg+"하기");//핵심기능 
		Logout.logout(msg);//공통기능 
	}

}
