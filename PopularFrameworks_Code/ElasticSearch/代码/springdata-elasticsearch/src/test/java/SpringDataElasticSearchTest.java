import com.itheima.es.entity.Article;
import com.itheima.es.repositories.ArticleRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() throws Exception {
        //创建索引，并配置映射关系
        template.createIndex(Article.class);
        //配置映射关系
        //template.putMapping(Article.class);
    }

    @Test
    public void addDocument() throws Exception {
        for (int i = 10; i <= 20; i++) {
            //创建一个Article对象
            Article article = new Article();
            article.setId(i);
            article.setTitle("【图解】习近平寄语中俄青少年" + i);
            article.setContent("盛会再携手—各国政要高度评价东博会和商务与投资峰会");
            //把文档写入索引库
            articleRepository.save(article);

        }
    }
    @Test
    public void deleteDocumentById() throws Exception {
        articleRepository.deleteById(1l);
        //全部删除
        //articleRepository.deleteAll();
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(a-> System.out.println(a));
    }
    @Test
    public void testFindById() throws Exception {
        Optional<Article> optional = articleRepository.findById(1l);
        Article article = optional.get();
        System.out.println(article);
    }

    @Test
    public void testFindByTitle() throws Exception {
        List<Article> list = articleRepository.findByTitle("maven是一个工程构建工具");
        list.stream().forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindByTitleOrContent() throws Exception {
        Pageable pageable = PageRequest.of(1, 15);
        articleRepository.findByTitleOrContent("maven", "商务与投资", pageable)
                .forEach(a-> System.out.println(a));
    }

    @Test
    public void testNativeSearchQuery() throws Exception {
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("maven是一个工程构建工具").defaultField("title"))
                .withPageable(PageRequest.of(0, 15))
                .build();
        //执行查询
        List<Article> articleList = template.queryForList(query, Article.class);
        articleList.forEach(a-> System.out.println(a));
    }








}
