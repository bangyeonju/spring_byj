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
//�����ϱ� Ŭ��������(MallList.jsp���� �����ϱ� Ŭ��������..)
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
		Map<Integer, Integer>  maplists =mycart.getAllOrderLists(); //maplists = ��ٱ��Ͽ� ����ִ� ��ǰ��
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist :"+keylist);
		//oid,mid,orderdate
		Member member =(Member)session.getAttribute("loginInfo"); //MemberLoginController���� loginInfo�� ���Ǽ����Ͽ��� . loginInfo�� �α����� ��������� ����ֶ�.
		orderDao.insertData(member.getId());
		int maxOid = orderDao.getMaxOid();
		
		for(Integer pnum:keylist) {//�ֹ���ǰ�¼��� ����?
			Integer qty = maplists.get(pnum);//qty=�ֹ����� pnum(key)������ value���� �˼��ִ�.
			productDao.updateStock(pnum,qty);
			//orderdetails:odid,oid,pnum,qty
			// oid:�ֹ���ȣ,pnum:��ǰ��ȣ,qty:�ֹ�����
			
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			orderDetailDao.insertData(odBean);
			
		}
		memberDao.updatePoint(member.getId(),100);
		session.removeAttribute("mycart");//����������~ => �����Ϸ�Ǽ� ��ٱ��ϰ� ������!
		
		return getPage;
	}
}
