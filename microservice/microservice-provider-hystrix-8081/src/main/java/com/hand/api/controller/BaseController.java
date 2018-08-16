package com.hand.api.controller;

import com.hand.api.service.BaseService;
import com.hand.domain.entity.BaseEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

public abstract class BaseController<V extends BaseEntity, T extends BaseService> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected T service;

    //@Autowired
    //protected DiscoveryClient client;

    public abstract Class getEntityClass();

    @PostMapping
    public V create(@RequestBody V v) {
        v.setLastUpdate(new Date());
        service.create(v);
        logger.info("save " + getEntityClass().getSimpleName() + ":" + v);
        return v;
    }

    @PutMapping("/{id}")
    public V update(@PathVariable("id") Short id, @RequestBody V v) {
        System.out.println(v);
        v.setLastUpdate(new Date());
        service.update(v);
        logger.info("update " + getEntityClass().getSimpleName() + v);
        return v;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short id) {
        service.delete(id);
        logger.info("delete " + getEntityClass().getSimpleName() + ":" + id);
    }

    //服务熔断
    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public V get(@PathVariable("id") Short id) {
        V v = (V) service.get(id);
        if (v == null) throw new RuntimeException("id不存在");
        logger.info("get " + getEntityClass().getSimpleName() + ":" + v);
        return v;
    }

    public V processHystrixGet(@PathVariable("id") Short id) {
        //不能返回字符串等
        logger.info("Hystrix get id" + id + "不存在");
        BaseEntity b = new BaseEntity();
        b.setLastUpdate(new Date());
        return (V) b;
    }

    @GetMapping
    public List<V> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        logger.info("getAll " + getEntityClass().getSimpleName() + " pageSize:" + pageSize + ",pageNum:" + pageNum);
        return service.list(pageNum, pageSize);
    }

    /*@GetMapping("cities/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        List<ServiceInstance> serviceInstances = client.getInstances("provider8081");
        for (ServiceInstance serviceInstance : serviceInstances) {
            logger.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" +
                    serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return client;
    }*/
}
