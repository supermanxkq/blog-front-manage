<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	String rootPath=request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
		var rootPath='<%=rootPath%>';
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.title }</title>

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
		<img src="<%=rootPath %>/images/blog_show_icon.png"/>
		博客信息
	</div>
	<div>
	   <div class="blog_title"><h3><strong>${article.title }</strong></h3></div>
	   <div style="padding-left: 330px;padding-bottom: 20px;padding-top: 10px">
		<div class="bshare-custom"><a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博" class="bshare-sinaminiblog"></a><a title="分享到人人网" class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a><span class="BSHARE_COUNT bshare-share-count">0</span></div><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=1&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
	   </div>
		<div class="blog_info">
			发布时间：『<fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 』&nbsp;&nbsp;博客类别：IT之路&nbsp;&nbsp;阅读(22) 评论(4)
		</div>
		<div class="blog_content">
			${article.content }
		</div>
		<div class="blog_keyWord">
			<font><strong>标签：</strong></font>
						&nbsp;&nbsp;<a href="/blog/q.html?q=百度云" target="_blank">${article.tags}</a>&nbsp;&nbsp;
		</div>
		<div class="blog_lastAndNextPage">
			<c:choose>
					<c:when test="${preArticle!=null}">
					<p>上一篇：<a href='<%=rootPath%>/article/articleDetail/${preArticle.id}'>${preArticle.title}</a></p>
					</c:when>
					<c:otherwise>
						<p>上一篇：没有了</p>
					</c:otherwise>
			</c:choose>
			<c:choose>
					<c:when test="${nextArticle!=null}">
					<p>下一篇：<a href='<%=rootPath%>/article/articleDetail/${nextArticle.id}'>${nextArticle.title}</a></p>
					</c:when>
					<c:otherwise>
						<p>下一篇：没有了</p>
					</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/comment_icon.png"/>
		评论信息    
		
	</div>
	<div class="commentDatas">
								<div class="comment">
									<span><font>1楼&nbsp;&nbsp;&nbsp;&nbsp;120.52.18.49：</font>支持小峰老师，不过网盘搜索是真的man。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;2016-07-30 17:50&nbsp;]</span>
								</div>								
								<div class="comment">
									<span><font>2楼&nbsp;&nbsp;&nbsp;&nbsp;125.88.189.13：</font>支持峰哥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;2016-07-30 19:33&nbsp;]</span>
								</div>								
							
							
						
				
						
							
								<div class="comment">
									<span><font>3楼&nbsp;&nbsp;&nbsp;&nbsp;202.102.85.21：</font>牛掰，牛逼，牛叉，屌，强&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;2016-07-30 20:39&nbsp;]</span>
								</div>								
							
							
						
				
			
		
	</div>
</div>

<div class="data_list" >
	<div class="data_list_title">
		<img src="/static/images/publish_comment_icon.png"/>
		发表评论
	</div>
	<div class="publish_comment">
			<div>
				<textarea style="width: 100%" rows="3" id="content" name="content" placeholder="来说两句吧..."></textarea>
			</div>
			<div class="verCode">
				验证码：<input type="text" value="" name="imageCode"  id="imageCode" size="10" onkeydown= "if(event.keyCode==13)form1.submit()"/>&nbsp;<img onclick="javascript:loadimage();"  title="换一张试试" name="randImage" id="randImage" src="/image.jsp" width="60" height="20" border="1" align="absmiddle"> 
			</div>
			<div class="publishButton">
				<button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
			</div>
		</form>
	</div>
</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</div>
<script src="<%=rootPath %>/javascript/index/index.js"></script>
</body>
</html>