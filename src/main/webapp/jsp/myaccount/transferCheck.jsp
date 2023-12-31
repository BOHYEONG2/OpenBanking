<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Check</title>
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
        .container {
            margin-top: 70px;
        }
        .card {
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #f8f9fa;
        }
        .card-body {
            padding: 15px;
        }
        .card-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
  <header>
    <%@include file="/index.jsp" %>
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
		<form action="${pageContext.request.contextPath}/transferMoneyProcess.do" method="post">
    <div class="card">
        <div class="card-header">
            <h5 class="card-title">보내는 사람</h5>
        </div>
        <div class="card-body">
           <input name="senderName" value="${loginUser.name}">
           <input  name="senderAcNumber" value="<%= request.getAttribute("senderAcNumber") %>">
      	   <input  name="sendMoney" value="<%= request.getAttribute("sendMoney") %>">
           <input  name="message" value="<%= request.getAttribute("message") %>">
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title">받는 사람</h5>
        </div>
        <div class="card-body">
            <input  name="receiverBank" value="<%= request.getAttribute("receiverBank") %>">
            <input name="receiverName" value="<%= request.getAttribute("receiverName") %>">
            <input  name="receiverAcNumber" value="<%= request.getAttribute("receiverAcNumber") %>">
            <input  name="message" value="<%= request.getAttribute("message") %>">
        </div>
    </div>
		        <button type="submit" class="btn btn-primary">송금하기</button>
		</form>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>