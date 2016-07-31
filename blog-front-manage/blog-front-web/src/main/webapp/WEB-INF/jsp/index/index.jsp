<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
		var rootPath='<%=rootPath%>';
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java开源博客系统-Powered by java1234</title>

<link rel="stylesheet" href="<%=rootPath %>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=rootPath %>/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=rootPath %>/stylesheets/blog.css">
<link href="http://blog.java1234.com/favicon.ico" rel="SHORTCUT ICON">
<script src="<%=rootPath %>/javascript/jquery/jquery.min-1.11.3.js"></script>
<script src="<%=rootPath %>/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
	  body {
        padding-top: 10px;
        padding-bottom: 40px;
      }
</style>
</head>
<body>
<div class="container">
	
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp"></jsp:include>
	
	<div class="row">
	<jsp:include page="/WEB-INF/jsp/common/sidebar.jsp"></jsp:include>
		
		<div class="col-md-9">
<div class="data_list">
		<div class="data_list_title">
		<img src="<%=rootPath %>/images/list_icon.png"/>
		最新博客</div>
		<div class="datas articleList">
			<ul>
			  
			</ul>
		</div>
   </div>

<div>
	<nav>
		<div class="dataTables_paginate paging_bootstrap" style="text-align:center;">
														<ul class="pages" id="pagination"></ul>
													</div>
<!-- 	  <ul class="pagination pagination-sm" id="pagination"> -->
<!-- <!-- 	    <li><a href='/index.html?page=1&'>首页</a></li><li class='disabled'><a href='#'>上一页</a></li><li class='active'><a href='/index.html?page=1&'>1</a></li><li><a href='/index.html?page=2&'>2</a></li><li><a href='/index.html?page=3&'>3</a></li><li><a href='/index.html?page=2&'>下一页</a></li><li><a href='/index.html?page=11&'>尾页</a></li> -->
<!-- 	  </ul> -->
	</nav>
 </div>
		</div>
	</div>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</div>
<script src="<%=rootPath %>/javascript/index/index.js"></script>
	<script type="text/javascript"
		src="<%=rootPath%>/javascript/plus/jquery.pagination.js"></script>
</body>
</html>