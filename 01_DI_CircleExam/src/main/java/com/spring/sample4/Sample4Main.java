package com.spring.sample4;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Sample4Main {
	public static void main(String[] args) {
// 방법1	Calc calc = new CalcImpl(4);
//		CalcImpl calc = new CalcImpl(4);//방법2
//		calc.setSu1(9);
//		calc.calculate();
		Resource resource = new ClassPathResource("calcTest.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Calc calc = (Calc)factory.getBean("calc");
		calc.calculate();
				
		
	}
}
