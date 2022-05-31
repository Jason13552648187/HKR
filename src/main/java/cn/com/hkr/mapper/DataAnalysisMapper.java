package cn.com.hkr.mapper;

import cn.com.hkr.bean.Course;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/5-16:59
 */
@Mapper
public interface DataAnalysisMapper {

    public List<Map<String,Object>> getDataByDate(Map map);

    public List<Map<String,Object>> getUserNeiSevenDay();

    public List<Map<String,Object>> getNeiSixMonthUser();

    public List<Map> countSalaryNumbers();


}
