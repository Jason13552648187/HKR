package cn.com.hkr.test;

import java.util.Calendar;

import static cn.com.hkr.service.BaseService.ymd;
import static cn.com.hkr.service.BaseService.ymd_start;

/**
 * @author jason
 * @date 2022/3/12-10:25
 */
public class UpdateData {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-2);

        int month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),month);
        
        System.out.println(ymd_start.format(calendar.getTime()));
        System.out.println(ymd.format(calendar.getTime()));





    }






}
