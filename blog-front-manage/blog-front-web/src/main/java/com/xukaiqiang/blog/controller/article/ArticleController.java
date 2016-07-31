package com.xukaiqiang.blog.controller.article;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xukaiqiang.blog.api.article.IArticleService;
import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;

/**
 * Controller of Article
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Article search){
		if (search == null) {
			search = new Article();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleServiceImpl.findArticleByPage(search));
		return "article/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Article Article) {
		articleServiceImpl.insert(Article);
		return "redirect:/article";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Article Article) {
		articleServiceImpl.update(Article);
		return "redirect:/article";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleServiceImpl.deleteArticleById(id);
		return "redirect:/article";
	}
	
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	/**
	 * Class Name: ArticleController.java
	 * 
	 * @Description: 查询博客列表
	 * @author Administrator
	 * @date 2016年7月19日 上午12:51:03
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:51:03
	 * @version 1.0
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryArticleList")
	public PageFinder<QueryArticleListVo> queryArticleList(Model model, QueryArticleListVo search) {
		PageFinder<QueryArticleListVo> pageFinder = articleServiceImpl.queryArticleList(search);
		return pageFinder;
	}
	
	
	/**
	 * Class Name: ArticleController.java
	 * 
	 * @Description: 查询类别下的数量
	 * @author Administrator
	 * @date 2016年7月19日 上午12:51:03
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:51:03
	 * @version 1.0
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryTypeCount")
	public List<QueryArticleVo> queryTypeCount() {
		List<QueryArticleVo> list = articleServiceImpl.queryTypeCount();
		return list;
	}
	
	/**
	 * Class Name: ArticleController.java
	 * 
	 * @Description: 日期分组查询
	 * @author Administrator
	 * @date 2016年7月19日 上午12:51:03
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:51:03
	 * @version 1.0
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryDateCount")
	public List<QueryArticleVo> queryDateCount() {
		List<QueryArticleVo> list = articleServiceImpl.queryDateCount();
		return list;
	}
	
	
	
	/**
	 * Class Name: ArticleController.java
	 * @Description: 查看文章详情
	 * @author Administrator
	 * @date 2016年7月31日 上午9:22:32
	 * @modifier
	 * @modify-date 2016年7月31日 上午9:22:32
	 * @version 1.0
	 * @return
	*/
	@RequestMapping("/articleDetail/{id}")	
	public String articleDetail(Model model,@PathVariable Integer id){
		QueryArticleListVo queryArticleListVo=articleServiceImpl.findArticleById(id);
		model.addAttribute("article", queryArticleListVo);
		//查询上一篇和下一篇文章
		Article preArticle=articleServiceImpl.findPreArticle(id);
		Article nextArticle=articleServiceImpl.findNextArticle(id);
		model.addAttribute("preArticle", preArticle);
		model.addAttribute("nextArticle", nextArticle);
		return "article/articledetail";
	}
}
