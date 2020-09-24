package album.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public List<AlbumBean> getAlbumList(){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList");//album.AlbumBean의 namespace GetAlbumList를 말하는거다.
		return lists;
	}
	public int deleteAlbum(int num) {
		int cnt =sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum",num);
		return cnt;		
	}
	public AlbumBean selectOneAlbum(int num) {
		AlbumBean ab = sqlSessionTemplate.selectOne("album.AlbumBean.SelectOneAlbum",num);
			
		return ab;
	}
	public int updateAlbum(AlbumBean bean) {
		System.out.println("1");
		int cnt = sqlSessionTemplate.update("album.AlbumBean.UpdateAlbum",bean);
		return cnt;
	}
}
