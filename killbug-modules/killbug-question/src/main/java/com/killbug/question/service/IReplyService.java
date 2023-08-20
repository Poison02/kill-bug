package com.killbug.question.service;

import com.killbug.question.api.vo.ReplyVO;
import com.killbug.question.dto.ReplyDTO;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface IReplyService {

    ReplyVO createReply(ReplyDTO replyDTO);

}
