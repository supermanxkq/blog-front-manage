package com.xukaiqiang.blog.api.articletags;

import java.util.List;

import com.xukaiqiang.blog.model.artileTags.ArtileTags;
/**
 * Service Interface:ArtileTags
 * @author xukaiqiang
 * @date 2016-7-27
 */
public interface IArtileTagsService  {
	/**
	 * 
	* @Title: saveArtileTags
	* @Description: 新增ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void insert(ArtileTags entity);
	
	/**
	 * 
	* @Title: batchSaveArtileTags 
	* @Description: 批量新增ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void batchInsert(List<ArtileTags> list);
	
	/**
	 * 
	* @Title: updateArtileTags 
	* @Description: 编辑ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void update(ArtileTags entity);
	
	/**
	 * 
	* @Title: deleteArtileTagsById 
	* @Description: 根据id删除ArtileTags
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArtileTagsById(Integer id);
	
	/**
	 * 
	* @Title: deleteArtileTagsByIds 
	* @Description: 根据id批量删除ArtileTags
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArtileTagsByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArtileTagsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	ArtileTags findArtileTagsById(Integer id);
	
	/**
	 * 
	* @Title: findArtileTagsByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArtileTags>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	List<ArtileTags> findArtileTagsByPage(ArtileTags search);
}