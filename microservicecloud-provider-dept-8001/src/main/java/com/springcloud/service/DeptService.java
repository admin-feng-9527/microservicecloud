package com.springcloud.service;

import com.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept findById(Long dept_no);

    List<Dept> findAll();
}
