package com.killbug.question.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
@NoArgsConstructor
public class CommentDTO {

    @NotBlank(message = "content cannot be null")
    private String content;

    @NotBlank(message = "userId cannot be null")
    private String userId;

    @NotBlank(message = "questionId cannot be null")
    private String questionId;
}