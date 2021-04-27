package cn.com.hkr.controller;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author jason
 * @date 2020/10/22-20:08
 */
@Controller
public class TeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping({"admin"})
    public String adminIndex(){
        return "/adminpage/login";
    }

    @RequestMapping("/teacherLogin")
    public String teacherLogin(@Param("loginname") String loginname,
                               @Param("password") String password,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session) throws UnsupportedEncodingException {








        return "/admin_jsps/login";

    }


    /**
     * 查找启动状态老师
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findAllValidTeacher")
    @ResponseBody
    public Object  findAllValidTeacher(HttpServletRequest request , HttpServletResponse response, Teacher teacher){
        List<Teacher>  list = teacherService.findTeacherByValid(teacher.getStatus());

        result.put("code",700);
        result.put("msg","查询成功!数据记录为" + list.size());
        result.put("success",true);
        result.put("data",list);

        return result.getMap();

    }




    @RequestMapping("/findAllTeacher")
    @ResponseBody
    public Object findAllTeacher(){
        result.put("code",700);
        result.put("msg","成功!");

        List<Teacher> list = teacherService.findAllTeacher();
        result.put("success",true);
        result.put("data",list);
        return result.getMap();
    }








}
