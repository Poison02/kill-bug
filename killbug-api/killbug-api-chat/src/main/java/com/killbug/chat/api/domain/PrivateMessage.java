package com.killbug.chat.api.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.killbug.common.domain.BaseEntity;
import com.killbug.common.xss.Xss;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("private_message")
public class PrivateMessage extends BaseEntity {

    @TableId(value = "id")
    private Long id;

    @NotNull(message = "senderId cannot be null")
    private Long senderId;

    @NotNull(message = "receiverId cannot be null")
    private Long receiverId;

    @Xss(message = "script cannot exist in content")
    @NotBlank(message = "content cannot be null")
    private String content;

    @NotNull(message = "type cannot be null")
    private Integer type;
}
