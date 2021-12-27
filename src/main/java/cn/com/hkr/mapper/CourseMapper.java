package cn.com.hkr.mapper;

import cn.com.hkr.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/5-16:59
 */
@Mapper
public interface CourseMapper {
    
    public List<Course> findAll();

    public void addCourse(Course course);

    public List<Course> commonSelect(Course course);

    public void updateCourse(Course course);
}
