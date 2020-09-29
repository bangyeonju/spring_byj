package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myTravelDao")
public class TravelDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insertTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.insert("travel.TravelBean.InsertTravel",travel);
		return cnt;
	}
	
	public List<TravelBean> getTravelList(Map<String,String> map) {
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList("travel.TravelBean.SelectTravel",map);
		return lists;
	}
	
	public TravelBean getOneTravel(int num) {
		TravelBean travel =  null;
		travel = sqlSessionTemplate.selectOne("travel.TravelBean.GetOneTravel",num);
		return travel;
	}
	
	public int updateTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.update("travel.TravelBean.UpdateTravel",travel);
		return cnt;
	}
	
	public void deleteTravel(int num) {
		sqlSessionTemplate.delete("travel.TravelBean.DeleteTravel",num);
	}

}
