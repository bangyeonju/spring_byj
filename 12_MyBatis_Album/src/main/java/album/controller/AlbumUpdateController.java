package album.controller;

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

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	final String command = "update.ab";
	final String  getPage ="AlbumUpdateForm";
	final String gotoPage ="redirect:/list.ab";
	@Autowired
	private AlbumDao albumdao;
	
	//model방식으로 넘기는 방법.!
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam int num,Model model) {
		System.out.println(num);
		AlbumBean album = albumdao.selectOneAlbum(num);
		model.addAttribute("album",album);
		return getPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("album")@Valid AlbumBean album,
								BindingResult result) {
		System.out.println("update()");
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { //유효성검사에서  
			mav.setViewName(getPage); //updateForm으로
			return mav;
		}
		
		int cnt =albumdao.updateAlbum(album);
		
		if(cnt>0) { //성공적으로 업데이트 되면 list호출 
				mav.setViewName(gotoPage); 
		}else {//업데이트 실패하면 UpdateForm으로
			mav.setViewName(getPage);//
		}
		return mav;
	}
}
