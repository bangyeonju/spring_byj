package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductListController {
	final String command ="/list.prd";
	final String getPage = "ProductList";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
								@RequestParam(value="pageNumber",required=false) String pageNumber,
								@RequestParam(value="pageSize", required=false) String pageSize,
								@RequestParam(value="whatColumn", required=false) String whatColumn,
								@RequestParam(value="keyword",required=false) String keyword,
								HttpServletRequest request) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("whatColumn",whatColumn);
		map.put("keyword","%"+keyword+"%");
		
		int totalCount = productDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		List<Product> lists = productDao.getDataList(pageInfo, map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);//ProductList.jsp·Î°£´Ù
	return mav;	
	}
	
	
}
