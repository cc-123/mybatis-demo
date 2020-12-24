package com.cc.mybatisdemo.service;

import com.cc.mybatisdemo.pojo.Student;

public interface StudentService {
    /**
     * 新增数据
     * @param student
     */
    void save(Student student);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 更新数据
     * @param student
     */
    void updateByStudent(Student student);

    /**
     * 根据id删除数据
     * @param id
     */
    void deleteById(Integer id);
}
