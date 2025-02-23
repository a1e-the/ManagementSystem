package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Scope("prototype")
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);


//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList );
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception{
        log.info("删除:{}", id);
        deptService.delete(id);
        return Result.success();
    }


    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("新增部门:{}", dept);
        deptService.insert(dept);
        return Result.success();
    }
}
