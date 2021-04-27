package cn.com.hkr.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 * @date 2020/9/22-14:59
 */
public class AjaxResult {

    private String msg;
    private int code;
    private Object data;
    private Boolean success;
    private Map<String,Object> result = new HashMap<String,Object>();

    public AjaxResult(int errorCode, String dataTypeMsg, Object o) {
    }

    public void put(String key,Object value){
        this.result.put(key,value);
    }

    public Object get(String key){
        return this.result.get(key);
    }

    public Map  getMap(){
        return this.result;
    }

    public AjaxResult(Map result) {
        this.result = result;
    }

    public AjaxResult() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public AjaxResult( int code, String msg, Boolean success,Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.success = success;
    }
}
