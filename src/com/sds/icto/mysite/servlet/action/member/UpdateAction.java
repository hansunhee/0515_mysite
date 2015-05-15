package com.sds.icto.mysite.servlet.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.MemberDao;
import com.sds.icto.mysite.vo.MemberVo;
import com.sds.icto.web.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		HttpSession session=request.getSession(false);
		MemberVo authMember=(MemberVo)session.getAttribute("authMember");
		if(authMember!=null){
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			authMember.setName(name);
			authMember.setGender(gender);
			MemberDao dao=new MemberDao();
			dao.update(authMember);
			response.sendRedirect("/mysite/views/member/myinfo.jsp");			
		}else{
			response.sendRedirect("/mysite/member?a=loginform");
			return;
		}
		
	}

}
