package com.xukaiqiang.blog.controller.course;

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

import com.xukaiqiang.blog.api.course.ICourseService;
import com.xukaiqiang.blog.model.course.Course;

/**
 * Controller of Course
 * @author xukaiqiang
 * @date 2016-8-28
 */
@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Course search){
		if (search == null) {
			search = new Course();
			// search.setPageSize(20);
		}
		model.addAttribute("list", courseServiceImpl.findCourseByPage(search));
		return "course/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Course Course) {
		courseServiceImpl.insert(Course);
		return "redirect:/course";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Course Course) {
		courseServiceImpl.update(Course);
		return "redirect:/course";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		courseServiceImpl.deleteCourseById(id);
		return "redirect:/course";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Course getJson(Model model, @PathVariable Integer id){
		return courseServiceImpl.findCourseById(id);
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
