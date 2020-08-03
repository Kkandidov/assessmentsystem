package org.astashonok.assessmentsystem.controller.tutor.test;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.model.Topic;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.astashonok.assessmentsystem.service.api.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tutor")
public class TutorCreateTestController {

    private TopicService topicService;
    private TestService testService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/createTest")
    public String createTest(Model model){
        model.addAttribute("clickedTutorCreateTest", true);
        model.addAttribute("topics", topicService.getAll());
        return "page";
    }

    @PostMapping(value = "/createTest")
    public String addTest(@RequestParam(name = "topicId") Long topicId,
                          @RequestParam(name = "test-name") String nameTest,
                          @RequestParam(name = "test-description") String descTest,
                          Model model){

        model.addAttribute("clickedTutorCreateTest", true);

        Topic topic = topicService.getById(topicId);
        Test test = new Test();

        test.setName(nameTest);
        test.setDescription(descTest);
        test.setTopic(topic);

        testService.add(test);

        model.addAttribute("topics", topicService.getAll());
        model.addAttribute("message","Добавлен тест:\"" + nameTest + "\" в топик: " + topic.getName());

        return "page";
    }
}
