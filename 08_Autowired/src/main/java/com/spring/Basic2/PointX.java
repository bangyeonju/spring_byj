package com.spring.Basic2;

import org.springframework.stereotype.Component;
//PointX px = new PointX(); �Ʒ��� ����.
@Component("PointX") //��ü���鶧 ����ϴ� ������̼� //Ŭ���� �̸��� ���� �ص� ���.
public class PointX implements Shape{
	
	public PointX() {
		System.out.println("PointX()");
	}
	@Override
	public String make() {
		return "x�� �����.";
	}

	@Override
	public String delete() {
		return "x�� �����";
	}
	

}
