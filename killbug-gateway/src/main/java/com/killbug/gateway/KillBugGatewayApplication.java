package com.killbug.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zch
 * @date 2023/8/21
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KillBugGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillBugGatewayApplication.class, args);
    }

}
