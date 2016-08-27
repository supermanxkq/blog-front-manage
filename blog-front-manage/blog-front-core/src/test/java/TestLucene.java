import static org.junit.Assert.*;

import org.junit.Test;

import com.xukaiqiang.blog.lucene.impl.LuceneServiceImpl;

/**
 * @ClassName: TestLucene
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年8月26日 下午11:35:48
 * @modifier
 * @modify-date 2016年8月26日 下午11:35:48
 * @version 1.0
*/

public class TestLucene {

	@Test
	public void test() {
		LuceneServiceImpl luceneServiceImpl=new LuceneServiceImpl();
		try {
//			luceneServiceImpl.buildIndex();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
