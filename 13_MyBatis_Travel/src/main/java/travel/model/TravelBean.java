package travel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	//@NotNull(message="name 누락")//이거 안된다
	@NotEmpty(message="name 누락")
	private String name;
	
	//@Min(value = 10,message = "10살에서 100살까지 입력하세요")
	//@Max(value = 100,message = "10살에서 100살까지 입력하세요")
	@Range(min = 10, max = 100, message = "10살에서 100살까지 입력하세요")
	private int age;
	
	//@NotEmpty(message="지역 하나라도 선택하세요")
	@NotNull(message="지역 하나라도 선택하세요")
	private String area;
	
	//@NotEmpty(message="여행타입 하나라도 선택하세요")
	@NotNull(message="여행타입 하나라도 선택하세요")
	private String style;
	
	//@NotNull(message="가격 하나라도 선택하세요")//이거 안된다
	//@NotEmpty(message="가격 하나라도 선택하세요")
	private String price;
	
	public TravelBean() {
		
	}
	
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
