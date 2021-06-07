package cn.com.hkr.mapper;

import cn.com.hkr.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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


}
