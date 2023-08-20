package com.killbug.question.api.domain;

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
@TableName("thumbup")
public class Thumbup extends BaseEntity {

    @TableId(value = "id")
    private Long id;

    @NotNull(message = "likedId cannot be null")
    private Long likedId;

    @NotNull(message = "userId cannot be null")
    private Long userId;

    private Integer type;
}
