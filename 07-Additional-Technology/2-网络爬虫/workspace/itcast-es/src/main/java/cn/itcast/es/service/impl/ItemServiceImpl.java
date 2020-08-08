package cn.itcast.es.service.impl;

import cn.itcast.es.dao.ItemRepository;
import cn.itcast.es.pojo.Item;
import cn.itcast.es.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        this.itemRepository.save(item);
    }

    public void delete(Item item) {
        this.itemRepository.delete(item);
    }

    public void saveAll(List<Item> list) {
        this.itemRepository.saveAll(list);
    }

    public Iterable<Item> findAll() {
        Iterable<Item> items = this.itemRepository.findAll();
        return items;
    }

    public Page<Item> findByPage(int page, int rows) {
        Page<Item> items = this.itemRepository.findAll(PageRequest.of(page, rows));
        return items;
    }

    public List<Item> findByTitleAndContent(String title, String content) {
        List<Item> list = this.itemRepository.findByTitleAndContent(title, content);
        return list;
    }

    public Page<Item> findByTitleOrContent(String title, String content, Integer page, Integer rows) {

        Page<Item> items = this.itemRepository.findByTitleOrContent(title, content, PageRequest.of(page - 1, rows));

        return items;
    }

    public Page<Item> findByTitleAndContentAndIdBetween(String title, String content, int min, int max, int page, int
            rows) {
        Page<Item> items = this.itemRepository.findByTitleAndContentAndIdBetween(title, content, min, max, PageRequest
                .of(page - 1, rows));
        return items;
    }

}
