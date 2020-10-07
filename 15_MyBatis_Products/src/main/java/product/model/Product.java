package product.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int num;
	
	@Length(min=3,max=10,message="상품이름은 최소 3자리 최대 10자리입니다.")
	private String name;
	
	private String company;
	
	@NotEmpty(message="파일 선택 안함")
	private String image;
	
	private int stock;
	
	@Min(value=3000,message="가격은 최소 3000원 이상 이여야 합니다.")
	private int price;
	
	private String category;
	
	@Length(min=5,max=10,message="상품에 대한 설명은 최소5자리 최대 10자리 입니다.")
	private String contents;
	
	private int point;
	private String inputdate;
	
	private int orderqty; // 주문수량
	
	private String uploadOld; //수정 전 이미지가 담긴다.
	
	public String getUploadOld() {
		return uploadOld;
	}


	public void setUploadOld(String uploadOld) {
		this.uploadOld = uploadOld;
	}


	private MultipartFile upload; //넘어오는 파일 pom.xml에서 설정함. commons
	
	
	public MultipartFile getUpload() {
		return upload;
	}


	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload:"+upload); //주소형태로 나옴
		if(upload !=null) { // 파일을 선택했다면
			System.out.println(upload.getName()); //파일의 이름이 아니다.
			System.out.println(upload.getOriginalFilename()); //진짜파일의 이름.
			this.image = upload.getOriginalFilename();
		}
		
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int num, String name, String company, String image, int stock, int price, String category,
			String contents, int point, String inputdate, int orderqty, MultipartFile upload) {
		super();
		this.num = num;
		this.name = name;
		this.company = company;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.contents = contents;
		this.point = point;
		this.inputdate = inputdate;
		this.orderqty = orderqty;
		this.upload = upload;
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


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getInputdate() {
		return inputdate;
	}


	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}


	public int getOrderqty() {
		return orderqty;
	}


	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}

	
}