package com.killbug.chat.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
public class ChatVO {

    private Long chatId;

    private Long userId;

    private String nickname;

    private String avatar;

    private Date updateTime;

    private Integer type;
}
