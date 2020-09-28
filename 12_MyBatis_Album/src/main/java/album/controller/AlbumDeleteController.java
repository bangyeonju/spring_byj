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
	private AlbumDao albumdao;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("num") int num,
								@RequestParam("pageNumber") int pageNumber
								) {
		System.out.println("1");
	albumdao.deleteAlbum(num);
		
		return gotoPage+"?pageNumber="+pageNumber;
				
		
	}
	
}
