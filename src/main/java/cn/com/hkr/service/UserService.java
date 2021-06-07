package cn.com.hkr.service;

import cn.com.hkr.bean.User;
import cn.com.hkr.bean.UserInterface;
import cn.com.hkr.mapper.UserMapper;
import cn.com.hkr.utils.StaticUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/9/21-15:49
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.getAllUser();
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userMapper.getUserByPhone(phoneNumber);
    }

    public User getUserByNameAndPassword(String username, String password) {
        return userMapper.getUserByNameAndPassword(username, password);
    }

    @Transactional
    public Map register(User user) {
        try {
            if (null == user) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }
            //校验邮箱和手机号是否已经被注册

            if (emailIsExist(user.getEmail())) {
                msg.put("msg", "该邮箱已被注册!");
                msg.put("success", false);
                return msg;
            } else if (phoneIsExists(user.getPhoneNumber())) {
                msg.put("msg", "该手机号已被注册!");
                msg.put("success", false);
                return msg;
            }

            /*正常注册逻辑*/
            user.setUid(StaticUtils.getUUID());
            user.setGraduation(2);
            user.setStatus(0);
            user.setRegisterDate(new Date());

            userMapper.addUser(user);
            msg.put("msg", "添加成功!");
            msg.put("success", true);
        } catch (Exception e) {
            msg.put("msg", "注册失败!请稍后重试!");
            msg.put("success", false);

            return msg;
        }
        return msg;
    }


    public Map login(User user) {
        try {
            if (null == user) {
                msg.put("msg", "信息不能为空!");
                msg.put("success", false);
                return msg;
            }

            /*检测密码是否正确*/
            List<User> list = userMapper.selectCommon(user);
            if (null != list && list.size() != 0){
                User u = list.get(0);
                if (u.getStatus() == UserInterface.USER_STATUS_UNACTIVTE){
                    msg.put("msg", "对不起，您还未激活!请到您的邮箱里完成激活配置!");
                    msg.put("success", false);
                    msg.put("code",781);
                    return msg;
                }else if (u.getStatus() == UserInterface.USER_STATUS_ACTIVETED && u.getGraduation() == UserInterface.USER_STATUS_LOGINOUT){
                    msg.put("msg", "对不起，你已退学!账户不可用!");
                    msg.put("success", false);
                    msg.put("code",782);
                    return msg;
                }
                msg.put("data",list.get(0));
                msg.put("success",true);
                return msg;
            }

            msg.put("msg","邮箱或密码错误!");
            msg.put("success",false);
            return msg;

        } catch (Exception e) {
            msg.put("msg","登陆发生未知错误!");
            msg.put("success",false);
            return msg;
        }

    }




    /*查询邮箱是否存储在*/
    private  Boolean emailIsExist(String email){
        User u = new User();
        u.setEmail(email);

        List<User> list = userMapper.selectCommon(u);

        if (null != list && list.size() != 0) return true;
        return false;
    }

    /*查询手机号是否存在*/
    private Boolean phoneIsExists(String phone){
        User u = new User();
        u.setPhoneNumber(phone);

        List<User> list = userMapper.selectCommon(u);

        if (null != list  && list.size() != 0) return true;
        return false;
    }

}
