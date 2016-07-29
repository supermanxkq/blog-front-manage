package com.xukaiqiang.blog.controller.userdetail;

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

import com.xukaiqiang.blog.api.userdetail.IUserDetailService;
import com.xukaiqiang.blog.model.userDetail.UserDetail;

/**
 * Controller of UserDetail
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/userDetail")
public class UserDetailController {
	
	@Autowired
	private IUserDetailService userDetailServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, UserDetail search){
		if (search == null) {
			search = new UserDetail();
			// search.setPageSize(20);
		}
		model.addAttribute("list", userDetailServiceImpl.findUserDetailByPage(search));
		return "userDetail/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(UserDetail UserDetail) {
		userDetailServiceImpl.insert(UserDetail);
		return "redirect:/userDetail";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(UserDetail UserDetail) {
		userDetailServiceImpl.update(UserDetail);
		return "redirect:/userDetail";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		userDetailServiceImpl.deleteUserDetailById(id);
		return "redirect:/userDetail";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public UserDetail getJson(Model model, @PathVariable Integer id){
		return userDetailServiceImpl.findUserDetailById(id);
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
