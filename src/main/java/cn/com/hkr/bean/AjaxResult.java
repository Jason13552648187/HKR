package cn.com.hkr.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 * @date 2020/9/22-14:59
 */
public class AjaxResult {

    private String msg;
    private Integer code;
    private Object data;
    private Boolean success;
    private Map<String,Object> result = new HashMap<String,Object>();

    @Override
    public String toString() {
        return "AjaxResult{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", success=" + success +
                ", result=" + result +
                '}';
    }

    public void put(String key, Object value){
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public AjaxResult(Integer code, String msg, Boolean success,Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public AjaxResult(Integer errorCode, String dataTypeMsg, Object o) {
        this.code = errorCode;
        this.msg = dataTypeMsg;
        this.data =  o;
        this.success = Boolean.FALSE;
    }

}
