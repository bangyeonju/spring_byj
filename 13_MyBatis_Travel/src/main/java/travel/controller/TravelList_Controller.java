package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelList_Controller {
	private final String gotoList = "list.tv";
	private final String gotoListPage = "TravelListForm";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(gotoList)
	public ModelAndView insert(@RequestParam(value="searchColumn",required=false) String searchColumn,
							   @RequestParam(value="searchWord",required=false) String searchWord,
							   HttpServletRequest request) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("searchColumn", searchColumn);
		map.put("searchWord", "%"+searchWord+"%");
		
		List<TravelBean> lists = travelDao.getTravelList(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.setViewName(gotoListPage);
		return mav;
	}

}
