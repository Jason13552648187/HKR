package cn.com.hkr.bean;

/**
 * @author jason
 * @date 2021/1/27-13:51
 */
public interface UserStatus {
    //0:未激活   1：已激活
    public static final Integer USER_STATUS_UNACTIVTE = 0;
    public static final Integer USER_STATUS_ACTIVETED = 1;
    
    //2：未毕业   3：已毕业   4:已退学
    public static final Integer USER_STATUS_UNGRANDUTED = 2;
    public static final Integer USER_STATUS_GRANDUTED = 3;
    public static final Integer USER_STATUS_LOGINOUT = 4;

    public static final String USER_ACTIVE  = "在籍";
    public static final String USER_GRANDUED = "已就业";
    public static final String USER_QUIT = "退学";


}
