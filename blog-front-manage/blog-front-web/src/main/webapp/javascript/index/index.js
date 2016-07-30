$(function(){
	//定义index对象
	var Index={};
	
	//初始化方法
	Index.init=function(){
		var $this=this;
		$this.queryArticleList();
		$this.queryArticleTypes();
	}
	
	//查询类别和数量
	Index.queryArticleTypes=function(){
		$.ajax({
			url:rootPath+"/article/queryTypeCount",
			data:'',
			type:'post',
			success:function(jsonData){
				$.each(jsonData,function(i,obj){
					$(".typeCount").find("ul").append(
							'<li><span><a href="/index.html?typeId=1">'+obj.name+'('+obj.count+')</a></span></li>'		
					);
				});
			}
		});
	}
	
	//分页查询所有的文章列表
	Index.queryArticleList=function(page){
		var article={};
		article.page = page ? page : 1;
		$.ajax({
			url : rootPath+ "/article/queryArticleList",
			data : article,
			type : 'post',
			success:function(jsonData){
				// 清空table中的数据
				$(".articleList").find("tr").remove();
				 if (jsonData.data.length == 0) {
                     $(".articleList").append( '<tr><td colspan="9">没有查找到数据。</td></tr>');
                 }
				$.each(jsonData.data, function(i, obj) {
					$(".articleList").find("ul").append(
					'<li style="margin-bottom: 30px">'+
				  	'<span class="date"><a href="/blog/articles/153.html">2016年07月25日</a></span>'+
				  	'<span class="title"><a href="/blog/articles/153.html">'+obj.title+'</a></span>'+
				  	'<span class="summary">摘要: 数组简介数组是Java中最常见的一种数据结构，可用于存储多个数据；数组的定义type []arrayName; 或者 type arrayName[];实例： int []arr ;int arr[]实例代码：package com.java1234.chap02;public class Demo18 {	...</span>'+
				  	'<span class="img">'+
					  		'<a href="/blog/articles/153.html"><img src="http://blog.java1234.com/static/userImages/20160725/1469430717468024387.jpg" title="1469430717468024387.jpg" alt="QQ鎴浘20160725150712.jpg"></a>'+
					  		'&nbsp;&nbsp;'+
				  	'</span>'+
				  	'<span class="info">发表于 2016-07-25 15:15 阅读(126) 评论(3) </span>'+
				  '</li>'+
				  '<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;">'
				  );
				});
//				   if (jsonData.rowCount >jsonData.pageSize) {
                       $("#pagination").pagination(jsonData.rowCount,
                           {
                               next_text: "下一页",
                               prev_text: "上一页",
                               current_page: jsonData.pageNo - 1,
                               link_to: "javascript:void(0)",
                               num_display_entries: 8,
                               items_per_page: jsonData.pageSize,
                               num_edge_entries: 1,
                               callback: function (page, jq) {
                                   var pageNo = page + 1;
                                   Article.queryList(pageNo);
                               }
                           });
//                   } else {
//                       $(".pagination").html('');
//                   }
				   if (this.page <= 1) {
						return 1;
					}
			}
		});
	}
	// 声明
	window.Index = Index;
	$(document).ready(function() {
		Index.init();
	});
})