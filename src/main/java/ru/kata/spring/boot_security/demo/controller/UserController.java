package ru.kata.spring.boot_security.demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPanel(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
