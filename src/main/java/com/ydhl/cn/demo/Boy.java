package com.ydhl.cn.demo;

import javax.persistence.*;

/**
 * @ClassName Boy
 * @Description TODO
 * @Author yangll
 * @Date 2019/9/4 0004 10:52
 * @Version 1.0
 **/
@Entity
@Table(name = "boy")
@org.hibernate.annotations.Table(appliesTo = "boy",comment = "实体表")
public class Boy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true,columnDefinition = "VARCHAR(200) default null comment '用户名'")
    private String name;

    @Column(nullable = true,columnDefinition = "VARCHAR(100) default null comment '邮箱'")
    private String email;

    @Column(columnDefinition = "int(11) default 0 comment '性别 0:男 1:女'")
    private String sex;

    public Boy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
