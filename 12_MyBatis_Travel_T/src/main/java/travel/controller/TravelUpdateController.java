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
public class TravelUpdateController {
	final String command="/update.tv";
	final String getPage="TravelUpdateForm";
	final String gotoPage = "redirect:/list.tv";
	
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction(@RequestParam(value="num") int num,
							Model model) {
		TravelBean travel= travelDao.selectOneTravel(num);
		model.addAttribute("travel",travel);
		return getPage;
		
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
							@RequestParam(value="pageNumber") int pageNumber,
							@ModelAttribute("travel") @Valid TravelBean travel,
							BindingResult result
			) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		} 
		
		int cnt = travelDao.updateTravel(travel);
		if(cnt >=1) {
			mav.setViewName(gotoPage+"?pageNumber="+pageNumber);		
			} else {
				mav.setViewName(getPage);
			}
		return mav;
	}
}
