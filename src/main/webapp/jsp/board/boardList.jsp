<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
	table {
		border-collapse: collapse;
		width: 80%;
		margin: 0 auto;
		margin-top: 30px;
	}

	th, td {
		border: 1px solid #ddd;
		padding: 8px;
		text-align: center;
	}

	tr:nth-child(even) {
		background-color: #f2f2f2;
	}

	tr:hover {
		background-color: #ddd;
	}

	.btn-write {
		text-align: right;
		margin-top: 10px;
		margin-right: 190px;
	}

	.btn-write a {
		display: inline-block;
		padding: 10px 20px;
		border-radius: 5px;
		background-color: #333;
		color: #fff;
		text-decoration: none;
	}

	.empty-msg {
		text-align: center;
		font-size: 14px;
		color: #333;
		margin-top: 50px;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="/index.jsp" />
	</header>
	<section>

		<table>
		
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty boardList}">
					<tr>
						<td colspan="4" class="empty-msg">등록된 글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.boardNo}</td>
							<td>${board.userId}</td>
							<td>
								 <a href="${contextPath}/getBoard.do?boardNo=${board.boardNo}">${board.title}</a>
							</td>
							<td><fmt:formatDate value="${board.boardTime}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="btn-write">
			<a href="${contextPath}/jsp/board/board.jsp">글쓰기</a>
		</div>
	</section>
</body>
</html>