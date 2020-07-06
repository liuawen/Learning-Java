package cn.itcast.job.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "jobinfo", type = "JobInfoField")
public class JobInfoField {

    @Id
    @Field(index = true, store = true, type = FieldType.Long)
    private Long id;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String companyName;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String companyAddr;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String companyInfo;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String jobName;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String jobAddr;
    @Field(index = true, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart", type = FieldType.Text)
    private String jobInfo;
    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer salaryMin;
    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer salaryMax;
    @Field(index = true, store = true, type = FieldType.Text)
    private String url;
    @Field(index = true, store = true, type = FieldType.Text)
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobAddr() {
        return jobAddr;
    }

    public void setJobAddr(String jobAddr) {
        this.jobAddr = jobAddr;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyAddr='" + companyAddr + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobAddr='" + jobAddr + '\'' +
                ", jobInfo='" + jobInfo + '\'' +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
