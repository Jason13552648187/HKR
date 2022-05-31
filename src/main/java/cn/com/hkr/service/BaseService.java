package cn.com.hkr.service;

import cn.com.hkr.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jason
 * @date 2021/6/6-1:23
 */
public class BaseService {

    public Map<String, Object> msg = new HashMap<>();
    public static Map query = new HashMap();
    public static SimpleDateFormat ymd   = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat ymd_start = new SimpleDateFormat("yyyy-MM-01");
    public static SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat year = new SimpleDateFormat("yyyy");
    @Autowired
    public LogMapper logMapper;
}
