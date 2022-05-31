package cn.com.hkr.mapper;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/5-17:02
 */
@Mapper
public interface TeacherMapper {

    public List<Teacher> getAllTeacher();

    public List<Teacher> findTeacherByValid(Integer status);

    public Teacher getTeaById(String tid);

    public List<Teacher> getTeaBySex(String sex);

    public Teacher getUserByNameAndPassword(String loginname,String password);

    public Teacher getUserByPhone(String phoneNumber);

    public List<Teacher> getAllUser();

    public List<Teacher> getUserById(String id);

    public User getUserBySex(String sex);

    public void addTeacher(Teacher user);

    public List<Teacher> selectCommon(Teacher teacher);

    public void modifyPass(@Param("email") String email, @Param("password") String password);

    public void insertVerify(@Param("vid") String vid,@Param("uid") String uid,@Param("vcode")String vcode);

    public Map commonSelectVerify(@Param("vcode")String vcode);

    public void updateUserStatus(@Param("uid")String uid,@Param("status")Integer status);

    public Map findByTid(Teacher teacher);


}
