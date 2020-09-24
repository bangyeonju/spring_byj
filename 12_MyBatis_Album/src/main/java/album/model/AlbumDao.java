package album.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")//��ü����
public class AlbumDao {
	@Autowired//��ü����. �ٸ������� ���簴ü�� ����ٰ� �־��!
	SqlSessionTemplate sqlSessionTemplate;
	public int insertAlbum(AlbumBean album) {
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum",album);//(album.AlbumBean��� namespace�� ������ )�ȿ�InsertAlbum������Ѷ� 
											//*AlbumBean�̶� �������
		System.out.println("insertAlbum cnt :"+cnt);
		return cnt;
		
	}
	public List<AlbumBean> getAlbumList(){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList");//album.AlbumBean�� namespace GetAlbumList�� ���ϴ°Ŵ�.
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
