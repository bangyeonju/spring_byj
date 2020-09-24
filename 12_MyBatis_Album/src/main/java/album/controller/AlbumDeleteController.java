package album.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumDao;
@Controller
public class AlbumDeleteController {
	final String command= "delete.ab";
	final String gotoPage="redirect:/list.ab";
	@Autowired
	AlbumDao albumdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("num") int num) {
		System.out.println("1");
		int cnt = albumdao.deleteAlbum(num);
		
		System.out.println(cnt);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(gotoPage);
		return mav;
				
		
	}
	
}
