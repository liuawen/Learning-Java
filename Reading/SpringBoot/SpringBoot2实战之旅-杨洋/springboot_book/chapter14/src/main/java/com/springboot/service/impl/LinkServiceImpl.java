package com.springboot.service.impl;

import com.springboot.entity.Link;
import com.springboot.entity.Pages;
import com.springboot.repository.LinkRepository;
import com.springboot.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Page<Link> findAllBySearch(Pages pages, Long linkId, String linkName) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "linkId");
        return linkRepository.findAll(this.getWhereClause(linkId, linkName), pageable);
    }

    @Override
    public Link findLinkByLinkId(Long linkId) {
        Optional<Link> optionalLink = linkRepository.findById(linkId);
        if (optionalLink.isPresent()) {
            return optionalLink.get();
        }
        return null;
    }

    @Override
    public void saveOrUpdateLink(Link link) {
        linkRepository.save(link);
    }

    @Override
    public void deleteLink(Long linkId) {
        linkRepository.deleteById(linkId);
    }

    @Override
    public Long count() {
        return linkRepository.count();
    }

    /**
     * 动态生成where语句
     *
     * @param linkId,linkName
     * @return
     */
    private Specification<Link> getWhereClause(Long linkId, String linkName) {
        return new Specification<Link>() {
            @Override
            public Predicate toPredicate(Root<Link> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (linkId != null) {
                    predicate.add(
                            cb.or(cb.equal(root.get("linkId"), linkId))
                    );
                }
                if (!StringUtils.isEmpty(linkName)) {
                    predicate.add(
                            cb.or(cb.like(root.get("linkName"), linkName + "%"))
                    );
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}
