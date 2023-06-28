<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/JooBank/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/index.jsp" />
	</header>
	<section>
		<button><a href="${contextPath}/account/createAccount.jsp">계좌개설하기</a></button>
		<br> <br>
		<c:choose>
				<c:when test="${ empty accountList }"> 
			 		계좌가 없습니다.
			 	</c:when>
				<c:otherwise>
					<c:forEach var="account" items="${ accountList }">
						<table border="1">
							<tr>
							<td>
							<button><a href="${contextPath}/depositPage.do?ac_number=${ account.ac_number }">입금</a></button>&nbsp;&nbsp;
							<button><a href="${contextPath}/withdrawPage.do?ac_number=${ account.ac_number }">출금</a></button>&nbsp;&nbsp;
							<button><a href="${contextPath}/trasferPage.do?ac_number=${ account.ac_number }">이체</a></button>
							</td>
							<td>
							${ account.AC_OP_DATE }
							</td>
							</tr>
							<tr>
								<td>${ account.bank_name }</td>
								<td>${ account.pd_name }</td>
								<td>${ account.name }</td>
							</tr>
							<tr>
								<td ><a href="${contextPath}/getAc_recordList.do?ac_number=${ account.ac_number }">${ account.ac_number }</a></td>
								<td COLSPAN="2" align="right" style="width:250px">
								 잔액 : <fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" /> 원
								 </td>
							</tr>
						</table>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
	</section>
</body>
</html>