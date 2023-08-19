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
public class QuestionVO implements Serializable {

    private Long id;

    private String title;

    private String content;

    private Long userId;

    private Integer likeCount;

    private Integer commentCount;

    private String nickname;

    private String avatar;

    private String position;

    private Date createTime;

    // if liked by current user - 0:no 1:yes
    private Integer isLiked;

    private List<String> tags;
}
