package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jason
 * @date 2021/12/10-11:37
 */
@Component
public class UserInfo {
    private String uid;
    private String sex;
    private Integer age;
    private String idcard;
    private String email;
    private String rawaddress;
    private String curprovince;
    private String curcity;
    private String curcounty;
    private String nationa;
    private Date birthday;
    private String phoneNumber;
    private String wechat;

    public UserInfo(String uid, String sex, Integer age, String idcard, String email, String rawaddress, String curprovince, String curcity, String curcounty, String nationa, Date birthday, String phoneNumber, String wechat) {
        this.uid = uid;
        this.sex = sex;
        this.age = age;
        this.idcard = idcard;
        this.email = email;
        this.rawaddress = rawaddress;
        this.curprovince = curprovince;
        this.curcity = curcity;
        this.curcounty = curcounty;
        this.nationa = nationa;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.wechat = wechat;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserInfo() {
    }

    public UserInfo(String sex, String idcard, String email, String rawaddress, String curprovince, String curcity, String curcounty, String nationa, Date birthday, String phoneNumber, String wechat) {
        this.sex = sex;
        this.idcard = idcard;
        this.email = email;
        this.rawaddress = rawaddress;
        this.curprovince = curprovince;
        this.curcity = curcity;
        this.curcounty = curcounty;
        this.nationa = nationa;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.wechat = wechat;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", email='" + email + '\'' +
                ", rawaddress='" + rawaddress + '\'' +
                ", curprovince='" + curprovince + '\'' +
                ", curcity='" + curcity + '\'' +
                ", curcounty='" + curcounty + '\'' +
                ", nationa='" + nationa + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRawaddress() {
        return rawaddress;
    }

    public void setRawaddress(String rawaddress) {
        this.rawaddress = rawaddress;
    }

    public String getCurprovince() {
        return curprovince;
    }

    public void setCurprovince(String curprovince) {
        this.curprovince = curprovince;
    }

    public String getCurcity() {
        return curcity;
    }

    public void setCurcity(String curcity) {
        this.curcity = curcity;
    }

    public String getCurcounty() {
        return curcounty;
    }

    public void setCurcounty(String curcounty) {
        this.curcounty = curcounty;
    }

    public String getNationa() {
        return nationa;
    }

    public void setNationa(String nationa) {
        this.nationa = nationa;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
