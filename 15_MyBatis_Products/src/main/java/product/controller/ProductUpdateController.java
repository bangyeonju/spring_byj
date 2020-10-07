package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.taglibs.standard.tag.common.core.RemoveTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {
	final String command="/update.prd";
	final String getPage = "ProductUpdateForm";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command , method=RequestMethod.GET)
	public String doAction(@RequestParam(value="num",required=true) int num,
							Model model,
							HttpSession session ) {
		
		System.out.println("loginInfo:"+session.getAttribute("loginInfo"));
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/update.prd?num="+num);
			return "redirect:/loginForm.me";
		} else {
			Product product = productDao.getOneData(num);
			model.addAttribute("product", product);
			return getPage;
		}
		
		
	}
	
	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doAction(@Valid Product product,
									BindingResult result
								) {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 오류");
			mav.setViewName(getPage);
			return mav;
			// return new ModelAndView(getPage);
		}
		
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);
		// C:\Spring_byj\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\15_MyBatis_Products\resources
		
		System.out.println("새로 선택한 화일명 : " + product.getImage()); // 정장.jpg => 가방.jpg
		
		File file = new File(uploadPath + File.separator + product.getImage());
		//C:\Spring_ysy\~~~resources\가방.jpg
		
		//수정하기전에 이미지 지우기!
		File delFile = new File(uploadPath+ File.separator+ product.getUploadOld());
		delFile.delete();
		
		MultipartFile multi = product.getUpload();
		try {
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		productDao.updateData(product);
		mav.setViewName(gotoPage);
		return mav;
	}
	
}


