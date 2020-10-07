package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	final String command ="/delete.me";
	final String getPage="MemberList";
	final String gotoPage = "redirect:/list.me";

	@Autowired
	MemberDao memberdao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			@RequestParam(value="id",required=true) String id )  {
		memberdao.deleteData(id);
		System.out.println("pageNumber:"+pageNumber);
			return gotoPage+"?pageNumber="+pageNumber;
	}
	
	
}

