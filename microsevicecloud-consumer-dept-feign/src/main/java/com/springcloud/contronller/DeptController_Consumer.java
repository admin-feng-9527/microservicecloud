package com.springcloud.contronller;


import com.springcloud.entities.Dept;
import com.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@EnableFeignClients(basePackages = {"com.springcloud"})
public class DeptController_Consumer {
    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept) {

        return this.service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{dept_no}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("dept_no") Long dept_no) {
        return this.service.findById(dept_no);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return this.service.findAll();
    }

}
