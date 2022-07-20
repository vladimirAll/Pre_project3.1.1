package org.example.Pre_project311.controller;

import org.example.Pre_project311.model.User;
import org.example.Pre_project311.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String getUsers(Model model) {
        model.addAttribute("user", userServiceImpl.getAllUsers());
        return "user";
    }

    @GetMapping("/new")
    public String newPlayer(Model model) {
       model.addAttribute("user", new User());
       return "new";
    }

    @PostMapping("/user")
    public String addPlayer(@ModelAttribute("user") User user) {
        userServiceImpl.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String deletePlayer(@PathVariable("id") Long id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "/update";
    }

    @PostMapping("update/{id}")
    public String addUpdateUser(User user) {
        userServiceImpl.updateUser(user);
        return "redirect:/user";
    }
}
