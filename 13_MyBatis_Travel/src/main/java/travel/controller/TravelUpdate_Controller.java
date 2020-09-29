package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdate_Controller {
	
	final String gotoUpdate = "update.tv";
	final String gotoUpdatePage = "TravelUpdateForm";
	final String gotoListPage = "redirect:/list.tv";
	// 슬레쉬(/)는 jsp파일 앞에만 안 넣으면 된다 
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value=gotoUpdate,method=RequestMethod.GET)
	public String update(@RequestParam("num") int num, Model model) {
		TravelBean travel = travelDao.getOneTravel(num);
		model.addAttribute("travel",travel);
		return gotoUpdatePage;
	}
	
	@RequestMapping(value=gotoUpdate,method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("travel") @Valid TravelBean travel,
						BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(gotoUpdatePage);
		}
		int cnt = travelDao.updateTravel(travel);
		if(cnt>0) {
			mav.setViewName(gotoListPage);
		}
		else {
			mav.setViewName(gotoUpdatePage);
		}
		return mav;
		
	}

}
