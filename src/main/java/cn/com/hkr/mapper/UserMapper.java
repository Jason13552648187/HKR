package cn.com.hkr.mapper;

import cn.com.hkr.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/5-17:02
 */
@Mapper
public interface UserMapper {

    public List<HashMap> getAllUser();

    public List<User> getUserById(String id);

    public User getUserBySex(String sex);

    public User getUserByNameAndPassword(String loginname,String password);

    public User getUserByPhone(String phoneNumber);

    public void addUser(User user);

    public List<HashMap> selectCommonBase(User user);

    public void modifyPass(@Param("email") String email,@Param("password") String password);

    public void insertVerify(@Param("vid") String vid,@Param("uid") String uid,@Param("vcode")String vcode);

    public Map commonSelectVerify(@Param("vcode")String vcode);

    public void updateUserStatus(@Param("uid")String uid,@Param("status")Integer status);

    public List<HashMap> unionSelectCommon(User user);

    public List<Map> unionSelectCommonMap(Map map);

    public void updateUser(User user);


    public Map findUserEndtime(Map map);


    public void  updateUserMap(Map map);


}
