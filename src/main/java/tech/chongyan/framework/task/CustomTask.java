package tech.chongyan.framework.task;

import org.springframework.stereotype.Component;
import tech.chongyan.common.utils.StringUtils;

/**
 * 定时任务调度测试
 *
 * @author maj
 */
@Component("customTask")
public class CustomTask {
    public void multipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void params(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void noParams() {
        System.out.println("执行无参方法");
    }
}
