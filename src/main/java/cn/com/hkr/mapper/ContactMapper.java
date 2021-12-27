package cn.com.hkr.mapper;

import cn.com.hkr.bean.UserContact;
import cn.com.hkr.bean.UserEducation;
import cn.com.hkr.bean.UserWorkHistory;

import java.util.List;

/**
 * @author jason
 * @date 2021/12/12-20:17
 */
public interface ContactMapper {

    public void add(UserContact userContact);

    public void updateData(UserContact userContact);

}
