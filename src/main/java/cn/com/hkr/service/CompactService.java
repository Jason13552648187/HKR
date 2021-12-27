package cn.com.hkr.service;

import cn.com.hkr.bean.Log;
import cn.com.hkr.mapper.CompactMapper;
import cn.com.hkr.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class CompactService extends BaseService{

    @Autowired
    private CompactMapper compactMapper;

    public List<Map> commonSelect(HashMap map){
        return compactMapper.commonselect(map);
    }




    @Transactional
    public void addCompactStatus(Map map){
        compactMapper.addCompactStatus(map);
    }

}
