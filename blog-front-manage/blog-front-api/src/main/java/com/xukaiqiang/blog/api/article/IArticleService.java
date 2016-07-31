package com.xukaiqiang.blog.api.article;

import java.util.List;
import java.util.Map;

import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.model.tags.Tags;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;
/**
 * Service Interface:Article
 * @author xukaiqiang
 * @date 2016-7-27
 */
public interface IArticleService  {
	/**
	 * 
	* @Title: saveArticle
	* @Description: 新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void insert(Article entity);
	
	/**
	 * 
	* @Title: batchSaveArticle 
	* @Description: 批量新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void batchInsert(List<Article> list);
	
	/**
	 * 
	* @Title: updateArticle 
	* @Description: 编辑Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void update(Article entity);
	
	/**
	 * 
	* @Title: deleteArticleById 
	* @Description: 根据id删除Article
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArticleById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleByIds 
	* @Description: 根据id批量删除Article
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	void deleteArticleByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	Article findArticleById(Integer id);
	
	/**
	 * 
	* @Title: findArticleByPage 
	* @Description: 分页查询
	* @return
	* @return List<Article>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-27
	* @user by wangzx
	 */
	List<Article> findArticleByPage(Article search);

	
	/**
	 * Class Name: IArticleService.java
	 * @Description: 分页查询文章列表
	 * @author Administrator
	 * @date 2016年7月29日 下午10:28:43
	 * @modifier
	 * @modify-date 2016年7月29日 下午10:28:43
	 * @version 1.0
	 * @param search
	 * @return
	*/
		
	PageFinder<QueryArticleListVo> queryArticleList(QueryArticleListVo search);

	
	/**
	 * Class Name: IArticleService.java
	 * @Description:  查询类别下的数量
	 * @author Administrator
	 * @date 2016年7月30日 下午1:08:27
	 * @modifier
	 * @modify-date 2016年7月30日 下午1:08:27
	 * @version 1.0
	 * @return
	*/
		
	List<QueryArticleVo> queryTypeCount();

	
	/**
	 * Class Name: IArticleService.java
	 * @Description: 日期分组查询
	 * @author Administrator
	 * @date 2016年7月30日 下午2:06:55
	 * @modifier
	 * @modify-date 2016年7月30日 下午2:06:55
	 * @version 1.0
	 * @return
	*/
		
	List<QueryArticleVo> queryDateCount();

	
	/**
	 * Class Name: IArticleService.java
	 * @Description: 查询上一篇
	 * @author Administrator
	 * @date 2016年7月31日 下午4:05:27
	 * @modifier
	 * @modify-date 2016年7月31日 下午4:05:27
	 * @version 1.0
	 * @param id
	 * @return
	*/
		
	Article findPreArticle(Integer id);

	
	/**
	 * Class Name: IArticleService.java
	 * @Description: 查询下一篇文章
	 * @author Administrator
	 * @date 2016年7月31日 下午4:05:47
	 * @modifier
	 * @modify-date 2016年7月31日 下午4:05:47
	 * @version 1.0
	 * @param id
	 * @return
	*/
		
	Article findNextArticle(Integer id);
}