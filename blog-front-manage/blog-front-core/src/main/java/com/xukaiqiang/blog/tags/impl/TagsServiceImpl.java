package com.xukaiqiang.blog.tags.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.tags.ITagsService;
import com.xukaiqiang.blog.model.tags.Tags;
import com.xukaiqiang.blog.tags.mapper.TagsMapper;


/**
 * Service Implementation:Tags
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class TagsServiceImpl implements ITagsService {

	@Autowired
	private TagsMapper tagsMapper;
	
	/**
	 * 
	* @Title: saveTags
	* @Description: 新增Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(Tags entity){
		tagsMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveTags 
	* @Description: 批量新增Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<Tags> entity){
		tagsMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateTags 
	* @Description: 编辑Tags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(Tags entity){
		tagsMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteTagsById 
	* @Description: 根据id删除Tags
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteTagsById(Integer id){
		tagsMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteTagsByIds 
	* @Description: 根据id批量删除Tags
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteTagsByIds(Integer[] ids){
		tagsMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findTagsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public Tags findTagsById(Integer id){
		return tagsMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findTagsByPage 
	* @Description: 分页查询
	* @return
	* @return List<Tags>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<Tags> findTagsByPage(Tags search){
		return tagsMapper.page(search);
	}

	
	/* (non-Javadoc)
	 * @Description: 标签查询
	 * @author Administrator
	 * @date 2016年7月30日 下午2:51:17
	 * @modifier
	 * @modify-date 2016年7月30日 下午2:51:17
	 * @version 1.0
	 * @return
	*/
		
	@Override
	public List<Tags> queryTagCount() {
		return tagsMapper.queryAll();
	};
}
