package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jason
 * @date 2021/12/10-11:41
 */
@Component
public class UserWorkHistory {
    private String uid;
    private String company;
    private String job;
    private Date starttime;
    private Date endtime;
    private String workdetail;


    public UserWorkHistory(String uid, String company, String job, Date starttime, Date endtime, String workdetail) {
        this.uid = uid;
        this.company = company;
        this.job = job;
        this.starttime = starttime;
        this.endtime = endtime;
        this.workdetail = workdetail;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserWorkHistory() {
    }

    @Override
    public String toString() {
        return "WorkHistory{" +
                "company='" + company + '\'' +
                ", job='" + job + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", workdetail='" + workdetail + '\'' +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getWorkdetail() {
        return workdetail;
    }

    public void setWorkdetail(String workdetail) {
        this.workdetail = workdetail;
    }

    public UserWorkHistory(String company, String job, Date starttime, Date endtime, String workdetail) {
        this.company = company;
        this.job = job;
        this.starttime = starttime;
        this.endtime = endtime;
        this.workdetail = workdetail;
    }
}
