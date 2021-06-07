package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jason
 * @date 2020/10/26-15:58
 */
@Component
public class Evaluate implements Serializable {
    private String id;
    private String username;
    private String classname;
    private Integer lesson;
    private String understand;
    private String helpful;
    private String enterpriseNeed;
    private String langClear;
    private String isSystem;
    private String studyAgain;
    private String satis;
    private String purpose;
    private String suggestion;
    private Date submitDate;
    private String tname;


    public Evaluate(String id, String username, String classname, Integer lesson, String understand, String helpful, String enterpriseNeed, String langClear, String isSystem, String studyAgain, String satis, String purpose, String suggestion, Date submitDate, String tname) {
        this.id = id;
        this.username = username;
        this.classname = classname;
        this.lesson = lesson;
        this.understand = understand;
        this.helpful = helpful;
        this.enterpriseNeed = enterpriseNeed;
        this.langClear = langClear;
        this.isSystem = isSystem;
        this.studyAgain = studyAgain;
        this.satis = satis;
        this.purpose = purpose;
        this.suggestion = suggestion;
        this.submitDate = submitDate;
        this.tname = tname;
    }

    public String getSatis() {
        return satis;
    }

    public void setSatis(String satis) {
        this.satis = satis;
    }


    public Evaluate() {
    }

    public Evaluate(String id, String username, String classname, Integer lesson, String understand, String helpful, String enterpriseNeed, String langClear, String isSystem, String studyAgain, String purpose, String suggestion, Date submitDate, String tname) {
        this.id = id;
        this.username = username;
        this.classname = classname;
        this.lesson = lesson;
        this.understand = understand;
        this.helpful = helpful;
        this.enterpriseNeed = enterpriseNeed;
        this.langClear = langClear;
        this.isSystem = isSystem;
        this.studyAgain = studyAgain;
        this.purpose = purpose;
        this.suggestion = suggestion;
        this.submitDate = submitDate;
        this.tname = tname;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public String getUnderstand() {
        return understand;
    }

    public void setUnderstand(String understand) {
        this.understand = understand;
    }

    public String getHelpful() {
        return helpful;
    }

    public void setHelpful(String helpful) {
        this.helpful = helpful;
    }

    public String getEnterpriseNeed() {
        return enterpriseNeed;
    }

    public void setEnterpriseNeed(String enterpriseNeed) {
        this.enterpriseNeed = enterpriseNeed;
    }

    public String getLangClear() {
        return langClear;
    }

    public void setLangClear(String langClear) {
        this.langClear = langClear;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getStudyAgain() {
        return studyAgain;
    }

    public void setStudyAgain(String studyAgain) {
        this.studyAgain = studyAgain;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        try {
            this.submitDate = new SimpleDateFormat("yyyy-MM-dd").parse(submitDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", classname='" + classname + '\'' +
                ", lesson=" + lesson +
                ", understand='" + understand + '\'' +
                ", helpful='" + helpful + '\'' +
                ", enterpriseNeed='" + enterpriseNeed + '\'' +
                ", langClear='" + langClear + '\'' +
                ", isSystem='" + isSystem + '\'' +
                ", studyAgain='" + studyAgain + '\'' +
                ", purpose='" + purpose + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", submitDate=" + submitDate +
                ", tname='" + tname + '\'' +
                '}';
    }
}
