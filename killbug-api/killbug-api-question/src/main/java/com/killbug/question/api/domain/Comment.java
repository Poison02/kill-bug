package com.killbug.question.api.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.killbug.common.domain.BaseEntity;
import com.killbug.common.xss.Xss;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("comment")
public class Comment extends BaseEntity {

    @TableId(value = "id")
    private Long id;

    @NotBlank(message = "questionId cannot be null")
    private Long questionId;

    @Xss(message = "script cannot exist in content")
    @NotBlank(message = "content cannot be null")
    private String content;

    @NotBlank(message = "userId cannot be null")
    private Long userId;

    @NotBlank(message = "likeCount cannot be null")
    private Integer likeCount;

    @NotBlank(message = "replyCount cannot be null")
    private Integer replyCount;
}
