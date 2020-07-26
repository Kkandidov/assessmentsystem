package org.astashonok.assessmentsystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/admin/home")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/tutor/home")
    public String tutor() {
        return "Tutor";
    }
}
