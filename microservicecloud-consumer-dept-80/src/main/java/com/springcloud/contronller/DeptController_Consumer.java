package com.springcloud.contronller;


import com.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class DeptController_Consumer {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**
     * 注册再EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private RestOperations restOperations;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        //三个参数：url,requestMap ResponseBean.class
        return restOperations.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{dept_no}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("dept_no") Long dept_no) {
        //三个参数：url,requestMap ResponseBean.class
        return restOperations.getForObject(REST_URL_PREFIX + "/dept/get/" + dept_no, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        //三个参数：url,requestMap ResponseBean.class
        return restOperations.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery",method = RequestMethod.GET)
    public Object discovery() {
        System.out.println("discovery");
        return restOperations.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
