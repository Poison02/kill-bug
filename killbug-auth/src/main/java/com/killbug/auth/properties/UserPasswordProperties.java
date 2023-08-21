package com.killbug.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zch
 * @date 2023/8/21
 **/
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "user.password")
public class UserPasswordProperties {

    private Integer maxRetryCount;

    private Integer lockTime;
}
