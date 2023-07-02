<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
   <style>
        .sidebar {
            position: fixed;
            top: 50%;
            left: 10px;
            transform: translateY(-50%);
            padding: 10px;
            
        }

        .sidebar .button {
            width: 5cm;
            height: 60px;
            display: inline-block;
            padding: 10px 20px;
            border:0.05px solid;
            background-color: lightgray;
            color: black;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            border-radius: 0;
            transition: background-color 0.3s ease;
        }

        .sidebar .button:hover {
            background-color: gray;
        }

        .accountListTable {
            margin-top: 130px;
            text-align: center;
            margin-left: auto;
            margin-right: 40%;
            width: 70%;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
        }

        .accountListTable th {
            background-color: #333;
            color: #fff;
        }
          .btn-gold {
        color: #ffffff;
        background-color: #ffd700;
        border-color: #ffd700;
    }
    
    .btn-gold:hover {
        color: #ffffff;
        background-color: #cca300;
        border-color: #cca300;
    }
    </style>
</head>
<body>
    <header>  
            <jsp:include page="/index.jsp" />
    </header>

    <div class="sidebar">  	
        <form action="${pageContext.request.contextPath}/myAccount.do" method="post">
            <button type="submit" class="button">나의계좌</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/createAccount.do" method="post">
            <button type="submit" class="button">계좌개설</button>
        </form>

        <form action="${pageContext.request.contextPath}/transactionHistory.do?id=${loginUser.id}" method="post">
       	    <input type="hidden" name="acNumber">         
            <button type="submit" class="button">입출금 내역조회</button><br>
        </form>

        <form action="${pageContext.request.contextPath}/openBanking.do" method="post">
            <button type="submit" class="button">오픈뱅킹</button><br>
        </form>

        <form action="${pageContext.request.contextPath}/closeAccount.do" method="post">
            <button type="submit" class="button">계좌해지</button>
        </form>   
    </div>
	<div class="container">
   	 <table class="table table-bordered accountListTable">
        <thead>
            <tr>
                <th>계좌번호</th>
                <th>계좌이름</th>
                <th>계좌잔액</th>
                <th>계좌생성일</th>
                <th>계좌만료일</th>
                <th>계좌상태</th>
            </tr>
        </thead>
   <tbody>
                <c:choose>
                    <c:when test="${ empty accountList }">
                        <tr>
                            <td colspan="6">
                                보유하신 계좌가 없습니다. 계좌를 개설해 주십시요 -->>
                                <button class="btn btn-sm btn-gold" style="color: black;" onclick="location.href='${pageContext.request.contextPath }/createAccount.do'">계좌개설</button>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="account" items="${accountList}">
                            <tr>
                                <td>${account.ac_number}</td>
                                <td>${account.AC_NAME}</td>
                                <td>${account.AC_MONEY}</td>
                                <td>${account.AC_OP_DATE}</td>
                                <td>${account.AC_ED_DATE}</td>
                                <td>${account.STATE}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
    </table>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
