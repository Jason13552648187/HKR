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
public class CourseService  extends BaseService{

    @Autowired
    private CourseMapper courseMapper;

    /*通过cid查询课程*/
    public List<Course> findCourse(Course course){
        return courseMapper.commonSelect(course);
    }

    /*公共查询课程功能*/
    public List<Course> findByProper(Course course){
        return courseMapper.commonSelect(course);
    }


}
