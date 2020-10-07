package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	//key : 상품번호 , value:주문수량
	private Map<Integer, Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
		
	}
	public void addOrder(int pnum, int oqty) {
		if(orderlists.containsKey(pnum)==false) { //새 상품이면
			orderlists.put(pnum, oqty);
		}else {// 이미 있는상품이면
//			int oldoqty = orderlists.get(pnum);
//			orderlists.put(pnum,oldoqty+oqty);
			//orderlists.get(pnum) == key를 알면 해당하는 주문수랑(oqty)알수있따.
			orderlists.put(pnum, orderlists.get(pnum)+oqty);
		}
	}
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}
}
