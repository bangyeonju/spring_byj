package member.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Member {
	@NotEmpty(message="아이디는 필수입니다.")
	private String id;
	@NotEmpty(message="이름은 필수입니다.")
	private String name;
	
	@NotEmpty(message="비밀번호는 필수입니다.")
	private String password;
	
	private int salary;
	private String hiredate;
	@NotEmpty(message="성별은 필수입니다.")
	private String gender;
	@NotEmpty(message="취미는 필수입니다.")
	private String hobby;
	
	private String job;
	private String zipcode;
	@NotEmpty(message="주소1는 필수입니다.")
	private String address1;
	private String address2;
	private int mpoint;
	
	public Member() {
	}
	
	public Member(String id, String name, String password, int salary, String hiredate, String gender, String hobby,
			String job, String zipcode, String address1, String address2, int mpoint) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.hiredate = hiredate;
		this.gender = gender;
		this.hobby = hobby;
		this.job = job;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.mpoint = mpoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", salary=" + salary + ", hiredate="
				+ hiredate + ", gender=" + gender + ", hobby=" + hobby + ", job=" + job + ", zipcode=" + zipcode
				+ ", address1=" + address1 + ", address2=" + address2 + ", mpoint=" + mpoint + "]";
	}
	
	
}
