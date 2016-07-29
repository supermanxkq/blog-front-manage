package com.xukaiqiang.blog.articletags.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.articletags.IArtileTagsService;
import com.xukaiqiang.blog.articletags.mapper.ArtileTagsMapper;
import com.xukaiqiang.blog.model.artileTags.ArtileTags;


/**
 * Service Implementation:ArtileTags
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class ArtileTagsServiceImpl implements IArtileTagsService {

	@Autowired
	private ArtileTagsMapper artileTagsMapper;
	
	/**
	 * 
	* @Title: saveArtileTags
	* @Description: 新增ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(ArtileTags entity){
		artileTagsMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveArtileTags 
	* @Description: 批量新增ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<ArtileTags> entity){
		artileTagsMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateArtileTags 
	* @Description: 编辑ArtileTags
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(ArtileTags entity){
		artileTagsMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteArtileTagsById 
	* @Description: 根据id删除ArtileTags
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteArtileTagsById(Integer id){
		artileTagsMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteArtileTagsByIds 
	* @Description: 根据id批量删除ArtileTags
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteArtileTagsByIds(Integer[] ids){
		artileTagsMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findArtileTagsById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public ArtileTags findArtileTagsById(Integer id){
		return artileTagsMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findArtileTagsByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArtileTags>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<ArtileTags> findArtileTagsByPage(ArtileTags search){
		return artileTagsMapper.page(search);
	};
}
