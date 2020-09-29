package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsert_Controller {
	
	final String gotoInsert = "insert.tv";
	final String gotoInsertPage = "TravelInsertForm";
	final String gotoListPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value=gotoInsert,method=RequestMethod.GET)
	public String insert() {
		return gotoInsertPage;
	}
	
	@RequestMapping(value=gotoInsert,method=RequestMethod.POST)
	public ModelAndView insert(@Valid TravelBean travel,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(gotoInsertPage);
			return mav;
		}
		int cnt = travelDao.insertTravel(travel);
		mav.setViewName(gotoListPage);
		return mav;
	}
	

}
