package com.spring.Basic2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		Shape px = new PointX(); //Shape�� PointX�� �θ𿩼� ��밡��
//		Shape py = new PointY(); //Shape�� PointY�� �θ𿩼� ��밡��
//		
//		CircleImpl circle = new CircleImpl();
//		circle.setPointx(px);
//		System.out.println(circle.make());
//		RectangleImpl rec = new RectangleImpl();
//		rec.setPointy(py);
//		System.out.println(rec.make());
		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiredExam.xml");
		
		Circle circle = (Circle)context.getBean("myCircleImpl");
		System.out.println(circle.make());
		System.out.println("--------------------------------------------------");
		
		//y�� �����.
		Rectangle rectangle = context.getBean("myRectangleImpl",Rectangle.class);
		System.out.println(rectangle.make());
		
		
	}
}
