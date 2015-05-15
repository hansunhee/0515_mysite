package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVo;

public class MemberDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=DriverManager.getConnection(dburl,"webdb","webdb");
		return conn;
	}
	
	public void insert(MemberVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="INSERT INTO MEMBER VALUES(MEMBER_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getGender());
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();					
		if(conn!=null) conn.close();
	}
	public MemberVo getMember(MemberVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="SELECT * FROM MEMBER WHERE EMAIL = ? AND PASSWORD = ?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, vo.getEmail());
		stmt.setString(2, vo.getPassword());
		ResultSet rs=stmt.executeQuery();
		MemberVo member=null;
		if(rs.next()){
			member=new MemberVo();
			member.setNo(rs.getLong(1));
			member.setName(rs.getString(2));
			member.setEmail(rs.getString(3));
			//member.setPassword(rs.getString(4));
			member.setGender(rs.getString(5));
		}
		if(rs!=null) rs.close();					
		if(stmt!=null) stmt.close();					
		if(conn!=null) conn.close();
		return member;
	}
	public void update(MemberVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql=" UPDATE MEMBER SET NAME=?, GENDER=? WHERE EMAIL = ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getGender());
		pstmt.setString(3, vo.getEmail());
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();					
		if(conn!=null) conn.close();
	}
}
