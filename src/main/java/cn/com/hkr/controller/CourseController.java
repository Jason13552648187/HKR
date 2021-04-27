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
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/getCourse")
    @ResponseBody
    public  Object getScore(){

        try {
            List<Course> list = courseService.findAll();
            result.put("code",700);
            result.put("msg","查询成功!");
            result.put("success",true);
            result.put("data",list);
        } catch (Exception e) {
            result.put("code",705);
            result.put("msg","查询失败!" + e.getMessage());
            result.put("success",false);
            result.put("data",null);
        }
        return result.getMap();
    }
}
