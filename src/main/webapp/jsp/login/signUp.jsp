<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
    <link rel="stylesheet" href="/MyBanking/css/header.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        .container {
            width: 40%;
            margin: 0 auto;
            padding: 20px;
            background-color: #f7f7f7;
            border: 1px solid #ddd;
        }
        
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        
        .form-group {
            margin-bottom: 15px;
        }
        
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        
        input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        // 아이디 유효성 검사 함수
        function validateId() {
            var id = $("#id").val();
            var idRegex = /^[a-zA-Z0-9]{2,16}$/;
            if (!idRegex.test(id)) {
                $("#id").addClass("is-invalid");
                $("#idError").text("아이디의 형식이 올바르지 않습니다.");
                return false;
            } else {
                $("#id").removeClass("is-invalid");
                $("#idError").text("");
                return true;
            }
        }

        // 비밀번호 유효성 검사 함수
        function validatePassword() {
            var password = $("#password").val();
            var passwordRegex = /^[a-zA-Z0-9]{1,16}$/;
            if (!passwordRegex.test(password)) {
                $("#password").addClass("is-invalid");
                $("#passwordError").text("비밀번호의 형식이 올바르지 않습니다.");
                return false;
            } else {
                $("#password").removeClass("is-invalid");
                $("#passwordError").text("");
                return true;
            }
        }

        function validateEmail() {
            var email = $("#email").val();
            var emailRegex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
            if (!emailRegex.test(email)) {
                $("#email").addClass("is-invalid");
                return false;
            } else {
                $("#email").removeClass("is-invalid");
                return true;
            }
        }
        
        function validateUserCode() {
            var userCode = $("#userCode").val();
            var userCodeRegex = /^\d{6}-?\d{7}$/;
            if (!userCodeRegex.test(userCode)) {
                $("#userCode").addClass("is-invalid");
                return false;
            } else {
                $("#userCode").removeClass("is-invalid");
                return true;
            }
        }
        
        function validateBirthday() {
            var birthday = $("#birthday").val();
            var birthdayRegex = /^\d{8}$/;
            if (!birthdayRegex.test(birthday)) {
                $("#birthday").addClass("is-invalid");
                return false;
            } else {
                $("#birthday").removeClass("is-invalid");
                return true;
            }
        }
        
        function validatePhone() {
            var phone = $("#phone").val();
            var phoneRegex = /^\d{3}-\d{3,4}-\d{4}$/;
            if (!phoneRegex.test(phone)) {
                $("#phone").addClass("is-invalid");
                return false;
            } else {
                $("#phone").removeClass("is-invalid");
                return true;
            }
        }
        
        function execDaumPostcode() {
            // 주소 찾기 팝업창을 호출합니다.
            daum.postcode.load(function() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        // 선택한 주소 정보를 해당 필드에 넣습니다.
                        $("#postcode").val(data.zonecode);
                        $("#address").val(data.address);
                        // 커서를 상세주소 필드로 이동합니다.
                        $("#detailAddress").focus();
                    }
                }).open();
            });
        }

        $(document).ready(function() {
            $("#id").on("keyup", validateId);
            $("#password").on("keyup", validatePassword);
            $("#email").on("keyup", validateEmail);
            $("#phone").on("keyup", validatePhone);
            $("#userCode").on("keyup", validateUserCode);
            
            $("#postcodeBtn").on("click", function() {
                execDaumPostcode();
            });
            
            $("form").submit(function(e) {
                e.preventDefault();
                var isValid = true;

                if (!validateId()) {
                    isValid = false;
                }
                if (!validatePassword()) {
                    isValid = false;
                }
                if (!validateEmail()) {
                    isValid = false;
                }
                if (!validatePhone()) {
                    isValid = false;
                }
                if (!validateUserCode()) {
                    isValid = false;
                }
             

                if (isValid) {
                    // Submit the form if all fields are valid
                    this.submit();
                } else {
                    // Show error messages for each field
                    $("#errorMessage").empty();

                    if (!validateId()) {
                        $("#errorMessage").append("<p>아이디의 형식이 올바르지 않습니다.</p>");
                    }
                    if (!validatePassword()) {
                        $("#errorMessage").append("<p>비밀번호의 형식이 올바르지 않습니다.</p>");
                    }
                    if (!validateEmail()) {
                        $("#errorMessage").append("<p>이메일의 형식이 올바르지 않습니다.</p>");
                    }
                    if (!validatePhone()) {
                        $("#errorMessage").append("<p>전화번호의 형식이 올바르지 않습니다.</p>");
                    }
                    if (!validateUserCode()) {
                        $("#errorMessage").append("<p>주민등록번호의 형식이 올바르지 않습니다.</p>");
                    }

                    $("#errorModal").modal("show");
                }
               
            });
        });
    </script>
</head>
<body>
	<header>
		<jsp:include page="/index.jsp" />
	</header>
     <div class="container">
        <h2>회원가입</h2>
        <form method="post" action="${pageContext.request.contextPath}/insertUserProcess.do">
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" id="id" name="id" placeholder="영문자와 숫자 조합, 2~16자" required>
                <div class="invalid-feedback" id="idError">
                    아이디의 형식이 올바르지 않습니다.
                </div>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="영문자와 숫자 조합, 2~16자" required>
                <div class="invalid-feedback" id="passwordError">
                    비밀번호의 형식이 올바르지 않습니다.
                </div>
            </div>
            <div class="form-group">
	            <label for="name">이름</label>
	            <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" required>
	            <div class="invalid-feedback" id="nameError">이름을 잘못 입력했습니다.</div>
   		    </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="text" id="email" name="email" placeholder="example@example.com" required>
                <div class="invalid-feedback">
                    이메일의 형식이 올바르지 않습니다.
                </div>
            </div>
            <div class="form-group">
                <label for="phone">전화번호</label>
                <input type="text" id="phone" name="phone" placeholder="000-0000-0000" required>
                <div class="invalid-feedback">
                    전화번호의 형식이 올바르지 않습니다.
                </div>
            </div>
            <div class="form-group">
                <label for="userCode">주민등록번호</label>
                <input type="text" id="userCode" name="userCode" placeholder="XXXXXXXX-XXXXXXX" required>
                <div class="invalid-feedback">
                    주민등록번호의 형식이 올바르지 않습니다.
                </div>
            </div>
            <div class="form-group">
                <label for="postcode">우편번호</label>
                <div class="input-group">
                    <input type="text" id="postcode" name="postcode" readonly required>
                    <span class="input-group-btn">
                        <button class="btn btn-secondary" type="button" id="postcodeBtn">주소 찾기</button>
                    </span>
                </div>
            </div>
            <div class="form-group">
                <label for="address">주소</label>
                <input type="text" id="address" name="address" readonly required]>
            </div>
            <div class="form-group">
                <label for="detailAddress">상세주소</label>
                <input type="text" id="detailAddress" name="detailAddress" required>
            </div>
            <input type="submit" value="회원가입">
        </form>
    </div>

    <!-- Error Modal -->
    <div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="errorModalLabel">오류 메시지</h5>
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
</body>
</html>