package com.tensquare.article.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.util.IdWorker;
import com.tensquare.util.MybatisPlusPubFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Article> findAll() {
		return articleDao.selectList(null);
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public IPage<Article> findSearch(Map whereMap, int page, int size) {
		QueryWrapper<Article> wapper = MybatisPlusPubFuns.createEntityWrapper(whereMap);
		// 执行查询
		IPage<Article> p = new Page<Article>(page, size);
		p = articleDao.selectPage(p, wapper);
		return p;
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Article> findSearch(Map whereMap) {
		QueryWrapper<Article> wapper = MybatisPlusPubFuns.createEntityWrapper(whereMap);
		return articleDao.selectList(wapper);
	}


	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Article findById(String id) {
		Article article= (Article)redisTemplate.opsForValue().get("article_"+id);
		if(article==null){
			article=articleDao.selectById(id);//从数据库中查询
			redisTemplate.opsForValue().set("article_"+id,article,10, TimeUnit.SECONDS);//放入缓存

			System.out.println("从数据库中查询并放入缓存");
		}else{
			System.out.println("从缓存中提取数据");
		}
		return article;
	}

	/**
	 * 增加
	 * @param article
	 */
	public void add(Article article) {
		article.setId( idWorker.nextId()+"" );
		articleDao.insert(article);
	}

	/**
	 * 修改
	 * @param article
	 */
	public void update(Article article) {
		redisTemplate.delete("article_"+article.getId());
		articleDao.updateById(article);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		redisTemplate.delete("article_"+id);
		articleDao.deleteById(id);
	}

	/**
	 * 文章审核
	 * @param id
	 */
	@Transactional
	public void examine(String id){
		articleDao.examine(id);
	}

	/**
	 * 点赞
	 * @param id
	 */
	@Transactional
	public void updateThumpup(String id){
		articleDao.updateThumbup(id);
	}

}
