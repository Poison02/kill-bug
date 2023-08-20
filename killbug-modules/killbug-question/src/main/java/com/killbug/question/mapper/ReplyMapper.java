package com.killbug.question.mapper;

import com.killbug.common.mybatis.core.mapper.BaseMapperPlus;
import com.killbug.question.api.domain.Reply;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface ReplyMapper extends BaseMapperPlus<ReplyMapper, Reply, Reply> {

    void incrLikeCountById(@Param("id") Long id);

    void decrLikeCountById(@Param("id") Long id);

}
