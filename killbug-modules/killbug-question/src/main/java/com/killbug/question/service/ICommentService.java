package com.killbug.question.service;

import com.killbug.question.api.vo.CommentVO;
import com.killbug.question.dto.CommentDTO;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface ICommentService {

    List<CommentVO> getComments(Long id);

    CommentVO createComment(CommentDTO commentDTO);

    void incrReplyCountById(Long id);

}
