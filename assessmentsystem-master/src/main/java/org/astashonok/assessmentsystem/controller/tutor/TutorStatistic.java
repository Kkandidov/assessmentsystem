package org.astashonok.assessmentsystem.controller.tutor;

import org.astashonok.assessmentsystem.model.admin.ViewStatistic;
import org.astashonok.assessmentsystem.model.admin.ViewStatisticUserTest;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/tutor/statistic")
public class TutorStatistic {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/select")
    public String selectStatisticPage(Model model){
        model.addAttribute("title", "Statistic");
        model.addAttribute("clickedTutorSelectStatistic", true);
        return "page";
    }

    @GetMapping(value = "/test-statistic")
    public String testStatistic(Model model){
        List<ViewStatistic> viewStatisticList = statisticService.getTestStatisticList();
        model.addAttribute("title", "Test Statistic");
        model.addAttribute("clickedTutorTestStatistic", true);
        model.addAttribute("statisticListTest", viewStatisticList);
        return "page";
    }

    @GetMapping(value = "/user-statistic")
        public String userTestStatistic(Model model){
        List<ViewStatisticUserTest> viewStatisticList = statisticService.getUserTestStatisticList();
        model.addAttribute("title", "Users Statistic");
        model.addAttribute("clickedTutorUserStatistic",true);
        model.addAttribute("statisticListUserTest", viewStatisticList);
        return "page";
    }
}
