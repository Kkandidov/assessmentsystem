package org.astashonok.assessmentsystem.controller.admin;

import org.astashonok.assessmentsystem.model.admin.ViewStatistic;
import org.astashonok.assessmentsystem.model.admin.ViewStatisticUserTest;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AllStatistics {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/adminStatistic")
    public ModelAndView adminStatistic(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Статистика");
        mv.addObject("clickedAdminStatistic", true);
        return mv;
    }

    @GetMapping(value = "/questionStatistic")
    public ModelAndView questionStatistic(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Статистика по вопросам");
        mv.addObject("clickedQuestionStatistic", true);
        List<ViewStatistic> viewStatisticList = statisticService.getQuestionStatisticList();
        mv.addObject("statisticListQuestion",viewStatisticList);
        return mv;
    }

    @GetMapping(value = "/testStatistic")
    public ModelAndView testStatistic(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Test Statistic");
        mv.addObject("clickedTestStatistic", true);
        List<ViewStatistic> viewStatisticList = statisticService.getTestStatisticList();
        mv.addObject("statisticListTest",viewStatisticList);
        return mv;
    }

    @GetMapping(value = "/userTestStatistic")
    public ModelAndView userTestStatistic(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "User Test Statistic");
        mv.addObject("clickedUserTestStatistic", true);
        List<ViewStatisticUserTest> viewStatisticList = statisticService.getUserTestStatisticList();
        mv.addObject("statisticListUserTest",viewStatisticList);
        return mv;
    }
}
