package com.xukaiqiang.blog.api.articletype;

import java.util.List;

import com.xukaiqiang.blog.model.articleType.ArticleType;
/**
 * Service Interface:ArticleType
 * @author xukaiqiang
 * @date 2016-7-27
 */
public interface IArticleTypeService  {
	/**
	 * 
	* @Title: saveArticleType
	* @Description: 新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void insert(ArticleType entity);
	
	/**
	 * 
	* @Title: batchSaveArticleType 
	* @Description: 批量新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void batchInsert(List<ArticleType> list);
	
	/**
	 * 
	* @Title: updateArticleType 
	* @Description: 编辑ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void update(ArticleType entity);
	
	/**
	 * 
	* @Title: deleteArticleTypeById 
	* @Description: 根据id删除ArticleType
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArticleTypeById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleTypeByIds 
	* @Description: 根据id批量删除ArticleType
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArticleTypeByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleTypeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	ArticleType findArticleTypeById(Integer id);
	
	/**
	 * 
	* @Title: findArticleTypeByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArticleType>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	List<ArticleType> findArticleTypeByPage(ArticleType search);
}