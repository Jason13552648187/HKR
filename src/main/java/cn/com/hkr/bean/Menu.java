package cn.com.hkr.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-15:58
 */
@JsonIgnoreProperties(value="parent")
public class Menu  implements Serializable {
    private String id;
    private String text;

    private String url;
    private String pid;
    private Menu parent;

    private List<Menu> childs;

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

    public Menu() {
    }

    public Menu(String id, String text, String url, String pid) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.pid = pid;
    }
}
