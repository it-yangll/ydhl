package com.ydhl.cn.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Girl
 * @Description TODO
 * @Author yangll
 * @Date 2019/9/3 0003 16:27
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "girl")
public class Girl {

    private String name;
    private String cupSize;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
