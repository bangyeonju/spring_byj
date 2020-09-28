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
										// Paging pageInfo : ���������� 2���� ���̰� �Ѵٴ� ������ �����ֶ�
	public List<AlbumBean> getAlbumList(Paging pageInfo,Map<String, String> map){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		//new RowBounds(0,2);
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList",map,rowBounds);//album.AlbumBean�� namespace GetAlbumList�� ���ϴ°Ŵ�.
		System.out.println("lists.size:"+lists.size());									//GetAlbumList���ΰ��� map�� ì�ܼ� ����.
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
