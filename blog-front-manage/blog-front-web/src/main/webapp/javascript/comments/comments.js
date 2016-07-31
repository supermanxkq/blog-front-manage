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
	var  Comments={};
	//初始化的方法
	Comments.init=function(){
		var $this=this;
		$this.event();
		$this.queryAll();
	}
	Comments.queryAll=function(){
		var url=rootPath+"/comments/queryAll";
		var data={};
		data.articleId=$(".blog_title").data("id");
		$.ajax({
			url:url,
			data:data,
			type:'post',
			success:function(jsonData){
				$(".commentDatas").html("");
				$.each(jsonData,function(i,obj){
					$(".commentDatas").append(
					'<div class="comment">'+
					'<span><font>'+(i+1)+'楼&nbsp;&nbsp;&nbsp;&nbsp;'+obj.addredss+'('+obj.ip+')：</font>'+obj.content+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;'+new Date(obj.createTime).Format("yyyy-MM-dd hh:mm:ss")+'&nbsp;]</span>'+
				'</div>'
				)
				});
			}
		});
	}
	//添加
	Comments.event=function(){
		$(".submitComment").on('click',function(){
			var url=rootPath+"/comments/add";
			var  data={};
			data.content=$(".commentContent").val();
			data.articleId=$(".blog_title").data("id");
			$.ajax({
				url:url,
				data:data,
				type:'post',
				success:function(jsonData){
					$(".commentContent").val("");
					Comments.queryAll();
				}
			});
			
		});
	}
	
	Window.Comments=Comments;
	$(document).ready(function() {
		Comments.init();
	});
});