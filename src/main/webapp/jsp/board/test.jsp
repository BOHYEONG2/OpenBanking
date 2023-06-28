<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CDN 링크 추가 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.myAccount {
  position: absolute;
  left: 10px;
}

.myHr {
  width: 10cm;
  margin-left: 10px;
}

.createAccount {
  position: relative;
  left: 500px;
  top: -100px;
}

.error {
  color: red;
}

.success {
  color: green;
}
</style>
<script>
$(document).ready(function() {
  $('#createAccountForm').submit(function(event) {
    event.preventDefault();

    var accountPW = $('#accountPW').val();
    var accountPW2 = $('#accountPW2').val();
    var errorElement = $('#error');

    if (accountPW.length < 4 || accountPW2.length < 4) {
      errorElement.html("계좌 비밀번호는 4자리 이상이어야 합니다.");
      return false;
    }

    if (accountPW !== accountPW2) {
      errorElement.html("계좌 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
      $('#accountPW2').addClass("is-invalid");
      return false;
    } else {
      errorElement.html("");
      $('#accountPW2').removeClass("is-invalid");
      $('#accountPW2').addClass("is-valid");
    }

    alert("계좌가 성공적으로 개설되었습니다.");

    // Form submission
    var form = $('#createAccountForm');
    form.attr('action', '${pageContext.request.contextPath}/createAccountProcess.do');
    form.unbind('submit').submit();
  });
});
</script>
</head>
<body>
<jsp:include page="/index.jsp"></jsp:include>
<h1 class="MyAccount">나의 계좌</h1>
<hr class="myHr" />
<form action="${pageContext.request.contextPath}/createAccount.do" method="post">
  <button type="submit" class="btn btn-primary" id="button1">계좌개설</button>
</form>

<form action="${pageContext.request.contextPath}/transactionHistory.do" method="post">
  <button type="submit" class="btn btn-primary">입출금 내역조회</button><br>
</form>

<form action="${pageContext.request.contextPath}/openBanking.do" method="post">
  <button type="submit" class="btn btn-primary">오픈뱅킹</button><br>
</form>

<form action="${pageContext.request.contextPath}/closeAccount.do" method="post">
  <button type="submit" class="btn btn-primary">계좌해지</button>
</form>

<form id="createAccountForm" class="createAccount" method="post">
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" name="id" value="${user.id}" readonly="readonly" disabled class="form-control" />
  </div>
  <div class="form-group">
    <label for="accountName">계좌이름</label>
    <input type="text" name="accountName" placeholder="만드실 계좌의 이름을 적어주세요" required class="form-control">
  </div>
  <div class="form-group">
    <label for="accountType">계좌 유형</label>
    <select name="accountType" class="form-control">
      <option value="입출금">입출금</option>
      <option value="적금">적금</option>
      <option value="예금">예금</option>
    </select>
  </div>
  <div class="form-group">
    <label for="accountPW">계좌 비밀번호</label>
    <input type="password" name="accountPW" id="accountPW" placeholder="4자리" maxlength="4" required class="form-control">
  </div>
  <div class="form-group">
    <label for="accountPW2">계좌 비밀번호 확인</label>
    <input type="password" name="accountPW2" id="accountPW2" placeholder="4자리" maxlength="4" required class="form-control">
    <div id="error" class="invalid-feedback"></div>
  </div>
  <button type="submit" class="btn btn-primary">계좌 개설하기</button>
</form>
</body>
</html>