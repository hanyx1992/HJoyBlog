<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${hello}</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<style type="text/css">
html, body, * {
	font-family: "Microsoft YaHei" ! important;
}

.c1 {
	background-color: #1abc9c;
	color: black;
}

.c2 {
	color: black;
	background-color: #FFFFFF;
}

.c3 {
	padding-left: 40px;
}

.ph-500 {
	min-height: 500px;
} /*用于占位*/
.ph-50 {
	min-height: 50px;
} /*用于占位*/
.ph-100 {
	min-height: 100px;
} /*用于占位*/
.ph-150 {
	min-height: 150px;
} /*用于占位*/
.ph-200 {
	min-height: 200px;
} /*用于占位*/
.ph-300 {
	min-height: 300px;
} /*用于占位*/
.mg {
	margin: 2px;
} /*增加边距*/
.main {
	max-width: 87%;
	margin: 0 auto;
} /*页面主体*/
.c3 input {
	font-size: 16px;
	width: 100%;
}

.catalog {
	padding-top: 20px;
	height: 40px;
	font-size: 18px;
	border-bottom: solid 1px #cfcfcf;
	height: 40px;
}

.catalogTotal {
	float: right;
}

.c2 ul {
	padding-left: 0px;
}

.c2 li {
	list-style-type: none;
}
</style>
</head>
<body>
	<div class="main pure-g">
		<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
		<div class="pure-u-3-4">
			<div class="c1 ph-500 mg">
				<!--内容-->
			</div>
		</div>
		<div class="pure-u-1-4">
			<div class="c2 ph-200 mg">
				<div class="c3 ph-200 mg">
					<input type="text" class="search" placeholder="Search">
					<div class="catalog">
						<span class="catalogName">目录</span>
					</div>
					<ul>
						<c:forEach items="${catalogList}" var="catalog">
							<li><a href="${catalog.catalogPath }">${catalog.catalogId }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="c2 ph-300 mg"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//
	})
</script>
</html>