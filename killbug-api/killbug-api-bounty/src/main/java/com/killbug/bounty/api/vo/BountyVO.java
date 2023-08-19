package com.killbug.bounty.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
public class BountyVO implements Serializable {

    private Long id;

    private String title;

    private String content;

    private Long publisherId;

    private String publisherAvatar;

    private String publisherNickname;

    private String publisherPosition;

    private Long solverId;

    private String solverAvatar;

    private String solverNickname;

    private String solverPosition;

    private Integer reward;

    private Integer status;

    private Date createTime;

    private List<String> tags;
}
