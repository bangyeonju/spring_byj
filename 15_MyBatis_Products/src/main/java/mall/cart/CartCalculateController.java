package mall.cart;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetail;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;
//결제하기 클릭했을때(MallList.jsp에서 결제하기 클릭했을때..)
@Controller
public class CartCalculateController {
	final String command ="calculate.mall";
	final String getPage ="redirect:/list.prd";
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer, Integer>  maplists =mycart.getAllOrderLists(); //maplists = 장바구니에 담겨있는 상품이
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist :"+keylist);
		//oid,mid,orderdate
		Member member =(Member)session.getAttribute("loginInfo"); //MemberLoginController에서 loginInfo에 세션설정하였땅 . loginInfo에 로그인한 사람정보가 들어있땅.
		orderDao.insertData(member.getId());
		int maxOid = orderDao.getMaxOid();
		
		for(Integer pnum:keylist) {//주문상품걔수를 뺀다?
			Integer qty = maplists.get(pnum);//qty=주문수량 pnum(key)값으로 value값을 알수있다.
			productDao.updateStock(pnum,qty);
			//orderdetails:odid,oid,pnum,qty
			// oid:주문번호,pnum:상품번호,qty:주문수량
			
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			orderDetailDao.insertData(odBean);
			
		}
		memberDao.updatePoint(member.getId(),100);
		session.removeAttribute("mycart");//세션지워라~ => 결제완료되서 장바구니가 없어짐!
		
		return getPage;
	}
}
