<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String rootPath = request.getContextPath();
%>
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
					文章分类
				</div>
				<div class="datas typeCount">
					<ul>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="<%=rootPath%>/images/byDate_icon.png"/> 
					文章存档
				</div>
				<div class="datas dateCount">
					<ul>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="<%=rootPath%>/images/label.png"/> 
					标签云
				</div>
				<div class="datas tagCount">
					<ul>
							
					</ul>
				</div>
			</div>
			
		</div>