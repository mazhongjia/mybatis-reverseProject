package com.demo.mybatis.pojo;

import java.io.Serializable;

public class UserCopy implements Serializable {
    private Integer id1;

    private String name1;

    private Integer age1;

    private static final long serialVersionUID = 1L;

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public Integer getAge1() {
        return age1;
    }

    public void setAge1(Integer age1) {
        this.age1 = age1;
    }
}