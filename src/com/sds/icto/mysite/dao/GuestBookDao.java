package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.GuestBookVo;

public class GuestBookDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}
	public void add(GuestBookVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="INSERT INTO GUESTBOOK VALUES(GUESTBOOK_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, vo.getName());
		stmt.setString(2, vo.getPassword());
		stmt.setString(3, vo.getMessage());
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public void delete(Long no) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="DELETE FROM GUESTBOOK WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1, no);
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public GuestBookVo selectOne(Long no) throws ClassNotFoundException, SQLException{
		GuestBookVo vo=new GuestBookVo();
		Connection conn=getConnection();
		String sql="SELECT * FROM GUESTBOOK WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1, no);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			String name=rs.getString(2);
			String password=rs.getString(3);
			String message=rs.getString(4);
			Date date=rs.getDate(5);
			vo=new GuestBookVo(no, name, password, message, date);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		return vo;
	}
	public List<GuestBookVo> selectList() throws ClassNotFoundException, SQLException{
		List<GuestBookVo> list=new ArrayList<GuestBookVo>();
		Connection conn=getConnection();
		String sql="SELECT * FROM GUESTBOOK";
		PreparedStatement stmt=conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			Long no=rs.getLong(1);
			String name=rs.getString(2);
			String password=rs.getString(3);
			String message=rs.getString(4);
			Date date=rs.getDate(5);
			list.add(new GuestBookVo(no, name, password, message, date));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		return list;
	}
}
