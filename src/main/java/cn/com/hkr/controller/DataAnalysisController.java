package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.Course;
import cn.com.hkr.bean.Teacher;
import cn.com.hkr.mapper.DataAnalysisMapper;
import cn.com.hkr.service.CourseService;
import cn.com.hkr.service.DataAnalysisService;
import cn.com.hkr.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/9/20-9:43
 */
@Controller
@RequestMapping("/data")
public class DataAnalysisController extends BaseController {


    @Autowired
    private DataAnalysisService dataAnalysisService;

    @RequestMapping("/getLastMonthData")
    @ResponseBody
    public Object getLastMonthData(@RequestBody Map map, HttpServletRequest request){

        List<Map> map1 = null;
        try {
            String token = getCookieValue(request.getCookies(), "adminmanager");

            if (null == token || token.equals("")) {
                return new AjaxResult(816, "访问数据过期！", false, null);
            }

            //否则就是正常token
            String tid = JwtUtils.getData(token, "tid");
            String loginname = JwtUtils.getData(token, "loginname");

            if (null == tid || null == loginname) {
                result = new AjaxResult(814, "token无效！禁止查询", false, null);
                return result;
            }

            //必须要有当前经理的id和名称
            Teacher tea = new Teacher();
            tea.setTid(tid);


            List<Map<String,Object>> data = dataAnalysisService.getLastMonthData();
            result.put("code",700);
            result.put("msg","查询成功！");
            result.put("success",true);
            result.put("data",data);
            result.put("title","本月入职员工人数");
            result.put("count",data.size());
            return result.getMap();
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }
    }


    @RequestMapping("/getUserNeiSevenDay")
    @ResponseBody
    public Object getUserNeiSevenDay(@RequestBody Map map, HttpServletRequest request){

        List<Map> map1 = null;
        try {
            String token = getCookieValue(request.getCookies(), "adminmanager");

            if (null == token || token.equals("")) {
                return new AjaxResult(816, "访问数据过期！", false, null);
            }

            //否则就是正常token
            String tid = JwtUtils.getData(token, "tid");
            String loginname = JwtUtils.getData(token, "loginname");

            if (null == tid || null == loginname) {
                result = new AjaxResult(814, "token无效！禁止查询", false, null);
                return result;
            }

            //必须要有当前经理的id和名称
            Teacher tea = new Teacher();
            tea.setTid(tid);


            List<Map<String,Object>> data = dataAnalysisService.getUserNeiSevenDay();
            result.put("code",700);
            result.put("msg","查询成功！");
            result.put("success",true);
            result.put("data",data);
            result.put("title","本月入职员工人数");
            result.put("count",data.size());
            return result.getMap();
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }
    }





    @RequestMapping("/getNeiSixMonthUser")
    @ResponseBody
    public Object getNeiSixMonthUser(@RequestBody Map map, HttpServletRequest request){

        List<Map> map1 = null;
        try {
            String token = getCookieValue(request.getCookies(), "adminmanager");

            if (null == token || token.equals("")) {
                return new AjaxResult(816, "访问数据过期！", false, null);
            }

            //否则就是正常token
            String tid = JwtUtils.getData(token, "tid");
            String loginname = JwtUtils.getData(token, "loginname");

            if (null == tid || null == loginname) {
                result = new AjaxResult(814, "token无效！禁止查询", false, null);
                return result;
            }

            //必须要有当前经理的id和名称
            Teacher tea = new Teacher();
            tea.setTid(tid);


            Map<String,Object> data = dataAnalysisService.getNeiSixMonthUser();
            result.put("code",700);
            result.put("msg","查询成功！");
            result.put("success",true);
            result.put("data",data);
            result.put("title","近6个月的入职员工人数");
            result.put("count",data.size());
            return result.getMap();
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }
    }







    /* *
     * 获取cookies里的key的值
     * @param cookies
     * @param key
     * @return
     */
    private String getCookieValue(Cookie[] cookies , String key) {
        if (null != cookies && cookies.length > 0){
            for (Cookie co : cookies){
                if (co.getName().equals(key) ){
                    try {
                        return  URLDecoder.decode(co.getValue(),"utf-8");

                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }
    
}
