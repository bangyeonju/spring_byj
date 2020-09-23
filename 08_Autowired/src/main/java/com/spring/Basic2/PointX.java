package com.spring.Basic2;

import org.springframework.stereotype.Component;
//PointX px = new PointX(); 아래와 같다.
@Component("PointX") //객체만들때 사용하는 어노테이션 //클래스 이름과 동일 해두 댄당.
public class PointX implements Shape{
	
	public PointX() {
		System.out.println("PointX()");
	}
	@Override
	public String make() {
		return "x를 만들다.";
	}

	@Override
	public String delete() {
		return "x를 지우다";
	}
	

}
