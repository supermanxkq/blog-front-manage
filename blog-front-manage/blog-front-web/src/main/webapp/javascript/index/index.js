$(function(){
	Date.prototype.Format = function(fmt) { // author: meizz
		  var o = {   
		    "M+" : this.getMonth()+1,                 // 月份
		    "d+" : this.getDate(),                    // 日
		    "h+" : this.getHours(),                   // 小时
		    "m+" : this.getMinutes(),                 // 分
		    "s+" : this.getSeconds(),                 // 秒
		    "q+" : Math.floor((this.getMonth()+3)/3), // 季度
		    "S"  : this.getMilliseconds()             // 毫秒
		  };   
		  if(/(y+)/.test(fmt))   
		    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		  for(var k in o)   
		    if(new RegExp("("+ k +")").test(fmt))   
		  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		  return fmt;   
		}
	//定义index对象
	var Index={};
	
	//初始化方法
	Index.init=function(){
		var $this=this;
		$this.queryArticleList();
		$this.queryArticleTypes();
		$this.queryDateCount();
		$this.queryTagCount();
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
	
	//查询日期和数量
	Index.queryDateCount=function(){
		$.ajax({
			url:rootPath+"/article/queryDateCount",
			data:'',
			type:'post',
			success:function(jsonData){
				$.each(jsonData,function(i,obj){
					$(".dateCount").find("ul").append(
							'<li><span><a href="/index.html?releaseDateStr=2016年07月">'+obj.dateCount+'</a></span></li>'		
					);
				});
			}
		});
	}
	//查询标签和数量
	Index.queryTagCount=function(){
		$.ajax({
			url:rootPath+"/tags/queryTagCount",
			data:'',
			type:'post',
			success:function(jsonData){
				$.each(jsonData,function(i,obj){
					$(".tagCount").find("ul").append(
							'<li><span><a href="http://www.java1234.com/" target="_blank">'+obj.name+'('+obj.num+')</a></span></li>'
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
				$(".articleList ul").find("li").remove();
				$(".articleList ul").find(".hrline").remove();
				 if (jsonData.data.length == 0) {
                     $(".articleList").append( '<tr><td colspan="9">没有查找到数据。</td></tr>');
                 }
				$.each(jsonData.data, function(i, obj) {
					$(".articleList").find("ul").append(
					'<li style="margin-bottom: 30px">'+
				  	'<span class="title"><a href='+rootPath+'/article/articleDetail/'+obj.id+'>'+(obj.type==1?'<font color="green">[原创]&nbsp;</font>':'<font color="gray">[转载]</font>&nbsp;')+(obj.isTop==1?'<font color="red">[置顶]&nbsp;</font>':'')+obj.title+'</a></span>'+
				  	'<span class="summary">摘要: '+obj.summary+'……</span>'+
				  	'<span class="info">'+new Date(obj.createTime).Format("yyyy-MM-dd hh:mm:ss")+'阅读(126) 评论(3) </span>'+
				  '</li>'+
				  '<hr class="hrline" style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;">'
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
                                   Index.queryArticleList(pageNo);
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