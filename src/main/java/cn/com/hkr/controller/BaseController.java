package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import org.apache.log4j.Logger;

/**
 * @author jason
 * @date 2020/9/22-15:01
 */
public class BaseController {
    public static Logger logger = Logger.getLogger(HomeController.class);
    public  AjaxResult result =  new AjaxResult();
}
