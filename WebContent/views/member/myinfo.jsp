<%@page import="com.sds.icto.mysite.vo.MemberVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo authMember=(MemberVo)session.getAttribute("authMember");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="header">
		<c:import url="/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinForm" method="post" action="/mysite/member">
				<input type="hidden" name="a" value="update">
				<label class="block-label" for="name">이름</label>
				<input id="name" name="name" type="text" value="${sessionScope.authMember.name }">

				<label class="block-label" for="email">이메일</label>
				<input id="email" name="email" type="text" value="${sessionScope.authMember.email }" disabled="disabled">
				
				<fieldset>
					<legend>성별</legend>
					<%-- <label>여</label> <input type="radio" name="gender" value="female" <%= ("female".equals(authMember.getGender())) ? "checked" : "" %>>
					<label>남</label> <input type="radio" name="gender" value="male" <%= ("male".equals(authMember.getGender())) ? "checked" : "" %>> --%>
					<c:choose>
						<c:when test="${sessionScope.authMember.gender == 'female' }">
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
						</c:when>
						<c:otherwise>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
						</c:otherwise>
					</c:choose>
					<input type="submit" value="수정하기">
				</fieldset>
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>