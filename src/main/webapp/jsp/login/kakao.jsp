<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script>
window.location.href = "https://kauth.kakao.com/oauth/authorize?client_id=77e72833ca2add3b0c5647bed56588a8&redirect_uri=http://localhost:8080/MyBanking/index.jsp&response_type=code";
</script>
<%
   String userID = null;
   if (session.getAttribute("ID") != null) {
      userID = (String) session.getAttribute("ID");
   } // 카카오톡 로그인 확인
   boolean isKakaoLoggedIn = false;
   String kakaoID = (String) session.getAttribute("kakaoID");
   if (kakaoID != null) {
      isKakaoLoggedIn = true;
      userID = (String) session.getAttribute("kakaoID");
   }
%>
</body>
</html>