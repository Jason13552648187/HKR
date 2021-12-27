package cn.com.hkr.filter;

import cn.com.hkr.bean.AjaxResult;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/17-16:39
 */
public class LoginFilter  implements Filter{
    private static Map token_maps = new HashMap();
    private static ArrayList filelist ;
    private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String path = ((HttpServletRequest) request).getContextPath();
        System.out.println(url);
        System.out.println(uri);
        System.out.println(path);


        String uycs = (String) request1.getSession().getAttribute("uycs");
        //不是访问登陆，也不是静态资源，判断是否已经登录状态
        Cookie[] cookies = request1.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (null != cookie.getName() && cookie.getName().equals("uycs")){
                    if (null != cookie.getValue()){
                        //这里把用户的token反解密，与用户的secret对比
                        System.out.println("cookie:" + cookie.getValue());
                        chain.doFilter(request,response);
                        return;
                    }
                }
            }
            response1.sendRedirect("/HKR");
        }


        if(null !=  uycs && !uycs.equals("")){
            System.out.println("授权uycs存在，允许通过：" + uycs);
            chain.doFilter(request,response);
            return;
        }
        System.out.println("----------------------" + uycs);

        if (uri.endsWith(".html") || uri.endsWith(".css") ||  uri.endsWith(".js") || uri.endsWith(".jpg")
            || uri.endsWith(".png") || uri.endsWith(".mp3") || uri.endsWith(".mp4") ||  uri.endsWith("login")
            || uri.endsWith(".jsp") || uri.endsWith(".json")){
            System.out.println("访问首页面和静态文件！系统允许！");
            chain.doFilter(request,response);
            return;
        }


        //否则就是没有登录的非法访问
        System.out.println("访问系统权限数据！未授权！禁止访问！Access denied!");
        //未登陆的，则返回登陆

        response1.sendRedirect("/HKR");
        return;


    }

    @Override
    public void destroy() {

    }
}
