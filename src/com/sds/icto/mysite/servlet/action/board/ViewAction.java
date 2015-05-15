package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		String no=request.getParameter("no");
		BoardDao dao=new BoardDao();
		BoardVo vo=new BoardVo();
		vo.setNo(Long.parseLong(no));
		dao.updateViewcnt(vo);
		BoardVo board=dao.selectOne(Long.parseLong(no));		
		request.setAttribute("vo", board);
		
		HttpSession session=request.getSession();
		MemberVo authMember=(MemberVo)session.getAttribute("authMember");
		if(authMember.getNo()==board.getMemberno()){
			WebUtil.forward("/views/board/updateform.jsp", request, response);
		}else{
			WebUtil.forward("/views/board/view.jsp", request, response);
		}
	}

}
