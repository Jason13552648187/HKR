package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.User;
import cn.com.hkr.service.UserService;
import cn.com.hkr.staticmsg.UserResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jason
 * @date 2020/10/15-10:51
 */
@Controller
public class UserTestController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUser(Model model, @Param("id") int id){

        try {
            Integer.valueOf(id);
        }catch (Exception e){
            result = new AjaxResult(UserResult.ERROR_CODE,UserResult.DATA_TYPE_MSG,null);
        }

        User user = userService.getUser(Integer.valueOf(id));

        if(user == null){
            result = new AjaxResult(UserResult.ERROR_CODE,UserResult.ERROR_MSG,null);
        }else{
            result = new AjaxResult(UserResult.SUCCESS_CODE,UserResult.SUCCESS_MSG,user);
        }

        model.addAttribute("result",result);
        return "user";
    }

    @RequestMapping("/getUser1")
    public String getUser1(Model model, @Param("id") String id){

        model.addAttribute("name","我是Jason!" + id);

        return  "user";
    }

}
