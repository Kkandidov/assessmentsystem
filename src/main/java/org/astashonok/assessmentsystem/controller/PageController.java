package org.astashonok.assessmentsystem.controller;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Домашняя");
        mv.addObject("clickedHome", true);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error,
                              @RequestParam(name = "logout", required = false) String logout) {
        ModelAndView mv = new ModelAndView("page");
        if (error != null) {
            mv.addObject("message", "Неверное имя пользователя или пароль");
        }
        if (logout != null) {
            mv.addObject("logout", "Пользователь успешно вышел из системы");
        }
        mv.addObject("title", "Аутентификация");
        mv.addObject("clickedAuthenticate", true);
        return mv;
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("errorCaused", true);
        mv.addObject("title", "403 - В доступе отказано");
        mv.addObject("errorTitle", "Ага! Вы пойманы!");
        mv.addObject("errorDescription", "Вы не авторизованы для просмотра этой страницы!");
        return mv;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }

//    @GetMapping("/registration")
//    public ModelAndView register(Model model) {
//        ModelAndView mv = new ModelAndView("page");
//        mv.addObject("clickedRegistration", true);
//        mv.addObject("title", "Регистрация");
//        model.addAttribute("userModel", new User());
//        return mv;
//    }

//    @PostMapping("/registration")
//    public String register(@ModelAttribute("userModel") User userModel
//            , BindingResult bindingResult) {
////        userAutoModelValidator.validate(userAutoModel, bindingResult);
////        if (bindingResult.hasErrors()) {
////            return "registration";
////        }
//        User user = userService.add(userModel);
//        securityService.autoLogIn(user.getEmail(), user.getConfirmPassword());
//        return "redirect:/welcome?firstName=" + user.getFirstName() + "&lastName=" + user.getLastName();
//    }
}

