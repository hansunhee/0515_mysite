package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		GuestBookDao dao=new GuestBookDao();
		List<GuestBookVo> list=dao.selectList();
		request.setAttribute("list", list);
		WebUtil.forward("/views/guestbook/list.jsp", request, response);
	}

}
