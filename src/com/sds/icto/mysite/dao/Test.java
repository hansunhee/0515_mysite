package com.sds.icto.mysite.dao;

import java.util.List;

import com.sds.icto.mysite.vo.BoardVo;

public class Test {
	public static void main(String[] args) {
		
		try{
			BoardVo vo=new BoardVo();
			vo.setTitle("gg");
			vo.setContent("!!!!!!!!!!!!!!!!!!!!");
			vo.setMemberno(1);
			vo.setMembername("hansunhee");
			vo.setViewcnt(0);
			
			BoardDao dao=new BoardDao();
			
//			dao.delete(2L);
		
			BoardVo b=dao.selectOne(3L);
			b.setViewcnt(11L);
			dao.updateViewcnt(b);
			
			
			System.out.println(b);
			
			List<BoardVo> list=dao.selectList();
			for (BoardVo board : list) {
				System.out.println(board);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
