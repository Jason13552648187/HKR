package cn.com.hkr.service;

import cn.com.hkr.bean.Teacher;
import cn.com.hkr.mapper.LogMapper;
import cn.com.hkr.mapper.SectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/6/6-1:23
 */
@Service
public class SectionService extends  BaseService{

    @Autowired
    private SectionMapper sectionMapper;


    /**
     * 通过uid得知用户项目进度
     * @return
     */
    public Map getUserProcessByUid(Map map){
        return sectionMapper.getUserProcess(map);
    }


    /**
     * 通过uid和sid查询阶段的详细情况
     * @param uid
     * @param sid
     * @return
     */
    public List<Map> selectSectionDetailByuidAndsid(String uid ,String sid){
        if (null == uid || null == sid)return null;

        List<Map> maps = sectionMapper.selectSectionDetailByuidAndsid(uid, sid);

        return maps;

    }


    /**
     * 通过uid和sid来查询用户的当前阶段的违规情况
     * @param uid  用户编号
     * @param sid  用户阶段编号
     * @return
     */
    public List<Map> selectSectionRebelByuidAndsid(String uid,String sid){
        if (null ==  uid || null == sid) return null;

        return sectionMapper.selectSectionRebelByuidAndsid(uid,sid);
    }






}
