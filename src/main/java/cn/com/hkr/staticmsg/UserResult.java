package cn.com.hkr.staticmsg;

import java.io.Serializable;

/**
 * @author jason
 * @date 2020/9/22-15:06
 */
public class UserResult implements Serializable {

    /*
        一些状态码
     */
    public final  static int ERROR_CODE = 705;
    public final  static int SUCCESS_CODE = 700;

    public final  static int LOGINNAME_NULL_CODE = 701;//用户名为空
    public final  static int LOGINNAME_PASSWORD_NULL_CODE = 705;
    public final  static int PASSWORD_NULL_CODE = 702; //密码为空
    public final  static int ID_NULL_CODE = 703; //id为空
    public final  static int LENGTH_DATA = 704; // 长度错误

    /*
    一些状态消息
     */
    public final  static String ERROR_MSG = "该用户不存在!";
    public final  static String SUCCESS_MSG = "OK!";
    public final  static String USERNAME_NULL_MSG = "用户名不能为空!";
    public final  static String PASSWORD_NULL_MSG = "密码不能为空!";
    public final  static String ID_NULL_MSG = "查询ID不能为空!";
    public final  static String LOGINNAME_PASSWORD_NULL_MSG = "用户名或密码不能为空";
    public final  static String LENGTH_DATA_MSG = "数据长度不支持!";
    public final  static String PHONE_ERROR_MSG = "手机号格式错误!";
    public final  static String DATA_TYPE_MSG = "数据格式不支持!";
    public final  static String PASSWORD_ERROR_MSG = "密码错误!";

    public final  static String GRADUATED_STATUS_MSG = "改学员已毕业!";
    public final  static String GRADUATED_BACK_STATUS_MSG = "改学员已退学!";
    public final  static String ACTIVE_STATUS_MSG = "该学员未激活!";




}
