package cn.itcast.es.service;

import cn.itcast.es.pojo.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {

    /**
     * 新增
     *
     * @param item
     */
    void save(Item item);

    /**
     * 删除
     *
     * @param item
     */
    void delete(Item item);

    /**
     * 批量保存
     *
     * @param list
     */
    void saveAll(List<Item> list);

    /**
     * 查询所有数据
     *
     * @return
     */
    public Iterable<Item> findAll();

    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @return
     */
    Page<Item> findByPage(int page, int rows);

    /**
     * 根据标题和内容查询，交集
     *
     * @param title
     * @param content
     * @return
     */
    List<Item> findByTitleAndContent(String title, String content);

    /**
     * 根据标题或内容分页查询，并集
     *
     * @param title
     * @param content
     * @param page
     * @param rows
     * @return
     */
    Page<Item> findByTitleOrContent(String title, String content, Integer page, Integer rows);

    /**
     * 根据Title或者Content和Id的范围，进行分页查询
     *
     * @param title
     * @param content
     * @param min
     * @param max
     * @param page
     * @param rows
     * @return
     */
    Page<Item> findByTitleAndContentAndIdBetween(String title, String content, int min, int max, int page, int rows);
}
