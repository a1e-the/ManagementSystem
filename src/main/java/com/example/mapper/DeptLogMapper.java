package com.example.mapper;

import com.example.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log (id, create_time, description) values (#{id}, #{createTime}, #{description})")
    void insert(DeptLog deptLog);
}
