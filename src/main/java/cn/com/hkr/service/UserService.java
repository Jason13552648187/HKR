package cn.com.hkr.service;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.bean.User;
import cn.com.hkr.bean.UserStatus;
import cn.com.hkr.mapper.UserMapper;
import cn.com.hkr.utils.SendEmailUtils;
import cn.com.hkr.utils.StaticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author jason
 * @date 2020/9/21-15:49
 */
@Service
public class UserService extends BaseService {
    /*用户相关的缓存map数据库*/
//    private static String verify_mail = "你好，这是您的验证码:<b>{0}</b>！有效时间五分钟！打死都不要告诉别人！";
//    private static String register_mail = new String("你好，您已成功注册账号，请点击连接完成激活:<a href='%s'>点击这里</a>");

    private static String verify_mail;
    private static String register_mail;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SendEmailUtils sendEmailUtils;

    static{

        //用于初始化读取邮件发送的模板数据
        InputStream  input = UserService.class.getClassLoader().getResourceAsStream("mail.properties");

        Properties properties = new Properties();
        if (null != input){
            try {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(properties.get("verify_mail"));
        verify_mail = (String )properties.get("verify_mail");
        register_mail = (String) properties.get("register_mail");
    }


    public List<HashMap> findAll() {
        return userMapper.getAllUser();
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userMapper.getUserByPhone(phoneNumber);
    }

    public User getUserByNameAndPassword(String username, String password) {
        return userMapper.getUserByNameAndPassword(username, password);
    }

    /**
     * 用户注册业务
     * @param user
     * @param contentPath
     * @return
     */
    /*@Transactional
    public Map register(User user,String contentPath) {
        String mail =  user.getUserInfo().getEmail();
        try {
            if (null == user) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }else if (emailIsExist(mail)) {
                msg.put("msg", "该邮箱已被注册!");
                msg.put("success", false);
                return msg;
            } else if (phoneIsExists(user.getUserInfo().getPhoneNumber())) {
                msg.put("msg", "该手机号已被注册!");
                msg.put("success", false);
                return msg;
            }

            *//*正常注册逻辑*//*
            user.setUid(StaticUtils.getUUID());
            user.setGraduation(2);
            user.setStatus(0);
            user.setRegisterDate(new Date());

            //先发送一封激活邮件，先向数据库里插入数据
            try {
                String active_code = StaticUtils.getMD5String(user.getUserInfo().getEmail() + user.getPassword() + user.getUserInfo().getPhoneNumber());
                String subject = "账号激活连接!";
                String active_link = contentPath + "/user/active?acid=" + active_code;
                String email_content = String.format(register_mail, active_link);
                sendEmailUtils.sendMail(user.getUserInfo().getEmail(),
                        subject,
                        email_content ,
                        new String[]{"C:\\Users\\jason\\Pictures\\picture.jpg"}
                );

                //将激活码存一份到数据库
               userMapper.insertVerify(StaticUtils.getUUID(),user.getUid(),active_code);
            }catch (Exception e){
                *//*如果发送邮件数据失败则会返回错误提示，不在添加数据库*//*
                msg.put("msg","邮件发送失败!请稍后重试!");
                msg.put("success",false);
                e.printStackTrace();
                return msg;
            }
            *//*正常添加用户数据*//*
            userMapper.addUser(user);
            msg.put("msg", "添加成功!");
            msg.put("success", true);
        } catch (Exception e) {
            msg.put("msg", "注册失败!请稍后重试!");
            msg.put("success", false);
            e.printStackTrace();
            return msg;
        }
        return msg;
    }
*/
    /**
     * 系统核心登陆业务
     * @return
     */
/*
    public Map login(User user) {
        try {
            if (null == user) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }

            */
/*检测密码是否正确*//*

            List<User> list = userMapper.selectCommon(user);
            if (null != list && list.size() != 0){
                User u = list.get(0);
                if (u.getStatus() == UserStatus.USER_STATUS_UNACTIVTE){
                    msg.put("msg", "对不起，您还未激活!请到您的邮箱里完成激活配置!");
                    msg.put("success", false);
                    msg.put("code",781);
                    return msg;
                }else if (u.getStatus() == UserStatus.USER_STATUS_ACTIVETED && u.getGraduation() == UserStatus.USER_STATUS_LOGINOUT){
                    msg.put("msg", "对不起，你已退学!账户不可用!");
                    msg.put("success", false);
                    msg.put("code",782);
                    return msg;
                }
                msg.put("data",list.get(0));
                msg.put("success",true);
                return msg;
            }
            msg.put("code",779);
            msg.put("msg","邮箱或密码错误!");
            msg.put("success",false);
            return msg;

        } catch (Exception e) {
            msg.put("code",778);
            msg.put("msg","登陆发生未知错误!");
            msg.put("success",false);
            return msg;
        }
    }
*/

    /*
    *发送校验的Email邮件（具体的什么业务逻辑要发的验证码）
    * 并存入数据库中进行校验
    * */
    @Transactional
    public String sendVerifyEmail(String email) throws Exception {

        String verifyCode = StaticUtils.getVerifyCode(6);

        sendEmailUtils.sendMail(email,
                "这是一封激活邮件!",
                MessageFormat.format(verify_mail,verifyCode),
                null);
        return verifyCode;
    }


    /*
    * 修改密码
    * */

    @Transactional
    public Boolean modifyPassword(String email,String newPassword){
        try {
            userMapper.modifyPass(email,newPassword);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    /*查询邮箱是否存储在*/
/*    private  Boolean emailIsExist(String email){
        User u = new User();
        u.getUserInfo().setEmail(email);
        System.out.println(email);
        List<User> list = userMapper.selectCommon(u);
        if (null != list && list.size() != 0) return true;
        return false;
    }*/

    /*查询手机号是否存在*/
/*
    private Boolean phoneIsExists(String phone){
        User u = new User();
        u.getUserInfo().setPhoneNumber(phone);

        List<User> list = userMapper.selectCommon(u);

        if (null != list  && list.size() != 0) return true;
        return false;
    }
*/


    /**
     * 统一的查询方法
     * @param user
     * @return
     */
    public List<HashMap> commonSelect(User user){
        return userMapper.unionSelectCommon(user);
    }

    /**
     * 统一的查询方法
     * @param map
     * @return
     */
    public List<Map> commonSelectMap(Map map){
        System.out.println(map);
        return userMapper.unionSelectCommonMap(map);
    }

    /*
    * 用户激活
    * */
    @Transactional
    public Map active(String acid){
        Map map = userMapper.commonSelectVerify(acid);

        //激活连接无效
        if (null == map  || map.size() == 0){
            msg.put("success",false);
            msg.put("msg","激活连接无效!");
            msg.put("code",925);
            return msg;
        }

        //重复激活
        if ((Integer) map.get("status") == 1){
            msg.put("success",false);
            msg.put("msg","该用户已经激活!请勿重新激活!");
            msg.put("code",924);
            return msg;
        }


        //激活连接已经失效
        if ((Integer) map.get("isVariable") == 1){
            msg.put("success",false);
            msg.put("msg","激活连接已经失效!");
            msg.put("code",925);
            return msg;
        }else{
            //正常激活
            userMapper.updateUserStatus((String)map.get("uid"),1);
            msg.put("success",true);
            msg.put("msg","激活成功!");
            msg.put("code",925);
            return msg;
        }

    }


}
