package cn.com.hkr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jason
 * @date 2021/1/24-20:02
 */

public class HomeController {

    @RequestMapping({"/index","/"})
    @ResponseBody
    public String index(){
        return "index.jsp";
    }
}
