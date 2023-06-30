<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.button {
    width: 5cm;
    height: 60px;
    display: inline-block;
    padding: 10px 20px;
    border: none;
    background-color: lightgray;
    color: black;
    text-align: center;
    text-decoration: none;
    font-size: 16px;
    cursor: pointer;
    border-radius: 0;
  }
  #button2{
  background-color: rgb(44, 62, 80);
    color: white;
  }
  .myHr {
    width: 5cm;
    margin-left: 0;
  }
</style>
</head>
<header>
<jsp:include page="/index.jsp" />
</header>
<body>
<section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">홈</a></li>
          <li>계좌</li>
          <li>입출금 내역조회</li>
        </ol>
        <h2 style="font-size : 35px;">입출금 내역조회</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
      
   
   <form action="${pageContext.request.contextPath}/createAccount.do" method="post">
    <button type="submit" class="button" id="button1">계좌개설</button>
  </form>

  <form action="${pageContext.request.contextPath}/transactionHistory.do" method="post">
    <button type="submit" class="button" id="button2">입출금 내역조회</button><br>
  </form>

  <form action="${pageContext.request.contextPath}/openBanking.do" method="post">
    <button type="submit" class="button">오픈뱅킹</button><br>
  </form>

  <form action="${pageContext.request.contextPath}/closeAccount.do" method="post">
    <button type="submit" class="button">계좌해지</button>
  </form>
  
  <form action="${pageContext.request.contextPath }/transactionHistoryProcess.do" class="transactionHistory" method="post">
      <div class="container">
            <div class="col-lg-8">
                     <div class="form-group">
                        <label for="accountType">조회하실 계좌를 선택해주세요</label> <select name="accountNum"
                           class="form-control">
                           <c:forEach var="account" items="${accountList}">
                              <option value="${account.accountNum}">${account.accountNum}
                                 - ${account.accountName} (${account.type})</option>
                           </c:forEach>
                        </select>
                     </div>
                     <div class="text-center">
                            <button type="submit" class="btn btn-primary">조회</button>
                        </div>
                  </div>
               </div>
   </form>
  
  </div>
  </section>
</body>
</html>