<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>SES(Search Easy-Sign-up)</title>
</head>
<body>
	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
	<div class="container"><!-- �¿����� ���� Ȯ�� -->
		<div class="jumbotron text-left">
			<img src="${pageContext.request.contextPath}/resources/images/mainmark.png" width="250px">
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>ȸ������</h3>
			</div>
		</div>
		
		<div class="row">
        	<!-- ���� ���� �κ� -->
	        <form class="form-horizontal" role="form" method="post" action="javascript:alert( 'success!' );">
            	<div class="form-group">
                	<label for="provision" class="col-lg-2 control-label">ȸ�����Ծ��</label>
               		<div class="col-lg-10" id="provision">
                    	<textarea class="form-control" rows="8" style="resize:none">�������
�������������������������
�������������������������
�������������������������.................
                    	</textarea>
                    <div class="radio">
                    	<label>
                        	<input type="radio" id="provisionYn" name="provisionYn" value="Y" autofocus="autofocus" checked>�����մϴ�.
                        </label>
                    </div>
                    <div class="radio">
                    	<label>
                        	<input type="radio" id="provisionYn" name="provisionYn" value="N">�������� �ʽ��ϴ�.
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
            	<label for="memberInfo" class="col-lg-2 control-label">����������޹�ħ</label>
                <div class="col-lg-10" id="memberInfo">
                	<textarea class="form-control" rows="8" style="resize:none">���������� �׸� �� �������
�������������������������                        
�������������������������
�������������������������.................
                	</textarea>
                	<div class="radio">
                    	<label>
                        	<input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y" checked>�����մϴ�.
                    	</label>
                	</div>
              		<div class="radio">
                    	<label>
                        	<input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">�������� �ʽ��ϴ�.
                    	</label>
                	</div>
                </div>
                </div>
            <div class="form-group" id="divId">
            	<label for="inputId" class="col-lg-2 control-label">���̵�</label>
            	<div class="col-lg-10">
                	<input type="text" class="form-control onlyAlphabetAndNumber" id="id" data-rule-required="true" placeholder="30���̳��� ���ĺ�, ������ھ�(_), ���ڸ� �Է� �����մϴ�." maxlength="30">
            	</div>
            </div>
            <div class="form-group" id="divPassword">
            	<label for="inputPassword" class="col-lg-2 control-label">��й�ȣ</label>
                <div class="col-lg-10">
                	<input type="password" class="form-control" id="password" name="excludeHangul" data-rule-required="true" placeholder="�н�����" maxlength="30">
            	</div>
        	</div>
        	<div class="form-group" id="divPasswordCheck">
            	<label for="inputPasswordCheck" class="col-lg-2 control-label">��й�ȣ Ȯ��</label>
            	<div class="col-lg-10">
                	<input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="�н����� Ȯ��" maxlength="30">
            	</div>
            </div>
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-2 control-label">����</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyHangul" id="name" data-rule-required="true" placeholder="�ѱ۸� �Է� �����մϴ�." maxlength="15">
                </div>
            </div>
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-2 control-label">�������</label>
                <div class="col-lg-10">
                    <input type="date" class="form-control" id="email" data-rule-required="true" placeholder="�������" maxlength="40">
                </div>
            </div> 
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-2 control-label">�̸���</label>
                <div class="col-lg-10">
                    <input type="email" class="form-control" id="email" data-rule-required="true" placeholder="�̸���" maxlength="40">
                </div>
            </div>
            <div class="form-group" id="divPhoneNumber">
                <label for="inputPhoneNumber" class="col-lg-2 control-label">�޴��� ��ȣ</label>
                <div class="col-lg-10">
                    <input type="tel" class="form-control onlyNumber" id="phoneNumber" data-rule-required="true" placeholder="-�� �����ϰ� ���ڸ� �Է��ϼ���." maxlength="11">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmailReceiveYn" class="col-lg-2 control-label">�̸��� ���ſ���</label>
                <div class="col-lg-10">
                    <label class="radio-inline">
                        <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="Y" checked> �����մϴ�.
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="N"> �������� �ʽ��ϴ�.
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhoneNumber" class="col-lg-2 control-label">SMS ���ſ���</label>
                <div class="col-lg-10">
                    <label class="radio-inline">
                        <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="Y" checked> �����մϴ�.
                    </label>
                	<label class="radio-inline">
                    	<input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="N"> �������� �ʽ��ϴ�.
                	</label>
            	</div>
            </div>
            <div class="form-group">
            	<div class="col-lg-offset-2 col-lg-10">
                	<button type="submit" class="btn btn-primary">Sign in</button>
            	</div>
        	</div>
        </form>
        
        <br />
		<br />
		<br />
        <!--// ���� ���� �κ� -->
        <hr/>
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
						<h5 class="font-weight-bold text-uppercase mt-2 mb-3">��������ó����ħ</h5>
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