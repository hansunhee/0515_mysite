<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul>
	<c:choose>
		<c:when test="${param.type == 'main' }">
			<li class="selected" id="name">${sessionScope.authMember.name }</li>
			<li><a href="/mysite/guestbook?a=list">방명록</a></li>
			<li><a href="/mysite/board?a=list">게시판</a></li>		
		</c:when>
		<c:when test="${param.type == 'guestbook' }">
			<li id="name">${sessionScope.authMember.name }</li>
			<li class="selected"><a href="/mysite/guestbook?a=list">방명록</a></li>
			<li><a href="/mysite/board?a=list">게시판</a></li>		
		</c:when>
		<c:when test="${param.type == 'board' }">
			<li id="name">${sessionScope.authMember.name }</li>
			<li><a href="/mysite/guestbook?a=list">방명록</a></li>
			<li class="selected"><a href="/mysite/board?a=list">게시판</a></li>		
		</c:when>
		<c:otherwise>
			<li class="selected" id="name">${sessionScope.authMember.name }</li>
			<li><a href="/mysite/guestbook?a=list">방명록</a></li>
			<li><a href="/mysite/board?a=list">게시판</a></li>				
		</c:otherwise>
	</c:choose>
</ul>