package org.astashonok.assessmentsystem.controller.tutor.test;

import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.model.Link;
import org.astashonok.assessmentsystem.model.Literature;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.service.api.*;
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
    private LiteratureService literatureService;
    private LinkService linkService;

    @Autowired
    public void setLiteratureService(LiteratureService literatureService) {
        this.literatureService = literatureService;
    }

    @Autowired
    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }

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
    public String getTutorTest(Model model) {
        model.addAttribute("title", "Добавить тест");
        model.addAttribute("clickedTutorTestPage", true);
        model.addAttribute("topics", topicService.getAll());
        return "page";
    }

    @GetMapping("/test/{tests}")
    public String getTestPage(@PathVariable("tests") Long testId,
                              Model model) {

        model.addAttribute("title", "Тест");
        model.addAttribute("clickedTutorViewQuestion", true);
        model.addAttribute("test", testService.getById(testId));
        model.addAttribute("questions", questionService.getByTestId(testId));
        return "page";
    }

    @PostMapping("/test/{tests}/add")
    public String addQuestion(@PathVariable("tests") Long testId,
                              @RequestParam("quest-name") String questName) {

        Question question = new Question();
        question.setDescription(questName);
        question.setTest(testService.getById(testId));
        questionService.add(question);

        return "redirect:/tutor/test/" + testId;
    }

    @GetMapping("/test/{test}/answer/{question}")
    public String editQuestion(@PathVariable("test") Long testId,
                               @PathVariable("question") Long questId,
                               Model model) {

        model.addAttribute("clickedTutorEditQuestion", true);
        model.addAttribute("title", "Вопрос");

        model.addAttribute("question", questionService.getById(questId));
        model.addAttribute("answers", answerService.getByQuestionId(questId));
        model.addAttribute("testId", testId);

        return "page";
    }


    @PostMapping("/test/question/update")
    public String updateQuestion(@RequestParam("test") Long testId,
                                 @RequestParam("question") Long questId,
                                 @RequestParam("question-desc") String questDesc) {

        Question question = questionService.getById(questId);
        question.setDescription(questDesc);
        questionService.update(question);

        return "redirect:/tutor/test/" + testId;
    }


    //deleteQuestion
    @GetMapping("/test/{test}/delete/{question}")
    public String deleteQuestion(@PathVariable("test") Long testId,
                                 @PathVariable("question") Long questId) {

        questionService.delete(questionService.getById(questId));
        return "redirect:/tutor/test/" + testId;
    }

    //addAnswer
    @PostMapping("/test/{test}/edit/{question}/add")
    public String addAnswer(@PathVariable("test") Long testId,
                            @PathVariable("question") Long questId,
                            @RequestParam("answer-desc") String answerDesc,
                            @RequestParam("isCorrect") boolean correct) {

        Answer answer = new Answer();

        answer.setDescription(answerDesc);
        answer.setCorrect(correct);
        answer.setQuestion(questionService.getById(questId));

        answerService.add(answer);

        return "redirect:/tutor/test/" + testId + "/answer/" + questId;
    }
    //editAnswer


    //deleteAnswer

    @GetMapping("/test/delete-answer")
    public String deleteAnswer(@RequestParam("test") Long testId,
                               @RequestParam("question") Long questId,
                               @RequestParam("answer") Long ansId) {

        answerService.delete(answerService.getById(ansId));
        return "redirect:/tutor/test/" + testId + "/answer/" + questId;
    }

    @PostMapping("/test/update-answer")
    public String updateAnswer(@RequestParam("test") Long testId,
                               @RequestParam("question") Long questId,
                               @RequestParam("answer") Long ansId,
                               @RequestParam("answer-desc") String answerDesc) {

        Answer answer = answerService.getById(ansId);
        answer.setDescription(answerDesc);
        answerService.update(answer);

        return "redirect:/tutor/test/" + testId + "/answer/" + questId;
    }


    @GetMapping("/test/{test}/literature/{question}")
    public String getLiterature(@PathVariable("test") Long testId,
                                @PathVariable("question") Long questId,
                                Model model) {

        model.addAttribute("clickedTutorEditLiterature", true);
        model.addAttribute("title", "Литература");

        model.addAttribute("question", questionService.getById(questId));
        model.addAttribute("literature", literatureService.getByQuestionId(questId));
        model.addAttribute("testId", testId);

        return "page";
    }

    @PostMapping("/test/add-literature")
    public String addLiterature(@RequestParam("test") Long testId,
                                @RequestParam("question") Long questId,
                                @RequestParam("liter-desc") String literDesc) {

        Literature literature = new Literature();
        literature.setDescription(literDesc);
        literature.setQuestion(questionService.getById(questId));
        literatureService.add(literature);

        return "redirect:/tutor/test/" + testId + "/literature/" + questId;
    }


    @PostMapping("/test/literature/update")
    public String updateLiterature(@RequestParam("test") Long testId,
                                   @RequestParam("question") Long questId,
                                   @RequestParam("literatureId") Long literatureId,
                                   @RequestParam("liter-desc") String literDesc) {

        Literature literature = literatureService.getById(literatureId);
        literature.setDescription(literDesc);
        literatureService.update(literature);

        return "redirect:/tutor/test/" + testId + "/literature/" + questId;
    }


    @GetMapping("test/{test}/question/{question}/delete-literature/{literature}")
    public String deleteLiterature(@PathVariable("test") Long testId,
                                   @PathVariable("question") Long questId,
                                   @PathVariable("literature") Long literatureId) {

        literatureService.delete(literatureService.getById(literatureId));
        return "redirect:/tutor/test/" + testId + "/literature/" + questId;
    }


    @GetMapping("/test/{test}/question/{question}/literature/{literature}")
    public String getLinks(@PathVariable("test") Long testId,
                           @PathVariable("question") Long questId,
                           @PathVariable("literature") Long literId,
                           Model model) {
        model.addAttribute("clickedTutorEditLinks", true);
        model.addAttribute("title", "Ссылки");

        model.addAttribute("literature", literatureService.getById(literId));
        model.addAttribute("links", linkService.getByLiteratureId(literId));

        model.addAttribute("testId", testId);
        model.addAttribute("questionId", questId);

        return "page";
    }

    @PostMapping("/test/add-link")
    public String addLink(@RequestParam("test") Long testId,
                          @RequestParam("question") Long questId,
                          @RequestParam("literature") Long literId,
                          @RequestParam("link") String strLink) {

        Link link = new Link();

        link.setLink(strLink);
        link.setLiterature(literatureService.getById(literId));
        linkService.add(link);

        return "redirect:/tutor/test/" + testId + "/question/" + questId + "/literature/" + literId;
    }

    @PostMapping("/test/link/update")
    public String updateLink(@RequestParam("test") Long testId,
                             @RequestParam("question") Long questId,
                             @RequestParam("literatureId") Long literId,
                             @RequestParam("linkId") Long linkId,
                             @RequestParam("linkLink") String linkLink) {

        Link link = linkService.getById(linkId);
        link.setLink(linkLink);
        linkService.update(link);

        return "redirect:/tutor/test/" + testId + "/question/" + questId + "/literature/" + literId;
    }


    @GetMapping("/test/{test}/question/{question}/literature/{literature}/delete-link/{link}")
    public String deleteLink(@PathVariable("test") Long testId,
                             @PathVariable("question") Long questId,
                             @PathVariable("literature") Long literId,
                             @PathVariable("link") Long linkId) {

        linkService.delete(linkService.getById(linkId));
        return "redirect:/tutor/test/" + testId + "/question/" + questId + "/literature/" + literId;
    }

}
