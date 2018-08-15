package com.hand.api.service;

import com.hand.domain.entity.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "microservice-privoder")
@RequestMapping("/api/cities")
public interface CityClientService {
    @PostMapping
    City create(City v);

    @PutMapping("/{id}")
    City update(City v);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Short id);

    @GetMapping("/{id}")
    City get(@PathVariable("id") Short id);

    @GetMapping
    List<City> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize);
}
