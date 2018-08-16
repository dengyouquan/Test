package com.hand.api.controller;

import com.hand.api.service.CityClientService;
import com.hand.domain.entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/feign/api/cities")
public class CityControllerConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected CityClientService service;

    @PostMapping
    public City create(@RequestBody City city) {
        city.setLastUpdate(new Date());
        service.create(city);
        logger.info("feign save  city :" + city);
        return city;
    }

    @PutMapping("/{id}")
    public City update(@PathVariable("id") Short id, @RequestBody City city) {
        city.setLastUpdate(new Date());
        service.update(city);
        logger.info("feign update city:" + city);
        return city;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Short id) {
        service.delete(id);
        logger.info("feign delete city:" + id);
    }

    @GetMapping("/{id}")
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City get(@PathVariable("id") Short id) {
        City city = service.get(id);
        logger.info("feign get city:" + city);
        return city;
    }

    @GetMapping
    public List<City> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        logger.info("feign getAll");
        return service.list(pageNum, pageSize);
    }
}
