package cn.com.hkr.mapper;

import cn.com.hkr.bean.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/11-12:00
 */
@Mapper
public interface LogMapper {

    public List<Log> findAll();

    public List<Log> findByProper(Log log);
}
