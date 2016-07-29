package com.xukaiqiang.blog.controller.tags;

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

import com.xukaiqiang.blog.api.tags.ITagsService;
import com.xukaiqiang.blog.model.tags.Tags;

/**
 * Controller of Tags
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/tags")
public class TagsController {
	
	@Autowired
	private ITagsService tagsServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Tags search){
		if (search == null) {
			search = new Tags();
			// search.setPageSize(20);
		}
		model.addAttribute("list", tagsServiceImpl.findTagsByPage(search));
		return "tags/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Tags Tags) {
		tagsServiceImpl.insert(Tags);
		return "redirect:/tags";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Tags Tags) {
		tagsServiceImpl.update(Tags);
		return "redirect:/tags";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		tagsServiceImpl.deleteTagsById(id);
		return "redirect:/tags";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Tags getJson(Model model, @PathVariable Integer id){
		return tagsServiceImpl.findTagsById(id);
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
