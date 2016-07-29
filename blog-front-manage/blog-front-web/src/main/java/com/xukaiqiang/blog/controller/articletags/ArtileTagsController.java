package com.xukaiqiang.blog.controller.articletags;

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

import com.xukaiqiang.blog.api.articletags.IArtileTagsService;
import com.xukaiqiang.blog.model.artileTags.ArtileTags;

/**
 * Controller of ArtileTags
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Controller
@RequestMapping("/artileTags")
public class ArtileTagsController {
	
	@Autowired
	private IArtileTagsService artileTagsServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ArtileTags search){
		if (search == null) {
			search = new ArtileTags();
			// search.setPageSize(20);
		}
		model.addAttribute("list", artileTagsServiceImpl.findArtileTagsByPage(search));
		return "artileTags/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ArtileTags ArtileTags) {
		artileTagsServiceImpl.insert(ArtileTags);
		return "redirect:/artileTags";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArtileTags ArtileTags) {
		artileTagsServiceImpl.update(ArtileTags);
		return "redirect:/artileTags";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		artileTagsServiceImpl.deleteArtileTagsById(id);
		return "redirect:/artileTags";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArtileTags getJson(Model model, @PathVariable Integer id){
		return artileTagsServiceImpl.findArtileTagsById(id);
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
