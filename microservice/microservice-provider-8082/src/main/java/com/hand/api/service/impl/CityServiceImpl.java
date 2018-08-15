package com.hand.api.service.impl;

import com.hand.api.service.CityService;
import com.hand.domain.entity.City;
import com.hand.infra.mapper.CityMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: TestSpringBoot
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-08 23:37
 **/
@Service
public class CityServiceImpl extends BaseServiceImpl<City,CityMapper> implements CityService {
}
