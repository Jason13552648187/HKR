package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

/**
 * @author jason
 * @date 2021/12/26-21:30
 */
@Component
public class Section {
    private String sid;
    private String secname;
    private String detailname;
    private String description;
    private Integer od;

    @Override
    public String toString() {
        return "Section{" +
                "sid='" + sid + '\'' +
                ", secname='" + secname + '\'' +
                ", detailname='" + detailname + '\'' +
                ", description='" + description + '\'' +
                ", od=" + od +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSecname() {
        return secname;
    }

    public void setSecname(String secname) {
        this.secname = secname;
    }

    public String getDetailname() {
        return detailname;
    }

    public void setDetailname(String detailname) {
        this.detailname = detailname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOd() {
        return od;
    }

    public void setOd(Integer od) {
        this.od = od;
    }

    public Section() {
    }

    public Section(String sid, String secname, String detailname, String description, Integer od) {
        this.sid = sid;
        this.secname = secname;
        this.detailname = detailname;
        this.description = description;
        this.od = od;
    }
}
