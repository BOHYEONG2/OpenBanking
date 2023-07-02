<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <style>
        .container {
            width: 800px;
            margin: 0 auto;
            padding: 20px;
            margin-top: 10%;              
        }

        h2 {
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .btn-back {
            text-align: right;
            margin-top: 20px;
        }
		
	    .btn-edit-delete {
            float: right;
            text-align: right;
  	    }

   	    .btn-edit-delete a {
	        display: inline-block;
	        padding: 5px 10px;
	        border-radius: 5px;
	        background-color: #333;
	        color: #fff;
	        text-decoration: none;
	        margin-left: 10px;
	        font-weight: lighter;
        }
        
        .btn-back a {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
        }

        .comment-form {
            margin-top: 20px;
        }

        .comment-form textarea {
            width: 100%;
            height: 100px; /* 내용칸 크기 수정 */
            padding: 5px;
        }

        .comment-form button {
            margin-top: 10px;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            background-color: #333;
            color: #fff;
            cursor: pointer;
        }

        .comment-list {
            margin-top: 20px;
        }

        .comment-list table {
            margin-bottom: 10px;
        }

        .comment-list table td {
            padding: 8px;
            text-align: left;
        }

        .comment-list table .comment-content {
            width: 80%;
        }

        .comment-list table .comment-date {
            width: 20%;
            text-align: right;
        }

        .empty-msg {
            text-align: center;
            font-size: 14px;
            color: #333;
            margin-top: 30px;
        }
	
	#deleteCommentModal {
    display: none;
    position: fixed;
    z-index: 9999;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
}

#modalContent {
    background-color: #fefefe;
    margin: 15% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 40%;
}

#modalButtons {
    text-align: right;
    margin-top: 20px;
}

#modalButtons button {
    padding: 8px 16px;
    margin-left: 10px;
}
        /* 모달 스타일 */
        #confirmationModal {
            display: none;
            position: fixed;
            z-index: 9999;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        #modalContent {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 40%;
        }

        #modalButtons {
            text-align: right;
            margin-top: 20px;
        }

        #modalButtons button {
            padding: 8px 16px;
            margin-left: 10px;
        }
    
	
		.comment-menu-options {
		  display: flex;
		  justify-content: center;
		  align-items: center;
		   width: 120px; 
		  height: 100%; /* 댓글 행 전체 높이에 맞춰 주세요 */
		}
		
		.comment-menu-options a {
		  display: block;
		  padding: 5px;
		  margin: 0 5px;
		}
		
		.comment-menu-options a.report {
		  margin-right: auto;
		  margin-left: auto;
		}
		
		.comment-menu-options a:hover {
		  background-color: lightgray; /* 마우스를 올렸을 때의 배경색 */
		}
    </style>
