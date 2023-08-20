package com.killbug.chat.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
public class ChatRecordVO {

    private String content;

    private Long senderId;

    private Long receiverId;

    private Date createTime;
}
