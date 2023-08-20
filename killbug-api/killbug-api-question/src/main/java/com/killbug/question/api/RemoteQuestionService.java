package com.killbug.question.api;

import com.killbug.common.core.vo.ListVO;
import com.killbug.question.api.vo.QuestionVO;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/19
 **/
public interface RemoteQuestionService {

    ListVO<QuestionVO> getQuestionList(Integer pageNum, Integer pageSize);

    List<QuestionVO> getQuestionList();

    String test(Integer num);

    List<QuestionVO> getMyQuestions();

    void testRemote();

    List<QuestionVO> getQuestionsByUserId(Long id);

}
