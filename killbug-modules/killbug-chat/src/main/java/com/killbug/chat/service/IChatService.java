package com.killbug.chat.service;

import com.killbug.chat.dto.MessageDTO;
import com.killbug.chat.vo.ChatRecordVO;
import com.killbug.chat.vo.ChatVO;

import java.util.Date;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface IChatService {
    List<ChatVO> getChatList(Integer type);

    List<ChatRecordVO> getChatRecords(Long uId, Integer type);

    Date sendMessage(MessageDTO messageDTO);

    Long createChat(String userId, Integer type);
}
