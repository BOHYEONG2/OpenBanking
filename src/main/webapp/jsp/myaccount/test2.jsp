<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<title>����¡ ó��</title>
	<link rel="stylesheet" href="../css/table.css" />
	<style>
		img {
			border: 0px;
		}
	</style>
</head>                          
<body>
	<header>
		<jsp:include page="/index.jsp" />
	</header>
	<table>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
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
							<td>${board.viewCnt}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<%-- ����¡ ���̺� --%>
		<table width="70%">
		<tr>
			<td valign="middle">
			<%-- ó�� ������ ���� --%>
			<c:choose>
				<c:when test="${pageNo == 1}" >
					<img alt="첫 페이지" src="../images/btn_first.gif" align="middle">
				</c:when>
				<c:otherwise>
					<a href="list4.jsp?pageNo=1">
						<img alt="ó������" src="../images/btn_first.gif" align="middle">
					</a>
				</c:otherwise>
			</c:choose>
			
			<%-- ���� ������ ���� --%>
			<c:choose>
				<c:when test="${beginPage == 1}" >
					<img alt="����" src="../images/btn_pre.gif" align="middle">
				</c:when>
				<c:otherwise>
					<a href="list4.jsp?pageNo=${beginPage - 1}">
						<img alt="����" src="../images/btn_pre.gif" align="middle">
					</a>
				</c:otherwise>
			</c:choose>
			
			<%-- ������ ��ȣ ���� --%>			
			<c:forEach var="i" begin="${beginPage}" end="${endPage}">
				<c:if test="${i eq pageNo}">
					<strong>[${i}]</strong>
				</c:if>
				<c:if test="${i ne pageNo}">
					<a href="list4.jsp?pageNo=${i}">[${i}]</a>
				</c:if>
			</c:forEach>
			
			<%-- ���� ������ ���� --%>
			<c:choose>
				<c:when test="${endPage == lastPage}" >
					<img alt="����" src="../images/btn_next.gif" align="middle">
				</c:when>
				<c:otherwise>
					<a href="list4.jsp?pageNo=${endPage + 1}">
						<img alt="����" src="../images/btn_next.gif" align="middle">
					</a>
				</c:otherwise>
			</c:choose>
			
			<%-- ������ ������ ���� --%>
			<c:choose>
				<c:when test="${pageNo == lastPage}" >
					<img alt="������" src="../images/btn_last.gif" align="middle">
				</c:when>
				<c:otherwise>
					<a href="list4.jsp?pageNo=${lastPage}">
						<img alt="������" src="../images/btn_last.gif" align="middle">
					</a>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>	
		</table>
	</div>
</body>
</html>