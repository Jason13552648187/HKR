package cn.com.hkr.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-15:58
 */
@Component
@JsonIgnoreProperties(value="parent")
public class Menu  implements Serializable {
    private String id;
    private String text;
    private String iconCls;
    private String url;
    private String pid;
    private Menu parent;
    private String rowid;

    private List<Menu> childs;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", parent=" + parent +
                ", rowid='" + rowid + '\'' +
                ", childs=" + childs +
                '}';
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}
