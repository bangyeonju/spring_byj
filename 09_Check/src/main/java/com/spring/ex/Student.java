package com.spring.ex;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Student {
	@NotEmpty(message="이름 입력 누락")//바로아래만 적용. pom.xml에  <!-- 유효성검사-->추가.
	private String name;
	
	@Length(min=3, max=5, message="3이상~5이하")
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName(String name)");
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
