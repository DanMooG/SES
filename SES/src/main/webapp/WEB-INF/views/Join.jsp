<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>SES(Search Easy-Sign-up)</title>
</head>
<body>
	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

	<div class="container">
		<!-- 좌우측의 공간 확보 -->
		<div class="jumbotron text-left">
			<a href="main"><img
				src="${pageContext.request.contextPath}/resources/images/mainmark.png"
				width="250px"></a>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>회원가입</h3>
			</div>
		</div>

		<div class="row">
			<!-- 본문 들어가는 부분 -->
			<form class="form-horizontal" name="join" role="form" method="post"
				onsubmit="emailCheck();">
				<div class="form-group">
					<label for="provision" class="col-lg-2 control-label">회원가입약관</label>
					<div class="col-lg-10" id="provision">
						<textarea class="form-control" rows="8" style="resize: none">약관동의
SES 통합 조회서비스에서 제공하는 ‘웹사이트 가입여부 조회지원’ 서비스 이용을 위한 개인정보 수집·이용에 동의가 필요합니다.
‘동의함’을 클릭해주세요.
                    	</textarea>
						<div class="radio">
							<label> <input type="radio" id="provisionYn"
								name="provisionYn" value="Y" autofocus="autofocus" checked>동의합니다.
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" id="provisionYn"
								name="provisionYn" value="N">동의하지 않습니다.
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="memberInfo" class="col-lg-2 control-label">개인정보취급방침</label>
					<div class="col-lg-10" id="memberInfo">
						<textarea class="form-control" rows="8" style="resize: none">개인정보의 항목 및 수집방법
개인정보 수집·이용 목적
o 간편가입조회 이용자 본인확인 

수집하려는 개인정보의 항목
o 휴대폰 본인확인: 이름, 휴대폰번호
o 이메일 본인확인: 이름, 이메일주소

