package cn.com.hkr.mapper;

import cn.com.hkr.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/5-17:02
 */
@Mapper
public interface UserMapper {

    public List<User> getAllUser();

    public List<User> getUserById(String id);

    public User getUserBySex(String sex);

    public User getUserByNameAndPassword(String loginname,String password);

    public User getUserByPhone(String phoneNumber);

    public void addUser(User user);

    public List<User> selectCommon(User user);


}
