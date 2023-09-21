package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }
}
