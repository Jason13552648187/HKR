package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jason
 * @date 2020/10/29-17:04
 */
@Component
public class Course implements Serializable {

    private Integer id;
    private String cid;
    private String courseName;
    private String descri;
    private Date createtime;
    private Integer status;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", courseName='" + courseName + '\'' +
                ", descri='" + descri + '\'' +
                ", createtime=" + createtime +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Course() {
    }

    public Course(Integer id, String cid, String courseName, String descri, Date createtime, Integer status) {

        this.id = id;
        this.cid = cid;
        this.courseName = courseName;
        this.descri = descri;
        this.createtime = createtime;
        this.status = status;
    }
}
