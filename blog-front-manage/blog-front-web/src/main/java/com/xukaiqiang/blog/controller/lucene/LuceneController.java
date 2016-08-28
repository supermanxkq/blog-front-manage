package com.xukaiqiang.blog.controller.lucene;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xukaiqiang.blog.lucene.BlogIndex;
import com.xukaiqiang.blog.utils.StringUtil;
import com.xukaiqiang.blog.vo.lucene.ArticleLuceneVo;

/**
 * 
 * @ProjectName:MarsPlan
 * @ClassName:LuceneAction
 * @Description:索引查询检索
 * @date: Apr 16, 20163:19:07 PM
 * @author: bruce
 * @version: V1.0
 */
@Controller
@RequestMapping("/lucene")
public class LuceneController {
	//博客索引
		private BlogIndex blogIndex=new BlogIndex();
	/** 日志 */
	public Logger logger = Logger.getLogger(LuceneController.class);
	
	/**
	 * Class Name: LuceneController.java
	 * @Description: lucene搜索博客信息
	 * @author Administrator
	 * @date 2016年8月28日 上午1:23:18
	 * @modifier
	 * @modify-date 2016年8月28日 上午1:23:18
	 * @version 1.0
	 * @param q
	 * @param page
	 * @param request
	 * @return
	 * @throws Exception
	*/
		
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="keyWord",required=false)String keyWord,@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("mainPage", "foreground/blog/result.jsp");
		List<ArticleLuceneVo> blogList=blogIndex.searchBlog(keyWord.trim());
		Integer toIndex=blogList.size()>=Integer.parseInt(page)*10?Integer.parseInt(page)*10:blogList.size();
		mav.addObject("blogList",blogList.subList((Integer.parseInt(page)-1)*10, toIndex));
		mav.addObject("pageCode",this.genUpAndDownPageCode(Integer.parseInt(page), blogList.size(), keyWord,10,request.getContextPath()));
		mav.addObject("keyWord",keyWord);
		mav.addObject("resultTotal",blogList.size());
		mav.addObject("pageTitle","搜索关键字'"+keyWord+"'结果页面_Java开源博客系统");
		mav.setViewName("/index/search");
		return mav;
	}
	
	/**
	 * 获取上一页，下一页代码 查询博客用到
	 * @param page 当前页
	 * @param totalNum 总记录数
	 * @param q 查询关键字
	 * @param pageSize 每页大小
	 * @param projectContext
	 * @return
	 */
	private String genUpAndDownPageCode(Integer page,Integer totalNum,String keyWord,Integer pageSize,String projectContext){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(totalPage==0){
			return "";
		}else{
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager' >");
			if(page>1){
				pageCode.append("<li><a href='"+projectContext+"/lucene/search.html?page="+(page-1)+"&keyWord="+keyWord+"'>上一页</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}
			if(page<totalPage){
				pageCode.append("<li><a href='"+projectContext+"/lucene/search.html?page="+(page+1)+"&keyWord="+keyWord+"'>下一页</a></li>");				
			}else{
				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");				
			}
			pageCode.append("</ul>");
			pageCode.append("</nav>");
		}
		return pageCode.toString();
	}
}
