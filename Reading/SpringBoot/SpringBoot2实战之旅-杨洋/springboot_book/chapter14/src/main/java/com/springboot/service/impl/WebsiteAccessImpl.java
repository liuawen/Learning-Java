package com.springboot.service.impl;

import com.springboot.constants.Constants;
import com.springboot.entity.WebsiteAccess;
import com.springboot.repository.WebsiteAccessRepository;
import com.springboot.service.WebsiteAccessService;
import com.springboot.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Service
public class WebsiteAccessImpl implements WebsiteAccessService {

    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return websiteAccessRepository.getByAccessDateIs(accessDate);
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {
        websiteAccessRepository.save(websiteAccess);
    }

    @Override
    public List<WebsiteAccess> findChartsWebsiteAccess() {
        Pageable pageable = PageRequest.of(Constants.startPage, Constants.defaultPageSize, Sort.Direction.ASC, "accessDate");
        Page<WebsiteAccess> websiteAccessPage = websiteAccessRepository.findAll(pageable);
        return websiteAccessPage != null ? websiteAccessPage.getContent() : null;
    }

    @Override
    public Integer sumWebsiteAccess(Date date, Integer days) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);
        Root<WebsiteAccess> root = query.from(WebsiteAccess.class);
        query.select(criteriaBuilder.sum(root.get("accessCount")));
        if (days == null && date != null) {
            Predicate predicate = criteriaBuilder.equal(root.get("accessDate"), date);
            query.where(predicate);
        } else if (date != null) {
            Predicate predicate = criteriaBuilder.between(root.get("accessDate"), DateUtils.getDateBefore(date, days), date);
            query.where(predicate);
        }
        Integer result = entityManager.createQuery(query).getSingleResult();
        if (result == null) {
            result = 0;
        }
        return result;
    }

}