</head>
<body>
	<header>
        <jsp:include page="/index.jsp" />
    </header>
    <div class="container">
        <h2>게시글 상세보기
        <div class="btn-edit-delete">
         <c:if test="${board.userId eq loginUser.id}">
		    <a href="${contextPath}/updateBoard.do?boardNo=${board.boardNo}">수정</a>
		    <a href="#" onclick="showConfirmationModal(${board.boardNo})">삭제</a>
		    </c:if>
		</div>
		</h2>

        <table>
            <tr>
                <th>게시글 번호</th>
                <td>${board.boardNo}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${board.userId}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${board.title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td style="white-space: pre-line;">${board.contents}</td> <!-- 내용칸 크기 수정 -->
            </tr>
            <tr>
                <th>작성일</th>
                <td><fmt:formatDate value="${board.boardTime}" pattern="yyyy-MM-dd" /></td>
            </tr>
        </table>
	
        <div class="btn-back">
            <a href="${contextPath}/boardList.do">목록으로</a>
        </div>

        <div class="comment-form">
            <form action="${ pageContext.request.contextPath }/writeComment.do" method="post" onsubmit="refreshPage()">
                <input type="hidden" name="id" value="${loginUser.id}" /> 
                <input type="hidden" name="boardNo" value="${board.boardNo}" />
                <textarea name="contents" placeholder="댓글을 입력하세요"></textarea>
                 <button type="submit" onclick="refreshPage()">등록</button>
            </form>
        </div>
		
 <div class="comment-list">
    <h3>댓글 목록</h3>

    <c:choose>
        <c:when test="${empty commentList}">
            <p class="empty-msg">등록된 댓글이 없습니다.</p>
        </c:when>
        <c:otherwise>
       

<table>
    <c:forEach var="comment" items="${commentList}">
        <tr>
            <td class="comment-userId">${comment.userId}</td>
            <td class="comment-content">${comment.contents}</td>
            <td class="comment-date"><fmt:formatDate value="${comment.commentTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td class="comment-actions">
                <c:if test="${comment.userId eq loginUser.id}">
                    <!-- 내가 작성한 댓글인 경우 -->
                    <div class="comment-menu-options" id="commentMenuOptions_${comment.commentNo}">
                        <a href="#" onclick="editComment(${comment.commentNo})">수정</a>
                        <a href="#" onclick="showDeleteCommentModal(${comment.commentNo})">삭제</a>
                    </div>
                </c:if>
                <c:if test="${comment.userId ne loginUser.id}">
                    <!-- 다른 사람이 작성한 댓글인 경우 -->
                    <div class="comment-menu-options" id="commentMenuOptions_${comment.commentNo}">
                        <a href="#" onclick="reportComment(${comment.commentNo})">신고하기</a>
                    </div>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
        </c:otherwise>
    </c:choose>
</div>
        
    </div>

    <!-- 게시글 삭제 모달 -->
    <div id="confirmationModal">
        <div id="modalContent">
            <h3>게시글 삭제</h3>
            <p>게시글을 삭제하시겠습니까?</p>
            <div id="modalButtons">
                <button onclick="deleteBoard()">확인</button>
                <button onclick="hideConfirmationModal()">취소</button>
            </div>
        </div>
    </div>
	    <!-- 댓글 삭제 모달 -->
	<div id="deleteCommentModal">
	    <div id="modalContent">
	        <h3>댓글 삭제</h3>
	        <p>댓글을 삭제하시겠습니까?</p>
	        <div id="modalButtons">
	            <button onclick="deleteComment()">확인</button>
	            <button onclick="hideDeleteCommentModal()">취소</button>
	        </div>
	    </div>
	</div>

    <script>
    var boardNoToDelete = 0;
    var commentNoToDelete = 0;

    function showConfirmationModal(boardNo) {
        boardNoToDelete = boardNo;
        var modal = document.getElementById("confirmationModal");
        modal.style.display = "block";
    }

    function hideConfirmationModal() {
        var modal = document.getElementById("confirmationModal");
        modal.style.display = "none";
    }

    function deleteBoard() {
        var modal = document.getElementById("confirmationModal");
        modal.style.display = "none";

        // AJAX 요청으로 게시글 삭제 수행
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // 삭제 성공 시, 페이지 리로드
                location.reload();
            }
        };
        xhr.open("POST", "${contextPath}/deleteBoard.do", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("boardNo=" + boardNoToDelete);
    }

    function showDeleteCommentModal(commentNo) {
        commentNoToDelete = commentNo;
        var modal = document.getElementById("deleteCommentModal");
        modal.style.display = "block";
    }

    function hideDeleteCommentModal() {
        var modal = document.getElementById("deleteCommentModal");
        modal.style.display = "none";
    }

    function deleteComment() {
        var modal = document.getElementById("deleteCommentModal");
        modal.style.display = "none";

        // AJAX 요청으로 댓글 삭제 수행
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // 삭제 성공 시, 페이지 리로드
                location.reload();
            }
        };
        xhr.open("POST", "${contextPath}/deleteComment.do", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("commentNo=" + commentNoToDelete);
    }
        function refreshPage() {
            location.reload();
        }
    </script>
</body>
</html>