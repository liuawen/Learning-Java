package com.springboot.controller;

import com.springboot.entity.Goods;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SolrController {

    @Autowired
    private SolrClient client;

    @Value("${spring.data.solr.collectionName}")
    private String collectionName;
    //给了值 test_solr

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@RequestBody Goods goods) {
        //判断id是否为空 是 赋值  
        if(goods.getId() == null){
            goods.setId(System.currentTimeMillis());
        }
        try {
            SolrInputDocument solrInputDocument = new SolrInputDocument();
            solrInputDocument.setField("id", goods.getId());
            solrInputDocument.setField("goodsName", goods.getGoodsName());
            solrInputDocument.setField("goodsIntroduce", goods.getGoodsIntroduce());
            solrInputDocument.setField("goodsPrice", goods.getGoodsPrice());
            client.add(collectionName, solrInputDocument);
            client.commit(collectionName);
            return goods.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id删除索引
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String delete(String id)  {
        try {
            client.deleteById(collectionName,id);
            client.commit(collectionName);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除所有的索引
     * @return
     */
    @GetMapping("deleteAll")
    public String deleteAll(){
        try {
            client.deleteByQuery(collectionName,"*:*");
            client.commit(collectionName);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
     */
    @GetMapping("getGoodsById")
    public String getGoodsById(String id) throws Exception {
        SolrDocument document = client.getById(collectionName, id);
        return document.toString();
    }

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @GetMapping("search")
    public Map<String, Object> search(String keyword){
        //返回集合
        Map<String,Object> returnMap = new HashMap();
        try {
            SolrQuery params = new SolrQuery();
            //查询条件
            params.set("q", keyword);
            //过滤条件
            params.set("fq", "goodsPrice:[100 TO 100000]");
            //排序
            params.addSort("id", SolrQuery.ORDER.asc);
            //分页
            //从第几条记录开始
            params.setStart(0);
            //最多返回多少条记录
            params.setRows(20);
            //默认域
            params.set("df", "goodsIntroduce");
            //只查询指定域
            params.set("fl", "id,goodsName,goodsIntroduce,goodsPrice");
            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("goodsIntroduce");
            params.addHighlightField("goodsName");
            //设置高亮前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置高亮后缀
            params.setHighlightSimplePost("</span>");
            QueryResponse queryResponse = client.query(collectionName,params);
            SolrDocumentList results = queryResponse.getResults();
            //返回行数
            long numFound = results.getNumFound();
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            results.forEach(result->{
                Map map = highlight.get(result.get("id"));
                result.addField("goodsNameHH",map.get("goodsName"));
                result.addField("goodsIntroduceHH",map.get("goodsIntroduce"));
            });
            returnMap.put("numFound", numFound);
            returnMap.put("results", results);
            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
