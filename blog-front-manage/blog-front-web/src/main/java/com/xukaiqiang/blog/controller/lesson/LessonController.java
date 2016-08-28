package com.xukaiqiang.blog.controller.lesson;

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

import com.xukaiqiang.blog.api.lesson.ILessonService;
import com.xukaiqiang.blog.model.lesson.Lesson;

/**
 * Controller of Lesson
 * @author xukaiqiang
 * @date 2016-8-28
 */
@Controller
@RequestMapping("/lesson")
public class LessonController {
	
	@Autowired
	private ILessonService lessonServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Lesson search){
		if (search == null) {
			search = new Lesson();
			// search.setPageSize(20);
		}
		model.addAttribute("list", lessonServiceImpl.findLessonByPage(search));
		return "lesson/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Lesson Lesson) {
		lessonServiceImpl.insert(Lesson);
		return "redirect:/lesson";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Lesson Lesson) {
		lessonServiceImpl.update(Lesson);
		return "redirect:/lesson";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		lessonServiceImpl.deleteLessonById(id);
		return "redirect:/lesson";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Lesson getJson(Model model, @PathVariable Integer id){
		return lessonServiceImpl.findLessonById(id);
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
