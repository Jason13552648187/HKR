package cn.com.hkr.mapper;

import cn.com.hkr.bean.Compact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/12/12-20:17
 */
@Mapper
public interface CompactMapper {


    public List<Map> commonselect(Map map);


    public void addCompactStatus(Map map);

    public Compact selectBycompact(Map map);

    public void updateCompactStatus(Map map);
}
