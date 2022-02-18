package cn.com.hkr.mapper;

import cn.com.hkr.bean.Menu;
import cn.com.hkr.bean.Train;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jason
 * @date 2021/5/11-12:01
 */
@Mapper
public interface TrainMapper {

    public void addTrain(Train train);

}
