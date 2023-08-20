package com.killbug.chat.controller;

import com.killbug.chat.dto.MessageDTO;
import com.killbug.chat.service.IChatService;
import com.killbug.chat.vo.ChatRecordVO;
import com.killbug.chat.vo.ChatVO;
import com.killbug.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@RequiredArgsConstructor
@Validated
@RestController
public class ChatController {

    private final IChatService chatService;

    @GetMapping("/getChatList/{type}")
    public R<List<ChatVO>> getChatList(@PathVariable Integer type) {
        List<ChatVO> normalChatList = chatService.getChatList(type);
        return R.ok(normalChatList);
    }

    @GetMapping("/getChatRecords/{userId}/{type}")
    public R<List<ChatRecordVO>> getChatRecords(@PathVariable String userId, @PathVariable Integer type) {
        Long uId = Long.valueOf(userId);
        List<ChatRecordVO> list = chatService.getChatRecords(uId, type);
        return R.ok(list);
    }

    @PostMapping("/sendMessage")
    public R<Date> sendMessage(@Validated @RequestBody MessageDTO messageDTO) {
        Date time = chatService.sendMessage(messageDTO);
        return R.ok(time);
    }

    @PostMapping("/createChat/{userId}/{type}")
    public R<Long> createChat(@PathVariable String userId, @PathVariable Integer type) {
        Long chatId = chatService.createChat(userId, type);
        return R.ok(chatId);
    }

}
