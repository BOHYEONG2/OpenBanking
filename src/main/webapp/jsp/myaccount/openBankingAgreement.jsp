<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Open Banking Agreement</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 130px;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 70%;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 10px;
        }
        
        .container h2 {
            margin-bottom: 20px;
        }
        
        .btn-gold {
            color: #ffffff;
            background-color: #ffd700;
            border-color: #ffd700;
        }
        
        .btn-gold:hover {
            color: #ffffff;
            background-color: #cca300;
            border-color: #cca300;
        }
    </style>
</head>
<body>
    <header>  
        <jsp:include page="/index.jsp" />
    </header>
    
    <div class="container">
        <h2>오픈뱅킹 약관 동의</h2>
        <form action="${pageContext.request.contextPath}/openBankingAgreement.do" method="post">
            <div class="form-group">
                <textarea class="form-control" rows="5" placeholder="약관 내용을 작성하세요" readonly>
오픈뱅킹 계좌이체를 하다가 문제가 생기더라도 모든건 본인의 탓입니다.
BH Bank에게 책임을 묻지 않습니다.
                </textarea>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="agreeCheck" required>
                <label class="form-check-label" for="agreeCheck">약관에 동의합니다.</label>
            </div>
            <button type="submit" class="btn btn-gold" id="agreeButton" disabled>약관 동의</button>
        </form>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script>
        // 체크박스 선택 여부 확인 및 버튼 활성화/비활성화
        document.getElementById("agreeCheck").addEventListener("change", function() {
            document.getElementById("agreeButton").disabled = !this.checked;
        });
    </script>
</body>
</html>