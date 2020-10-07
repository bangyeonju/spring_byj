package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {

	final String command = "/delete.prd";
	final String getPage = "redirect:/list.prd";

	@Autowired
	ServletContext servletContext;

	@Autowired
	ProductDao productDao;

	@RequestMapping(command)
	public String doAction(@RequestParam(value = "num", required = true) int num) {
		Product product = productDao.getOneData(num);
		System.out.println(product.getImage());

		String uploadPath = servletContext.getRealPath("/resources");
		File delFile = new File(uploadPath + File.separator + product.getImage());
		delFile.delete();
		productDao.deleteData(num);

		return getPage;

	}
}
