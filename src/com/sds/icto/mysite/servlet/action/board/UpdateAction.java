package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.web.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		String no=request.getParameter("no");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		BoardDao dao=new BoardDao();
		BoardVo vo=dao.selectOne(Long.parseLong(no));
		vo.setTitle(title);
		vo.setContent(content);
		dao.update(vo);
		response.sendRedirect("/mysite/board?a=list");
	}

}
