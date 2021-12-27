package cn.com.hkr.bean;

/**
 * @author jason
 * @date 2021/12/20-16:48
 */
public class Compact {

    private String cid;
    private String compactname;
    private String compactstatus;

    public Compact() {
    }

    @Override
    public String toString() {
        return "Compact{" +
                "cid='" + cid + '\'' +
                ", compactname='" + compactname + '\'' +
                ", compactstatus='" + compactstatus + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCompactname() {
        return compactname;
    }

    public void setCompactname(String compactname) {
        this.compactname = compactname;
    }

    public String getCompactstatus() {
        return compactstatus;
    }

    public void setCompactstatus(String compactstatus) {
        this.compactstatus = compactstatus;
    }

    public Compact(String cid, String compactname, String compactstatus) {
        this.cid = cid;
        this.compactname = compactname;
        this.compactstatus = compactstatus;
    }
}
