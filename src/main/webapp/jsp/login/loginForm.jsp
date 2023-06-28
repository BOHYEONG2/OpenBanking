<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login-form {
        text-align: center;
    }

    .input-group {
        margin-bottom: 10px;
    }

    .input-group label {
        display: block;
        margin-bottom: 5px;
        text-align: left;
    }

    .input-group input[type="text"],
    .input-group input[type="password"] {
        width: 280px;
        padding: 5px;
    }

    .login-button {
        background-color: #f2c94c;
        color: #000000;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        float: left;
    }

    .login-button:hover {
        background-color: #f7e17e;
    }

    .link-group {
        margin-top: 20px;
    }

    .link-group a {
        color: #000000;
        text-decoration: none;
        margin-right: 10px;
    }

    .kakao-button {
        background-color: #f8e71c;
        color: #000000;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        float: right;
    }

    .kakao-button:hover {
        background-color: #ffe347;
    }

    header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        background-color: #f2f2f2;
        padding: 10px;
        z-index: 999;
    }
</style>

</head>
<body>
<header>
    <jsp:include page="/index.jsp"/>
</header>
<div class="login-form">
    <form action="${pageContext.request.contextPath}/loginProcess.do">
        <div class="input-group">
            <input type="text" id="id" name="id" placeholder="아이디" value="aaa" required>
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" placeholder="비밀번호" value="123" required>
        </div>
        <input type="submit" value="로그인" class="login-button">
    </form>
    <form action="${pageContext.request.contextPath}/kakao.do">
        <input type="submit" value="카카오로 로그인" class="kakao-button">
    </form>
    <br><br>
    <div class="link-group">
        <a href="#">아이디 찾기</a>
        <a href="#">비밀번호 찾기</a>
        <a href="#">회원가입</a>
    </div>
</div>
</body>
</html>