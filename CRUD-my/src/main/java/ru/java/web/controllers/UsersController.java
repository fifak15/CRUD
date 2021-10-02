package ru.java.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.java.web.models.User;
import ru.java.web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    final UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "show";
    }

    @GetMapping("new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        service.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
