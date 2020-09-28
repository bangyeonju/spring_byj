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
	
	//model������� �ѱ�� ���.!
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num,
						   @RequestParam("pageNumber") int pageNumber,
						   @RequestParam("pageSize") int pageSize,
							Model model
			) {
		System.out.println("num:"+num);
		AlbumBean album = albumdao.selectOneAlbum(num);
		model.addAttribute("album",album);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		return getPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView update(	@RequestParam("pageNumber") int pageNumber,
								@RequestParam("pageSize") int pageSize,
								@ModelAttribute("album")@Valid AlbumBean album,
								BindingResult result) {
		System.out.println("update()");
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { //��ȿ���˻翡��  
			mav.addObject("pageNumber",pageNumber);
			mav.addObject("pageSize",pageSize);
			mav.setViewName(getPage); //updateForm����
			
			return mav;
		}
		
		int cnt =albumdao.updateAlbum(album);
		
		if(cnt>0) { //���������� ������Ʈ �Ǹ� listȣ�� 
				mav.setViewName(gotoPage+"?pageNumber="+pageNumber+"&pageSize="+pageSize); 
				//"redirect:/list.ab?pageNumber"+pageNumber+"&pageSize="+pageSize; �䷯�ɰ����Ѵ�.
		}else {//������Ʈ �����ϸ� UpdateForm����
			mav.setViewName(getPage);//
		}
		return mav;
	}
}
