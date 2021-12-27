package cn.com.hkr.mapper;

import cn.com.hkr.bean.UserInfo;
import cn.com.hkr.bean.UserWorkHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/12/12-20:17
 */
public interface StaffInfoMapper {

    public void add(UserInfo userInfo);

    public List<Map> selectCommon(UserInfo userInfo);

    public void updateData(UserInfo userInfo);


}
