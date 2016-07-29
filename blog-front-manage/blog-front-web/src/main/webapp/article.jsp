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
	
<div class="row">
	<div class="col-md-4">
		<img alt="java1234开源博客系统" src="<%=rootPath %>/images/logo.png">
	</div>
	<div class="col-md-8">
		<iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
	</div>
</div>
	
	
<script type="text/javascript">
	function checkData(){
		var q=document.getElementById("q").value.trim();
		if(q==null || q==""){
			alert("请输入您要查询的关键字！");
			return false;
		}else{
			return true;
		}
	}
</script>
<div class="row">
	<div class="col-md-12" style="padding-top: 10px">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="<%=rootPath %>/article/toArticle"><font color="black"><strong>首页</strong></font></a>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
		      <ul class="nav navbar-nav">
		        <!-- <li><a href="#"><font color="black"><strong>Java1234官网</strong></font></a></li> -->
		        <!-- <li><a href="#"><font color="black"><strong>Java学习路线图</strong></font></a></li> -->
		        <!-- <li><a href="#"><font color="red"><strong>Java1234 VIP项目</strong></font></a></li> -->
		        <li><a href="/blogger/aboutMe.html"><font color="black"><strong>关于博主</strong></font></a></li>
		        <li><a href="/download.html"><font color="black"><strong>本站源码下载</strong></font></a></li>
		      </ul>
		      <form action="/blog/q.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
		        <div class="form-group" >
		          <input type="text" id="q" name="q" value="" class="form-control" placeholder="请输入要查询的关键字...">
		        </div>
		        <button type="submit" class="btn btn-default">搜索</button>
		      </form>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
</div>
	
	<div class="row">
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
	  <ul class="pagination pagination-sm">
	    <li><a href='/index.html?page=1&'>首页</a></li><li class='disabled'><a href='#'>上一页</a></li><li class='active'><a href='/index.html?page=1&'>1</a></li><li><a href='/index.html?page=2&'>2</a></li><li><a href='/index.html?page=3&'>3</a></li><li><a href='/index.html?page=2&'>下一页</a></li><li><a href='/index.html?page=11&'>尾页</a></li>
	  </ul>
	</nav>
 </div>
		</div>
		<div class="col-md-3">
			<div class="data_list">
				<div class="data_list_title">
 					<img src="<%=rootPath %>/images/user_icon.png"/>
					博主信息
				</div>
				<div class="user_image">
				<img src="<%=rootPath %>/images/timg.jpg"/> 
				</div>
				<div class="nickName">徐半仙儿</div>
				<div class="userSign">(知识就是力量)</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="<%=rootPath %>/images/byType_icon.png"/> 
					按日志类别
				</div>
				<div class="datas typeCount">
					<ul>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="<%=rootPath%>/images/byDate_icon.png"/> 
					按日志日期
				</div>
				<div class="datas">
					<ul>
							<li><span><a href="/index.html?releaseDateStr=2016年07月">2016年07月(5)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年06月">2016年06月(36)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年05月">2016年05月(10)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年04月">2016年04月(19)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年03月">2016年03月(14)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年02月">2016年02月(23)</a></span></li>
						
							<li><span><a href="/index.html?releaseDateStr=2016年01月">2016年01月(1)</a></span></li>
						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="<%=rootPath%>/images/link_icon.png"/> 
					友情链接
				</div>
				<div class="datas">
					<ul>
							<li><span><a href="http://www.java1234.com/" target="_blank">Java知识分享网</a></span></li>
							<li><span><a href="http://pan.java1234.com/" target="_blank">百度云搜索引擎</a></span></li>
							<li><span><a href="http://www.easyicon.net/" target="_blank">小图标下载</a></span></li>
							<li><span><a href="http://tieba.baidu.com/f?kw=java" target="_blank">Java贴吧</a></span></li>
							<li><span><a href="http://www.uugai.com/" target="_blank">免费logo在线制作</a></span></li>
					</ul>
				</div>
			</div>
			
		</div>
		
		
	</div>
	
	
<div class="row">
	<div class="col-md-12" >
		<div align="center" style="padding-top: 120px" >
			<span style="float: left;">Powered by <a  href="http://www.xukaiqiang.com" target="_blank">徐半仙儿</a> V3.0</span>
			  Copyright © 2012-2016 徐半仙儿  版权所有
		</div>
	</div>
</div>
</div>
<script src="<%=rootPath %>/javascript/article/article.js"></script>
</body>
</html>