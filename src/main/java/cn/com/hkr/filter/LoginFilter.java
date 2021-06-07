package cn.com.hkr.filter;

import org.apache.poi.hssf.record.ArrayRecord;

import javax.annotation.Resources;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        request = (HttpServletRequest)request;
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String path = ((HttpServletRequest) request).getContextPath();
        System.out.println(url);
        System.out.println(uri);
        System.out.println(path);

        if (null != uri && (uri.endsWith("index")) || filelist.contains(uri.substring(uri.lastIndexOf(".")))){
            System.out.println("访问首页面和静态文件！系统允许！");
            chain.doFilter(request,response);
            return;
        }
        System.out.println("访问系统权限数据！未授权！禁止访问！");
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (null != cookies)
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName() + "=" +  cookie.getValue());
            }
    }

    @Override
    public void destroy() {

    }
}
