package com.cc.mybatisdemo.service.base.impl;

import com.cc.mybatisdemo.mapper.base.StudentMapper;
import com.cc.mybatisdemo.pojo.base.Student;
import com.cc.mybatisdemo.service.base.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public void save(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Transactional
    @Override
    public void updateByStudent(Student student) {
        studentMapper.updateByStudent(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public List<Student> selectAllData() {
        return studentMapper.selectAllData();
    }
}
