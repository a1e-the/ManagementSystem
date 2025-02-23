package com.example.service;

import com.example.pojo.Dept;
import com.example.pojo.PageBean;

import java.util.List;

public interface DeptService {
    public List<Dept> list();

    void delete(Integer id) throws Exception;

    void insert(Dept dept);


}
