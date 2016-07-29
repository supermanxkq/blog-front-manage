package com.xukaiqiang.blog.article.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.article.IArticleService;
import com.xukaiqiang.blog.article.mapper.ArticleMapper;
import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;


/**
 * Service Implementation:Article
 * @author xukaiqiang
 * @date 2016-7-27
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	/**
	 * 
	* @Title: saveArticle
	* @Description: 新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void insert(Article entity){
		articleMapper.insert(entity);
	};
	
	/**
	 * 
	* @Title: batchSaveArticle 
	* @Description: 批量新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void batchInsert(List<Article> entity){
		articleMapper.batchInsert(entity);
	};
	
	/**
	 * 
	* @Title: updateArticle 
	* @Description: 编辑Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void update(Article entity){
		articleMapper.update(entity);
	};
	
	/**
	 * 
	* @Title: deleteArticleById 
	* @Description: 根据id删除Article
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	 @Override
	public void deleteArticleById(Integer id){
		articleMapper.deleteById(id);
	};
	
	/**
	 * 
	* @Title: deleteArticleByIds 
	* @Description: 根据id批量删除Article
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public void deleteArticleByIds(Integer[] ids){
		articleMapper.deleteByIds(ids);
	};
	
	/**
	 * 
	* @Title: findArticleById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public Article findArticleById(Integer id){
		return articleMapper.findById(id);
	};
	
	/**
	 * 
	* @Title: findArticleByPage 
	* @Description: 分页查询
	* @return
	* @return List<Article>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by chopin
	 */
	@Override
	public List<Article> findArticleByPage(Article search){
		return articleMapper.page(search);
	}

	
	/* (non-Javadoc)
	 * @Description: 分页查询文章信息
	 * @author Administrator
	 * @date 2016年7月29日 下午10:29:11
	 * @modifier
	 * @modify-date 2016年7月29日 下午10:29:11
	 * @version 1.0
	 * @param search
	 * @return
	*/
	@Override
	public PageFinder<QueryArticleListVo> queryArticleList(QueryArticleListVo search) {
		List<QueryArticleListVo> data = articleMapper.queryArticleList(search);
		int rowCount=articleMapper.pageCountArticle(search);
		PageFinder<QueryArticleListVo> pageFinder = new PageFinder<QueryArticleListVo>(search.getPage(), search.getPageSize(), rowCount, data);
		return pageFinder;
	};
}
