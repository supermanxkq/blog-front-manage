package com.xukaiqiang.blog.articletype.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.articletype.IArticleTypeService;
import com.xukaiqiang.blog.articletype.mapper.ArticleTypeMapper;
import com.xukaiqiang.blog.model.articleType.ArticleType;


/**
 * Service Implementation:ArticleType
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class ArticleTypeServiceImpl implements IArticleTypeService {

	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	
	/**
	 * 
	* @Title: saveArticleType
	* @Description: 新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(ArticleType entity){
		articleTypeMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveArticleType 
	* @Description: 批量新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<ArticleType> entity){
		articleTypeMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateArticleType 
	* @Description: 编辑ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(ArticleType entity){
		articleTypeMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteArticleTypeById 
	* @Description: 根据id删除ArticleType
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteArticleTypeById(Integer id){
		articleTypeMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteArticleTypeByIds 
	* @Description: 根据id批量删除ArticleType
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteArticleTypeByIds(Integer[] ids){
		articleTypeMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findArticleTypeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public ArticleType findArticleTypeById(Integer id){
		return articleTypeMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findArticleTypeByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArticleType>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<ArticleType> findArticleTypeByPage(ArticleType search){
		return articleTypeMapper.page(search);
	};
}
