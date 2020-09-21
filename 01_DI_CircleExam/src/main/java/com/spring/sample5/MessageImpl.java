package com.spring.sample5;

public class MessageImpl implements Message{
	
	
	private String name; //영희(생성자통한 주입)
	private String greeting; //Hello(setter통한주입)
	
	
	


	public MessageImpl(String name) {
		// TODO Auto-generated constructor stub
	}





	public String getGreeting() {
		return greeting;
	}





	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}





	@Override
	public void sayHello() {
		System.out.println(name +"~"+ greeting +"!");
	}

}
