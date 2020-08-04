package org.astashonok.assessmentsystem.controller.user;

import org.astashonok.assessmentsystem.model.Test;
import org.astashonok.assessmentsystem.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonDataController {

    @Autowired
    TestService testService;

    @GetMapping("user/topic/{id}/tests")
    @ResponseBody
    public List<Test> getProductsByCategory(@PathVariable long id) {
        System.out.println(testService.getByTopicId(id));
        return testService.getByTopicId(id);
    }
}
