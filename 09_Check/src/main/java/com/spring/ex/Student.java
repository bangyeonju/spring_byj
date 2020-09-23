package com.spring.ex;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Student {
	@NotEmpty(message="�̸� �Է� ����")//�ٷξƷ��� ����. pom.xml��  <!-- ��ȿ���˻�-->�߰�.
	private String name;
	
	@Length(min=3, max=5, message="3�̻�~5����")
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
