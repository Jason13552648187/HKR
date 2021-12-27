package cn.com.hkr.service;

import cn.com.hkr.bean.Log;
import cn.com.hkr.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class LogService extends  BaseService{

    @Autowired
    private LogMapper logMapper;


    /*
    *
    * 添加一个日志记录信息
    * */
    @Transactional
    public void addLog(Log log){
        logMapper.addLog(log);
    }


    /*
    * 查询全部
    * */
    public List<Log> findAll(){
        return logMapper.findAll();
    }


    /*
    * 条件查询数据
    * */
    public List<Log> findByProper(Log log){
        return logMapper.findByProper(log);
    }



}
