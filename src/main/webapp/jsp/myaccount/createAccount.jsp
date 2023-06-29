<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설</title>
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
        margin-top: 50px;
        max-width: 500px;
    }

    .my-4 {
        text-align: center;
    }

    .form-group {
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
    }

    .btn-primary {
        width: 100%;
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
    <h1 class="my-4">계좌 개설</h1>

    <form action="${pageContext.request.contextPath}/createAccountProcess.do" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" name="id" value="${loginUser.id}" required>
        </div>
        <div class="form-group">
            <label for="ac_name">계좌 이름:</label>
            <input type="text" class="form-control" id="ac_name" name="ac_name" required>
        </div>
        <div class="form-group">
            <label for="ac_money">입금액:</label>
            <input type="number" class="form-control" id="ac_money" name="ac_money" required>
        </div>
        <div class="form-group">
            <label for="bank_code">은행 코드:</label>
            <input type="text" class="form-control" id="bank_code" name="bank_code" value="111" required>
        </div>
        <div class="form-group">
            <label for="ac_pw">계좌 비밀번호:</label>
            <input type="password" class="form-control" id="ac_pw" name="ac_pw" required>
        </div>
        <button type="submit" class="btn btn-primary">개설</button>
    </form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>