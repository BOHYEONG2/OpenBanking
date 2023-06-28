<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <header>
        <jsp:include page="/index.jsp" />
    </header>

    <div class="container">
        <h1 class="text-center mt-5">게시글 수정</h1>
        <form name="articleForm" method="post" action="${ pageContext.request.contextPath }/updateBoardProcess.do">
            <input type="hidden" name="boardNo" value="${board.boardNo}" />
            <div class="mb-3">
                <label for="title" class="form-label">글제목</label>
                <input type="text" class="form-control" id="title" name="title" maxlength="500" value="${board.title}" required>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">글내용</label>
                <textarea class="form-control" id="content" name="content" rows="10" cols="65" maxlength="4000" required>${board.content}</textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/boardList.do'">취소</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>
</body>

</html>