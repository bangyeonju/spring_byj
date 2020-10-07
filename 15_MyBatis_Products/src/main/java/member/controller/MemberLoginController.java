package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberLoginController {

	final String command = "/loginForm.me";
	final String getPage = "MemberLoginForm";
	
	@Autowired
	MemberDao memberDao;
	
	// ProductInsertController에서 get방식으로 넘어옴
	@RequestMapping(value=command , method=RequestMethod.GET)
	public String doAction() {
		System.out.println(getClass() + " GET방식"); // MemberLoginController GET방식
		return getPage;
	}
	
	//MemberLoginForm.jsp에서 post방식으로 넘어옴
	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doAction(Member member,
							HttpServletResponse response,
							HttpSession session 
			) throws IOException {
		System.out.println(getClass() + " POST방식"); // MemberLoginController POST방식
		
		System.out.println("입력한 id:"+member.getId());
		System.out.println("입력한 password:" + member.getPassword());
		
		Member dbMember = memberDao.getData(member.getId());
		PrintWriter pw = response.getWriter(); //객체만드는법
		response.setContentType("text/html;charset=UTF-8");//한글처리
//		ModelAndView mav = new ModelAndView();
		if(dbMember == null) {
			System.out.println("존재하지 않는 회원");//콘솔창에 출력
			// pw.println("존재하지 않은 회원");//웹브라우저에 출력
			pw.println("<script type='text/javascript'>");
			pw.println("alert('해당아이디가 존재하지 않습니다.');");
			pw.println("</script>");
			pw.flush();// 웹브라우저에 내보낼때 사용
			return new ModelAndView(getPage);
			
		}
		else {
			System.out.println("존재하는 회원");
			
	/*
			pw.println("<script type='text/javascript'>");
			pw.println("alert('존재하는 회원입니다.');");
			pw.println("</script>");
			pw.flush();//내보내야?
	*/
			if(member.getPassword().equals(dbMember.getPassword())) {
				session.setAttribute("loginInfo",dbMember);// loginInfo으로세션설정
				System.out.println(session.getAttribute("destination")); 
				
			//방법1	return (String)session.getAttribute("detination");
			
//				mav.setViewName((String)session.getAttribute("detination"));
//				return mav;
				return new ModelAndView((String)session.getAttribute("destination"));//ProductInsertController에서 설정함. 여기서는 destination=redirect:/insert.prd
				
			} else {
				System.out.println("아이디는 일치, 비번은 불일치");
				pw.println("<script type='text/javascript'>");
				pw.println("alert('비번이 일치하지 않습니다.');");
				pw.println("</script>");
				pw.flush();//내보내야?
			}
			//return getPage;
			return new ModelAndView(getPage);
			
		}
	}
}







