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
			<form class="pure-form">
				<fieldset class="pure-group">
					<input type="text" class="pure-input-1" placeholder="请输入用户名" required>
					<input type="text" class="pure-input-1" placeholder="请输入密码" required>
				</fieldset>
				<label for="option-one" class="pure-checkbox"><input id="option-one" type="checkbox" value="">&nbsp;记住密码</label>
				<button type="submit" class="pure-button pure-input-1 pure-button-primary">登&nbsp;&nbsp;&nbsp;录</button>
			</form>
		</div>
		<div class="footer-div"><p>- Powered By Hanyx & Meihf -</p></div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		//
	})
</script>
</html>