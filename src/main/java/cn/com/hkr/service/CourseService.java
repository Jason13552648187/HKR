package cn.com.hkr.service;

import cn.com.hkr.bean.Course;
import cn.com.hkr.mapper.CourseMapper;
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
    private CourseMapper courseMapper;

    public List<Course> findCourse(Course course){
        return courseMapper.findByProper(course);
    }

    public List<Course> findByProper(Course course){
        return courseMapper.findByProper(course);
    }


}
