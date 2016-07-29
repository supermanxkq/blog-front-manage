package com.xukaiqiang.blog.article.mapper;

import java.util.List;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;

/**
 * Service Interface:Article
 * @author xukaiqiang
 * @date 2016-7-27
 */
public interface ArticleMapper extends BaseMapper<Article> {

	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 分页查询文章列表
	 * @author Administrator
	 * @date 2016年7月29日 下午10:30:06
	 * @modifier
	 * @modify-date 2016年7月29日 下午10:30:06
	 * @version 1.0
	 * @param search
	 * @return
	*/
	List<QueryArticleListVo> queryArticleList(QueryArticleListVo search);

	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 查询文章的数量
	 * @author Administrator
	 * @date 2016年7月29日 下午10:30:28
	 * @modifier
	 * @modify-date 2016年7月29日 下午10:30:28
	 * @version 1.0
	 * @param search
	 * @return
	*/
	int pageCountArticle(QueryArticleListVo search);
	
	
}