package com.springboot.service.impl;

import com.springboot.entity.Pages;
import com.springboot.entity.Tag;
import com.springboot.repository.TagRepository;
import com.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<Tag> findAllBySearch(Pages pages, Long tagId, String tagName) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "tagId");
        return  tagRepository.findAll(this.getWhereClause(tagId, tagName), pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Tag saveTag(Tag tag) {
       return tagRepository.save(tag);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteTagByTagId(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Tag findTagByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }

    @Override
    public Integer countByTagInputDate(Date tagInputdate) {
        return tagRepository.countByTagInputDate(tagInputdate);
    }

    @Override
    public Long count() {
        return tagRepository.count();
    }

    /**
     * 动态生成where语句
     *
     * @param tagId,tagName
     * @return
     */
    private Specification<Tag> getWhereClause(Long tagId, String tagName) {
        return new Specification<Tag>() {
            @Override
            public Predicate toPredicate(Root<Tag> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (tagId != null) {
                    predicate.add(
                            cb.or(cb.equal(root.get("tagId"), tagId ))
                    );
                }
                if (!StringUtils.isEmpty(tagName)) {
                    predicate.add(
                            cb.or(cb.like(root.get("tagName"), tagName + "%"))
                    );
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}
