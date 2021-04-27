package cn.com.hkr.bean;

/**
 * @author jason
 * @date 2021/1/27-13:51
 */
public interface UserInterface {
    //0:未激活   1：已激活   2：未毕业   3：已毕业   4:已退学
    public  static final int USER_STATUS_UNACTIVTE = 0;
    public static final int USER_STATUS_ACTIVETED = 1;
    public static final int USER_STATUS_UNGRANDUTED = 2;
    public static final int USER_STATUS_GRANDUTED = 3;
    public static final int USER_STATUS_LOGINOUT = 4;

}
