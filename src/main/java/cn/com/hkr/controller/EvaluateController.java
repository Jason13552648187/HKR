package cn.com.hkr.controller;

import cn.com.hkr.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jason
 * @date 2020/9/20-9:43
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController extends BaseController {
    @Autowired
    private EvaluateService evaluateService;

    @RequestMapping("/getAllEvalute")
    @ResponseBody
    public  Object getAllEvalute(){
      /*  List<Evaluate> list = evaluateService.getAllEvaluate();

        result.put("code","700");
        result.put("msg","查询成功！");
        result.put("success",true);
        result.put("data",list);
*/
        return null;

    }


}