동의 거부 권리 및 동의 거부에 따른 불이익
o 개인정보 수집·이용에 동의를 거부하실 수 있으며, 동의를 거부하시는 경우에는 SES 간편가입조회 서비스 이용이 제한됩니다.
                	</textarea>
						<div class="radio">
							<label> <input type="radio" id="memberInfoYn"
								name="memberInfoYn" value="Y" checked>동의합니다.
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" id="memberInfoYn"
								name="memberInfoYn" value="N">동의하지 않습니다.
							</label>
						</div>
					</div>
				</div>
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyAlphabetAndNumber"
							id="id" data-rule-required="true"
							placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divPassword">
					<label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="password"
							name="excludeHangul" data-rule-required="true" placeholder="패스워드"
							maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divPasswordCheck">
					<label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호
						확인</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="passwordCheck"
							data-rule-required="true" placeholder="패스워드 확인" maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divName">
					<label for="inputName" class="col-lg-2 control-label">성명</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="name"
							data-rule-required="true" placeholder="한글만 입력 가능합니다."
							maxlength="15">
					</div>
				</div>
				<div class="form-group" id="divBirth">
					<label for="inputBirth" class="col-lg-2 control-label">생년월일</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="datepicker"
							data-date-format="yyyy-mm-dd" maxlength="15">
					</div>
				</div>
				<div class="form-group" id="divEmail">
					<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="email"
							data-rule-required="true" placeholder="이메일을 입력해주세요"
							maxlength="50">
					</div>
				</div>
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰
						번호</label>
					<div class="col-lg-10">
						<div class="row">
							<div class="col-lg-5">
								<div class="row">
									<div class="col-lg-4">
										<select class="form-control" data-toggle="dropdown"
											name="phoneNumber" style="width: 120px;">
											<option value="">선택하세요</option>
											<option value="010">010</option>
											<option value="011">011</option>
										</select>
									</div>
									<div class="col-lg-4">
										<input type="tel" class="form-control onlyNumber"
											id="phoneNumber" data-rule-required="true" maxlength="4"
											style="width: 115px;">
									</div>
									<div class="col-lg-4">
										<input type="tel" class="form-control onlyNumber"
											id="phoneNumber" data-rule-required="true" maxlength="4"
											style="width: 115px;">
									</div>
								</div>
							</div>
							<div class="col-lg-7"></div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmailReceiveYn" class="col-lg-2 control-label">이메일
						수신여부</label>
					<div class="col-lg-10">
						<label class="radio-inline"> <input type="radio"
							id="emailReceiveYn" name="emailReceiveYn" value="Y" checked>
							동의합니다.
						</label> <label class="radio-inline"> <input type="radio"
							id="emailReceiveYn" name="emailReceiveYn" value="N"> 동의하지
							않습니다.
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPhoneNumber" class="col-lg-2 control-label">SMS
						수신여부</label>
					<div class="col-lg-10">
						<label class="radio-inline"> <input type="radio"
							id="smsReceiveYn" name="smsReceiveYn" value="Y" checked>
							동의합니다.
						</label> <label class="radio-inline"> <input type="radio"
							id="smsReceiveYn" name="smsReceiveYn" value="N"> 동의하지
							않습니다.
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="connectSNS" class="col-lg-2 control-label">계정
						연동</label>
					<p>
						<a href="#"><img
							src="${pageContext.request.contextPath}/resources/images/FacebookConn.png"
							width="100px"></a> <a href="#"><img
							src="${pageContext.request.contextPath}/resources/images/KakaotalkConn.png"
							width="100px"></a> <a href="#"><img
							src="${pageContext.request.contextPath}/resources/images/NaverConn.png"
							width="100px"></a> <a href="#"><img
							src="${pageContext.request.contextPath}/resources/images/GoogleConn.png"
							width="100px"></a>
					</p>
				</div>


				<br /> <br />
				<div class="form-group" align="center">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-primary">회원가입</button>
					</div>
				</div>
			</form>

			<br /> <br /> <br />
			<!--// 본문 들어가는 부분 -->
			<hr />
			<!-- Footer -->
			<footer class="page-footer font-small indigo">
				<!-- Footer Links -->
				<div class="container text-center text-md-left">

					<!-- Grid row -->
					<div class="row text-center">
						<!-- Grid column -->
						<div class="col-md-1 mx-auto">
							<!-- Links -->
							<h5 class="font-weight-bold text-uppercase mt-2 mb-3">FAQ</h5>
						</div>
						<div class="col-md-2 mx-auto">
							<!-- Links -->
							<h5 class="font-weight-bold text-uppercase mt-2 mb-3">개인정보처리방침</h5>
						</div>
						<div class="col-md-5 mx-auto"></div>
						<div class="col-md-1 mx-auto">
							<!-- Links -->
							<a href="https://https://www.facebook.com"> <img
								src="${pageContext.request.contextPath}/resources/images/facebook.png"
								width="30px">
						</div>
						<div class="col-md-1 mx-auto">
							<!-- Links -->
							<a href="https://www.kakaocorp.com/service/KakaoTalk"> <img
								src="${pageContext.request.contextPath}/resources/images/kakaotalk.png"
								width="30px">
						</div>
						<div class="col-md-1 mx-auto">
							<!-- Links -->
							<a href="https://www.naver.com"> <img
								src="${pageContext.request.contextPath}/resources/images/naver.png"
								width="30px">
						</div>
						<div class="col-md-1 mx-auto">
							<!-- Links -->
							<a href="https://www.google.com"> <img
								src="${pageContext.request.contextPath}/resources/images/google.png"
								width="30px">
						</div>
						<!-- Grid column -->
					</div>
					<!-- Grid row -->
				</div>
			</footer>
		</div>

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
		<script type="text/javascript">
			$('#datepicker').datepicker({
				weekStart : 1,
				daysOfWeekHighlighted : "6,0",
				autoclose : true,
				todayHighlight : true,
			});
			$('#datepicker').datepicker("setDate", new Date());

			function emailCheck() {
				alert(document.getElementById("email").value);
				var email = document.getElementById("email").value;
				var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
				if (exptext.test(email) == false) {

					//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐 경우
					alert("이메일 형식이 올바르지 않습니다.");

					document.join.email.value = "";
					return;
				}
			}
		</script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
</body>
</html>