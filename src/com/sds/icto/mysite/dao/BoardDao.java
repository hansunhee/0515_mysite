package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.BoardVo;


public class BoardDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}
	public void add(BoardVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="INSERT INTO BOARD VALUES(BOARD_NO_SEQ.NEXTVAL, ?, ?, ?, ?, 0, SYSDATE)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getContent());
		stmt.setLong(3, vo.getMemberno());
		stmt.setString(4, vo.getMembername());
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public void delete(Long no) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="DELETE FROM BOARD WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1, no);
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public void update(BoardVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="UPDATE BOARD SET TITLE = ? , CONTENT = ? WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getContent());
		stmt.setLong(3, vo.getNo());
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public void updateViewcnt(BoardVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="UPDATE BOARD SET VIEW_CNT = VIEW_CNT+1 WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1, vo.getNo());
		stmt.executeUpdate();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
	public BoardVo selectOne(Long no) throws ClassNotFoundException, SQLException{
		BoardVo vo=new BoardVo();
		Connection conn=getConnection();
		String sql="SELECT * FROM BOARD WHERE NO = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setLong(1, no);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			String title=rs.getString(2);
			String content=rs.getString(3);
			long memberno=rs.getLong(4);
			String membername=rs.getString(5);
			long viewcnt=rs.getLong(6);
			Date regdate=rs.getDate(7);
			vo=new BoardVo(no, title, content, memberno, membername, viewcnt, regdate);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		return vo;
	}
	public List<BoardVo> selectList() throws ClassNotFoundException, SQLException{
		List<BoardVo> list=new ArrayList<BoardVo>();
		Connection conn=getConnection();
		String sql="SELECT * FROM BOARD";
		PreparedStatement stmt=conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			Long no=rs.getLong(1);
			String title=rs.getString(2);
			String content=rs.getString(3);
			long memberno=rs.getLong(4);
			String membername=rs.getString(5);
			long viewcnt=rs.getLong(6);
			Date regdate=rs.getDate(7);
			list.add(new BoardVo(no, title, content, memberno, membername, viewcnt, regdate));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		return list;
	}
	public List<BoardVo> search(String keyword) throws ClassNotFoundException, SQLException{
		List<BoardVo> list=new ArrayList<BoardVo>();
		Connection conn=getConnection();
		String sql="SELECT * FROM BOARD WHERE TITLE LIKE ? ORDER BY NO DESC";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, "%"+keyword+"%");
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			Long no=rs.getLong(1);
			String title=rs.getString(2);
			String content=rs.getString(3);
			long memberno=rs.getLong(4);
			String membername=rs.getString(5);
			long viewcnt=rs.getLong(6);
			Date regdate=rs.getDate(7);
			list.add(new BoardVo(no, title, content, memberno, membername, viewcnt, regdate));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		return list;
		
	}
}
