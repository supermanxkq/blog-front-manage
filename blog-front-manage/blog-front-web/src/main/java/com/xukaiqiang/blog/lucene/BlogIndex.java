package com.xukaiqiang.blog.lucene;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.xukaiqiang.blog.utils.StringUtil;
import com.xukaiqiang.blog.vo.lucene.ArticleLuceneVo;


/**
 * 博客索引类
 * @author Administrator
 *
 */
public class BlogIndex {

	private Directory dir=null;
	/**
	 * 查询博客信息
	 * @param q 查询关键字
	 * @return
	 * @throws Exception
	 */
	public List<ArticleLuceneVo> searchBlog(String q)throws Exception{
//		dir=FSDirectory.open(Paths.get("D://lucene"));
		dir=FSDirectory.open(Paths.get("/usr/lucene"));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
		QueryParser parser=new QueryParser("title",analyzer);
		Query query=parser.parse(q);
		QueryParser parser2=new QueryParser("content",analyzer);
		Query query2=parser2.parse(q);
		booleanQuery.add(query,BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2,BooleanClause.Occur.SHOULD);
		TopDocs hits=is.search(booleanQuery.build(), 100);
		QueryScorer scorer=new QueryScorer(query);  
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);  
		SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);  
		List<ArticleLuceneVo> articleList=new LinkedList<ArticleLuceneVo>();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			ArticleLuceneVo article=new ArticleLuceneVo();
			article.setId(Integer.parseInt(doc.get(("id"))));
			article.setCreateTime(doc.get(("createTime")));
			String title=doc.get("title");
			String content=StringEscapeUtils.escapeHtml(doc.get("content"));
			if(title!=null){
				TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
				String hTitle=highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)){
					article.setTitle(title);
				}else{
					article.setTitle(hTitle);					
				}
			}
			if(content!=null){
				TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content)); 
				String hContent=highlighter.getBestFragment(tokenStream, content);
				if(StringUtil.isEmpty(hContent)){
					if(content.length()<=200){
						article.setContent(content);
					}else{
						article.setContent(content.substring(0, 200));						
					}
				}else{
					article.setContent(hContent);					
				}
			}
			articleList.add(article);
		}
		return articleList;
	}
}
