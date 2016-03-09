<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${blog_name }-后台管理</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/style/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<div class="page">
         <div class="pageName" ></div>
	     <div class="blog_title" >博客名称:</div>
	<input type="text" class="blog_name" value="${blog_name }">
	</div>
</body>
<script type="text/javascript">
    var errorMsg = "${errorMsg}";
</script>
</html>