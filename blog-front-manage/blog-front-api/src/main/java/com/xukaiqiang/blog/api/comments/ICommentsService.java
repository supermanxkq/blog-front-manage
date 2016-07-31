package com.xukaiqiang.blog.api.comments;

import java.util.List;

import com.xukaiqiang.blog.model.comments.Comments;
/**
 * Service Interface:Comments
 * @author xukaiqiang
 * @date 2016-7-31
 */
public interface ICommentsService  {
	/**
	 * 
	* @Title: saveComments
	* @Description: 新增Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	void insert(Comments entity);
	
	/**
	 * 
	* @Title: batchSaveComments 
	* @Description: 批量新增Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	void batchInsert(List<Comments> list);
	
	/**
	 * 
	* @Title: updateComments 
	* @Description: 编辑Comments
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	void update(Comments entity);
	
	/**
	 * 
	* @Title: deleteCommentsById 
	* @Description: 根据id删除Comments
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	void deleteCommentsById(Integer id);
	
	/**
	 * 
	* @Title: deleteCommentsByIds 
	* @Description: 根据id批量删除Comments
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	void deleteCommentsByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findCommentsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	Comments findCommentsById(Integer id);
	
	/**
	 * 
	* @Title: findCommentsByPage 
	* @Description: 分页查询
	* @return
	* @return List<Comments>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-31
	* @user by wangzx
	 */
	List<Comments> findCommentsByPage(Comments search);

	
	/**
	 * Class Name: ICommentsService.java
	 * @Description:查询所有)
	 * @author Administrator
	 * @date 2016年7月31日 下午8:10:01
	 * @modifier
	 * @modify-date 2016年7月31日 下午8:10:01
	 * @version 1.0
	 * @param comments 
	 * @return
	*/
		
	List<Comments> queryAll(Comments comments);
}