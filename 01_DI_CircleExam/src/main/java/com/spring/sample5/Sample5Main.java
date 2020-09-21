package com.spring.sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Sample5Main {
	public static void main(String[] args) {
//		MessageImpl ms = new MessageImpl("영희");
//		ms.setGreeting("Hello");
		
		Resource resource = new ClassPathResource("msg.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		MessageImpl ms2 = (MessageImpl) factory.getBean("ms");
				
		ms2.sayHello();
	}
}

