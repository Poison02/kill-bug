package com.killbug.question.controller;

import com.killbug.common.core.domain.R;
import com.killbug.question.dto.ThumbupDTO;
import com.killbug.question.service.IThumbupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Validated
@RequiredArgsConstructor
@RestController
public class ThumbupController {

    private final IThumbupService likeService;

    @PostMapping("/like")
    public R<Boolean> like(@Validated @RequestBody ThumbupDTO thumbupDTO) {
        Boolean like = likeService.like(thumbupDTO);
        return R.ok(like);
    }
}
