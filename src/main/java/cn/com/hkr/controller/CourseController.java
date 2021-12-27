package cn.com.hkr.controller;

import cn.com.hkr.bean.Course;
import cn.com.hkr.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jason
 * @date 2020/9/20-9:43
 */
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private Course course;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/getCourse")
    @ResponseBody
    public Object getCourse(Course course){
        logger.debug("----------------------------------进行了课程查询功能的执行!----------------------------------");
        List<Course> se = courseService.findByProper(course);

        result.put("code",700);
        result.put("msg","查询成功！");
        result.put("data",se);
        result.put("success",true);

        System.out.println(course.getCid() + "-----" + se + "-----" + result);

        return result.getMap();
    }
    
}
