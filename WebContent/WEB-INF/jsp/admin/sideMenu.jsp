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
	<div id="menu">
		<div class="pure-menu">
			<a class="pure-menu-heading" href="/">Pure</a>
			<ul class="pure-menu-list">

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Get
						Started</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Layouts</a></li>

				<li class="pure-menu-item menu-item-divided"><a href=""
					class="pure-menu-link">Base</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Grids</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Forms</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Buttons</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Tables</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Menus</a></li>

				<li class="pure-menu-item menu-item-divided"><a href=""
					class="pure-menu-link">Tools</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Customize</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Extend</a></li>

				<li class="pure-menu-item"><a href="" class="pure-menu-link">Blog</a></li>
				<li class="pure-menu-item"><a href="" class="pure-menu-link">Releases</a></li>
			</ul>
		</div>
	</div>
</body>
</html>