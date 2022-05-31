package cn.com.hkr.utils;

import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static Date getDateByString(String time){
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date date = sp.parse(time, pos);
        return date;
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

    /**
     * 校验身份证号是否合法
     * @param id
     * @return
     */
    public static boolean verifyIDCard(String id){
        if (id == null)
            return false;
        id = id.toUpperCase();
        if (id.length() != 15 && id.length() != 18) {
            return false;
        }
        int y = 0, m = 0, d = 0;
        if (id.length() == 15) {
            y = Integer.parseInt("19" + id.substring(6, 8), 10);
            m = Integer.parseInt(id.substring(8, 10), 10);
            d = Integer.parseInt(id.substring(10, 12), 10);
        } else if (id.length() == 18) {
            if (id.indexOf("X") >= 0 && id.indexOf("X") != 17) {
                return false;
            }
            char verifyBit = 0;
            int sum = (id.charAt(0) - '0') * 7 + (id.charAt(1) - '0') * 9 + (id.charAt(2) - '0') * 10
                    + (id.charAt(3) - '0') * 5 + (id.charAt(4) - '0') * 8 + (id.charAt(5) - '0') * 4
                    + (id.charAt(6) - '0') * 2 + (id.charAt(7) - '0') * 1 + (id.charAt(8) - '0') * 6
                    + (id.charAt(9) - '0') * 3 + (id.charAt(10) - '0') * 7 + (id.charAt(11) - '0') * 9
                    + (id.charAt(12) - '0') * 10 + (id.charAt(13) - '0') * 5 + (id.charAt(14) - '0') * 8
                    + (id.charAt(15) - '0') * 4 + (id.charAt(16) - '0') * 2;
            sum = sum % 11;
            switch (sum) {
                case 0:
                    verifyBit = '1';
                    break;
                case 1:
                    verifyBit = '0';
                    break;
                case 2:
                    verifyBit = 'X';
                    break;
                case 3:
                    verifyBit = '9';
                    break;
                case 4:
                    verifyBit = '8';
                    break;
                case 5:
                    verifyBit = '7';
                    break;
                case 6:
                    verifyBit = '6';
                    break;
                case 7:
                    verifyBit = '5';
                    break;
                case 8:
                    verifyBit = '4';
                    break;
                case 9:
                    verifyBit = '3';
                    break;
                case 10:
                    verifyBit = '2';
                    break;

            }

            if (id.charAt(17) != verifyBit) {
                return false;
            }
            y = Integer.parseInt(id.substring(6, 10), 10);
            m = Integer.parseInt(id.substring(10, 12), 10);
            d = Integer.parseInt(id.substring(12, 14), 10);
        }

        int currentY = Calendar.getInstance().get(Calendar.YEAR);

        /*
         * if(isGecko){ currentY += 1900; }
         */
        if (y > currentY || y < 1870) {
            return false;
        }
        if (m < 1 || m > 12) {
            return false;
        }
        if (d < 1 || d > 31) {
            return false;
        }
        return true;
    }

    /**
     * 通过身份证获取出生日期
     * @param id
     * @return
     */
    public static String getBirthById(String id){
        return null;
    }


    /**
     * 通过身份证号获取出生日期、性别、年龄
     * @param certificateNo
     * @return
     */
    public static Map<String,String> getBirAgeSex(String certificateNo){

        if(!verifyIDCard(certificateNo)){
            return null;
        }
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag)
                    return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag)
                    return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-" + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length()))
                    % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-" + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1))
                    % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }



}
