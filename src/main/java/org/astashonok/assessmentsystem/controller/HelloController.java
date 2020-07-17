package org.astashonok.assessmentsystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/admin")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/tutor")
    public String tutor() {
        return "Tutor";
    }
}
