package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jason
 * @date 2022/2/9-10:30
 */
@Component
public class Train implements Serializable {
    private String tid;
    private String uid;

    @Override
    public String toString() {
        return "Train{" +
                "tid='" + tid + '\'' +
                ", uid='" + uid + '\'' +
                ", tcompany='" + tcompany + '\'' +
                ", tstarttime=" + tstarttime +
                ", tendtime=" + tendtime +
                ", learntitle='" + learntitle + '\'' +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Train(String tid, String uid, String tcompany, Date tstarttime, Date tendtime, String learntitle) {
        this.tid = tid;
        this.uid = uid;
        this.tcompany = tcompany;
        this.tstarttime = tstarttime;
        this.tendtime = tendtime;
        this.learntitle = learntitle;
    }

    private String tcompany;
    private Date tstarttime;
    private Date tendtime;
    private String learntitle;

    public Train() {
    }

    public String getTcompany() {
        return tcompany;
    }

    public void setTcompany(String tcompany) {
        this.tcompany = tcompany;
    }

    public Date getTstarttime() {
        return tstarttime;
    }

    public void setTstarttime(Date tstarttime) {
        this.tstarttime = tstarttime;
    }

    public Date getTendtime() {
        return tendtime;
    }

    public void setTendtime(Date tendtime) {
        this.tendtime = tendtime;
    }

    public String getLearntitle() {
        return learntitle;
    }

    public void setLearntitle(String learntitle) {
        this.learntitle = learntitle;
    }

    public Train(String tcompany, Date tstarttime, Date tendtime, String learntitle) {
        this.tcompany = tcompany;
        this.tstarttime = tstarttime;
        this.tendtime = tendtime;
        this.learntitle = learntitle;
    }
}
