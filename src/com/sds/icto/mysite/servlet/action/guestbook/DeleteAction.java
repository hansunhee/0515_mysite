package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("no");
		String password=request.getParameter("password");
		GuestBookDao dao=new GuestBookDao();
		GuestBookVo vo=dao.selectOne(Long.parseLong(no));
		if(vo.getPassword().equals(password)){
			dao.delete(Long.parseLong(no));		
			response.sendRedirect("/mysite/guestbook");
		}else{
			request.setAttribute("msg", "비밀번호를 다시 확인해주세요!");
			request.setAttribute("no", no);
			WebUtil.forward("/views/guestbook/deleteform.jsp", request, response);	
		}
	}

}
