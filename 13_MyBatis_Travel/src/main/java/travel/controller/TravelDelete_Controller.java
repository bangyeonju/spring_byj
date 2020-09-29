package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDelete_Controller {
	
	final String gotoInsert = "delete.tv";
	final String gotoListPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(gotoInsert)
	public String delete(@RequestParam("num") int num) {
		travelDao.deleteTravel(num);
		return gotoListPage;
	}

}
