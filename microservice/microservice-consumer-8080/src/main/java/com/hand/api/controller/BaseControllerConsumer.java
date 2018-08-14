package com.hand.api.controller;

import com.hand.domain.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

public abstract class BaseControllerConsumer<V extends BaseEntity> {
    private static final String REST_URL_PREFIX = "http://localhost:8081/api/";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract String getUrlName();

    abstract Class getEntityClass();

    @Autowired
    protected RestTemplate restTemplate;

    @PostMapping
    public V create(@RequestBody V v) {
        v.setLastUpdate(new Date());
        restTemplate.postForObject(REST_URL_PREFIX + getUrlName(), v, getEntityClass());
        logger.info("restTemplate save " + getEntityClass().getSimpleName() + ":" + v);
        return v;
    }

    @PutMapping("/{id}")
    public V update(@PathVariable("id") Short id, @RequestBody V v) {
        v.setLastUpdate(new Date());
        restTemplate.put(REST_URL_PREFIX + getUrlName() + "/" + id, v);
        logger.info("restTemplate update " + getEntityClass().getSimpleName() + v);
        return v;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short id) {
        restTemplate.delete(REST_URL_PREFIX + getUrlName() + "/" + id);
        logger.info("restTemplate delete " + getEntityClass().getSimpleName() + ":" + id);
    }

    @GetMapping("/{id}")
    public V get(@PathVariable("id") Short id) {
        V v = (V) restTemplate.getForObject(REST_URL_PREFIX + getUrlName() + "/" + id, getEntityClass());
        logger.info("restTemplate get " + getEntityClass().getSimpleName() + ":" + v);
        return v;
    }

    @GetMapping
    public List<V> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        logger.info("restTemplate getAll " + getEntityClass().getSimpleName() + " pageSize:" + pageSize + ",pageNum:" + pageNum);
        return restTemplate.getForObject(REST_URL_PREFIX + getUrlName(), List.class, pageNum, pageSize);
    }
}
