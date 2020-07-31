package org.astashonok.assessmentsystem.controller.tutor.test;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.service.api.AnswerService;
import org.astashonok.assessmentsystem.service.api.QuestionService;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tutor")
public class TutorTestWorkController {

    private QuestionService questionService;
    private TopicService topicService;
    private TestService testService;
    private AnswerService answerService;


    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
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

    @GetMapping("/tutor-test")
    public String getTutorTest(Model model){
        model.addAttribute("title", "Добавить тест");
        model.addAttribute("clickedTutorTestPage", true);
        model.addAttribute("topics", topicService.getAll());
        return "page";
    }

    @GetMapping("/test/{tests}")
    public String getTestPage(@PathVariable("tests") Long testId,
                              Model model){

        model.addAttribute("title", "Тест");
        model.addAttribute("clickedTutorViewQuestion", true);
        model.addAttribute("test", testService.getById(testId));
        model.addAttribute("questions", questionService.getByTestId(testId));
        return "page";
    }

    @PostMapping("/test/{tests}/add")
    public String addQuestion(@PathVariable("tests") Long testId,
                              @RequestParam("quest-name") String questName){

        Question question = new Question();
        question.setDescription(questName);
        question.setTest(testService.getById(testId));
        questionService.add(question);

        return "redirect:/tutor/test/" + testId;
    }

    //editQuestion /tutor/test/${test.id}/${question.id}
    @GetMapping("/test/{test}/edit/{question}")
    public String editQuestion(@PathVariable("test") Long testId,
                               @PathVariable("question") Long questId,
                               Model model){

        model.addAttribute("clickedTutorEditQuestion", true);
        model.addAttribute("title", "Вопрос");

        model.addAttribute("question", questionService.getById(questId));
        model.addAttribute("answers", answerService.getByQuestionId(questId));
        model.addAttribute("testId", testId);

        return "page";
    }

    //deleteQuestion
    @GetMapping("/test/{test}/delete/{question}")
    public String deleteQuestion(@PathVariable("test") Long testId,
                               @PathVariable("question") Long questId){

        questionService.delete(questionService.getById(questId));
        return "redirect:/tutor/test/" + testId;
    }

    //addAnswer
    @PostMapping("/test/{test}/edit/{question}/add")
    public String addAnswer(@PathVariable("test") Long testId,
                               @PathVariable("question") Long questId,
                               @RequestParam("answer-desc") String answerDesc,
                               @RequestParam("isCorrect") boolean correct){

        Answer answer = new Answer();

        answer.setDescription(answerDesc);
        answer.setCorrect(correct);
        answer.setQuestion(questionService.getById(questId));

        answerService.add(answer);

        return "redirect:/tutor/test/" + testId + "/edit/" + questId;
    }
    //editAnswer


    //deleteAnswer

    @GetMapping("/test/delete-answer")
    public String deleteAnswer(@RequestParam("test") Long testId,
                                 @RequestParam("question") Long questId,
                                 @RequestParam("answer") Long ansId){

        answerService.delete(answerService.getById(ansId));
        return "redirect:/tutor/test/" + testId + "/edit/" + questId;
    }
}
