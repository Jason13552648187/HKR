package cn.com.hkr.annotation;

import java.lang.annotation.*;

/**
 * @author jason
 * @date 2021/8/5-13:40
 */

@Target(ElementType.METHOD)  //这是一个方法注解
@Retention(RetentionPolicy.RUNTIME)  //运行时可见
@Documented
public @interface LogAnnotation {

    String operationType();  //记录日志的操作类型

}