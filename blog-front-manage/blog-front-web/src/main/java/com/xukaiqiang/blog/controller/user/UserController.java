package com.xukaiqiang.blog.controller.user;

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

import com.xukaiqiang.blog.api.user.IUserService;
import com.xukaiqiang.blog.model.user.User;

/**
 * Controller of User
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, User search){
		if (search == null) {
			search = new User();
			// search.setPageSize(20);
		}
		model.addAttribute("list", userServiceImpl.findUserByPage(search));
		return "user/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(User User) {
		userServiceImpl.insert(User);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(User User) {
		userServiceImpl.update(User);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		userServiceImpl.deleteUserById(id);
		return "redirect:/user";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public User getJson(Model model, @PathVariable Integer id){
		return userServiceImpl.findUserById(id);
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
