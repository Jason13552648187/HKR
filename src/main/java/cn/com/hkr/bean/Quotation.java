package cn.com.hkr.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author jason
 * @date 2020/10/29-17:04
 */
@Component
public class Quotation implements Serializable {
    private String id;
    private String qid;
    private String qtitle;
    private String qtxt;

    public String getQid() {
        return qid;
    }

    public Quotation(String id, String qid, String qtitle, String qtxt) {
        this.id = id;   
        this.qid = qid;
        this.qtitle = qtitle;
        this.qtxt = qtxt;
    }

    public Quotation() {
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getQtxt() {
        return qtxt;
    }

    public void setQtxt(String qtxt) {
        this.qtxt = qtxt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "id='" + id + '\'' +
                ", qid='" + qid + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", qtxt='" + qtxt + '\'' +
                '}';
    }
}
