package cn.com.hkr.bean;

/**
 * @author jason
 * @date 2021/12/12-20:05
 */
public class UserContact {
    private String uid;
    private String cid;
    private String contact;
    private String unit;
    private String workjob;
    private String telphone;
    private String relation;

    @Override
    public String toString() {
        return "UserContact{" +
                "uid='" + uid + '\'' +
                ", cid='" + cid + '\'' +
                ", contact='" + contact + '\'' +
                ", unit='" + unit + '\'' +
                ", workjob='" + workjob + '\'' +
                ", telphone='" + telphone + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWorkjob() {
        return workjob;
    }

    public void setWorkjob(String workjob) {
        this.workjob = workjob;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public UserContact() {
    }

    public UserContact(String uid, String cid, String contact, String unit, String workjob, String telphone, String relation) {
        this.uid = uid;
        this.cid = cid;
        this.contact = contact;
        this.unit = unit;
        this.workjob = workjob;
        this.telphone = telphone;
        this.relation = relation;
    }
}
