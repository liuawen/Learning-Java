package com.dalaoyang;

import com.dalaoyang.entity.Book;
import com.dalaoyang.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang
 * @email yangyang@dalaoyang.cn
 * @date 2018/8/8
 */
@RestController
public class Controller {

    @Autowired
    private BookRepository bookRepository;

    //http://localhost:8888/save?bookName=java
    @GetMapping("save")
    public String saveBook(String bookName){

        Book book = new Book();
        book.setBookName(bookName);
        bookRepository.save(book);
        return "success";
    }

    //http://localhost:8888/book/1
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> showBook(@PathVariable Long id) {
        System.out.println(new Date());
        System.out.println("这次查询的id是"+id);
        String version = id+"";
        Book book = bookRepository.getOne(id);

        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
                .eTag(version) // lastModified is also available
                .body(book);
    }
}
