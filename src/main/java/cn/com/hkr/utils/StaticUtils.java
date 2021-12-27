package cn.com.hkr.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author jason
 * @date 2021/4/23-16:51
 */
public class StaticUtils {

   /*获取静态uuid序列码*/
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }

    /*获取静态模板时间*/
    public static  String getDate(String simple){
        return new SimpleDateFormat(simple).format(new Date()).toString();
    }

    public static String getVerifyCode(Integer num){
        return getUUID().toUpperCase().substring(10,10+num);
    }

    /*MD5加密*/
    public static byte[] getMD5Data(String data){
        return DigestUtils.md5Digest(data.getBytes());
    }

    /*获取MD5加密后的str*/
    public static String getMD5String(String data){
        try {
            return DigestUtils.md5DigestAsHex(data.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

/*    public static void main(String[] args) {
        String mail = "这是邮件的激活链接：<a href={0}>点击这里</a>";
        System.out.println(MessageFormat.format(mail,"http://localhost:90/HKR/user/active?acid=23eda43eraewfasd"));


    }*/

}
