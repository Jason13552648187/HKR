package cn.com.hkr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jason
 * @date 2020/9/18-17:44
 */
@Component
public class User implements Serializable {

    private Integer id;
    private String uid;
    private String loginname;
    private String username;
    private Date registerDate;
    private String graduation;
    private String classname;
    private String carte;
    private Integer status;
    private UserEducation userEducation;
    private UserInfo userInfo;
    private UserWorkHistory userWorkHistory;
    private String password;


    public User() {
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", registerDate=" + registerDate +
                ", graduation='" + graduation + '\'' +
                ", classname='" + classname + '\'' +
                ", carte='" + carte + '\'' +
                ", status=" + status +
                ", userEducation=" + userEducation +
                ", userInfo=" + userInfo +
                ", userWorkHistory=" + userWorkHistory +
                ", password='" + password + '\'' +
                '}';
    }

    public User(Integer id, String uid, String loginname, String username, Date registerDate, String graduation, String classname, String carte, Integer status, UserEducation userEducation, UserInfo userInfo, UserWorkHistory userWorkHistory, String password) {
        this.id = id;
        this.uid = uid;
        this.loginname = loginname;
        this.username = username;
        this.registerDate = registerDate;
        this.graduation = graduation;
        this.classname = classname;
        this.carte = carte;
        this.status = status;
        this.userEducation = userEducation;
        this.userInfo = userInfo;
        this.userWorkHistory = userWorkHistory;
        this.password = password;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEducation getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(UserEducation userEducation) {
        this.userEducation = userEducation;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserWorkHistory getUserWorkHistory() {
        return userWorkHistory;
    }

    public void setUserWorkHistory(UserWorkHistory userWorkHistory) {
        this.userWorkHistory = userWorkHistory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
