package cn.com.hkr.mapper;
import cn.com.hkr.bean.UserWorkHistory;

import java.util.List;

/**
 * @author jason
 * @date 2021/12/12-20:17
 */
public interface WorkHistoryMapper {

    public void add(UserWorkHistory userWorkHistory);

    public void updateData(UserWorkHistory userWorkHistory);


}
