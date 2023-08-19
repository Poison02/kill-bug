package com.killbug.question.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
public class CommentVO implements Serializable {

    private Long id;

    private Long userId;

    private String avatar;

    private String nickname;

    private String content;

    private Integer likeCount;

    private Integer replyCount;

    private Date createTime;

    private List<ReplyVO> replies;

    // if liked by current user - 0:no 1:yes
    private Integer isLiked;
}
