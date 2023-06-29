<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Banking</title>
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

        .container {
            margin-top: 130px;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 70%;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
        }
        
        .container h2 {
            margin-bottom: 20px;
        }
        
        .container .button {
            margin-top: 20px;
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

    <h2 class="hidden">오픈뱅킹 약관 동의</h2>
    <p class="hidden">오픈뱅킹을 이용하기 위해서는 약관에 동의해야 합니다.</p>
    <button class="btn btn-gold hidden" onclick="location.href='${pageContext.request.contextPath}/openBankingAgreement.do'">약관 동의</button>

    <h2>계좌 이체</h2>
    <p>다른 계좌로 송금을 하려면 아래의 버튼을 클릭하세요.</p>
    <button class="btn btn-gold" onclick="location.href='${pageContext.request.contextPath}/transferMoney.do'">계좌 이체</button>

  
</div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>