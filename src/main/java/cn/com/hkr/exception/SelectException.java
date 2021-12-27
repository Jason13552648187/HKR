package cn.com.hkr.exception;

import org.springframework.stereotype.Component;

/**
 * @author jason
 * @date 2021/8/24-14:15
 */
@Component
public class SelectException extends RuntimeException{
    private String msg;

    public SelectException() {
    }

    public SelectException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
