package cn.com.hkr.service;

import cn.com.hkr.bean.User;
import cn.com.hkr.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jason
 * @date 2020/9/21-15:49
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(int id){
        return userDao.getUserById(id);
    }

    public List<User> getUserBySex(String sex){
        return userDao.getUserBySex(sex);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User getUserByNameAndPassword(String nameOrPhone,String password){
        return userDao.getUserByNameAndPassword(nameOrPhone,password);

    }

    public User getUserByPhoneNumber(String phoneNumber){
        return userDao.getUserByPhoneNumber(phoneNumber);
    }


}
