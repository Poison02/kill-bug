package com.killbug.common.core.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 通用配置以及启用AOP支持
 * @author Zch
 * @date 2023/8/19
 **/
@AutoConfiguration
@EnableAspectJAutoProxy(exposeProxy = true)
public class ApplicationConfig {
}
