package com.springcloud.dao;

import com.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
     boolean addDept(Dept dept);

     Dept findById(Long dept_no);

     List<Dept> findAll();
}
