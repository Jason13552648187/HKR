package cn.com.hkr.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jason
 * @date 2020/10/29-17:04
 */
public class Course implements Serializable {

    private Integer id;
    private String cid;
    private String courseName;
    private String descri;
    private Date createtime;
    private int status;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
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

    public Date getCreateTime() {
        return createtime;
    }

    public void setCreateTime(String createtime) {
        try {
            this.createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Course() {
    }

    public Course(Integer id, String cid, String courseName, String descri, Date createtime, int status) {
        this.id = id;
        this.cid = cid;
        this.courseName = courseName;
        this.descri = descri;
        this.createtime = createtime;
        this.status = status;
    }
}
