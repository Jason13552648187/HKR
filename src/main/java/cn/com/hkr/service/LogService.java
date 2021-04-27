package cn.com.hkr.service;

import cn.com.hkr.dao.LogDao;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class LogService {
 
    @Autowired
    public LogDao logDao;

    public List<Log> getAll(){
        return logDao.getAll();
    }
}
