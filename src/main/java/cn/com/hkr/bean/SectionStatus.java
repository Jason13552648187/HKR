package cn.com.hkr.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jason
 * @date 2021/12/20-16:35
 */
public class SectionStatus {

    public static final String SECTION_ONE = "第一阶段";
    public static final String SECTION_TWO = "第二阶段";
    public static final String SECTION_THREE = "第三阶段";
    public static final String SECTION_FOUR = "第四阶段";
    public static final String SECTION_FIVE = "第五阶段";
    public static final String SECTION_FINAL = "最后阶段";

    public static List<String> SECTIONS = null;


    static {
        String[] arrs = {SECTION_ONE,SECTION_TWO,SECTION_THREE,SECTION_FOUR,SECTION_FIVE,SECTION_FINAL};
        SECTIONS = Arrays.asList(arrs);

    }

}
