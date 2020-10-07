package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	final String command="/insert.prd";
	final String getPage = "ProductInsertForm";
	final String gotoPage="redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;

	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value =command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		//session���� �α��� �ߴ��� ���ߴ��� �� �� �ִ�.
		System.out.println("loginInfo :"+session.getAttribute("loginInfo")); //null
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination","redirect:/insert.prd");
			return "redirect:/loginForm.me";
		} else {
			return getPage;
		}
	}
	@RequestMapping(value =command, method = RequestMethod.POST)
	public ModelAndView doAction(@Valid Product product,
							BindingResult  result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		// request.getContextPath()
		
		// *�߿��մϴ�*
		MultipartFile multi = product.getUpload();// 
		
		System.out.println("servletContext.getRealPath('/') : "+servletContext.getRealPath("/"));
		String uploadPath = servletContext.getRealPath("/resources");//������ �ø� ��ġ. 
		System.out.println("uploadPath :" +uploadPath); // C:\spring_byj\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\15_MyBatis_Products\resources
		
		System.out.println("������ ���ϸ�:"+product.getImage()); // �׳� ���ڿ�!
		
		System.out.println("**********************************************************************");
		System.out.println(uploadPath+File.separator+product.getImage());
		File file = new File(uploadPath+File.separator+product.getImage()); //������ �����ϰ�(�ν��ϰ�) ��!
		try {
			multi.transferTo(file); //file������ ��� �͵� transferTo�� �Ἥ ��¥ ��ġ(~\wtpwebapps\15_MyBatis_Products\resources)�� �ö󰡰���.
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		//  *�߿��մϴ�*
		
		productDao.insertData(product);
		mav.setViewName(gotoPage);
		return mav;
	}
}
