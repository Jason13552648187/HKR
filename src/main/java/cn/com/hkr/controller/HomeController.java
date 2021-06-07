package cn.com.hkr.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author jason
 * @date 2021/1/24-20:02
 */
@Controller
public class HomeController extends BaseController {

    public static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping({"/index","/"})
    public String index(){
        logger.debug("--------------------------------访问了首页面!----------------------------------");
        return "user/index";
    }
}
