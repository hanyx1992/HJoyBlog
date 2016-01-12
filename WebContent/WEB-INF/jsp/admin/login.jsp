<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${hello} - 后台管理</title>
	<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
</head>
<body class="admin-body">
	<div class="main">
		<div class="login-div">
			<div class = "logo-div">
				<img class="logo-img" alt="HJoyBlog" src="<%=request.getContextPath()%>/style/img/logo.png">
			</div>
			<form class="pure-form" action="login.do" method="POST">
				<fieldset class="pure-group">
					<input type="text" name="loginName" value="${loginName}" class="pure-input-1" placeholder="请输入用户名" required oninvalid="setCustomValidity('请输入用户名');" oninput="setCustomValidity('');"/>
					<input type="password" name="loginPwd" value="${loginPwd}"  class="pure-input-1" placeholder="请输入密码" required oninvalid="setCustomValidity('请输入密码');" oninput="setCustomValidity('');"/>
					<input id = "autoLogin-ipt" type="hidden" name="autoLogin"/>
				</fieldset>
				<label for="autoLogin" class="pure-checkbox"><input id="autoLogin" type="checkbox" name="autoLogin" value="">&nbsp;自动登录</label>
				<button type="submit" class="pure-button pure-input-1 pure-button-primary">登&nbsp;&nbsp;&nbsp;录</button>
			</form>
		</div>
		<div class="footer-div"><p>- Powered By Hanyx & Meihf -</p></div>
	</div>
</body>
<script type="text/javascript">
	$('#autoLogin').change(function(){
		$('#autoLogin-ipt').val($("input[name='autoLogin']:checked").length > 0);
	});
	$(function(){
		var errorMsg = "${errorMsg}";
		if (errorMsg.length != 0) {
			showTips(errorMsg, 340, 2);
		}
	})
</script>
</html>