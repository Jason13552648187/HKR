package cn.com.hkr.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2022/2/8-16:43
 */
@Mapper
public interface SourceMapper {


    public List<Map> selectSource(Map map);

    public void addSource(Map map);

    public void addUserSource(Map map);
}
