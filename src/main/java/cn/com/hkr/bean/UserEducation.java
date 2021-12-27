package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jason
 * @date 2021/12/10-11:43
 */
@Component
public class UserEducation {
    private String school;
    private String professional;
    private Date gradutime;
    private String edulevel;
    private String educonfirm;
    private String edutelnumber;
    private String uid;

    public UserEducation(String school, String professional, Date gradutime, String edulevel, String educonfirm, String edutelnumber, String uid) {
        this.school = school;
        this.professional = professional;
        this.gradutime = gradutime;
        this.edulevel = edulevel;
        this.educonfirm = educonfirm;
        this.edutelnumber = edutelnumber;
        this.uid = uid;
    }

    public String getEduconfirm() {
        return educonfirm;
    }

    public void setEduconfirm(String educonfirm) {
        this.educonfirm = educonfirm;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserEducation() {
    }



    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getGradutime() {
        return gradutime;
    }

    public void setGradutime(Date gradutime) {
        this.gradutime = gradutime;
    }

    public String getEdulevel() {
        return edulevel;
    }

    public void setEdulevel(String edulevel) {
        this.edulevel = edulevel;
    }


    public String getEdutelnumber() {
        return edutelnumber;
    }

    public void setEdutelnumber(String edutelnumber) {
        this.edutelnumber = edutelnumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


}
