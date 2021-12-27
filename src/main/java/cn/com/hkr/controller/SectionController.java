package cn.com.hkr.controller;

import cn.com.hkr.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jason
 * @date 2021/12/20-20:54
 */
@Controller
@RequestMapping("/sec")
public class SectionController extends  BaseController{

    @Autowired
    private SectionService sectionService;


















}
