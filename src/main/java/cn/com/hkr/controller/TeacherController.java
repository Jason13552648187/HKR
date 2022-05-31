package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.Evaluate;
import cn.com.hkr.bean.Teacher;
import cn.com.hkr.bean.User;
import cn.com.hkr.service.*;
import cn.com.hkr.staticmsg.UserResult;
import cn.com.hkr.utils.JwtUtils;
import cn.com.hkr.utils.StaticUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/10/22-20:08
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService  teacherService;

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private DataValidateService dataValidateService;

    @Autowired
    private DataAnalysisService dataAnalysisService;

    /*
     * 所有程序入口
     * */
    @RequestMapping({"/","index"})
    public String index(HttpServletRequest request, HttpSession session)
            throws UnsupportedEncodingException {

        return "index";
    }

    @RequestMapping("/null")
    @ResponseBody
    public Object getNull() throws InterruptedException {
        Thread.sleep(1000);
        result = new AjaxResult(460,"你好",false,null);
        return result;
    }

    /**
     * 是否是手机
     * @param phone
     * @return
     */
    private boolean isPhone(String phone){
        String regex = "^1[345789]\\d{9}$";
        if (null == phone) return false;
        if (phone.matches(regex)) return true;
        else return false;
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
                if (co.getName().equals(key)){
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




    /* *
     * 添加cookie
     * @param response
     * @param key
     * @param value
     * */
    private void addCookies(HttpServletResponse response, String key, String value){
        try {
            response.addCookie(new Cookie(key, URLEncoder.encode(value,"utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void addCookies(HttpServletResponse response, Cookie cookie){
        response.addCookie(cookie);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        Object list = teacherService.findAll();
        result.put("code",UserResult.SUCCESS_CODE);
        result.put("msg",UserResult.SUCCESS_MSG);
        result.put("success",true);
        result.put("data",list);

        return result.getMap();
    }


    /*注册操作
    @RequestMapping("/register")
    @ResponseBody
    public Object register(@RequestBody User user,HttpServletRequest request){

        if (null ==  user){
            result = new AjaxResult(780,"注册信息不能为空!",false,null);
            return result;
        }

        if (!check_email(user.getUserInfo().getEmail())){
            result = new AjaxResult(705,"邮箱不能空或者格式错误!",false);
            return result;
        }else if (!check_phone(user.getUserInfo().getPhoneNumber())){
            result = new AjaxResult(705,"手机号不能空或者格式错误!",false);
            return result;
        }

        String base_path = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        Map<String,Object> res = teacherService.register(user,base_path);
        if (!(boolean)res.get("success")) {
            result = new AjaxResult(706,(String) res.get("msg"),false);

            return result;
        }
        result = new AjaxResult(760, "注册成功!", true, null);
        return result;
    }*/


    /*
     * 登陆成功
     * */
    @RequestMapping(value="/main")
    public String loginSuccess(HttpServletRequest request,HttpServletResponse response){

        request.getSession().setAttribute("uycs",StaticUtils.getMD5String("success"));

        return  "forward:/jsps/user/main.jsp";
    }

    /*登陆操作*/
    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(@RequestBody Map<String,String> map,
                        HttpServletRequest request, HttpServletResponse response){

        //公司内部员工登陆
        System.out.println("------------------" + map);
        String mapString = JSON.toJSONString(map);
        final Teacher teacher = JSON.parseObject(mapString, Teacher.class);

        System.out.println("------------------" + teacher);

        if (null != teacher.getEmail() && !check_email(teacher.getEmail())){
            result = new AjaxResult(785,"邮箱不能为空或者邮箱格式错误!",false);
            return result;
        }

        if (null == teacher.getPassword() && teacher.getPassword().trim().equals("")){
            result = new AjaxResult(786,"密码不能为空!",false,null);
            return result;
        }

        //参数必填项校验
        Map<String,Object> res = teacherService.login(teacher);
        if (res.get("success").equals(false)){
            result = new AjaxResult((Integer) res.get("code"),(String)res.get("msg"),false,null);
            return result;
        }
        Teacher tea = (Teacher) res.get("data");
        result = new AjaxResult(784,"登陆成功!",true,tea);
        Cookie cookie  = new Cookie("uycs", JwtUtils.getToken(map,"asdfasdf"));

        cookie.setPath("/");

        HashMap tdata = new HashMap();
        tdata.put("loginname",tea.getLoginname());
        tdata.put("tid",tea.getTid());
        System.out.println(tdata + "---------------------------");
        Cookie cooks = new Cookie("adminmanager",JwtUtils.getToken(tdata,tea.getTid()));

        cooks.setPath("/");

        addCookies(response,cookie);
        addCookies(response,cooks);
        addCookies(response,"username",tea.getTeacherName());

        //保存角色编号
        request.getSession().setAttribute("triod",tea.getRole_id());



        return result;

    }


    /*
     * 退出
     * */
    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //session移除属性
        session.removeAttribute("loginname");
        session.removeAttribute("uid");
        session.removeAttribute("username");
        Cookie uid = new Cookie("uid",null);
        Cookie username = new Cookie("username",null);
        uid.setMaxAge(-1);
        username.setMaxAge(-1);

        response.addCookie(uid);
        response.addCookie(username);
        response.addCookie(new Cookie("hello",null));
        Cookie coos  = new Cookie("uycs",null);
        coos.setMaxAge(0);
        response.addCookie(coos);
        session.invalidate();

        return "redirect:/";
    }


    /*
     * 提价今日评价
     * */
    @RequestMapping("/submitEvaluate")
    @ResponseBody
    public Object submitEvaluate(Evaluate evaluate, String username, String uid){

        if (null == uid ||  uid.trim().length() == 0){
            result.put("code",705);
            result.put("msg","UID is not exists！");
            result.put("data",null);
            result.put("success",false);
            return result.getMap();
        }
        evaluateService.addEvaluate(evaluate);

        result.put("code",700);
        result.put("msg","提交成功!");
        result.put("data",null);
        result.put("success",true);

        return result.getMap();
    }



    /*邮箱校验*/
    private static Boolean check_email(String email){
        String reg = "^\\w+@\\w+\\.[a-zA-Z]{2,4}$";
        return email.matches(reg);
    }

    /*手机号校验*/
    private static Boolean check_phone(String phone){
        String reg = "^1[3-9]{1}\\d{9}$";
        return phone.matches(reg);
    }

    /*
     * 公共通用查询
     * */
    @RequestMapping("/commonSelect")
    @ResponseBody
    public Object commonSelect(@RequestBody User user){
        if (null == user)
        {
            result = new AjaxResult(813,"查询入参不能为空!",false,null);
            return result;
        }
        List<HashMap> lists = userService.commonSelect(user);

        if (lists != null){
            result.put("code",875);
            result.put("msg","查询成功!");
            result.put("data",lists);
            result.put("total",lists.size());
            result.put("success",true);
            return result.getMap();
        }
        return result;
    }


    /*
     * 公共通用查询
     * */
    @RequestMapping("/ucommonSelect")
    @ResponseBody
    public Object commonSelect(@RequestBody Map<String,String> map,HttpServletRequest request,
                               HttpServletResponse response){

        String token = getCookieValue(request.getCookies(), "adminmanager");

        if (null == token || token.equals("")){
            return new AjaxResult(816,"访问数据过期！",false,null);
        }

        //否则就是正常token
        String tid = JwtUtils.getData(token, "tid");
        String loginname = JwtUtils.getData(token, "loginname");



        if (null == tid || null == loginname){
            result =  new AjaxResult(814,"token无效！禁止查询",false,null);
            return result;
        }


        Teacher tea = new Teacher();
        tea.setTid(tid);


        List<Map> lists = teacherService.commonSelectUserMap(map,tea);

        if (lists != null){
            result.put("code",875);
            result.put("msg","查询成功!");
            result.put("data",lists);
            result.put("total",lists.size());
            result.put("success",true);
            return result.getMap();
        }
        return result;
    }


    /*发送邮件*/
    @RequestMapping("/sendMail")
    @ResponseBody
    public Object sendMail(@RequestBody User user,HttpSession session){
        try {
            if (null == user || user.getUserInfo().getEmail().equals("")) return new AjaxResult(889,"邮箱不能为空!",true,null);
            String code = userService.sendVerifyEmail(user.getUserInfo().getEmail());
            //把验证码保存到session里,将验证码和邮箱用md5加密后放入session区域内
            session.setAttribute("v_code", StaticUtils.getMD5Data(code));
            session.setAttribute("digest_mail",StaticUtils.getMD5Data(user.getUserInfo().getEmail()));
            session.setMaxInactiveInterval(0);
            result = new AjaxResult(880, "发送邮件成功!", true, null);
            return result;
        }catch (Exception e){
            result = new AjaxResult(881, "邮件发送失败！" + e.getMessage(), false, null);
            e.printStackTrace();
            return result;
        }
    }



    /*用户修改密码*/
    @RequestMapping("/modifyPasswd")
    @ResponseBody
    public Object modifyPasswd(@RequestBody User user,HttpSession session,String vcode){

        System.out.println(user + "---------------" + vcode);

        //判断session的邮箱和验证码是否是这个邮箱和验证码
        Object sess_mail = session.getAttribute("digest_mail");
        Object sess_code = session.getAttribute("v_code");

        if (null == sess_mail || null == sess_code){
            result = new AjaxResult(910,"您还未发送验证码！",false,null);
            return result;
        }else if (!new String(StaticUtils.getMD5Data(vcode)).equals(new String((byte[])sess_code))){
            result = new AjaxResult(911,"验证码错误！",false,null);
            return result;
        }else{
            //正常修改密码
            Boolean flag = userService.modifyPassword(user.getUserInfo().getEmail(), user.getPassword());
            if (flag){
                result = new AjaxResult(912,"修改成功！",true,null);
                return result;
            }
            result = new AjaxResult(913,"修改失败！",false,null);
            return result;
        }
    }

    /*用户激活功能*/
    @RequestMapping("/active")
    @ResponseBody
    public Object active(@Param("acid") String acid){
        //接受校验码
        if (null == acid || acid.trim().equals(""))
        {
            result = new AjaxResult(922,"激活连接无效!",false,null);
            return result;
        }

        //核对是否已经激活，防止二次激活
        //检查改用户是否已经激活完成
        Map acResult = userService.active(acid);
        System.out.println(acResult);

        //正常激活
        return new AjaxResult((Integer) acResult.get("code"), (String) acResult.get("msg"), (Boolean) acResult.get("success"),null);

    }

    @RequestMapping("/addStaff")
    @ResponseBody
    public Object addStaff(@RequestBody HashMap map,HttpServletRequest request,HttpServletResponse response){
        System.out.println(map);


        //必填项校验阶段


        //必须要进行的校验


        //添加员工信息阶段
        Map map1 = teacherService.addStaff(map);
        return map1;

    }



    @RequestMapping("/findData")
    @ResponseBody
    public Object findData(@RequestBody Map map,HttpServletRequest request,HttpServletResponse response){
        List<Map> map1 = null;
        try {
            String token = getCookieValue(request.getCookies(), "adminmanager");

            if (null == token || token.equals("")){
                return new AjaxResult(816,"访问数据过期！",false,null);
            }

            //否则就是正常token
            String tid = JwtUtils.getData(token, "tid");
            String loginname = JwtUtils.getData(token, "loginname");



            if (null == tid || null == loginname){
                result =  new AjaxResult(814,"token无效！禁止查询",false,null);
                return result;
            }


            Teacher tea = new Teacher();
            tea.setTid(tid);



            map1 = teacherService.findDataByUser(map,tea);
            return new AjaxResult(700,"查询成功",true,map1);
        } catch (Exception e) {
            return new AjaxResult(789,"查询失败！",e.getMessage());
        }
    }


    @RequestMapping("/updateStaff")
    @ResponseBody
    public Object updateStaff(@RequestBody Map  map){

        List<HashMap> map1 = null;
        try {
            map1 = teacherService.updateStaff(map);
            return new AjaxResult(700,"更新成功",true,map1);
        } catch (Exception e) {
            return new AjaxResult(789,"更新失败，请稍后重试！",null);
        }
    }


   /* *//**
     * 查询用户每个阶段的详情
     * @param map
     * @param request
     * @return
     *//*
    @RequestMapping("/fsectionDetail")
    @ResponseBody
    public Object findUserSectionDetail(@RequestBody Map map,HttpServletRequest request) {
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


            Teacher tea = new Teacher();
            tea.setTid(tid);

            List<Map> map2 = teacherService.findUserSectionDetailByUid(map, tea);
            return new AjaxResult(700, "查询成功", true, map2);
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }
    }
*/

    @RequestMapping("/findUserAllSec")
    @ResponseBody
    public Object findUserCurrentSection(@RequestBody Map map,HttpServletRequest request){
        
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


            Teacher tea = new Teacher();
            tea.setTid(tid);

            Map map2 = teacherService.findUserAllSec(map,tea);
            return new AjaxResult(700, "查询成功", true, map2);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }

    }






    @RequestMapping("/findUserProcess")
    @ResponseBody
    public Object findUserProcess(@RequestBody Map map,HttpServletRequest request){
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


            Teacher tea = new Teacher();
            tea.setTid(tid);

            Map map2 = teacherService.findUserProcessByUid(map);
            request.getSession().setAttribute("uid",map.get("uid"));
            return new AjaxResult(700, "查询成功", true, map2);
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }

    }



    @RequestMapping("/findUserEndtime")
    @ResponseBody
    public Object findUserEndtime(@RequestBody Map map,HttpServletRequest request){
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


//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            Map map2 = teacherService.findUserEndtime(map);
            return new AjaxResult(700, "查询成功", true, map2);
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }

    }


    /**
     * 修改目前用户的目前阶段的进度
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateProcess")
    @ResponseBody
    public Object updateProcess(@RequestBody Map map,HttpServletRequest request){

        //{"uid":"","od":2}
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

//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            teacherService.updateProcess(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }



    /**
     * 修改目前用户的目前阶段的开始和结束时间
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateProcessStartAndEnd")
    @ResponseBody
    public Object updateProcessStartAndEnd(@RequestBody Map map,HttpServletRequest request){

        //{"uid":"","od":2,startdate:'',enddate:""}
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

//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            teacherService.updateProcessStartAndEnd(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }





    /**
     * 修改项目的起始时间
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateStartTime")
    @ResponseBody
    public Object updateStartTime(@RequestBody Map map,HttpServletRequest request){

        //{"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","status":"第二阶段"}
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

//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            teacherService.updateStartTime(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }


    /**
     * 修改项目的结束时间
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateEndTime")
    @ResponseBody
    public Object updateEndTime(@RequestBody Map map,HttpServletRequest request){

        //{"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","status":"第二阶段"}
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

//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            teacherService.updateEndTime(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }


    /**
     * 修改项目的请假时间
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateLevalDays")
    @ResponseBody
    public Object updateLevalDays(@RequestBody Map map,HttpServletRequest request){

        //{"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","status":"第二阶段"}
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

//            Teacher tea = new Teacher();
//            tea.setTid(tid);

            teacherService.updateUserLevalDays(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }


    /**
     * 修改项目的毕业状态
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/updateGradution")
    @ResponseBody
    public Object updateGradution(@RequestBody Map map,HttpServletRequest request){

        //{"enddate":"2021-12-23","leavedays":"23","graduation":"已就业","uid":"3feb51be3eb44507b2d78f31796139e4","status":"第二阶段"}
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

            teacherService.updateUserGraduation(map);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }
    }



    @RequestMapping("/addSecDetail")
    @ResponseBody
    public Object addSecDetail(@RequestBody Map map,HttpServletRequest request){

        //{"secname":"第二阶段","uid":"3feb51be3eb44507b2d78f31796139e4","evaluate":"还可以"}
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

            teacherService.addSecDetail(map,tea);



            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }

    @RequestMapping("/addSectionRebel")
    @ResponseBody
    public Object addSectionRebel(@RequestBody Map map,HttpServletRequest request){

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

            teacherService.addSectionRebel(map,tea);
            return new AjaxResult(700, "修改成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(789, "修改失败！", e.getMessage());
        }

    }


    @RequestMapping("/validateAll")
    @ResponseBody
    public Object validateAll(){
        try {
            List<Map> maps = dataValidateService.startValidateAll();
            result.put("code",700);
            result.put("msg","处理成功！");
            result.put("success",true);
            result.put("data",maps);
            result.put("illgea",maps.size());
            return result.getMap();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(995, "修改失败", false);
        }
    }





    @RequestMapping("/findAllFinish")
    @ResponseBody
    public Object findAllFinish(HttpServletRequest request){

        //{"secname":"第二阶段","uid":"3feb51be3eb44507b2d78f31796139e4","evaluate":"还可以"}
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

            List<Map> users =  dataValidateService.findAllFinish(tea);



            return new AjaxResult(720, "查询成功", true, users);
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }

    }


    /**
     *  仅仅就是上传已经入场的人员数据
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFinishUser",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFinishUser(@RequestParam("file")  CommonsMultipartFile file,HttpServletRequest request){

        try {

            DiskFileItem fileItem = (DiskFileItem) file.getFileItem();
            InputStream inputStream = fileItem.getInputStream();
            byte[] bytes = new byte[1024];

            String path = request.getSession().getServletContext().getRealPath("/");

            System.out.println("系统运行路径：---" + path);

            //创建系统保存路径，如果没有files文件夹，自动创建，有则直接使用。
            String fileName = path  + "files";
            File finishFile = new File(fileName);
            if(!finishFile.exists()){
                finishFile.mkdirs();
            }




            fileName = fileName + File.separator + StaticUtils.getUUID() + ".xlsx";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            int temp;
            while ((temp = inputStream.read(bytes))!= -1){
                outputStream.write(bytes,0,temp);
            }

            outputStream.flush();
            inputStream.close();
            outputStream.close();


            //调用service层完成数据存入
            dataValidateService.importFinishData(fileName);

            return new AjaxResult(750,"成功",true,fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(755,e.getStackTrace().toString(),true,null);
        }

    }


    /**
     * 查询各个阶段的薪资情况
     * @param request
     * @return
     */
    @RequestMapping(value = "/countSalaryDetail",method = RequestMethod.POST)
    @ResponseBody
    public Object countSalaryDetail(HttpServletRequest request){

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

            List<Map> users =  dataAnalysisService.countSalaryDetail();

            return new AjaxResult(720, "查询成功", true, users);
        } catch (Exception e) {
            return new AjaxResult(789, "查询失败！", e.getMessage());
        }

    }









}
