<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="guestbook">
			<form method="post" action="/mysite/guestbook">
			<input type='hidden' name="a" value="delete">
			<input type='hidden' name="no" value="${no }">
			<div id="checkDiv">
				<c:if test="${!empty msg }">
					<div id="msg">${msg }</div>
				</c:if>
				<br>
			<table id="checkTable">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"></td>
					<!-- <td><a href="/guestbook/main">메인으로 돌아가기</a></td> -->
				</tr>
			</table>
				<input type="submit" value="확인" class="btn">
				<div>
				<a href="/mysite/guestbook?a=list">방명록 리스트</a>
				</div>
			</div>
			</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="guestbook"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>