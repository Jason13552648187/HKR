package cn.com.hkr.mapper;

import cn.com.hkr.bean.Course;
import cn.com.hkr.bean.Section;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/5/5-16:59
 */
@Mapper
public interface SectionMapper {

    public List<Map> selectSectionDetailByuidAndsid(@Param("uid") String uid,@Param("sid") String sid);


    public List<Map> selectSectionRebelByuidAndsid(@Param("uid") String uid,@Param("sid") String sid);

    /**
     * 获取当前uid的用户的进度和所在阶段名称，详细名称，状态编号
     * @param map
     * @return
     */
    public Map getUserProcess(Map map);


    /**
     * 通过uid查询用户所经历的阶段
     * @param uid
     * @return
     */
    public List<Map> getUserAllSidByUid(@Param("uid") String uid);


    /**
     * 阶段表的查询
     * @param map
     * @return
     */
    public List<Section> commonSelectSection(Map map);


    public void addSectionDetail(Map map);

    public void addSectionRebel(Map map);


    public void addUserSection(Map map);

    public Map commonSelectUserSection(Map map);



}
