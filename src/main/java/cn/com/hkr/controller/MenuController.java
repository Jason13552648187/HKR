package cn.com.hkr.controller;

import cn.com.hkr.bean.AjaxResult;
import cn.com.hkr.bean.Menu;
import cn.com.hkr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/20-12:03
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;
    private Menu menus;


    @RequestMapping("/getMenu")
    @ResponseBody
    public Object findMenu(Menu menu){
        result.put("data",menuService.commonSelect(menu));
        result.put("code",790);
        result.put("msg","查询成功!");
        result.put("success",true);
        return result.getMap();
    }

    @RequestMapping("/add/Menu")
    @ResponseBody
    public Object addMenu(@RequestBody Menu menus){//此步就是将前端的json数据封装到Menu对象中。并且前端发送的时候必须指定的数据类型application/json类型

        try {
            System.out.println("-------------------" + menus);
            result =  new AjaxResult(789,"添加成功！",true,menus);
            return result;

        }catch (Exception e){
            result = new AjaxResult(780,"添加异常，请稍后重试！",null);
            return result;
        }
    }
}

