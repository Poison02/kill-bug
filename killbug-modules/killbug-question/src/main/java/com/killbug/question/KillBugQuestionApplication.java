package com.killbug.question;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@EnableDubbo
@SpringBootApplication
public class KillBugQuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillBugQuestionApplication.class, args);
    }

}
