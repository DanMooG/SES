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
<title>SES(Search Easy-Sign-up)</title>
<style>
.nav-item {
	font: 20px solid;
}

footer {
	height: 50px;
	position: absolute;
}

#con {
	padding: 20px;
	border: 1px solid #dadada;
	background-color: #eeeeee;
}

.navbar-nav.navbar-center {
	position: absolute;
	left: 50%;
	transform: translatex(-50%);
}
</style>
</head>
<body>
	<main class="container-fluid">
		<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="js/bootstrap.js"></script>

		<!-- header -->
		<div class="jumbotron text-left">
			<div class="row">
				<div class="col-md-4">
					<a href="main"><img src="${pageContext.request.contextPath}/resources/images/mainmark.png" width="300px"></a>
				</div>
				<div class="col-md-8" style="padding-top: 120px;">
					<!-- navigation -->
					<nav class="nav navbar-default">
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a class="nav-item" href="serviceInfo">서비스/회사 소개<span
										class="sr-only"></span></a></li>
								<li><a class="nav-item" href="serviceStep">서비스 이용절차</a></li>
								<li class="dropdown"><a href="#"
									class="dropdown-toggle nav-item" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false">
										고객센터<span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li class="dropdown-item"><a href="#">자주하는 질문</a></li>
										<li class="dropdown-item"><a href="qna">문의하기</a></li>
									</ul></li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>서비스 이용절차</h3>
			</div>
			<div class="panel-body">
				<!-- Contents -->
				<br />
				<br />
				<center>
					<div class="row" align="center" style="width: 700px;">
						<div class="col-md-9" align="right">
							<a class="btn btn-default" data-target="#modal"
								data-toggle="modal"
								style="font: 30px solid; width: 500px; height: 500px;"></a>
						</div>
						<div class="col-md-3" align=left>
							<p><a href="#"><img src="${pageContext.request.contextPath}/resources/images/step1_s.png" height=50px"></a></p>
							<br />
							<p><a href="#"><img src="${pageContext.request.contextPath}/resources/images/step2.png" height=50px"></a></p>
							<br />
							<p><a href="#"><img src="${pageContext.request.contextPath}/resources/images/step3.png" height=50px"></a></p>
							<br />
							<p><a href="#"><img src="${pageContext.request.contextPath}/resources/images/step4.png" height=50px"></a></p>
							<br />
						</div>
					</div>
					<br />
					<br /> 
					<p><a href="#"><img src="${pageContext.request.contextPath}/resources/images/next.png" width="100px"></a></p>
					<br />
					<br />
				</center>
			</div>
		</div>
		<br />
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
						<div class="col-md-5 mx-auto">
						</div>
						<div class="col-md-1 mx-auto">
							<!-- Links -->
        					<a href="https://https://www.facebook.com"> <img src="${pageContext.request.contextPath}/resources/images/facebook.png" width="30px">
						</div>
   						<div class="col-md-1 mx-auto">
							<!-- Links -->
        					<a href="https://www.kakaocorp.com/service/KakaoTalk"> <img src="${pageContext.request.contextPath}/resources/images/kakaotalk.png" width="30px">
						</div>
     					<div class="col-md-1 mx-auto">
							<!-- Links -->
        					<a href="https://www.naver.com"> <img src="${pageContext.request.contextPath}/resources/images/naver.png" width="30px">
						</div>
   						<div class="col-md-1 mx-auto">
							<!-- Links -->
        					<a href="https://www.google.com"> <img src="${pageContext.request.contextPath}/resources/images/google.png" width="30px">
						</div>
      				<!-- Grid column -->
				</div>
    			<!-- Grid row -->
			</div>
		</footer>
	</main>
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