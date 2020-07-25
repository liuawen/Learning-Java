package com.springboot.service;

import com.springboot.entity.Message;
import com.springboot.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {

    void updateMessageIsRead(Long messageId);

    void deleteMessage(Long messageId);

    Message findMessageByMessageId(Long messageId);

    int countByIsRead(Integer isRead);

    Page<Message> findAllMessageBySearch(Pages pages, String name, String email);

    List<Message> findAllByIsRead(Integer isRead);

    Long count();
}
