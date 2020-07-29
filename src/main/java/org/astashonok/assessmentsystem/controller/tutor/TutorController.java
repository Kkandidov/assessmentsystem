package org.astashonok.assessmentsystem.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tutor")
public class TutorController {

    @GetMapping(value = {"/home", ""})
    public ModelAndView tutorPage() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Tutor");
        modelAndView.addObject("clickedTutorPage", true);
        return modelAndView;
    }
}
