package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	final String command = "update.ab";
	final String gotoPage ="AlbumUpdateForm";
	final String  getPage ="redirect:/list.ab";
	@Autowired
	AlbumDao albumdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam int num) {
		AlbumBean ab=albumdao.selectOneAlbum(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(gotoPage);
		mav.addObject("ab",ab);
		return mav;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView update(@RequestParam AlbumBean bean) {
		System.out.println("update()");
		int cnt =albumdao.updateAlbum(bean);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPage);
		return mav;
	}
}
