package com.nepxion.discovery.plugin.strategy.sentinel.configuration;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Weihua Wang
 * @author Haojun Ren
 * @version 1.0
 */

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.plugin.strategy.sentinel.constant.SentinelStrategyConstant;
import com.nepxion.discovery.plugin.strategy.sentinel.loader.SentinelRuleLoader;
import com.nepxion.discovery.plugin.strategy.sentinel.parser.SentinelAuthorityRuleParser;
import com.nepxion.discovery.plugin.strategy.sentinel.parser.SentinelDegradeRuleParser;
import com.nepxion.discovery.plugin.strategy.sentinel.parser.SentinelFlowRuleParser;
import com.nepxion.discovery.plugin.strategy.sentinel.parser.SentinelParamFlowRuleParser;
import com.nepxion.discovery.plugin.strategy.sentinel.parser.SentinelSystemRuleParser;

@Configuration
@ConditionalOnProperty(value = SentinelStrategyConstant.SPRING_APPLICATION_STRATEGY_SENTINEL_ENABLED, matchIfMissing = false)
public class SentinelStrategyAutoConfiguration {
    @Autowired
    private SentinelRuleLoader sentinelRuleLoader;

    @PostConstruct
    public void initialize() {
        sentinelRuleLoader.load();
    }

    @Bean
    public SentinelFlowRuleParser sentinelFlowRuleParser() {
        return new SentinelFlowRuleParser();
    }

    @Bean
    public SentinelDegradeRuleParser sentinelDegradeRuleParser() {
        return new SentinelDegradeRuleParser();
    }

    @Bean
    public SentinelAuthorityRuleParser sentinelAuthorityRuleParser() {
        return new SentinelAuthorityRuleParser();
    }

    @Bean
    public SentinelSystemRuleParser sentinelSystemRuleParser() {
        return new SentinelSystemRuleParser();
    }

    @Bean
    public SentinelParamFlowRuleParser sentinelParamFlowRuleParser() {
        return new SentinelParamFlowRuleParser();
    }
}