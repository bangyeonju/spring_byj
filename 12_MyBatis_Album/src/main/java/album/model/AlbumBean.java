package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	private int num;
	
	@NotEmpty(message="제목누락")
	private String title;//제목누락
	
	@Length(min=3,max=7,message="3~7글자 입력하세요")
	private String singer;//3~7글자
	
	//@Pattern(regexp = "^[0-9]+$")
	@Min(value=1000,message="최소1000이상 입력하세요")
	private String price;//최소1000원이상
	
	private String day;
	
	public AlbumBean() {

	}
	
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
}
