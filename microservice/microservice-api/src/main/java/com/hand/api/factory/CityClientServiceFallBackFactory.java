package com.hand.api.factory;

import com.hand.api.service.CityClientService;
import com.hand.domain.entity.City;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Program: TestSpringCloud
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-15 20:16
 **/

//服务降级,不要忘记加@Component组件
@Component
public class CityClientServiceFallBackFactory implements FallbackFactory<CityClientService> {
    @Override
    public CityClientService create(Throwable throwable) {
        return new CityClientService() {
            @Override
            public City create(City v) {
                return null;
            }

            @Override
            public City update(City v) {
                return null;
            }

            @Override
            public void delete(Short id) {

            }

            @Override
            public City get(Short id) {
                return new City().setCityId(id).setCity("服务降级，服务关闭").setLastUpdate(new Date());
            }

            @Override
            public List<City> list(Integer pageNum, Integer pageSize) {
                return null;
            }
        };
    }
}
