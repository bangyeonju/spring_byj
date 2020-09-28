package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
//	@RequestMapping("list")
	
	final String command="list.ab";
	final String getPage = "AlbumList";
	
	@Autowired
	private AlbumDao albumDao;//
	
	@RequestMapping(command)
	//url창에 list.ab창에 칠떄...안넘어..required=false로 해야댄다..
	public ModelAndView doAction(@RequestParam(value="whatColumn",required=false) String whatColumn,
								@RequestParam(value="keyword",required=false) String keyword,
								@RequestParam(value="pageNumber",required=false) String pageNumber,
								@RequestParam(value="pageSize",required=false) String pageSize,
								HttpServletRequest request,Model model) {
		
		System.out.println("whatcolumn:"+whatColumn);
		System.out.println("keyword:"+keyword);
		System.out.println("pageNumber:"+pageNumber);
		System.out.println("pageSize:"+pageSize);
		Map<String, String> map = new HashMap<String,String >();
		
		map.put("whatColumn", whatColumn);//whatColumn=title
		map.put("keyword", "%"+keyword+"%");//keyword=날
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount:"+totalCount);
		
		
		String url = request.getContextPath() +"/"+command ;
		System.out.println("url:"+url);
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword); //pageIngo는 Paging객체 관리자 입니다.
		
		System.out.println("offset:"+pageInfo.getOffset());
		System.out.println("limit : "+pageInfo.getLimit());
		
		
		
		
		
		List<AlbumBean> lists = albumDao.getAlbumList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.addObject("pageInfo",pageInfo);
		model.addAttribute("totalCount",totalCount);
		mav.setViewName(getPage);
		return mav;
	}

}

