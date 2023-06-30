<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Money</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
<script>
function validateTransfer() {
    // 입력값 가져오기
    var sendMoney = parseInt(document.getElementById("transferAmount").value);
    var senderBalance = parseInt(document.getElementById("senderBalance").value);

    // 유효성 검사
    if (isNaN(sendMoney) || sendMoney <= 0) {
        displayErrorMessage("송금할 금액을 올바르게 입력해주세요.");
        return false;
    }

    if (sendMoney > senderBalance) {
        displayErrorMessage("잔액이 부족합니다.");
        return false;
    }

    // 모든 유효성 검사 통과
    return true;
}

function displayErrorMessage(message) {
    document.getElementById("errorMessage").textContent = message;
    $('#errorModal').modal('show');
}
</script>
<body>
  <header>
    <jsp:include page="/index.jsp" />
  </header>

  <div class="container">
    <h2>계좌이체</h2>

    <div class="row">
      <div class="col-md-6">
    <form action="${pageContext.request.contextPath}/transferCheck.do" method="post">
    <!-- 출금 계좌선택 -->
    <div class="form-group">
        <label for="selectBank">출금 계좌선택</label>
        <select class="form-control" id="selectBank" name="senderAcNumber">
            <c:forEach var="account" items="${accountList}">
                <option value="${account.ac_number}">${account.AC_NAME} - ${account.ac_number}</option>
            </c:forEach>
        </select>
    </div>
    <!-- 입금받을 은행 입력 -->
    <div class="form-group">
        <label for="receiverBank">입금받을 은행 입력</label>
        <input type="text" class="form-control" id="receiverBank" name="receiverBank">
    </div>
    <!-- 계좌정보 입력 -->
    <div class="form-group">
        <label for="receiverAccount">계좌정보 입력</label>
        <input type="text" class="form-control" id="receiverAccount" name="receiverAcNumber">
    </div>
    <!-- 송금할 금액 -->
    <div class="form-group">
        <label for="transferAmount">송금할 금액</label>
        <input type="number" class="form-control" id="transferAmount" name="sendMoney">
    </div>
    <!-- 상대방에게 보낼 메시지 -->
    <div class="form-group">
        <label for="message">상대방에게 보낼 메시지</label>
        <textarea class="form-control" id="message" rows="3" name="message"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">보내기</button>
</form>
      </div>
    </div>
  </div>
  
  <!-- 모달 -->
<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel">오류</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="errorMessage"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
  

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>