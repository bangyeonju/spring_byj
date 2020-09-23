package com.spring.ex;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

public class BookDTO {
	@NotEmpty(message="제목입력누락")
	private String title;
	
	//@Length(min=5, message="5글자이상으로입력")
	//@Min(value=5,message="")
	@NotEmpty(message="저자입력누락")
	private String author;
	
	@Pattern(regexp = "^[0-9]+$" ,message="숫자만 입력 가능") //정규표현식 
	private String price;
	
	@NotEmpty(message="출판사 입력 누락")
	private String publisher;
	
	public BookDTO() {
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
