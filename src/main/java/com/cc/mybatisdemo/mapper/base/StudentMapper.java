package com.cc.mybatisdemo.mapper.base;

import com.cc.mybatisdemo.pojo.base.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * 新增数据
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 更新数据
     * @param student
     * @return
     */
    int updateByStudent(@Param("student") Student student);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Student selectById(@Param("id") Integer id);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 查询所有学生数据
     * @return
     */
    List<Student> selectAllData();
}
