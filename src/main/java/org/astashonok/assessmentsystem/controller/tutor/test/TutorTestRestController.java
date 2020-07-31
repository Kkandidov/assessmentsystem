package org.astashonok.assessmentsystem.controller.tutor.test;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TutorTestRestController {

    private TestService testService;
    private QuestionService questionService;


    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/tutor/tutor-test/{id}/tests")
    @ResponseBody
    public List<Test> getTestForTopic(@PathVariable("id") Long id){
        return testService.getByTopicId(id);
    }

//    @GetMapping("/tutor/tutor-test/topic/{test}/questions")
//    @ResponseBody
//    public List<Question> getQuestionForTest(@PathVariable("test") Long testId){
//        return questionService.getByTestId(testId);
//    }
}
