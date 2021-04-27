package cn.com.hkr.service;

import cn.com.hkr.bean.Evaluate;
import cn.com.hkr.dao.EvaluateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class EvaluateService {
 
    @Autowired
    public EvaluateDao evaluateDao;

    public List<Evaluate> getAllEvaluate(){

        return evaluateDao.getAllEvaluate();
    }


}
