<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계좌 개설</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-pzjw7KdVpD8FyOaRrCkNHEHz8C3KEUz1ckC1+sqX8xgpvcA6lO8NoX3h+a2rb4+6" crossorigin="anonymous">
</head>
<body>
<header>
<jsp include page="/index.jsp" /> 
</header>
<div class="container">
    <h1 class="my-4">계좌 개설</h1>

    <form action="${pageContext.request.contextPath}/createAccountProcess.do" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" name="id" value="${loginUser.id }" required>
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
</body>	
</html>