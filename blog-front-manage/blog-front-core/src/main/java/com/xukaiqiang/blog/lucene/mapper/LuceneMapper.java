package com.xukaiqiang.blog.lucene.mapper;

import java.util.List;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.lucene.Search;

/**
 * @ClassName: LuceneMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年8月26日 下午10:43:39
 * @modifier
 * @modify-date 2016年8月26日 下午10:43:39
 * @version 1.0
*/

public interface LuceneMapper extends BaseMapper<Search>{

	
	/**
	 * Class Name: LuceneMapper.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Administrator
	 * @date 2016年8月26日 下午10:44:42
	 * @modifier
	 * @modify-date 2016年8月26日 下午10:44:42
	 * @version 1.0
	 * @param statementName
	 * @return
	*/
	List<Search> queryForList(String statementName);

}
