package org.astashonok.assessmentsystem.controller;

import org.astashonok.assessmentsystem.dto.user.TestDto;
import org.astashonok.assessmentsystem.dto.user.UserDto;
import org.astashonok.assessmentsystem.model.Role;
import org.astashonok.assessmentsystem.model.User;
import org.astashonok.assessmentsystem.model.enums.RoleName;
import org.astashonok.assessmentsystem.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @ModelAttribute("userDto")
    public UserDto getUserDto() {
        if (session.getAttribute("userDto") == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (!authentication.getPrincipal().equals("anonymousUser")) {
                User user = userService.getByLogin(authentication.getName());
                if (user != null) {
                    UserDto userDto = new UserDto();
                    userDto.setUser(user);
                    userDto.setId(user.getId());
                    userDto.setFullName(user.getFirstName() + " " + user.getLastName());
                    userDto.setLogin(user.getLogin());
                    userDto.setRoles(user.getRoles());
                    session.setAttribute("userDto", userDto);
                    return userDto;
                }
            }
        }
        return (UserDto) session.getAttribute("userDto");
    }

    @ModelAttribute("testDto")
    public TestDto getTestDto() {
        if (session.getAttribute("testDto") == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!authentication.getPrincipal().equals("anonymousUser")) {
                User user = userService.getByLogin(authentication.getName());
                if (user != null
                        && user
                        .getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())
                        .contains(RoleName.ROLE_USER.name())) {
                    TestDto testDto = new TestDto();
                    session.setAttribute("testDto", testDto);
                    return testDto;
                }
            }
        }
        return (TestDto) session.getAttribute("testDto");
    }
}
