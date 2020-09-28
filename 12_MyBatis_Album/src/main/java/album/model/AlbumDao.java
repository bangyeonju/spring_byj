package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

//AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")//객체생성
public class AlbumDao {
	@Autowired//객체주입. 다른곳에서 만든객체를 여기다가 넣어라!
	SqlSessionTemplate sqlSessionTemplate;
	public int insertAlbum(AlbumBean album) {
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum",album);//(album.AlbumBean라는 namespace로 가보라 )안에InsertAlbum실행시켜라 
											//*AlbumBean이랑 상관없음
		System.out.println("insertAlbum cnt :"+cnt);
		return cnt;
		
	}
										// Paging pageInfo : 한페이지에 2개씩 보이게 한다는 설정이 들어와있땅
	public List<AlbumBean> getAlbumList(Paging pageInfo,Map<String, String> map){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		//new RowBounds(0,2);
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList",map,rowBounds);//album.AlbumBean의 namespace GetAlbumList를 말하는거다.
		System.out.println("lists.size:"+lists.size());									//GetAlbumList으로갈때 map를 챙겨서 간다.
		return lists;
	}
	public int deleteAlbum(int num) {
		int cnt =sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum",num);
		return cnt;		
	}
	public AlbumBean selectOneAlbum(int num) {
		AlbumBean album= null;
		album = sqlSessionTemplate.selectOne("album.AlbumBean.SelectOneAlbum",num);
		return album;
	}
	public int updateAlbum(AlbumBean album) {
		//System.out.println("1");
		int cnt = sqlSessionTemplate.update("album.AlbumBean.UpdateAlbum",album);
		return cnt;
	}
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("album.AlbumBean.GetTotalCount",map);
		return cnt;
	}
}
