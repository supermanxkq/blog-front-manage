<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
<title>徐半仙儿</title>

<link rel="stylesheet" href="<%=rootPath %>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=rootPath %>/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=rootPath %>/stylesheets/blog.css">
<link rel="stylesheet" href="<%=rootPath %>/stylesheets/fatstyle.css">
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
						<c:if test="${empty pageViewBaidu.list}">
							<li>没有找到数据！</li>
						</c:if>
							<c:forEach items="${pageViewBaidu.list }" var="obj" varStatus="status">
							<li style="margin-bottom: 30px">
				  	<span class="title"><a href="<%=rootPath %>/article/articleDetail/${obj.id }.html">
				  		<c:choose>
				  			<c:when test="${obj.type==1}">
				  				<font color="green">[原创]&nbsp;</font>
				  			</c:when>
				  			<c:otherwise>
				  				<font color="gray">[转载]</font>
				  			</c:otherwise>
				  		</c:choose>
				  		<c:if test="${obj.isTop==1}">
				  			<font color="red">[置顶]&nbsp;</font>
				  		</c:if>
				  	${obj.title }</a></span>
				  	<span class="summary">摘要: ${obj.summary}……</span>
				  	<span class="info"><fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
				  </li>
				  <hr class="hrline" style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;">
							</c:forEach>
					</ul>
				</div>
  			 </div>

			<div>
				<nav>
					<div class="dataTables_paginate paging_bootstrap" style="text-align:center;">
					${pageViewBaidu.pageHtml2 }
<!-- 																	<ul class="pages" id="pagination"></ul> -->
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
<script src="<%=rootPath %>/javascript/index/index.js" charset="UTF-8"></script>
	<script type="text/javascript"
		src="<%=rootPath%>/javascript/plus/jquery.pagination.js"></script>
</body>
</html>