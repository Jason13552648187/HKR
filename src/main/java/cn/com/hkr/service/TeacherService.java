package cn.com.hkr.service;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/23-15:59
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> findAllTeacher(){
        return teacherDao.findAll();
    }

    public List<Teacher> findTeacherByValid(Integer status){
        return teacherDao.findTeacherByValid(status);
    }

}
