package cn.com.hkr.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jason
 * @date 2020/10/29-22:40
 */
public class Log {
    private String role;
    private String username;
    private String operation;
    private Date opera_time;

    @Override
    public String toString() {
        return "Log{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", opera_time='" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(opera_time) + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getOpera_time() {
        return opera_time;
    }

    public void setOpera_time(String opera_time) {
        try {
            this.opera_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(opera_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Log() {
    }

    public Log(String role, String username, String operation, Date opera_time) {
        this.role = role;
        this.username = username;
        this.operation = operation;
        this.opera_time = opera_time;
    }
}
