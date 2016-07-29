package com.xukaiqiang.blog.api.tags;

import java.util.List;

import com.xukaiqiang.blog.model.tags.Tags;
/**
 * Service Interface:Tags
 * @author xukaiqiang
 * @date 2016-7-27
 */
public interface ITagsService  {
	/**
	 * 
	* @Title: saveTags
	* @Description: 新增Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void insert(Tags entity);
	
	/**
	 * 
	* @Title: batchSaveTags 
	* @Description: 批量新增Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void batchInsert(List<Tags> list);
	
	/**
	 * 
	* @Title: updateTags 
	* @Description: 编辑Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void update(Tags entity);
	
	/**
	 * 
	* @Title: deleteTagsById 
	* @Description: 根据id删除Tags
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteTagsById(Integer id);
	
	/**
	 * 
	* @Title: deleteTagsByIds 
	* @Description: 根据id批量删除Tags
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteTagsByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findTagsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	Tags findTagsById(Integer id);
	
	/**
	 * 
	* @Title: findTagsByPage 
	* @Description: 分页查询
	* @return
	* @return List<Tags>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	List<Tags> findTagsByPage(Tags search);
}