<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){
			var password = $("#password").val();
			var repassword = $("#repassword").val();
			
			if(password != repassword){
				alert('二次密码不对');
				return false;
			}
			
			var email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(email.test($("#email").val())==false){
				alert('邮箱格式输入格式不对');
				return false;
			}
		});
		
		
		$("#img").click(function(){
			this.src = "kaptchaServlet";
		});
		
	});
</script>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${requestScope.error}</span>
							</div>
							<div class="form">
								<form action="${pageContext.request.contextPath}/userServlet" method="post">
									<input type="hidden" name="method" value="Regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" value="${param.username}" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" id="password" type="password" value="${param.password}" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" id="repassword" type="password" value="${param.repwd}" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" id="email" type="text" value="${param.email}" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" id="img" src="kaptchaServlet" style="float: right; margin-right: 40px; width: 95px;height: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>