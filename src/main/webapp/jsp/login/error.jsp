<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f2f2f2;
        }

        .error-container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #FF0000;
            font-size: 24px;
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            line-height: 1.5;
        }

        .contact-info {
            margin-top: 30px;
        }

        .contact-info p {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>에러 발생</h1>
        <p>요청을 처리하는 동안 오류가 발생했습니다. 나중에 다시 시도해주세요.</p>
        <p>문제가 계속되는 경우, 시스템 관리자에게 문의해주세요.</p>
        <div class="contact-info">
            <p>문의: admin@example.com</p>
            <p>전화번호: 123-456-7890</p>
        </div>
    </div>
</body>
</html>