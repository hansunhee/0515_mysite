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
<title>Insert title here</title>
<script type="text/javascript" src="/mysite/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#writeBtn").click(function(){
		location.href="/mysite/board?a=insertform";
	});
	$("#listTable tr").mouseover(function(){
		$(this).css("backgroundColor","#eee");
	})
	$("#listTable tr").mouseout(function(){
		$(this).css("backgroundColor","#fff");
	})
	$("#listTable tr").click(function(){
		console.log($(this).children());
		var no=$(this).children().children().val();
		location.href="/mysite/board?a=view&no="+no;
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
				<form method="post" action="/mysite/board">
				<input type="hidden" name="a" value="search">
					<table id="searchTable">
					<tr><td>
						<input type="text" name="search" style="  margin-left: 340px; width:150px;" placeholder="제목을 검색하세요">
					</td><td>
						<input type="image" src="/mysite/assets/images/search.png" name="submit" id="submit" style="width:25px;"> 
						<!-- <img src="/mysite/assets/images/search.png" style="width:25px;" id="searchBtn"> -->
						<!-- <input type="submit" value="검색" class="btn" id="searchBtn"> -->
					</td></tr>
					</table>
				</form>
				<table id="listTable">
					<tr>
						<th>번호</th><th>등록일</th><th>작성자</th><th>제목</th><th>조회수</th>
					</tr>
					<c:forEach items="${list }" var="board" varStatus="status">
					<tr>
						<td>${status.index + 1 }<input type="hidden" value="${board.no }"></td><td>${board.regdate }</td><td>${board.membername }</td><td>${board.title }</td><td>${board.viewcnt }</td>
					</tr>
					</c:forEach>
				</table>
				<div id="writeBtnDiv">
					<input type="button" value="글쓰기" id="writeBtn" class="btn">
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
