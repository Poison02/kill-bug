package com.killbug.common.idempotent.config;

import com.killbug.common.idempotent.aspectj.RepeatSubmitAspect;
import com.killbug.common.redis.config.RedisConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@AutoConfiguration(after = RedisConfiguration.class)
public class IdempotentAutoConfiguration {

    @Bean
    public RepeatSubmitAspect repeatSubmitAspect() {
        return new RepeatSubmitAspect();
    }
}
