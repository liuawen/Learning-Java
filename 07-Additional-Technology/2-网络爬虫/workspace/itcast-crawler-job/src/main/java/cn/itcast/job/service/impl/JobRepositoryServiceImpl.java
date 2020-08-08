package cn.itcast.job.service.impl;


import cn.itcast.job.dao.JobRepository;
import cn.itcast.job.pojo.JobInfoField;
import cn.itcast.job.pojo.JobResult;
import cn.itcast.job.service.JobRepositoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRepositoryServiceImpl implements JobRepositoryService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void save(JobInfoField jobInfoField) {
        this.jobRepository.save(jobInfoField);
    }

    @Override
    public void saveAll(List<JobInfoField> list) {
        this.jobRepository.saveAll(list);
    }

    //salary: *-*
    //page: 1
    //jobaddr: 北京
    //keyword: java
    @Override
    public JobResult search(String salary, String jobaddr, String keyword, Integer page) {
        //解析参数薪资
        String[] salarys = salary.split("-");

        int salaryMin = 0, salaryMax = 0;

        //获取最低薪资
        if ("*".equals(salarys[0])) {
            //如果最小值是*，表示最低薪资是0
        } else {
            //如果最小值不是*，需要转为数字类型，乘以10000
            salaryMin = Integer.parseInt(salarys[0]) * 10000;
        }


        //获取最高薪资
        if ("*".equals(salarys[1])) {
            //如果最大值是*，代表最大的数也包含,设置为1000万
            salaryMax = 10000000;
        } else {
            //如果最大值不是*，需要转为数字类型，乘以10000
            salaryMax = Integer.parseInt(salarys[0]) * 10000;
        }

        //判断工作地点是否为空
        if (StringUtils.isBlank(jobaddr)) {
            //如果为空，设置为*
            jobaddr = "*";
        }

        //判断查询关键词是否为空
        if (StringUtils.isBlank(keyword)) {
            //如果为空，设置为*
            keyword = "*";
        }


        //调用dao的方法执行查询
        Page<JobInfoField> pages = this.jobRepository.findBySalaryMinBetweenAndSalaryMaxBetweenAndJobAddrAndJobNameAndJobInfo(salaryMin,
                salaryMax, salaryMin, salaryMax, jobaddr, keyword, keyword, PageRequest.of(page-1,30));

        //封装结果对象jobResult
        JobResult jobResult = new JobResult();

        //设置结果集
        jobResult.setRows(pages.getContent());
        //设置总页数
        jobResult.setPageTotal(pages.getTotalPages());

        return jobResult;
    }
}
