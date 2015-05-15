<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
<title>mysite</title>
<script type="text/javascript" src="/mysite/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#listBtn").click(function(){
		location.href="/mysite/board?a=list";
	})
});
</script>
</head>
<body>

<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="board">
				<table width=500 id="insertForm">
				<tr>
					<th>제목</th><td colspan="3"><input type="text" name="name" required="required" readonly="readonly" id="title-box" value="${vo.title }"></td>
				</tr>
				<tr>
					<th>작성자</th><td><input type="text" name="name" required="required" readonly="readonly" value="${vo.membername }"></td>
					<th>조회수</th><td><input type="text" name="pass" required="required" readonly="readonly" value="${vo.viewcnt }"></td>
				</tr>
					<tr>
					<td colspan=4><textarea name="content" cols=70 rows=5 required="required" readonly="readonly">${vo.content }</textarea></td>
				</tr>
				</table>
				<div id="writeBtnDiv">
					<span>
					<input type="button" value="게시판으로" id="listBtn" class="btn">
					</span>
				</div>

				
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="board"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp"></c:import>
		</div>
	</div>

</body>
</html>
