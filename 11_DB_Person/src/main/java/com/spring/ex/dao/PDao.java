package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "jspid";
	private String pw = "jsppw";
	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private static PDao dao= null;
		
	
	private PDao() {
		try {
			Class.forName(driver);
			DriverManager.getConnection(url,user,pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//ΩÃ±€≈Ê ∆–≈œ¿∏∑Œ ∞¥√º∏∏µÈ±‚.
		public static PDao getInstance() {
			if(dao==null) {
				dao=new PDao();
			}
			return dao;
			
	}
		public void write(String id,String name,String age) {
			String sql = "insert into person(num,id,name,age) values(person_seq.nextval,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setInt(3, Integer.parseInt(age));
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(ps!=null) {
						ps.close();
					}
					
				}catch (Exception e) {
				}
			}
			
			
		}
		public ArrayList<PDto> list(){
			String sql = "select * from person order by num";
			ArrayList<PDto> lists = new ArrayList<PDto>();
			try {
				ps = conn.prepareStatement(sql);
				rs= ps.executeQuery();
				while(rs.next()) {
					int num = Integer.parseInt(rs.getString("num"));
					String id = rs.getString("id");
					String name = rs.getString("name");
					int age = Integer.parseInt(rs.getString("age"));
					PDto dto = new PDto(num, id, name, age);
					lists.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return lists;
		}

}
