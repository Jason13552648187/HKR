package cn.com.hkr.dao;

import cn.com.hkr.bean.Course;
//import cn.com.hkr.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Repository
public class CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll(){
        return courseMapper.findAll();
    }

    public Course findCourseByCid(String cid){
        return courseMapper.findCourseByCid(cid);
    }

    public void addCourse(Course course){
        courseMapper.addCourse(course);
    }


}
