package com.cc.mybatisdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Student", description = "学生表")
public class Student {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", example = "张三", required = true)
    private String name;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
