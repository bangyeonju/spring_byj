package com.spring.sample3;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CircleMain {
	public static void main(String[] args) {
//		double radius=10.0;
//		Point point = new PointImpl();
//	
//		point.setXpos(3.0);
//		point.setYpos(4.0);
//		
//		Circle circle = new CircleImpl(radius, point);
//		circle.display();
		
		Resource resource =new ClassPathResource("abc.xml");
		BeanFactory factory =  new XmlBeanFactory(resource);//bean만드는 공장
		
		Circle circle = (Circle)factory.getBean("circle");
		circle.display();
		
		
		Point point = (Point)factory.getBean("point");
		System.out.println("point.getXpos()="+point.getXpos());
		System.out.println("point.getYpos()="+point.getYpos());
		
		
	}
}
