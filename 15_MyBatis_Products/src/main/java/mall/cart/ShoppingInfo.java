package mall.cart;
//상품번호,상품명,주문수량,단가,금액를 담을수 있는 클래스
public class ShoppingInfo {
	private int pnum;
	private String pname;
	private int qty;
	private int price;
	private int amount;

	public ShoppingInfo(int pnum, String pname, int qty, int price, int amount) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
	}
	public ShoppingInfo() {
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
