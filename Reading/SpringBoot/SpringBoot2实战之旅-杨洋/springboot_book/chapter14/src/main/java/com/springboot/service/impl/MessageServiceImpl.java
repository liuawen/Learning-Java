package com.springboot.service.impl;

import com.springboot.constants.Constants;
import com.springboot.entity.Message;
import com.springboot.entity.Pages;
import com.springboot.repository.MessageRepository;
import com.springboot.service.MessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void updateMessageIsRead(Long messageId) {
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setIsRead(1);
            messageRepository.save(message);
        }

    }

    @Override
    public int countByIsRead(Integer isRead) {
        return messageRepository.countByIsRead(isRead);
    }

    @Override
    public Page<Message> findAllMessageBySearch(Pages pages, String name, String email) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "isRead", "messageInputDate");
        return messageRepository.findAll(this.getWhereClause(name, email), pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public Message findMessageByMessageId(Long messageId) {
        return messageRepository.findById(messageId).get();
    }

    @Override
    public List<Message> findAllByIsRead(Integer isRead) {
        return messageRepository.findAllByIsRead(Constants.NO);
    }

    @Override
    public Long count() {
        return messageRepository.count();
    }

    /**
     * 动态生成where语句
     *
     * @param name,email
     * @return
     */
    private Specification<Message> getWhereClause(String name, String email) {
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (StringUtils.isNotBlank(name)) {
                    predicate.add(
                            cb.or(cb.like(root.get("name"), name + "%"))
                    );
                }
                if (StringUtils.isNotBlank(email)) {
                    predicate.add(
                            cb.or(cb.like(root.get("email"), email + "%"))
                    );
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}
