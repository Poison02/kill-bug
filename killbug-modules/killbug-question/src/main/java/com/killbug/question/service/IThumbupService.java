package com.killbug.question.service;

import com.killbug.question.api.domain.Thumbup;
import com.killbug.question.dto.ThumbupDTO;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface IThumbupService {

    Boolean like(ThumbupDTO thumbupDTO);

    Thumbup selectOne(Long likedId, Long userId, Integer type);

}
