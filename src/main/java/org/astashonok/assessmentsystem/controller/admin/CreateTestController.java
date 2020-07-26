package org.astashonok.assessmentsystem.controller.admin;

import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.astashonok.assessmentsystem.service.api.TtqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CreateTestController {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;
    private TtqService ttqService;

    @Autowired
    public void setTtqService(TtqService ttqService) {
        this.ttqService = ttqService;
    }

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/createTest")
    public ModelAndView createTest() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Создание теста");
        mv.addObject("clickedCreateTest", true);
        mv.addObject("topics", topicService.getNamesTopics());
        mv.addObject("tests", testService.getNamesTests());
        mv.addObject("questions", questionService.getNamesQuestions());
        return mv;
    }

    @GetMapping("/saveNewQuestion")
    public ModelAndView addTest(@RequestParam(name = "topic") String nameTopic,
                                @RequestParam(name = "test") String nameTest,
                                @RequestParam(name = "question") String nameQuestion) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Создание теста");
        mv.addObject("clickedCreateTest", true);
        ttqService.createNewQuestion(nameTopic, nameTest, nameQuestion);
        List<String> nameTopics = topicService.getNamesTopics();
        List<String> nameTests = testService.getNamesTests();
        List<String> nameQuestions = questionService.getNamesQuestions();
        mv.addObject("topics", nameTopics);
        mv.addObject("tests", nameTests);
        mv.addObject("questions", nameQuestions);
        mv.addObject("success", "Добавлен вопрос \"" + nameQuestion + "\" в тест " + nameTest);
        return mv;
    }
}
