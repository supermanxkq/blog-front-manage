package com.xukaiqiang.blog.controller.comments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

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

import com.xukaiqiang.blog.api.comments.ICommentsService;
import com.xukaiqiang.blog.model.comments.Comments;
import com.xukaiqiang.blog.utils.IpAddressUtil;

/**
 * Controller of Comments
 * @author xukaiqiang
 * @date 2016-7-31
 */
@Controller
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	private ICommentsService commentsServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Comments search){
		if (search == null) {
			search = new Comments();
			// search.setPageSize(20);
		}
		model.addAttribute("list", commentsServiceImpl.findCommentsByPage(search));
		return "comments/list";
	}
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Comments Comments,HttpServletRequest request) {
		Comments.setCreateTime(new Date());
		Comments.setIp(IpAddressUtil.getIpAddr(request));
		Comments.setAddredss(IpAddressUtil.getAddressByIP(IpAddressUtil.getIpAddr(request)));
		commentsServiceImpl.insert(Comments);
		return "ok";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Comments Comments) {
		commentsServiceImpl.update(Comments);
		return "redirect:/comments";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		commentsServiceImpl.deleteCommentsById(id);
		return "redirect:/comments";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Comments getJson(Model model, @PathVariable Integer id){
		return commentsServiceImpl.findCommentsById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	@ResponseBody
	@RequestMapping("/queryAll")
	public List<Comments> queryAll(Model model,Comments comments){
		return commentsServiceImpl.queryAll(comments);
	}
}
