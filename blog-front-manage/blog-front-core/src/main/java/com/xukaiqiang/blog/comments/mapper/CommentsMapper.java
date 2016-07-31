package com.xukaiqiang.blog.comments.mapper;

import java.util.List;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.comments.Comments;

/**
 * Service Interface:Comments
 * @author xukaiqiang
 * @date 2016-7-31
 */
public interface CommentsMapper extends BaseMapper<Comments> {

	
	/**
	 * Class Name: CommentsMapper.java
	 * @Description:查询所有
	 * @author Administrator
	 * @date 2016年7月31日 下午8:29:16
	 * @modifier
	 * @modify-date 2016年7月31日 下午8:29:16
	 * @version 1.0
	 * @param comments
	 * @return
	*/
		
	List<Comments> queryAllList(Comments comments);
	
	
}