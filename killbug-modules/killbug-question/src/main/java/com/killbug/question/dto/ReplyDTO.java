package com.killbug.question.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
@NoArgsConstructor
public class ReplyDTO {

    private Integer replyType;

    private String commentId;

    private String replyId;

    private String fromUserId;

    private String toUserId;

    private String replyContent;
}
