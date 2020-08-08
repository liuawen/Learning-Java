package cn.itcast.es.test;

import cn.itcast.es.pojo.Item;
import cn.itcast.es.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ESTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    //创建索引和映射
    @Test
    public void createIndex() {
        this.elasticsearchTemplate.createIndex(Item.class);
        this.elasticsearchTemplate.putMapping(Item.class);
    }

    //新增
    @Test
    public void testSave() {
        Item item = new Item();
        item.setId(100);
        item.setTitle("SpringData ES");
        item.setContent("今天我们使用SpringData ES完成搜索功能。");

        this.itemService.save(item);

    }

    //修改,和新增的代码是一样的，如果id存在就是修改，如果id不存在就是新增
    @Test
    public void testUpdate() {
        Item item = new Item();
        item.setId(100);
        item.setTitle("SpringData ES");
        item.setContent("今天我们使用SpringData ES完成job搜索功能。");

        this.itemService.save(item);

    }

    //删除
    @Test
    public void testDelete() {
        Item item = new Item();
        item.setId(100);

        this.itemService.delete(item);
    }


    //批量保存
    @Test
    public void testSaveAll() {
        //创建集合
        List<Item> list = new ArrayList<Item>();

        //封装数据
        for (int i = 1; i < 100; i++) {
            Item item = new Item();
            item.setId(i);
            item.setTitle("SpringData ES " + i);
            item.setContent("今天我们使用SpringData ES完成job搜索功能。" + i);

            list.add(item);
        }

        //批量保存
        this.itemService.saveAll(list);
    }

    //查询所有数据
    @Test
    public void testFindAll() {
        Iterable<Item> items = this.itemService.findAll();

        for (Item item : items) {
            System.out.println(item);
        }
    }

    //分页查询数据
    @Test
    public void testFindByPage() {
        Page<Item> page  = this.itemService.findByPage(1, 30);

        for (Item item : page.getContent()) {
            System.out.println(item);
        }
    }

    //复杂查询
    //根据title和Content进行查询，交集
    @Test
    public void testFindByTitleAndContent() {
        List<Item> list = this.itemService.findByTitleAndContent("22", "23");
        for (Item item : list) {
            System.out.println(item);
        }
    }


    //根据title或者Content进行分页查询，并集
    @Test
    public void testFindByTitleOrContent() {
       Page<Item> page =  this.itemService.findByTitleOrContent("22","23",1,5);

        for (Item item : page.getContent()) {
            System.out.println(item);
        }
    }


    //根据Title或者Content和Id的范围，进行分页查询
    @Test
    public void testFindByTitleAndContentAndIdBetween() {
        Page<Item> page = this.itemService.findByTitleAndContentAndIdBetween("ES","job",10,16,1,10);

        for (Item item : page.getContent()) {
            System.out.println(item);
        }
    }


}
