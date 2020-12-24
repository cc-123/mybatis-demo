package com.cc.mybatisdemo.controller;

import com.cc.mybatisdemo.pojo.Student;
import com.cc.mybatisdemo.service.StudentService;
import com.cc.mybatisdemo.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {
    @Autowired
    private StudentService studentService;

    /**
     * 新增数据
     * @param student
     * @return
     */
    @PostMapping("/save")
    public ApiResult save(@RequestBody Student student) {
        ApiResult apiResult = new ApiResult(true, true);
        try {
            studentService.save(student);
            apiResult.setMessage("新增成功");
        } catch (Exception e) {
            apiResult.failed();
        }
        return apiResult;
    }

    /**
     * 更新数据
     * @param student
     * @return
     */
    @PostMapping("/updateByStudent")
    public ApiResult updateByStudent(@RequestBody Student student) {
        ApiResult apiResult = new ApiResult(true, true);
        try {
            studentService.updateByStudent(student);
            apiResult.setMessage("更新成功");
        } catch (Exception e) {
            apiResult.failed();
        }
        return apiResult;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @GetMapping("/selectById")
    public ApiResult selectById(@RequestParam("id") Integer id) {
        ApiResult apiResult = new ApiResult(true, true);
        try {
            Student student = studentService.selectById(id);
            apiResult.setData(student);
        } catch (Exception e) {
            apiResult.failed();
        }
        return apiResult;
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @GetMapping("/deleteById")
    public ApiResult deleteById(@RequestParam("id") Integer id) {
        ApiResult apiResult = new ApiResult(true, true);
        try {
            studentService.deleteById(id);
        } catch (Exception e) {
            apiResult.failed();
        }
        return apiResult;
    }
}
