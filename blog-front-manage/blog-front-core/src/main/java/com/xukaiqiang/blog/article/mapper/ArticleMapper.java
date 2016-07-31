package com.xukaiqiang.blog.article.mapper;

import java.util.List;
import java.util.Map;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.model.tags.Tags;
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


	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description:查询类别下的数量
	 * @author Administrator
	 * @date 2016年7月30日 下午1:09:31
	 * @modifier
	 * @modify-date 2016年7月30日 下午1:09:31
	 * @version 1.0
	 * @return
	*/
		
	List<QueryArticleVo> queryTypeCount();


	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 日期分组查询
	 * @author Administrator
	 * @date 2016年7月30日 下午2:07:35
	 * @modifier
	 * @modify-date 2016年7月30日 下午2:07:35
	 * @version 1.0
	 * @return
	*/
		
	List<QueryArticleVo> queryDateCount();


	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description:  标签查询
	 * @author Administrator
	 * @date 2016年7月30日 下午2:48:08
	 * @modifier
	 * @modify-date 2016年7月30日 下午2:48:08
	 * @version 1.0
	 * @return
	*/
		
	List<Tags> queryTagCount();


	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 查询上一篇和下一篇文章
	 * @author Administrator
	 * @date 2016年7月31日 下午2:21:55
	 * @modifier
	 * @modify-date 2016年7月31日 下午2:21:55
	 * @version 1.0
	 * @param id
	 * @return
	*/
		
	List<Article> findPreAndNextArticle(Integer id);
	
	
}