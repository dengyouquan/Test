package com.hand.api.controller;

import com.hand.domain.entity.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityControllerConsumer extends BaseControllerConsumer<City> {
    @Override
    String getUrlName() {
        return "cities";
    }

    @Override
    public Class getEntityClass() {
        return City.class;
    }
}
