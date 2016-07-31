package com.xukaiqiang.blog.comments.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.comments.ICommentsService;
import com.xukaiqiang.blog.comments.mapper.CommentsMapper;
import com.xukaiqiang.blog.model.comments.Comments;


/**
 * Service Implementation:Comments
 * @author xukaiqiang
 * @date 2016-7-31
 */
@Service
@Transactional
public class CommentsServiceImpl implements ICommentsService {

	@Autowired
	private CommentsMapper commentsMapper;
	
	/**
	 * 
	* @Title: saveComments
	* @Description: 新增Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public void insert(Comments entity){
		commentsMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveComments 
	* @Description: 批量新增Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<Comments> entity){
		commentsMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateComments 
	* @Description: 编辑Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public void update(Comments entity){
		commentsMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteCommentsById 
	* @Description: 根据id删除Comments
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	 @Override
	public void deleteCommentsById(Integer id){
		commentsMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteCommentsByIds 
	* @Description: 根据id批量删除Comments
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public void deleteCommentsByIds(Integer[] ids){
		commentsMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findCommentsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public Comments findCommentsById(Integer id){
		return commentsMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findCommentsByPage 
	* @Description: 分页查询
	* @return
	* @return List<Comments>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by chopin
	 */
	@Override
	public List<Comments> findCommentsByPage(Comments search){
		return commentsMapper.page(search);
	}

	
	/* (non-Javadoc)
	 * @Description:查询所有
	 * @author Administrator
	 * @date 2016年7月31日 下午8:10:14
	 * @modifier
	 * @modify-date 2016年7月31日 下午8:10:14
	 * @version 1.0
	 * @return
	*/
		
	@Override
	public List<Comments> queryAll(Comments comments) {
		return commentsMapper.queryAllList(comments);
	};
}
