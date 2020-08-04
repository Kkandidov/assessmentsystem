package org.astashonok.assessmentsystem.controller.admin;

import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.astashonok.assessmentsystem.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CreateUserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private SimpleMailMessage simpleMailMessage;
    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ModelAndView createUserGet(Model model, User user) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Создание пользователя");
        mv.addObject("clickedCreateUserGet", true);
        userService.add(user, passwordEncoder);

        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setText("Вы были успешно зарегестрированы. Перейти по ссылке: http://localhost:8080/login");
        javaMailSender.send(simpleMailMessage);

        user = new User();
        List<User> userList = userService.getAll();
        model.addAttribute("user", user);
        mv.addObject("userList", userList);
        mv.addObject("allRoles", RoleName.values());
        mv.addObject("success", "Пользователь добавлен");
        return mv;
    }

    @GetMapping(value = "/createUser")
    public ModelAndView createUser(Model model) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Создание пользователя");
        mv.addObject("clickedCreateUserGet", true);

        List<User> userList = userService.getAll(User.class);
        User user = new User();
        mv.addObject("userList", userList);
        model.addAttribute("user", user);
        mv.addObject("allRoles", RoleName.values());
        return mv;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deletePage(@PathVariable("id") int id, Model model) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Создание пользователя");
        mv.addObject("clickedCreateUserGet", true);

        User user = userService.getById(id);
        userService.delete(user);
        List<User> userList = userService.getAll(User.class);
        User user1 = new User();
        mv.addObject("userList", userList);
        model.addAttribute("user", user1);
        mv.addObject("allRoles", RoleName.values());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id, Model model) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Edit");
        mv.addObject("clickedEditPage", true);

        User user = userService.getById(id);
        user.setPassword("");
        mv.addObject("allRoles", RoleName.values());
        model.addAttribute("user", user);
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView editPagePost(@ModelAttribute("user") User user, Model model) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Edit");
        mv.addObject("clickedCreateUserGet", true);

        userService.update(user, passwordEncoder);
        List<User> userList = userService.getAll(User.class);
        User user1 = new User();
        mv.addObject("userList", userList);
        model.addAttribute("user", user1);
        mv.addObject("allRoles", RoleName.values());
        return mv;
    }
}
