package com.killbug.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 * @author Zch
 * @date 2023/8/19
 **/
@Getter
@AllArgsConstructor
public enum UserStatus {

    OK("0", "正常"), DISABLE("1", "停用");

    private final String code;
    private final String info;
}
