package com.springcloud.service;

import com.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{dept_no}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("dept_no") Long dept_no);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll();
}
