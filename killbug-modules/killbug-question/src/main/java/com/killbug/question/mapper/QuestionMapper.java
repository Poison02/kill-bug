package com.killbug.question.mapper;

import com.killbug.common.mybatis.core.mapper.BaseMapperPlus;
import com.killbug.question.api.domain.Question;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface QuestionMapper extends BaseMapperPlus<QuestionMapper, Question, Question> {

    void incrCommentCountById(@Param("id") Long id);

    void incrLikeCountById(@Param("id") Long id);

    void decrLikeCountById(@Param("id") Long id);

}
