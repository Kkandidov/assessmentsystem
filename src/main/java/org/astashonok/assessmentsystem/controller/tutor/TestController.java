package org.astashonok.assessmentsystem.controller.tutor;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tutor")
public class TestController {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;
    private AnswerService answerService;
    private TtqService ttqService;


    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

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

    //questions
    @GetMapping(value = "/view-questions")
    public String showQuestion(Model model){
        model.addAttribute("title", "Questions");
        model.addAttribute("clickedTutorViewQuestion", true);
        model.addAttribute("questions", questionService.getAll());
        return "page";
    }

    //delete
    @GetMapping(value = "/delete-question/{id}")
    public String deletePage(@PathVariable("id") int id){
        questionService.delete(questionService.getById(id));
        return "redirect:/tutor/view-questions";
    }

    //edit
    @GetMapping(value = "/view-question/{id}")
    public String edit(@PathVariable int id, Model model){
        Question question = questionService.getById(id);

        model.addAttribute("clickedTutorEditQuestion", true);

        model.addAttribute("title", question.getDescription());
        model.addAttribute("question", question);
        model.addAttribute("answers", question.getAnswers());
        return "page";
    }

    @RequestMapping(value="/save-question", method = RequestMethod.POST)
    public String save(@ModelAttribute("question") Question question){
        questionService.update(question);
        return "redirect:/tutor/view-question";
    }

    //answers

    @GetMapping("/add-answer")
    public String showFormForAdd(@RequestParam("questId") int questId, Model theModel) {
        Question question = questionService.getById(questId);
        Answer answer = new Answer();
        answer.setQuestion(question);
        theModel.addAttribute("answer", answer);
        return "/tutor/answerForm";
    }

    @PostMapping("/save-answer")
    public String editAnswer(@ModelAttribute("answer")Answer answer) {
        answerService.update(answer);
        return "redirect:/tutor/view-question/" + answer.getQuestion().getId();
    }

    @RequestMapping(value = "/update-answer", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
        Answer answer = answerService.getById(theId);
        theModel.addAttribute("answer", answer);
        return "/tutor/answerForm";
    }

    @GetMapping("/delete-answer")
    public String deleteAnswer(@RequestParam("id") int theId) {
        Answer answer = answerService.getById(theId);
        long questId = answer.getQuestion().getId();
        answerService.delete(answer);
        return "redirect:/tutor/view-question/" + questId;
    }

    //add

    @GetMapping(value = "/createTest")
    public String createTest(Model model){
        model.addAttribute("topics",topicService.getNamesTopics());
        model.addAttribute("tests",testService.getNamesTests());
        model.addAttribute("questions",questionService.getNamesQuestions());
        return "tutor/createTest";
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public String addTest(@RequestParam(name = "topic")String nameTopic,
                          @RequestParam(name = "test")String nameTest,
                          @RequestParam(name = "question")String nameQuestion,
                          Model model){

        Question completed = ttqService.createNewQuestion(nameTopic, nameTest, nameQuestion);

        List<String> nameTopics = topicService.getNamesTopics();
        List<String> nameTests = testService.getNamesTests();
        List<String> nameQuestions = questionService.getNamesQuestions();

        model.addAttribute("topics",nameTopics);
        model.addAttribute("tests",nameTests);
        model.addAttribute("questions",nameQuestions);
        model.addAttribute("success","Добавлен вопрос \"" + nameQuestion + "\" в тест "+nameTest);

        return "tutor/createTest";
    }
}
