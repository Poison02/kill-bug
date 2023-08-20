package com.killbug.chat.api.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.killbug.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("chat")
public class Chat extends BaseEntity {

    @TableId(value = "id")
    private Long id;

    @NotNull(message = "senderId cannot be null")
    private Long senderId;

    @NotNull(message = "receiverId cannot be null")
    private Long receiverId;

    @NotNull(message = "type cannot be null")
    private Integer type;
}
