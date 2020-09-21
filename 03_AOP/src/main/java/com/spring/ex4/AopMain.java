package com.spring.ex4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AopMain {
	public static void main(String[] args) {
		/*
		StudentImpl student = new StudentImpl();
		studetn.setName("조정석");
		*/
//		Resource resource = new ClassPathResource("a.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		WorkerImpl worker = (WorkerImpl)factory.getBean("worker");
//		
//		worker.getWorkerInfo();
//		
//		Worker myworker = (Worker)ctx.getBean("myworker");
//		myworker.getWorkerInfo();
//		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("a.xml");
		Student student = (Student)ctx.getBean("student");
		student.getStudentInfo();
		System.out.println("------------");
		Worker worker = (Worker)ctx.getBean("worker");
		worker.getWorkerInfo();
	}
}
