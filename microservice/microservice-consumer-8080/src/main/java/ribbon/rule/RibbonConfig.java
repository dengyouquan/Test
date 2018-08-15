package ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: TestSpringCloud
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-15 15:55
 **/
@Configuration
public class RibbonConfig {
    @Autowired
    IClientConfig config;

    @Bean
    //@ConditionalOnMissingBean
    public IRule ribbonRule(IClientConfig config) {
        System.out.println("随机算法");
        return new RandomRule();
    }
}
