<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/MyBanking/css/header.css">
<style>
    .logo {
        position: fixed;
        top: 0;
        left: 50px;
        width: 10%;
        height: 200px;
        z-index: 999;
    }
</style>
<c:choose>
   <c:when test="${loginUser == null}">
      <header>
      <h1>탑메뉴</h1>
         <nav>
            <ul class="main" >
               <li class="main"><a href="${ pageContext.request.contextPath }/main.do" class="main"><font size="4">HOME</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/boardList.do" class="main"><font size="4">Board</font></a>
               <li class="main"><a href="/MyBanking/product.do" class="main"><font size="4">Product</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/login.do" class="main"><font size="4">Login</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/insertUser.do" class="main"><font size="4">SignUp</font></a>
            </ul>
         </nav>
         <div style="text-align: right; margin-right: 200px;">
         <img src="/MyBanking/images/bank.png" style="width:10%; height:200px; margin-left:50px">
         </div>
           </header>
   </c:when>
   <c:otherwise>
      <header>
         <nav>
            <ul class="main">
               <li class="main"><a href="${ pageContext.request.contextPath }/main.do" class="main"><font size="4">HOME</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/myAccount.do"  class="main"><font size="4">MY Account</font></a>
               <li class="main"><a href="/MyBanking/openbanking.do" class="main"><font size="4">OpenBanking</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/boardList.do" class="main"><font size="4">Board</font></a>
               <li class="main"><a href="/MyBanking/product.do" class="main"><font size="4">product</font></a>
               <li class="main"><a href="/MyBanking/mypage.do" class="main"><font size="4">MyPage</font></a>
               <li class="main"><a href="${ pageContext.request.contextPath }/logout.do" class="main"><font size="4">Logout</font></a>
            </ul>
         </nav>
         <img src="/MyBanking/images/bank.png" class="logo">
      </header>
   </c:otherwise>
</c:choose>