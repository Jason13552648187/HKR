package cn.com.hkr.controller;

import cn.com.hkr.bean.*;
import cn.com.hkr.exception.ParamException;
import cn.com.hkr.service.*;
import cn.com.hkr.staticmsg.UserResult;
import cn.com.hkr.utils.JwtUtils;
import cn.com.hkr.utils.StaticUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jason
 * @date 2020/9/18-15:06
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService  teacherService;

    @Autowired
    private LogService logService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private EvaluateService evaluateService;

    /*
    * 所有程序入口
    * */
    @RequestMapping({"/","index"})
    public String index(HttpServletRequest request, HttpSession session)
            throws UnsupportedEncodingException {

        Cookie[] cookies = request.getCookies();
        Map map = getCookieValue(cookies, "uid");
        if (null != map && map.get("uid") != null){
            System.out.println("uid" + "******************************" + map.get("uid"));
        }else{
            System.out.println(new Date() + "\tCookie里面空空如也！！！！！！！");
        }

        return "index";
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


    /*
     * 获取cookies里的key的值
     * @param cookies
     * @param key
     * @return
    */
    private Map<String,String> getCookieValue(Cookie[] cookies , String key) {
        if (null != cookies && cookies.length > 0){
            Map<String,String> map = new HashMap();
            for (Cookie co : cookies){
                if (co.getName().equals(key)){
                    try {
                        map.put(key,URLDecoder.decode(co.getValue(),"utf-8"));
                        return map;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取用户状态
     * @param user
     * @return*/

    private AjaxResult getStatusResult(User user){
        String gradu = user.getGraduation();
        if (gradu.equals(UserResult.ACTIVE_STATUS_MSG)){
            result.put("code",UserResult.ERROR_CODE);
            result.put("msg",UserResult.ACTIVE_STATUS_MSG);
            result.put("success",false);
            result.put("data",null);
        }else if (gradu.equals(UserResult.GRADUATED_STATUS_MSG)){
            result.put("code",UserResult.ERROR_CODE);
            result.put("msg",UserResult.GRADUATED_STATUS_MSG);
            result.put("success",false);
            result.put("data",null);
        }else if (gradu.equals(UserResult.GRADUATED_BACK_STATUS_MSG)){
            result.put("code",UserResult.ERROR_CODE);
            result.put("msg",UserResult.GRADUATED_BACK_STATUS_MSG);
            result.put("success",false);
            result.put("data",null);
        }
        return result;
    }


   /* *
     * 添加cookie
     * @param response
     * @param key
     * @param value*/

    private void addCookies(HttpServletResponse response, String key, String value){
        try {
            response.addCookie(new Cookie(key, URLEncoder.encode(value,"utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        List list = userService.findAll();
        result.put("code",UserResult.SUCCESS_CODE);
        result.put("msg",UserResult.SUCCESS_MSG);
        result.put("success",true);
        result.put("count",list.size());
        result.put("data",list);

        return result.getMap();
    }


    /*注册操作*//*
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

        Map<String,Object> res = userService.register(user,base_path);
        if (!(boolean)res.get("success")) {
            result = new AjaxResult(706,(String) res.get("msg"),false);

            return result;
        }
        result = new AjaxResult(760, "注册成功!", true, null);
        return result;
    }


    *//*
    * 登陆成功
    * *//*
    @RequestMapping(value="/main")
    public String loginSuccess(){
        System.out.println("登陆成功了！");
        return  "forward:/jsps/user/main.jsp";
    }*/

/*
    */
/*登陆操作*//*

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(@RequestBody Map<String,String> map,
                        HttpServletRequest request, HttpServletResponse response){

        //公司内部员工登陆
        System.out.println("------------------" + map);
        String mapString = JSON.toJSONString(map);
        final User user = JSON.parseObject(mapString, User.class);
        UserWorkHistory userWorkHistory = JSON.parseObject(mapString,UserWorkHistory.class);


        System.out.println("------------------" + user);
        System.out.println("------------------" + userWorkHistory);
        if (null ==  user){
            result = new AjaxResult(780,"登陆信息不能为空!",false);
            return result;
        }

        if (null != user.getUserInfo().getEmail() && !check_email(user.getUserInfo().getEmail())){
            result = new AjaxResult(785,"邮箱不能为空或者邮箱格式错误!",false);
            return result;
        }

        if (null == user.getPassword() && user.getPassword().trim().equals("")){
            result = new AjaxResult(786,"密码不能为空!",false,null);
            return result;
        }

        Map<String,Object> res = userService.login(user);
        if (res.get("success").equals(false)){
            result = new AjaxResult((Integer) res.get("code"),(String)res.get("msg"),false,null);
            return result;
        }
        result = new AjaxResult(784,"登陆成功!",true,res.get("data"));
        addCookies(response,"uycs","asd4f8asf10asd9f81asf08asf");
        return result;

    }
*/


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
        session.invalidate();

        return "redirect:index";
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
    public Object commonSelect(@RequestBody Map<String,String> map,HttpServletRequest request,
                               HttpServletResponse response){
        String ustring = JSON.toJSONString(map);
        User user = JSON.parseObject(ustring, User.class);
        UserEducation userEducation = JSON.parseObject(ustring, UserEducation.class);
        UserWorkHistory userWorkHistory = JSON.parseObject(ustring, UserWorkHistory.class);

        if (null == user || null == userEducation || null == userWorkHistory )
        {
            result = new AjaxResult(813,"查询入参不能为空!",false,null);
            return result;
        }
        List<Map> lists = userService.commonSelectMap(map);

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

    @RequestMapping("/domain")
    @ResponseBody
    public Object domainTest(){
        throw new ParamException("参数错误！");
    }

    @RequestMapping("/domainOther")
    @ResponseBody
    public Object domainOther(){
        throw new RuntimeException("运行参数错误！");
    }


}
