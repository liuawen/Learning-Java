package cn.itcast.job.controller;

import cn.itcast.job.pojo.JobResult;
import cn.itcast.job.service.JobRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private JobRepositoryService jobRepositoryService;

    //salary: *-*
    //page: 1
    //jobaddr: 北京
    //keyword: java
    //Request URL: http://127.0.0.1:8080/search
    //Request Method: POST

    /**
     * 根据条件分页查询招聘信息
     * @param salary
     * @param jobaddr
     * @param keyword
     * @param page
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public JobResult search(String salary,String jobaddr,String keyword,Integer page) {
        JobResult jobResult =  this.jobRepositoryService.search(salary,jobaddr,keyword,page);
        return jobResult;
    }

}
