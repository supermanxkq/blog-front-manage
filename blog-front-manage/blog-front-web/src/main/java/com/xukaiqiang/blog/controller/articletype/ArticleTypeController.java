package com.xukaiqiang.blog.controller.articletype;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.xukaiqiang.blog.api.articletype.IArticleTypeService;
import com.xukaiqiang.blog.model.articleType.ArticleType;

/**
 * Controller of ArticleType
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/articleType")
public class ArticleTypeController {
	
	@Autowired
	private IArticleTypeService articleTypeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ArticleType search){
		if (search == null) {
			search = new ArticleType();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleTypeServiceImpl.findArticleTypeByPage(search));
		return "articleType/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ArticleType ArticleType) {
		articleTypeServiceImpl.insert(ArticleType);
		return "redirect:/articleType";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArticleType ArticleType) {
		articleTypeServiceImpl.update(ArticleType);
		return "redirect:/articleType";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleTypeServiceImpl.deleteArticleTypeById(id);
		return "redirect:/articleType";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleType getJson(Model model, @PathVariable Integer id){
		return articleTypeServiceImpl.findArticleTypeById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
