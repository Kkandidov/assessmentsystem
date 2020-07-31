package org.astashonok.assessmentsystem.controller;

import org.astashonok.assessmentsystem.dto.user.TestDto;
import org.astashonok.assessmentsystem.dto.user.UserDto;
import org.astashonok.assessmentsystem.model.Statistic;
import org.astashonok.assessmentsystem.service.api.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@SessionAttributes({"testDto", "userDto"})
public class PageController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Домашняя");
        mv.addObject("clickedHome", true);
        return mv;
    }

    @GetMapping("/choose/role")
    public ModelAndView chooseRole(@ModelAttribute("userDto") UserDto userDto) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Выбор роли");
        mv.addObject("clickedChooseRole", true);
        mv.addObject("cabinets", userDto.getCabinets());
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
    public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status,
                         @ModelAttribute("userDto") UserDto userDto,
                         @ModelAttribute("testDto") TestDto testDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            if (userDto.getRoles().contains("ROLE_USER") && testDto.getStatistics() != null) {
                for (Statistic s : testDto.getStatistics()) {
                    if (s.getUser() == null) {
                        s.setUser(userDto.getUser());
                        s.setDate(new Date());
                    }
                    statisticService.add(s);
                }
                testDto.iterator().clearData();
            }
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            status.setComplete();
        }
        return "redirect:/login?logout";
    }
}

