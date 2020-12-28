package com.cc.mybatisdemo.controller;

import com.cc.mybatisdemo.pojo.base.Student;
import com.cc.mybatisdemo.service.base.StudentService;
import com.cc.mybatisdemo.util.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(tags = "学生相关接口")
public class StudentController {
    private static Logger log = LoggerFactory.getLogger(StudentController.class);

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
            log.error(e.getMessage(), e);
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
            log.error(e.getMessage(), e);
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
//        log.trace("trace级别的日志");
//        log.debug("debug级别日志");
//        log.info("info级别日志");
//        log.warn("warn级别的日志");
//        log.error("error级别日志");
        log.info("查询数据");
        ApiResult<Student> apiResult = new ApiResult(true, true);
        try {
            Student student = studentService.selectById(id);
            apiResult.setData(student);
            apiResult.setMessage("查询成功");
        } catch (Exception e) {
            apiResult.failed();
            log.error(e.getMessage(), e);
        }
        log.info("查询数据结束");
        log.info("返回值为：" + apiResult.toString());
        return apiResult;
    }

    @ApiOperation("查询所有学生数据")
    @GetMapping("selectAllData")
    public ApiResult selectAllData() {
        ApiResult<List<Student>> apiResult = new ApiResult(true, true);
        try {
            List<Student> studentList = studentService.selectAllData();
            apiResult.setData(studentList);
            apiResult.setMessage("查询成功");
        } catch (Exception e) {
            apiResult.failed();
            log.error(e.getMessage(), e);
        }
        log.info(apiResult.toString());
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
            apiResult.setMessage("删除成功");
        } catch (Exception e) {
            apiResult.failed();
            log.error(e.getMessage(), e);
        }
        return apiResult;
    }
}
