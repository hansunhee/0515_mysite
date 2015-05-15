package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.dao.MemberDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		String title=request.getParameter("title");
		String password=request.getParameter("password");
		String content=request.getParameter("content");
		
		HttpSession session=request.getSession();
		MemberVo authMember=(MemberVo)session.getAttribute("authMember");
		System.out.println(authMember);
		authMember.setPassword(password);
		MemberDao mdao=new MemberDao();
		MemberVo member=mdao.getMember(authMember);
		System.out.println(member);
		if(member==null){
			WebUtil.forward("/views/board/insertformerror.jsp", request, response);
		}else{
			BoardVo vo=new BoardVo(title, content, authMember.getNo(), authMember.getName());
			BoardDao dao=new BoardDao();
			dao.add(vo);
			response.sendRedirect("/mysite/board?a=list");
		}
		
	}

}
