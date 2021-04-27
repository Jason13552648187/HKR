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

    private int id;
    private String uid;
    private String loginname;
    private String address;
    private String phoneNumber;
    private String email;
    private int graduation;
    private String classname;
    private String carte;
    private String username;
    @JsonIgnore
    private String password;
    private String sex;
    private int age;
    private Date registerDate;

    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", loginname='" + loginname + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", graduation=" + graduation +
                ", classname='" + classname + '\'' +
                ", carte='" + carte + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGraduation() {
        return graduation;
    }

    public void setGraduation(int graduation) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {

    }

    public User(int id, String uid, String loginname, String address, String phoneNumber, String email, int graduation, String classname, String carte, String username, String password, String sex, int age) {
        this.id = id;
        this.uid = uid;
        this.loginname = loginname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.graduation = graduation;
        this.classname = classname;
        this.carte = carte;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.registerDate = new Date();
    }
}
