package com.cc.mybatisdemo.service.impl;

import com.cc.mybatisdemo.mapper.StudentMapper;
import com.cc.mybatisdemo.pojo.Student;
import com.cc.mybatisdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}