<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Transaction List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
    
        body {
            padding: 20px;
        }
        .header {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            background-color: #f8f9fa;
            padding: 10px 20px;
            z-index: 999;
        }
        .container {
            margin-top: 70px;
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

        <form action="${pageContext.request.contextPath}/transactionHistory.do" method="post">
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
    <h2>입출금 내역</h2>

    <table class="table">
        <thead>
            <tr>
                <th>거래번호</th>
                <th>거래유형</th>
                <th>이름</th>
                <th>거래금액</th>
                <th>거래일시</th>
                <th>거래후잔액</th>
                <th>메시지</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="record" items="${accountRecords}">
                <tr>
              	    <td>${accountRecord.rcNo}</td>
                    <td>${accountRecord.rcType}</td>
                    <td>${accountRecord.rcName}</td>
                    <td>${accountRecord.rcMoney}</td>
                    <td>${accountRecord.rcTime}</td>
                    <td>${accountRecord.rcBalance}</td>
                    <td>${accountRecord.rcText}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>