package album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumListController {
//	@RequestMapping("list")
	
	final String command="list.ab";
	final String getPage = "AlbumList";
	
	@Autowired
	private AlbumDao albumDao;//
	
	@RequestMapping(command)
	public ModelAndView doAction() {
		List<AlbumBean> lists = albumDao.getAlbumList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.setViewName(getPage);
		return mav;
	}

}
