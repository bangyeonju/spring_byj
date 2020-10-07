package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import member.model.Member;
import utility.Paging;

//ProductDao myProductDao = new ProductDao();
@Component("myProductDao")//��ü���鶧 ����Ѵ� @Component
public class ProductDao {
	String namespace ="product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; //root-context.xml���� ���� ��ü ���Խ�Ų��.?
	
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	//pageInfo���� ������ page�� ������ ���ִ�!
	public List<Product> getDataList(Paging pageInfo, Map<String,String> map){
		List<Product> lists = new ArrayList<Product>();
											//page�� ��� �ǳʶٰ�,� ����ð���..ex)10������ �ǳʶٱ�.,5?
		System.out.println("lists.size:"+lists.size());
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists= sqlSessionTemplate.selectList(namespace+".GetDataList",map,rowBounds);
		return lists;
	}
	public void insertData(Product bean) {
		sqlSessionTemplate.insert(namespace+".InsertData",bean);
		
	}
	
	public Product getOneData(int num) {
		Product bean =sqlSessionTemplate.selectOne(namespace+".GetOneData",num);
		System.out.println("product:"+bean);
		 return bean;
		 
	}
	public void updateData(Product product) {
		sqlSessionTemplate.update(namespace+".UpdateData",product);
	}
	
	public void deleteData(int num) {
		sqlSessionTemplate.delete(namespace+".DeleteData",num);
		
	}
	public void updateStock(Integer pnum,Integer qty) {
		Product bean = new Product();
		bean.setNum(pnum);
		bean.setStock(qty);
		// pnum,qty�� bean���� ��� �Ѱܺ�����. 
		sqlSessionTemplate.update(namespace+".UpdateStock",bean);
	}
	
	
}
