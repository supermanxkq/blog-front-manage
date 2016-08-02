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
		$this.queryArticleTypes();
		$this.queryDateCount();
	}
	
	//查询类别和数量
	Index.queryArticleTypes=function(){
		$.ajax({
			url:rootPath+"/article/queryTypeCount.html",
			data:'',
			type:'post',
			success:function(jsonData){
				$.each(jsonData,function(i,obj){
					$(".typeCount").find("ul").append(
							'<li><span><a href="'+rootPath+'/article/queryArticleList.html?typeId='+obj.id+'">'+obj.name+'('+obj.count+')</a></span></li>'		
					);
				});
			}
		});
	}
	
	//查询日期和数量
	Index.queryDateCount=function(){
		$.ajax({
			url:rootPath+"/article/queryDateCount.html",
			data:'',
			type:'post',
			success:function(jsonData){
				$.each(jsonData,function(i,obj){
					$(".dateCount").find("ul").append(
							'<li><span><a href="'+rootPath+'/article/queryArticleList.html?createTimeStr='+obj.createTime+'">'+obj.createTime+'('+obj.count+')</a></span></li>'		
					);
				});
			}
		});
	}
	//查询标签和数量
//	Index.queryTagCount=function(){
//		$.ajax({
//			url:rootPath+"/tags/queryTagCount",
//			data:'',
//			type:'post',
//			success:function(jsonData){
//				$.each(jsonData,function(i,obj){
//					$(".tagCount").find("ul").append(
//							'<li><span><a href="http://www.java1234.com/" target="_blank">'+obj.name+'('+obj.num+')</a></span></li>'
//					);
//				});
//			}
//		});
//	}
	
	// 声明
	window.Index = Index;
	$(document).ready(function() {
		Index.init();
	});
})