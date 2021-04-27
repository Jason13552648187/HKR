package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.Evaluate;
import cn.com.hkr.bean.Menu;
import cn.com.hkr.bean.User;
import cn.com.hkr.service.LogService;
import cn.com.hkr.service.MenuService;
import cn.com.hkr.service.UserService;
import cn.com.hkr.staticmsg.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Autowired
    private MenuService menuService;

    @RequestMapping({"/",""})
    public String index(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {

        Cookie[] cookies = request.getCookies();
        Map map = getCookieValue(cookies, "uid");
        if (null != map && map.get("uid") != null){
            System.out.println("uid" + "******************************" + map.get("uid"));
        }else{
            System.out.println(new Date() + "\tCookie里面空空如也！！！！！！！");
        }

        return "/view/index";
    }

    @RequestMapping("/UserLogin")
    public Object UserLogin(@RequestParam String loginname,
                              @RequestParam String password,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              HttpSession session,
                              Model model) throws UnsupportedEncodingException {
        ModelAndView modelView = null;

        //username or phoneNumber or password is null or not?
        if (null == loginname || null == password || loginname.trim().length() == 0 || password.trim().length() == 0) {
            result.put("code", UserResult.LOGINNAME_PASSWORD_NULL_CODE);
            result.put("msg", UserResult.USERNAME_NULL_MSG + UserResult.PASSWORD_NULL_MSG);
            result.put("success", false);
            result.put("data", null);
            model.addAllAttributes(result.getMap());
            modelView = new ModelAndView("/view/index");
            return modelView;
        }

        //is  phone or loginname or not?

        if (isPhone(loginname)) {
            User user = userService.getUserByPhoneNumber(loginname);
            if (null != user) {
                // 0：未激活   1：已激活(activeted)   2：已毕业(graduted)   3：已退学(out of gradu)
                int gradu = user.getGraduation();
                //error status
                if (gradu != 1) {
                    result = getStatusResult(user);
                    model.addAllAttributes(result.getMap());
                    modelView = new ModelAndView();
                    return modelView;
                }

                if (user.getPassword().equals(password)) {
                    //login success!
                    modelView = new ModelAndView("/page/user.html");
                    session.setAttribute("loginname", loginname);
                    session.setAttribute("uid", user.getUid());
                    session.setAttribute("username", user.getUsername());
                    addCookies(response, "uid", user.getUid());
                    addCookies(response, "username", user.getUsername());
                    addCookies(response, "classname", user.getClassname());
                    return modelView;
                } else { //password error
                    result.put("code", UserResult.ERROR_CODE);
                    result.put("msg", UserResult.PASSWORD_ERROR_MSG);
                    result.put("success", false);
                    result.put("data", user);
                    model.addAttribute(result.getMap());
                    modelView = new ModelAndView("/view/index");
                    return modelView;
                }
            }
        } else {
            //and this time find  by username from  database! loginname find
            User u = userService.getUserByNameAndPassword(loginname, password);
            if (null != u) {
                int gradu = u.getGraduation();
                if (gradu != 1) {
                    result = getStatusResult(u);
                    model.addAllAttributes(result.getMap());
                    modelView = new ModelAndView("/view/index");
                    return modelView;
                }
                if (u.getPassword().equals(password)) {
                    //login success
                    modelView = new ModelAndView("/page/user.html");
                    session.setAttribute("loginname", loginname);
                    session.setAttribute("uid", u.getUid());
                    session.setAttribute("username", u.getUsername());
                    addCookies(response, "uid", u.getUid());
                    addCookies(response, "username", u.getUsername());
                    addCookies(response, "classname", u.getClassname());
                    return modelView;
                } else {
                    result.put("code", UserResult.ERROR_CODE);
                    result.put("msg", UserResult.PASSWORD_ERROR_MSG);
                    result.put("success", false);
                    result.put("data", u);
                    modelView = new ModelAndView("/view/index");
                    model.addAllAttributes(result.getMap());
                    return modelView;
                }
            } else {
                result.put("code", UserResult.ERROR_CODE);
                result.put("msg", "账户或密码错误！");
                result.put("success", false);
                result.put("data", u);
                modelView = new ModelAndView("/view/index");
                model.addAllAttributes(result.getMap());
                return modelView;
            }
        }
        return null;
    }

    @RequestMapping("/getUserMenu")
    @ResponseBody
    public Object getUserMenu(HttpServletRequest request , HttpServletResponse response){
        List<Menu> menus = menuService.getAllMenu();

        result.put("code",700);
        result.put("msg","查询成功！");
        result.put("success",true);
        result.put("data",menus);

        return result.getMap();
    }

    @RequestMapping("/getLog")
    @ResponseBody
    public Object getLog(){
        return logService.getAll();
    }



    /**
     * 是否是手机
     * @param phone
     * @return
     */
    private boolean isPhone(String phone){
        String regex = "1[34578]\\d{9}$";
        if (null == phone) return false;
        if (phone.matches(regex)) return true;
        else return false;
    }


    /**
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
     * @return
     */
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


    /**
     * 添加cookie
     * @param response
     * @param key
     * @param value
     */
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


    @RequestMapping("/register")
    public Object register(ModelAndView modelAndView){

        modelAndView.setViewName("/view/register.html");

        return modelAndView;
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

        return "/view/index";
    }


    @RequestMapping("/submitEvaluate")
    @ResponseBody
    public Object submitEvaluate(Evaluate evaluate, String username, String uid){

        System.out.println("---------------------" + evaluate);
        System.out.println("---------------------" + username + "------" + uid);

        if (uid != null &&  uid.trim().length() != 0){

        }


        result.put("code",700);
        result.put("msg","提交成功!");
        result.put("data",null);
        result.put("success",true);

        return result.getMap();
    }


}
