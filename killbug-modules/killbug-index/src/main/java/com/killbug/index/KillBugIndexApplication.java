package com.killbug.index;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@EnableDubbo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KillBugIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillBugIndexApplication.class, args);
    }
}
