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
		<img src="<%=rootPath %>/images/search_icon.png">
		搜索 <font color="red">${keyWord}</font>  的结果  (总共搜索到 <font color="red">${resultTotal}</font>条记录)</div>
		<div class="datas search">
			<ul>
			<c:forEach items="${blogList }" var="obj" varStatus="status">
					  	  <li style="margin-bottom: 20px">
						  	<span class="title"><a href="<%=rootPath %>/article/articleDetail/${obj.id}.html" target="_blank">${obj.title}</a></span>
						  	<span class="summary">摘要: ${obj.content}……</span>
						  	<span class="link"><a href="${pageContext.request.contextPath}/article/articleDetail/${obj.id}.html">${pageContext.request.contextPath}/article/articleDetail/${obj.id}.html</a>&nbsp;&nbsp;&nbsp;&nbsp;发布日期：${obj.createTime}</span>
						  </li>
			 </c:forEach>
			</ul>
		</div>
		${pageCode}
   </div>
		</div>
	</div>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</div>
<script src="<%=rootPath %>/javascript/index/index.js" charset="UTF-8"></script>
</body>
</html>