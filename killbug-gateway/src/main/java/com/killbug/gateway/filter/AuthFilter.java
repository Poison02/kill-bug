package com.killbug.gateway.filter;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.killbug.common.core.constant.HttpStatus;
import com.killbug.gateway.config.properties.IgnoreWhiteProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zch
 * @date 2023/8/21
 **/
@Configuration
public class AuthFilter {

    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreWhiteProperties ignoreWhite) {
        return new SaReactorFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico", "/actuator/**")
                .setAuth(obj -> {
                    SaRouter.match("/**")
                            .notMatch(ignoreWhite.getWhites())
                            .check(r -> StpUtil.checkLogin());
                }).setError(e -> {
                    e.printStackTrace();
                    return SaResult.error("Unauthorized, you cannot access system resources")
                            .setCode(HttpStatus.UNAUTHORIZED);
                });
    }

}
