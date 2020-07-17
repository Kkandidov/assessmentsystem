package org.astashonok.assessmentsystem.controller.user;

import org.astashonok.assessmentsystem.dto.user.TestDto;
import org.astashonok.assessmentsystem.dto.user.UserDto;
import org.astashonok.assessmentsystem.model.Answer;
import org.astashonok.assessmentsystem.model.Question;
import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.service.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@SessionAttributes({"testDto", "userDto"})
public class UserController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/user/home")
    public ModelAndView getUserPage() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Пользователь");
        mv.addObject("clickedUser", true);
        return mv;
    }

    @GetMapping("user/choose/test")
    public ModelAndView chooseTest() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Выбор теста");
        mv.addObject("clickedChooseTest", true);
        mv.addObject("topics", topicService.getAll());
        mv.addObject("tests", testService.getAll());
        return mv;
    }

    @GetMapping("/user/statistic")
    public ModelAndView getUserStatistic() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Статистика пользователя");
        mv.addObject("clickedUserStatistic", true);
        return mv;
    }

    @GetMapping("user/chosen/test")
    public String startTest(@ModelAttribute("testDto") TestDto testDto,
                            @ModelAttribute("userDto") UserDto userDto,
                            @RequestParam(name = "testId") String testId) {
        if (testId != null) {

            if (testDto.getStatistics() != null) {
                for (Statistic s : testDto.getStatistics()) {
                    if (s.getUser() == null) {
                        s.setUser(userDto.getUser());
                        s.setDate(new Date());
                    }
                    statisticService.add(s);
                }
            }

            testDto.setQuestions(questionService.getByTestId(Long.parseLong(testId)));
        }
        return "redirect:/user/test";
    }

    @GetMapping("user/test")
    public ModelAndView testGet(@ModelAttribute("testDto") TestDto testDto,
                                Model model) {
        ModelAndView mv = new ModelAndView("page");
        Question question = testDto.getQuestions().get(testDto.getQuestionCounter());
        mv.addObject("question", question);
        mv.addObject("answers", answerService.getByQuestionId(question.getId()));
        mv.addObject("title", "Тест пользователя");
        mv.addObject("clickedNextTest", true);
        model.addAttribute("answerModel", new Answer());
        return mv;
    }

    @PostMapping("user/test")
    public String testPost(@ModelAttribute("testDto") TestDto testDto,
                           @ModelAttribute("userDto") UserDto userDto,
                           @ModelAttribute("answerModel") Answer answerModel) {
        int issueOrder = testDto.iterator().questionCounterIncrement();
        Statistic statistic = testDto.getStatistics().get(issueOrder);
        statistic.setDate(new Date());
        statistic.setUser(userDto.getUser());
        if (answerModel.getId() != 0) {
            statistic.setCorrect(answerService.getById(answerModel.getId()).isCorrect());
        }
        if (testDto.iterator().hasNext()) {
            System.out.println(testDto.getStatistics().get(issueOrder));
            return "redirect:/user/test";
        } else {
            for (Statistic s : testDto.getStatistics()) {
                statisticService.add(s);
            }
            testDto.iterator().clearData();
            return "redirect:/user/test/result";
        }
    }

    @GetMapping("user/test/result")
    public ModelAndView getTestResult() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Результаты теста");
        mv.addObject("clickedResultTest", true);
        return mv;
    }
}