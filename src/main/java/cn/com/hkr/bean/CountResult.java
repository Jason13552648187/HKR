package cn.com.hkr.bean;

/**
 * @author jason
 * @date 2022/3/28-4:15
 */
public class CountResult {
    private String key;
    private String value;

    public CountResult() {
    }

    public CountResult(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
