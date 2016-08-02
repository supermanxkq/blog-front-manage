package com.xukaiqiang.blog.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseWebController {
	private Logger log = Logger.getLogger(BaseWebController.class);
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequestMapping(value={"/","/index"}) 
//	public String index(){
//		return "index/index";
//	}
}
