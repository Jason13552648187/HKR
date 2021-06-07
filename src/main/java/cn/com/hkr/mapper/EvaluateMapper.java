package cn.com.hkr.mapper;

import cn.com.hkr.bean.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/11-12:00
 */
@Mapper
public interface EvaluateMapper {
    public List<Evaluate> getAllEvaluate();

    public List<Evaluate> findByProperties(Evaluate evaluate);

    public void addEvaluate(Evaluate evaluate);
}
