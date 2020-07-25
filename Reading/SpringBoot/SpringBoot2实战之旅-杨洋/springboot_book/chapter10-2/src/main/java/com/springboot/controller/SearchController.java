package com.springboot.controller;

import com.springboot.entity.Article;
import com.springboot.repository.ArticleRepository;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class SearchController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ArticleRepository articleRepository;

    //1.不分词查询：查询articleContent带有你好 或者 articleName带有你好的文章列表，并且按照readCount倒叙排序
    //http://localhost:8080/query10?keyword=你好
    @GetMapping("query1")
    public List<Article> query1(String keyword) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.termQuery("articleContent", keyword));
        boolQueryBuilder.should(QueryBuilders.termQuery("articleName", keyword));
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("readCount").order(SortOrder.DESC);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withSort(fieldSortBuilder);
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        Page<Article> page = articleRepository.search(nativeSearchQuery);
        if (page != null) {
            return page.getContent();
        } else {
            return null;
        }
    }

    //2.不分词查询：查询articleContent带有我们 或者 你好 并且authorAge在20岁以下的文章列表，并且按照readCount倒叙排序
    //http://localhost:8080/query11?keyword=你好,我们
    @GetMapping("query2")
    public List<Article> query2(String... keyword) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termsQuery("articleContent", keyword));
        boolQueryBuilder.must(QueryBuilders.rangeQuery("authorAge").lt(20));
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("readCount").order(SortOrder.DESC);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withSort(fieldSortBuilder);
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        Page<Article> page = articleRepository.search(nativeSearchQuery);
        if (page != null) {
            return page.getContent();
        } else {
            return null;
        }
    }

    //3.分词查询：经过分词，查询articleContent带有你好节日一词分词后的文章列表，并且按照authorAge倒叙排序
    //http://localhost:8080/query12?keyword=你好节日
    @GetMapping("query3")
    public List<Article> query3(String keyword) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchQuery("articleContent", keyword));
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("authorAge").order(SortOrder.DESC);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withSort(fieldSortBuilder);
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        Page<Article> page = articleRepository.search(nativeSearchQuery);
        if (page != null) {
            return page.getContent();
        } else {
            return null;
        }
    }

    //4.分页分词查询：经过分词，查询articleContent带有你好节日一词分词后的文章列表，并且按照authorAge倒叙排序
    //http://localhost:8080/query13?keyword=你好节日&pageNum=1&pageSize=5
    @GetMapping("query4")
    public Page<Article> query4(String keyword, Integer pageNum, Integer pageSize) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchQuery("articleContent", keyword));
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("authorAge").order(SortOrder.DESC);
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withSort(fieldSortBuilder);
        nativeSearchQueryBuilder.withPageable(pageRequest);
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        Page<Article> page = articleRepository.search(nativeSearchQuery);
        if (page != null) {
            return page;
        } else {
            return null;
        }
    }

    //5.分页分词查询：经过分词，查询articleContent带有你好节日一词分词后的文章列表，并且按照authorAge倒叙排序，并且对匹配到的词语设置为高亮
    //http://localhost:8080/query14?keyword=你好节日&pageNum=1&pageSize=5&fieldNames=articleContent,articleName
    @GetMapping("query5")
    public Map<String, Object> query5(String keyword, Integer pageNum, Integer pageSize, String... fieldNames) {

        //定义返回的map
        Map<String, Object> returnMap = new HashMap<String,Object>();
        //构建请求构建器，设置查询索引
        SearchRequestBuilder builder = elasticsearchTemplate.getClient().prepareSearch("testes");

        //构建查询构建器，设置分词器（如果没设置使用默认）
        QueryBuilder matchQuery = QueryBuilders.multiMatchQuery(keyword, fieldNames).analyzer("ik_max_word");

        //构建高亮构建器
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.postTags("</span>");

        //将高亮构建器，查询构建器，分页参数设置到请求构建器内
        builder.highlighter(highlightBuilder);
        builder.setQuery(matchQuery);
        builder.setFrom((pageNum - 1) * pageSize);
        builder.setSize(pageNum * pageSize);
        builder.setSize(pageSize);

        //执行搜索,返回搜索响应信息
        SearchResponse searchResponse = builder.get();
        SearchHits searchHits = searchResponse.getHits();

        //总命中数
        long total = searchHits.getTotalHits();
        returnMap.put("count", total);

        //将高亮字段封装到返回map
        SearchHit[] hits = searchHits.getHits();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map;
        for(SearchHit searchHit : hits){
            map = new HashMap<>();
            map.put("data",searchHit.getSourceAsMap());
            Map<String,Object> hitMap = new HashMap<>();
            searchHit.getHighlightFields().forEach((k,v) -> {
                String hight = "";
                for(Text text : v.getFragments()){
                    hight += text.string();
                }
                hitMap.put(v.getName(),hight);
            });
            map.put("highlight",hitMap);
            list.add(map);
        }
        returnMap.put("dataList", list);
        return returnMap;
    }

}
