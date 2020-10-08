package product.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mall.cart.ShoppingInfo;
import order.model.Order;
import orderdetail.model.OrderDetail;

@Component("myCompositeDao")
public class CompositeDao {
	
	final String namespace="product.model.Composite";
	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;


	public List<Order> orderMall(String id) {
		List<Order> lists = new ArrayList<Order>();
		lists = sqlSessionTemplate.selectList(namespace+".OrderMall",id);
		return lists;
	}
	
	public List<ShoppingInfo> showDetail(int oid) {
		List<ShoppingInfo> lists = sqlSessionTemplate.selectList(namespace+".ShowDetail",oid);
		return lists;
	}
}
