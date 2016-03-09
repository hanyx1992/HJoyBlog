<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/css/side-menu.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/style/js/menu.js"></script>
</head>
<body>
	<div class="layout">
		<a href="#menu" id="menuLink" class="menu-link"> <span></span>
		</a>
		<div class="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="/">Pure</a>
				<ul class="pure-menu-list" name="pure-menu-list">

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">全局</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">目录</a></li>

					<li class="pure-menu-item menu-item-divided"><a href="javascript:" class="pure-menu-link">文章</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">巩俐</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">刮风</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">元旭</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">Tables</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">高级</a></li>

					<li class="pure-menu-item menu-item-divided"><a href="javascript:"
						class="pure-menu-link">Tools</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">Customize</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">Extend</a></li>

					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">Blog</a></li>
					<li class="pure-menu-item"><a href="javascript:" class="pure-menu-link">Releases</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>