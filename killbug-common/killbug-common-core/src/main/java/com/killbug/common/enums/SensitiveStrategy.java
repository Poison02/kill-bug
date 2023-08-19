package com.killbug.common.enums;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;

import java.util.function.Function;

/**
 * 脱敏策略枚举，使用HuTool的 DesensitizedUtil
 * @author Zch
 * @date 2023/8/19
 **/
@AllArgsConstructor
public enum SensitiveStrategy {

    /**
     * phone number 8123****
     */
    PHONE((num) -> StrUtil.isBlank(num) ? "" : StrUtil.hide(num, 4, num.length())),

    /**
     * address number
     */
    ADDRESS(s -> DesensitizedUtil.address(s, 8)),

    /**
     * email address
     */
    EMAIL(DesensitizedUtil::email),

    /**
     * bank card
     */
    BANK_CARD(DesensitizedUtil::bankCard);

    private final Function<String, String> desensitize;

    public Function<String, String> desensitize() {
        return desensitize;
    }

}
