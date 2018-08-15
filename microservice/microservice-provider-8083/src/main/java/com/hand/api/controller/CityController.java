package com.hand.api.controller;

import com.hand.api.service.CityService;
import com.hand.domain.entity.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController extends BaseController<City,CityService> {

    @Override
    public Class getEntityClass() {
        return City.class;
    }
}
