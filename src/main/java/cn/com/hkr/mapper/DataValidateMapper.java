package cn.com.hkr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/5-16:59
 */
@Mapper
public interface DataValidateMapper {

    public List<Map> findAllUser();

    public void updateUserSex(@Param("uid")String  uid,@Param("sex") String sex);

    public void updateAge(@Param("uid")String uid,@Param("age") Integer age);

    public void updateBirthday(@Param("uid")String uid,@Param("birthday") String birthday);

    public Map findByIdcard(@Param("idcard") String idcard);

    public void addFinishUser(Map map);

    public void deleteAlldata();

    public List<Map> findAllFinishUser();

}
