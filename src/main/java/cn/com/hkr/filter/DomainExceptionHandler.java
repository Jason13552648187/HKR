package cn.com.hkr.filter;

import cn.com.hkr.exception.ParamException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jason
 * @date 2021/8/24-14:16
 *
 * 全局异常处理器
 * 用于将全局异常信息捕捉并返回json数据。
 * 使用@Component这个注解将全局异常处理注册到系统里，用来捕捉全局异常信息。
 */
@Component
public class DomainExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();

        MappingJackson2JsonView view = new MappingJackson2JsonView();

        if(ex instanceof ParamException){
            mv.addObject("code",7600);
            mv.addObject("msg",ex.getMessage());
            mv.addObject("success",false);
            mv.addObject("data",null);
            mv.setView(view);
            return mv;
        }

        mv.addObject("code",7610);
        mv.addObject("msg",ex.getMessage());
        mv.addObject("success",false);
        mv.addObject("data",null);
        mv.setView(view);
        return mv;

    }
}
