package org.astashonok.assessmentsystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(value = "/admin")
    public ModelAndView adminPage() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Админ");
        mv.addObject("clickedAdminPage", true);
        return mv;
    }

    @GetMapping(value = "/allRoles")
    public String allRoles(){
        return "allRoles";
    }
}
