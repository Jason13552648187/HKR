package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.Evaluate;
import cn.com.hkr.bean.User;
import cn.com.hkr.service.EvaluateService;
import cn.com.hkr.service.LogService;
import cn.com.hkr.service.MenuService;
import cn.com.hkr.service.UserService;
import cn.com.hkr.staticmsg.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
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
    private LogService logService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private EvaluateService evaluateService;

    @RequestMapping({"/"})
    public String index(HttpServletRequest request, HttpSession session)
            throws UnsupportedEncodingException {

        Cookie[] cookies = request.getCookies();
        Map map = getCookieValue(cookies, "uid");
        if (null != map && map.get("uid") != null){
            System.out.println("uid" + "******************************" + map.get("uid"));
        }else{
            System.out.println(new Date() + "\tCookie里面空空如也！！！！！！！");
        }

        return "index_raw";
    }


   /* *
     * 是否是手机
     * @param phone
     * @return
*/
    private boolean isPhone(String phone){
        String regex = "^1[34578]\\d{9}$";
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
        int gradu = user.getGraduation();
        if (gradu == 0){
            result.put("code",UserResult.ERROR_CODE);
            result.put("msg",UserResult.ACTIVE_STATUS_MSG);
            result.put("success",false);
            result.put("data",null);
        }else if (gradu == 2){
            result.put("code",UserResult.ERROR_CODE);
            result.put("msg",UserResult.GRADUATED_STATUS_MSG);
            result.put("success",false);
            result.put("data",null);
        }else if (gradu == 3){
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
        Object list = userService.findAll();
        result.put("code",UserResult.SUCCESS_CODE);
        result.put("msg",UserResult.SUCCESS_MSG);
        result.put("success",true);
        result.put("data",list);

        return result.getMap();
    }


    /*注册操作*/
    @RequestMapping("/register")
    @ResponseBody
    public Object register(@RequestBody User user){
        if (null ==  user){
            result = new AjaxResult(780,"注册信息不能为空!",false,null);
            return result;
        }

        if (!check_email(user.getEmail())){
            result = new AjaxResult(705,"邮箱不能空或者格式错误!",false);
            return result;
        }else if (!check_phone(user.getPhoneNumber())){
            result = new AjaxResult(705,"手机号不能空或者格式错误!",false);
            return result;
        }

        Map<String,Object> res = userService.register(user);
        if (!(boolean)res.get("success")) {
            result = new AjaxResult(706,(String) res.get("msg"),false);

            return result;
        }
        result = new AjaxResult(760, "注册成功!", true, null);
        return result;
    }



    /*登陆操作*/
    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody User user){
        if (null ==  user){
            result = new AjaxResult(780,"登陆信息不能为空!",false);
            return result;
        }

        if (null != user.getEmail() && !check_email(user.getEmail())){
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
        return result;

    }


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

        return "user/index";
    }


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




    @RequestMapping("/active")
    @ResponseBody
    public Object active(){
        return result;
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




}












