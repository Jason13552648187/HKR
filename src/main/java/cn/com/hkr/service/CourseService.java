package cn.com.hkr.service;

import cn.com.hkr.bean.Course;
import cn.com.hkr.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class CourseService {
 
    @Autowired
    public CourseDao courseDao;



    public List<Course> findAll(){
        return courseDao.findAll();
    }

    public Course findCourseByCid(String cid){
        return courseDao.findCourseByCid(cid);
    }

    public void addCourse(Course course){
        courseDao.addCourse(course);
    }
}
