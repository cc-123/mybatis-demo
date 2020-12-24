package com.cc.mybatisdemo.controller;

import com.cc.mybatisdemo.pojo.Student;
import com.cc.mybatisdemo.service.StudentService;
import com.cc.mybatisdemo.util.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Api(tags = "学生相关接口")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 新增数据
     * @param student
     * @return
     */
    @ApiOperation("新增数据")
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
    @ApiOperation("更新数据")
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
    @ApiOperation("根据id查询数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "学生id", required = true)
    })
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
    @ApiOperation("根据id删除数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", value = "学生id", required = true)
    })
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
