package com.spring.Basic2;

import org.springframework.stereotype.Component;

@Component("PointY")// ��ü����� �۾�.
public class PointY implements Shape{
	
	public PointY() {
		System.out.println("PointY()");
	}
	@Override
	public String make() {
		return "Y�� �����.";
	}

	@Override
	public String delete() {
		return "Y�� �����";
	}
	

}
