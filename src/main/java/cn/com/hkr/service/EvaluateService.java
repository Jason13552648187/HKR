package cn.com.hkr.service;

import cn.com.hkr.bean.Evaluate;
import cn.com.hkr.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class EvaluateService {
 
    @Autowired
    private EvaluateMapper evaluateMapper;

    public void addEvaluate(Evaluate evaluate){
        evaluateMapper.addEvaluate(evaluate);
    }


}
