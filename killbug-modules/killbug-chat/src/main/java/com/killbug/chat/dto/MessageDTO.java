package com.killbug.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
@NoArgsConstructor
public class MessageDTO {

    @NotBlank(message = "ReceiverId cannot be null!")
    private String receiverId;

    @NotBlank(message = "Content cannot be null!")
    private String content;

    @NotNull(message = "Type cannot be null!")
    private Integer type;
}
