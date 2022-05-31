package cn.com.hkr.service;

import cn.com.hkr.mapper.CompactMapper;
import cn.com.hkr.mapper.DataAnalysisMapper;
import com.sun.javafx.fxml.expression.KeyPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jason
 * @date 2020/10/26-16:10
 */
@Service
public class DataAnalysisService extends BaseService{

    @Autowired
    private DataAnalysisMapper dataAnalysisMapper;

    /**
     * 获取今天是这个月的第几周
     * @return
     */
    private  static int getWeek(){
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 统计近6个月的每个月的入职人员数据
     * @return
     */
    public Map<String,Object> getNeiSixMonthUser(){
        List<Map<String, Object>> neiSixMonthUser = dataAnalysisMapper.getNeiSixMonthUser();

        Map<String,Object> datas =  new HashMap<>();
        List<String> xais =  new ArrayList<>();;
        List<Long> yais = new ArrayList<>();
        for(Map map :  neiSixMonthUser){
            xais.add(ym.format(map.get("dt")));
            yais.add((Long) map.get("nums"));
        }
        datas.put("ydata",yais);
        datas.put("xdata",xais);

        return datas;


    }

    /**
     * 获取近7天的人员数据
     * @return
     */
    public List<Map<String,Object>> getUserNeiSevenDay(){
        return dataAnalysisMapper.getUserNeiSevenDay();
    }


    /**
     * 获取上个月的用户数据
     * @return
     */
    public List<Map<String,Object>> getLastMonthData(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);

        int month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),month);

        return getUserData(ymd_start.format(calendar.getTime()),
                ymd.format(calendar.getTime()));
    }

    /**
     * 统计本月每个星期的入职人数
     * @return
     */
    private List<Map<String,Object>> getUserData(String startdate,String eddate){

        query.clear();
        query.put("startdate",startdate);
        query.put("eddate",eddate);
        List<Map<String,Object>> maps = dataAnalysisMapper.getDataByDate(query);

        return maps;
    }


    /**
     * 查询各个阶段的薪资情况
     * @return
     */
    public List<Map> countSalaryDetail() {

        List<Map> maps = dataAnalysisMapper.countSalaryNumbers();
        return maps;


    }
}
