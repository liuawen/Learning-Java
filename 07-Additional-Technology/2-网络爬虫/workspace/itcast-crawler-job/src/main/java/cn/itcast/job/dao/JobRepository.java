package cn.itcast.job.dao;

import cn.itcast.job.pojo.JobInfoField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface JobRepository extends ElasticsearchRepository<JobInfoField,Long> {
    Page<JobInfoField> findBySalaryMinBetweenAndSalaryMaxBetweenAndJobAddrAndJobNameAndJobInfo(int salaryMin, int salaryMax, int
            salaryMin1, int salaryMax1, String jobaddr, String keyword, String keyword1, Pageable pageable);
}
