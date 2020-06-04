package com.springcloud.controller;


import com.springcloud.entities.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{dept_no}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("dept_no") Long dept_no) {
        return service.findById(dept_no);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("********"+list);

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }
}
