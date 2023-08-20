package com.killbug.question.service;

import com.killbug.common.core.vo.ListVO;
import com.killbug.question.api.vo.QuestionVO;
import com.killbug.question.dto.QuestionDTO;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface IQuestionService {

    Long createQuestion(QuestionDTO questionDTO);

    ListVO<QuestionVO> getQuestionList(Integer pageNum, Integer pageSize, Integer type);

    List<QuestionVO> getQuestionList();

    QuestionVO getQuestionById(Long id);

    void incrCommentCountById(Long id);

    List<QuestionVO> getMyQuestions();

    List<QuestionVO> getQuestionsByUserId(Long id);

}
