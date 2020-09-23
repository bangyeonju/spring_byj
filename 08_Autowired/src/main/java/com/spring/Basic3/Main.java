package com.spring.Basic3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("AutowiredExam2.xml");
		
		Person per=(Person)context.getBean("Consumer");
		per.setName("À±¾Æ");
		System.out.println(per.getName());
		System.out.println(per.personDrive());
		
	}
}
