package cn.itcast.job.service;

import cn.itcast.job.pojo.JobInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobInfoService {

    /**
     * 保存工作信息
     *
     * @param jobInfo
     */
    public void save(JobInfo jobInfo);


    /**
     * 根据条件查询工作信息
     *
     * @param jobInfo
     * @return
     */
    public List<JobInfo> findJobInfo(JobInfo jobInfo);

    /**
     * 分页查询数据
     * @param page
     * @param rows
     * @return
     */
    Page<JobInfo> findJobInfoByPage(int page, int rows);
}
