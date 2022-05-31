package cn.com.hkr.bean;

import cn.com.hkr.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jason
 * @date 2022/4/21-11:53
 */

@Component
public class SysLogAspect {
    @Autowired
    private SyslogService syslogService;






}
